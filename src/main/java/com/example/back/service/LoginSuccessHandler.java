package com.example.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * packageName    : com.example.back.service
 * fileName       : LoginSuccessHandler
 * author         : 이선재
 * date           : 2024-03-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-29        이선재       최초 생성
 */
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirectPath;

    private final HttpSession httpSession;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken oauth2Authentication = (OAuth2AuthenticationToken) authentication;
        String provider = oauth2Authentication.getAuthorizedClientRegistrationId();
//        SessionUser user = (SessionUser)httpSession.getAttribute("currentMember");
//        ((OAuth2AuthenticationToken) authentication).setDetails(user.getMbrUid().toString());
        if(provider!=null){//소셜로그인
            if (redirectPath.startsWith("http://localhost")) {
                response.sendRedirect("http://localhost:3000");
            } else if (redirectPath.startsWith("http://dev.nubiz.co.kr")) {
                response.sendRedirect("http://dev.nubiz.co.kr:12163");
            } else if (redirectPath.startsWith("https://donggurami.kr/")) {
                response.sendRedirect("https://donggurami.kr");
            }
        }else{//form 로그인
            response.setStatus(HttpServletResponse.SC_OK);
        }

    }
}
