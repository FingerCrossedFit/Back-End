package com.example.back.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * packageName    : com.example.back.enums
 * fileName       : Role
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
public enum Role {
    AMN("AMN", "총괄관리자"), 	// 관리자
    MST("MST", "공무원"), 	// 운영자
    SMT("SMT", "센터관리자"), 	// 센터관리자
    RWM("RWM", "리워드관리자"), // 리워드관리자
    MBR("MBR", "쓰레기해결단"), // 마을주민
    STB("STB", "주민"), // 마을주민
    NON("NON", "비회원"); // 익명

	private final String code;
	private final String value;
	
    public static Role get(String code) {
        for (Role element : values()) {
            if (element.code.equalsIgnoreCase(code)) {
                return element;
            }
        }
        return null;
    }

    public static Role lookup(String code) {
        for (Role element : Role.values()) {
            if (element.code.equalsIgnoreCase(code)) {
                return element;
            }
        }
        return null;
    }
    
    public static Role lookupName(String name) {
        for (Role element : Role.values()) {
            if (element.name().equalsIgnoreCase(name)) {
                return element;
            }
        }
        return null;
    }
    
    public static boolean contain(Role role,Role ...roles) {
    	if(role==null || roles==null) return false;
    	return Arrays.asList(roles).contains(role);
    }

}
