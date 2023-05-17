package com.ssafy.enjoytrip.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.enjoytrip.global.exception.NoLoginException;
import com.ssafy.enjoytrip.global.util.JwtService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
	
	private static final String HEADER_AUTH = "auth-token";
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		final String token = request.getHeader(HEADER_AUTH);

		if (token != null && jwtService.checkToken(token)) {
			return true;
		} else {
			throw new NoLoginException();
		}
		
		//쿠키 , 세션 로그인 체크
//		HttpSession session = request.getSession(false);
//		if (session == null || session.getAttribute("loginUser") == null) {
//			log.info("비로그인 사용자 요청");
//			throw new NoLoginException();
//		}
	}

}
