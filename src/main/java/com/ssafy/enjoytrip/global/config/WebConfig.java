package com.ssafy.enjoytrip.global.config;

import java.util.List;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.enjoytrip.global.argumentresolver.LoginUserArgumentResolver;
import com.ssafy.enjoytrip.global.interceptor.LoginCheckInterceptor;

public class WebConfig implements WebMvcConfigurer  {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheckInterceptor())
		.order(1)
		.addPathPatterns("/**")
		.excludePathPatterns(
			"/api/users/login" , "/api/users" , "/api/users/auth" , "/api/users/duplication-email/**" , "/api/duplication-loginId/**",
			"/api/users/loginId" , "/api/users/new-password" , "/api/users/unlock"
		);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new LoginUserArgumentResolver());
	}

}
