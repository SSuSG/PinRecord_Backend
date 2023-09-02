package com.ssafy.enjoytrip.global.security;


import com.ssafy.enjoytrip.global.exception.ExpiredRefreshTokenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("JwtAuthenticationFilter_doFilterInternal");

        // 헤더에서 JWT 를 받아옵니다.
        String accessToken = jwtTokenProvider.getAccessToken(request);
        //토큰에서 로그인 아이디 꺼내기
        String loginId = jwtTokenProvider.getLoginId(accessToken);
        log.info("ACCESS TOKEN : {}" , accessToken);

        // 유효한 토큰인지 확인합니다.
        if (accessToken != null) {
            log.info("ACCESS 토큰 존재");
            // ACCESS TOKEN이 유효한 상황
            if (jwtTokenProvider.validateToken(accessToken)) {
                log.info("ACCESS 토큰 유효");
                this.setAuthentication(accessToken);
            }
            // ACCESS TOKEN이 만료
            else if (!jwtTokenProvider.validateToken(accessToken)) {
                log.info("ACCESS 토큰 만료");
                // 재발급 후, 컨텍스트에 다시 넣기
                /// 리프레시 토큰 저장소 존재유무 확인
                
                boolean isRefreshToken = jwtTokenProvider.existRefreshToken(loginId);
                if (isRefreshToken) {
                    /// 리프레시 토큰으로 로그인 정보 가져오기
                    /// 토큰 발급
                    String newAccessToken = jwtTokenProvider.createAccessToken(loginId);
                    /// 헤더에 어세스 토큰 추가
                    jwtTokenProvider.setHeaderAccessToken(response, newAccessToken);
                    /// 컨텍스트에 넣기
                    this.setAuthentication(newAccessToken);
                }else{
                    throw new ExpiredRefreshTokenException();
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    public void setAuthentication(String token) {
        log.info("JwtAuthenticationFilter_setAuthentication -> 토큰으로부터 유저정보를 받아오고 SecurityContext 에 Authentication 객체를 저장");

        // 토큰으로부터 유저 정보를 받아옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        log.info("Principal : {} ", authentication.getPrincipal());

        // SecurityContext 에 Authentication 객체를 저장합니다.
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
