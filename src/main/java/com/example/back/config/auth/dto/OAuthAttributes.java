/*
* Copyright (c) 2021 nubiz.co.kr CO.,LTD. All rights reserved.
* This software is the confidential and proprietary information of nubiz.co.kr CO.,LTD.
* You shall not disclose such Confidential Information and shall use it
* only in accordance with the terms of the license agreement you entered into
* with nubiz.co.kr CO.,LTD.
*/
package com.example.back.config.auth.dto;

import com.example.back.enums.SnsEnum;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

/**
 * packageName    : com.example.back.config.auth.dto
 * fileName       : OAuthAttributes
 * author         : 이선재
 * date           : 2024-03-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-29        이선재       최초 생성
 */
//@Slf4j
@Getter
@Builder
public class OAuthAttributes {
	
	private Map<String, Object> attributes;
	private String userNameAttributeName;
	private String nameAttributeKey;
	private SnsEnum snsType;
	private String userName;
	private String nickname;
	private String email;
	private String snsId;
	private String thumbnail;

	/**
	 * OAuth2User에서 반환하는 사용자 정보를 변환해서 반환
	 * 
	 * @param registrationId
	 * @param userNameAttributeName
	 * @param attributes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		System.out.println(registrationId);
		// TODO : 현재는 네이버 구글,카카오만 되어 있음, 애플, 핸드폰 필요
		if(SnsEnum.GOOGLE.name().equals(registrationId.toUpperCase())) {
			return ofGoogle(userNameAttributeName, attributes);
		} else if(SnsEnum.NAVER.name().equals(registrationId.toUpperCase())) {
			return ofNaver(userNameAttributeName, ( Map<String, Object>)attributes.get("response"));
		} else if(SnsEnum.FACEBOOK.name().equals(registrationId.toUpperCase())) {
		} else if(SnsEnum.TWITTER.name().equals(registrationId.toUpperCase())) {
		} else if(SnsEnum.KAKAO.name().equals(registrationId.toUpperCase())) {
			return ofKakao(userNameAttributeName, attributes);
		} else if(SnsEnum.PHONE.name().equals(registrationId.toUpperCase())) {
			return ofPhone(userNameAttributeName, attributes);
		} else if(SnsEnum.APPLE.name().equals(registrationId.toUpperCase())) {
			return ofApple(userNameAttributeName, attributes);
		}
		return null;
	}
	
	/**
	 * 구글에서 받은 사용자 정보를  OAuthAttributes로 반환
	 * @param userNameAttributeName
	 * @param attributes
	 * @return
	 */
	private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.snsType(SnsEnum.GOOGLE)
				.userName((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.snsId((String) attributes.get("email"))
				.thumbnail((String) attributes.get("picture"))
				.attributes(attributes)
				.nameAttributeKey(attributes.get(userNameAttributeName).toString() )
				.userNameAttributeName(userNameAttributeName)
				.build();
	}

	/**
	 * 카카오에서 받은 사용자 정보를  OAuthAttributes로 반환
	 * @param userNameAttributeName
	 * @param attributes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
		Map<String,Object> kakao_account = (Map<String, Object>)attributes.get("kakao_account");
		Map<String, String> profile = (Map<String, String>) kakao_account.get("profile");
		return OAuthAttributes.builder()
				.snsType(SnsEnum.KAKAO)
				.userName(profile.get("nickname")) // 실명으로 변경시 여기에 변경
				.email((String)kakao_account.get("email"))
				.snsId(attributes.get(userNameAttributeName).toString())
				.thumbnail(profile.get("profile_image_url"))
				.attributes(attributes)
				.nameAttributeKey(attributes.get(userNameAttributeName).toString() )
				.userNameAttributeName(userNameAttributeName)
				.build();
	}
	

	private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String,Object> attributes) {
        userNameAttributeName="id";
        return OAuthAttributes.builder()
        		.snsType(SnsEnum.NAVER)
                .userName((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .snsId(attributes.get("id").toString())
                .thumbnail((String) attributes.get("profile_image"))
                .attributes(attributes)
				.nameAttributeKey(attributes.get(userNameAttributeName).toString() )
				.userNameAttributeName(userNameAttributeName)
                .build();
    }
	
	/**
	 * 핸드폰 로그인으로 받은 사용자 정보를 OAuthAttributes로 반환
	 * @param userNameAttributeName
	 * @param attributes
	 * @return
	 */
	private static OAuthAttributes ofPhone(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.snsType(SnsEnum.PHONE)
				.userName((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.snsId((String) attributes.get("email"))
				.thumbnail((String) attributes.get("picture"))
				.attributes(attributes)
				.nameAttributeKey(attributes.get(userNameAttributeName).toString() )
				.userNameAttributeName(userNameAttributeName)
				.build();
	}

	/**
	 * 구글에서 받은 사용자 정보를  OAuthAttributes로 반환
	 * @param userNameAttributeName
	 * @param attributes
	 * @return
	 */
	private static OAuthAttributes ofApple(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.snsType(SnsEnum.APPLE)
				.email((String) attributes.get("email"))
				.attributes(attributes)
				.nameAttributeKey(attributes.get(userNameAttributeName).toString() )
				.userNameAttributeName(userNameAttributeName)
				.build();
	}
			
	/**
	 * 회원 VO를 생성
	 * @return
	 */
//	public MemberVO toEntity() {
//		MemberVO member = MemberVO.builder()
//				.userId(snsType.getCode()+nameAttributeKey)
//				.userName(userName)
//				.nickname(nickname)
//				.email(email)
//				.build();
//		member.setSns(new MemberSnsVO());
//		member.getSns().setMbrUid(member.getMbrUid());
//		member.getSns().setSnsType(snsType.getCode());
//		member.getSns().setSnsId(snsId);
//		member.getSns().setThumbnail(thumbnail);
//		member.getSns().setSnsSecretKey(nameAttributeKey);
//		member.setAuths(new ArrayList<>());
//		return member;
//	}
	
	
	/**
	 * 
	 * @return
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return "OAuthAttributes [attributes=" + attributes + ", nameAttributeKey=" + nameAttributeKey + ", snsType="
				+ snsType + ", userName=" + userName + ", nickname=" + nickname + ", email=" + email + ", thumbnail="
				+ thumbnail + "]";
	}
}
