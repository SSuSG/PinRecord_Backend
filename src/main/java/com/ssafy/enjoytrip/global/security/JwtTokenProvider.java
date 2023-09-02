package com.ssafy.enjoytrip.global.security;


import com.ssafy.enjoytrip.domain.user.entity.UserDetailsImpl;
import com.ssafy.enjoytrip.domain.user.repository.RefreshTokenRepository;
import com.ssafy.enjoytrip.domain.user.repository.UserRepository;
import com.ssafy.enjoytrip.domain.user.service.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Date;


@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {


    @Value("spring.jwt.secret")
    private String secretKey;

    private long refreshTokenValidTime = 1000L * 60 * 60 * 24 * 14;
    private long accessTokenValidTime = 1000L * 60 * 60; // 1시간 토큰 유효

    private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;
    private final RefreshTokenRepository refreshToeknRepostory;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createAccessToken(String loginId){
        log.info("JwtTokenProvider_createAccessToken -> ACCESS TOKEN 생성");
        return this.createToken(loginId, accessTokenValidTime);
    }

    public String createRefreshToken(String loginId) {
        log.info("JwtTokenProvider_createRefreshToken -> REFRESH_TOKEN 생성");
        return this.createToken(loginId,  refreshTokenValidTime);
    }

    public String createToken(String loginId, long tokenValid) {
        log.info("JwtTokenProvider_createToken -> JWT토큰 생성");
        Claims claims = Jwts.claims().setSubject(loginId);

        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) // 데이터
                .setIssuedAt(now) // 토큰 발행일자
                .setExpiration(new Date(now.getTime() + tokenValid)) // 토큰 유효시간 설정
                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, 암호키
                .compact();
    }

    public Authentication getAuthentication(String token) {
        log.info("JwtTokenProvider_getAuthentication -> JWT토큰으로 인증 정보 조회");
        UserDetailsImpl userDetails = (UserDetailsImpl)customUserDetailsService.loadUserByUsername(getLoginId(token));
        //log.info("UserName : {}" , userDetails.getUsername());
        //log.info("UserPw : {}" , userDetails.getPassword());
        return new UsernamePasswordAuthenticationToken(userDetails.getUser().getLoginId(), "", userDetails.getAuthorities());
    }

    public String getLoginId(String token) {
        log.info("JwtTokenProvider_getUserEmail -> JWT토큰에서 회원의 로그인 아이디 추출");
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String getAccessToken(HttpServletRequest request) {
        log.info("JwtTokenProvider_getAccessToken -> Request의 Header에서 AccessToken 값을 가져옵니다.");
        if(request.getHeader("X-AUTH-TOKEN") != null )
            return request.getHeader("X-AUTH-TOKEN");
        return null;
    }

    public String getRefreshToken(String loginId) {
        log.info("JwtTokenProvider_getRefreshToken -> RefreshTokenRepository에서 RefreshToken 값을 가져옵니다.");
        return refreshToeknRepostory.getRefreshToken(loginId);
    }

    // Jwt 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken) {
        log.info("JwtTokenProvider_validateToken -> JWT토큰의 유효성 + 만료일자 확인");
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            if(claims.getBody().getExpiration().getTime() - claims.getBody().getIssuedAt().getTime() != accessTokenValidTime){
                log.info("토큰이 유효하지 않습니다.");
                return false;
            }
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public void setHeaderAccessToken(HttpServletResponse response, String accessToken) {
        log.info("JwtTokenProvider_setHeaderAccessToken -> ACCESS TOKEN 헤더 설정");
        response.setHeader("X-AUTH-TOKEN", accessToken);
    }

    public boolean existRefreshToken(String loginId) {
        log.info("JwtTokenProvider_existsRefreshToken -> REFRESH TOKEN 존재유무 확인");
        return refreshToeknRepostory.existsByRefreshToken(loginId);
    }



}
