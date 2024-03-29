/*
* Copyright (c) 2021 nubiz.co.kr CO.,LTD. All rights reserved.
* This software is the confidential and proprietary information of nubiz.co.kr CO.,LTD.
* You shall not disclose such Confidential Information and shall use it
* only in accordance with the terms of the license agreement you entered into
* with nubiz.co.kr CO.,LTD.
*/
package com.example.back.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName    : com.example.back.service
 * fileName       : CustomOAuth2UserService
 * author         : 이선재
 * date           : 2024-03-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-29        이선재       최초 생성
 */
//@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	
	private final HttpSession httpSession;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = userRequest.getClientRegistration()
				.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

//		OAuthAttributes attributes = OAuthAttributes.
//				of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
//		MemberVO member = saveOrUpdate(attributes);
//		httpSession.setAttribute("currentMember", new SessionUser(member));
//		return new DefaultOAuth2User(
//				Collections.singleton(new SimpleGrantedAuthority(member.getRole(SystemEnum.USER).getCode())),
//				attributes.getAttributes(),
//				attributes.getUserNameAttributeName());
		return oAuth2User;
	}
	
//	@Transactional
//	private MemberVO saveOrUpdate(OAuthAttributes attributes) {
//		//이메일로 가져오면 이메일이 같을경우 같은계정으로 처리되버림
////		MemberVO member = memberMapper.getDataByEmail(attributes.getEmail()) ;
//		//SNS 타입과 시크릿키로 가져오게 수정
//		MemberSnsVO search = new MemberSnsVO();
//		search.setSnsSecretKey(attributes.getNameAttributeKey());
//		search.setSnsType(attributes.getSnsType().getCode());
//		MemberVO member = memberMapper.getDataBySns(search);
//		// 회원가입 안되어 있으면
//		if(member==null || member.getMbrUid()==null || member.getMbrUid()==0) {
//			member= attributes.toEntity();
//
//			memberMapper.insert(member);
//			memberMapper.updateCrtUid(member);
//			member.getSns().setMbrUid(member.getMbrUid());
//			memberSnsMapper.insert(member.getSns());
//
//			if(member.getAuths()==null || member.getAuths().isEmpty()) {
//				member.setAuths(new ArrayList<>());
//				MemberAuthVO auth = new MemberAuthVO();
//				auth.setMbrUid(member.getMbrUid());
//				auth.setTgtSys(SystemEnum.USER);
//				auth.setTgtMdl("ALL");
//				auth.setAuthRole(Role.NON);
//				auth.setAuthLevel(1);
//				auth.setCrtUid(member.getMbrUid());
//				member.getAuths().add(auth);
//				member.setCmmtRole(auth.getAuthRole());
//				memberAuthMapper.insert(auth);
//			}
//
//		} else {
//			MemberAuthVO auth = new MemberAuthVO();
//			auth.setMbrUid(member.getMbrUid());
//			auth = memberAuthMapper.select(auth);
//			if (auth != null) member.setCmmtRole(auth.getAuthRole());
//			List<MemberSnsVO> listSns =memberSnsMapper.selectList(member.getMbrUid());
//			boolean isExist = false;
//			for (MemberSnsVO sns : listSns) {
//				//회원가입할때 닉네임 필수 기재되므로
//				//회원가입 여부로 사용, 회원가입되어있다면 썸네일 변경되지 않게
//				if(sns.getSnsType().equals(attributes.getSnsType().getCode())) {
//					if(member.getNickname() == null) {
//						sns.setThumbnail(attributes.getThumbnail());
//						memberSnsMapper.update(sns);
//					}
//					isExist=true;
//				}
//			}
//			if(!isExist) {
//				MemberSnsVO sns = new MemberSnsVO();
//				sns.setMbrUid(member.getMbrUid());
//				sns.setSnsType(attributes.getSnsType().getCode());
//				sns.setSnsId(attributes.getEmail());
//				sns.setSnsSecretKey(attributes.getNameAttributeKey());
//				sns.setThumbnail(attributes.getThumbnail());
//				memberSnsMapper.insert(sns);
//			}
//		}
//		return member;
//	}
}
