package com.ssafy.enjoytrip.global.config;


import com.ssafy.enjoytrip.global.security.JwtAccessDeniedHandler;
import com.ssafy.enjoytrip.global.security.JwtAuthenticationEntryPoint;
import com.ssafy.enjoytrip.global.security.JwtAuthenticationFilter;
import com.ssafy.enjoytrip.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                httpBasic().disable() //rest api이므로 basic auth 및 csrf 보안을 사용하지 않는다는 설정
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //JWT를 사용하기 때문에 세션을 사용하지 않는다는 설정
                .and()
                .authorizeRequests()
                .antMatchers("/api/users/**").permitAll()
                //.antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // exception handling 할 때 우리가 만든 클래스를 추가
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint) //인증 실패시
                .accessDeniedHandler(jwtAccessDeniedHandler)//인가 실패시
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class); //JWT 인증을 위하여 직접 구현한 필터를 UsernamePasswordAuthenticationFilter 전에 실행하겠다는 설정

        return http.build();
    }

}