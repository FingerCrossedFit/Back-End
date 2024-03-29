/*
 * Copyright (c) 2021 nubiz.co.kr CO.,LTD. All rights reserved.
 * This software is the confidential and proprietary information of nubiz.co.kr CO.,LTD.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into
 * with nubiz.co.kr CO.,LTD.
 */
package com.example.back.config;

import com.example.back.service.CustomOAuth2UserService;
import com.example.back.service.LoginSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * packageName    : com.example.back.config
 * fileName       : SecurityConfig
 * author         : 이선재
 * date           : 2024-03-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-29        이선재       최초 생성
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
	CustomOAuth2UserService customOAuth2UserService;

	private final LoginSuccessHandler loginSuccessHandler;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// csrf 토큰을 비활성화
        http.csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().sameOrigin());

		// 요청 URL에 따라 접근 권한을 설정
		http.authorizeHttpRequests(requests -> requests
				// 해당 경로들은 접근을 허용
				.antMatchers("/member/**", "/comap/**", "/api/**").permitAll()
				// 다른 모든 요청은 인증된 유저만 접근을 허용
				.anyRequest().authenticated());
		
		http.oauth2Login( oauth2Login -> oauth2Login
				.loginPage("/")
		        .successHandler(loginSuccessHandler)
		        .userInfoEndpoint()
		        .userService(customOAuth2UserService)//구글 로그인이 완료된(구글회원) 뒤의 후처리가 필요함 . Tip.코드x, (엑세스 토큰+사용자 프로필 정보를 받아옴)
        );
		// 로그아웃 URL
        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) 
                .logoutSuccessUrl("/main") // 성공시 리턴 URL
                .invalidateHttpSession(true)	// 인증정보를 지우고 세션을 무효화
                .deleteCookies("JSESSIONID", "remember-me"));
		return http.build();
	}
}
