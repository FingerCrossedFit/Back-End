/*
* Copyright (c) 2021 nubiz.co.kr CO.,LTD. All rights reserved.
* This software is the confidential and proprietary information of nubiz.co.kr CO.,LTD.
* You shall not disclose such Confidential Information and shall use it
* only in accordance with the terms of the license agreement you entered into
* with nubiz.co.kr CO.,LTD.
*/
package com.example.back.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : com.example.back.enums
 * fileName       : SnsEnum
 * author         : 이선재
 * date           : 2024-03-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-29        이선재       최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum SnsEnum {

	NAVER("N","네이버"),		
	FACEBOOK("F","페이스북"),	
	TWITTER("T","트위터"),	
	GOOGLE("G","구글"),		
	KAKAO("K","카카오"),	                   
	PHONE("P","핸드폰"),
	APPLE("A", "애플"),
	EMAIL("E", "이메일");
	
	private final String code;
	private final String value;
	
	public static SnsEnum get(String code) {
		for (SnsEnum element : values()) {
			if (element.code.equalsIgnoreCase(code)) {
				return element;
			}
		}
		return null;
	}
	
	public static SnsEnum lookup(String code) {
		for (SnsEnum element : SnsEnum.values()) {
			if (element.code.equalsIgnoreCase(code)) {
				return element;
			}
		}
		return null;
	}

}
