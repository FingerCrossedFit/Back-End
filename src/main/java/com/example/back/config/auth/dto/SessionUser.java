/*
* Copyright (c) 2021 nubiz.co.kr CO.,LTD. All rights reserved.
* This software is the confidential and proprietary information of nubiz.co.kr CO.,LTD.
* You shall not disclose such Confidential Information and shall use it
* only in accordance with the terms of the license agreement you entered into
* with nubiz.co.kr CO.,LTD.
*/
package com.example.back.config.auth.dto;

import com.example.back.enums.Role;
import lombok.Getter;

import java.io.Serializable;

/**
 * packageName    : com.example.back.config.auth.dto
 * fileName       : SessionUser
 * author         : 이선재
 * date           : 2024-03-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-29        이선재       최초 생성
 */
@Getter
public class SessionUser implements Serializable {

	private static final long serialVersionUID = 4866788481701822438L;

	private Long mbrUid;
	private String userId;
	private String nickname;
	private String name;
	private String email;
	private String thumnail;
	private Role role;

	public SessionUser() {
		super();
		this.userId="";
		this.name = "";
		this.email = "";
		this.thumnail = "/resources/images/blankProfile.png";
	}
//	public SessionUser(MemberVO member) {
//		super();
//		this.mbrUid = member.getMbrUid();
//		this.userId = member.getUserId();
//		this.nickname = member.getNickname();
//		this.role = member.getCmmtRole();
//		this.name = member.getUserName();
//		this.email = member.getEmail();
//		if(member.getSns()!=null && member.getSns().getThumbnail() !=null && !member.getSns().getThumbnail().isEmpty()) {
//			this.thumnail = member.getSns().getThumbnail();
//		} else {
//			this.thumnail = "/resources/images/blankProfile.png";
//		}
//	}
	/**
	 * 
	 * @date 2021. 7. 29.
	 * @author 김준곤
	 * @return
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return "SessionUser [userId=" + userId + ", name=" + name + ", email=" + email + ", thumnail=" + thumnail + "]";
	}
	
	
}
