/*
* Copyright (c) 2021 nubiz.co.kr CO.,LTD. All rights reserved.
* This software is the confidential and proprietary information of nubiz.co.kr CO.,LTD.
* You shall not disclose such Confidential Information and shall use it
* only in accordance with the terms of the license agreement you entered into
* with nubiz.co.kr CO.,LTD.
*/
package com.example.back.utils;

/**
 * 제목
 * 사용 방법 : 메시지 통합 관리
 * <pre>
 * 상세내역...
 * ------------------------ 
 * 개정이력
 * 2024. 01. 15. 이선재 : 최초작성
 * </pre>
 * @author 이선재
 */
public class MessageUtil {

	/**
	 * 일반_등록_성공
	 */
	public final static String COMMON_INSERT_OK= "정상적으로 등록되었습니다.";
	/**
	 * 일반_수정_성공
	 */
	public final static String COMMON_UPDATE_OK= "정상적으로 수정되었습니다.";
	/**
	 * 일반_삭제_성공
	 */
	public final static String COMMON_DELETE_OK= "정상적으로 삭제되었습니다.";
	/**
	 * 일반_탐색_성공
	 */
	public final static String COMMON_SEARCH_OK= "정상적으로 탐색되었습니다.";
	/**
	 * 일반_전송_성공
	 */
	public final static String COMMON_SEND_OK= "정상적으로 전송되었습니다.";
	/**
	 * 일반_전송_실패
	 */
	public final static String COMMON_SEND_FAIL= "전송에 실패하였습니다.";
	/**
	 * 예외_비유효성_0
	 */
	public final static String EXCEPTION_BAD_VALIDATION_ZERO= "입력값은 0이 될 수 없습니다.";
	/**
	 * 예외_비유효성_0이하
	 */
	public final static String EXCEPTION_BAD_VALIDATION_UNDER_ZERO= "입력값이 0 혹은 0보다 작습니다.";
	/**
	 * 예외_비유효성_실패
	 */
	public final static String EXCEPTION_BAD_VALIDATION_FAIL= "값이 유효하지 않습니다.";
	/**
	 * 예외_비유효성_특수문자
	 */
	public final static String EXCEPTION_BAD_VALIDATION_CHARACTER= "입력된 값에 특수문자가 있습니다.";
	/**
	 * 예외_비유효성_EMPTY
	 */
	public final static String EXCEPTION_BAD_VALIDATION_EMPTY= "입력값이 없습니다.";
	/**
	 * 예외_비유효성_중복값
	 */
	public final static String EXCEPTION_BAD_VALIDATION_DUPLICATE= "서버에 중복된 값이 있습니다. 다른값을 입력해주세요.";
	/**
	 * 예외_비유효성_로그인_실패
	 */
	public final static String EXCEPTION_BAD_VALIDATION_LOGIN_FAIL= "입력된 아이디, 비밀번호를 확인하세요.";
	/**
	 * 예외_비유효성_불일치
	 */
	public final static String EXCEPTION_BAD_VALIDATION_NOT_EQUAL= "대상과 행위자가 일치하지 않습니다.";
	/**
	 * 예외_비유효성_중복_이름
	 */
	public final static String EXCEPTION_BAD_VALIDATION_DUPLICATE_NAME= "중복된 내부정보 이름입니다. 다른 이름으로 입력하세요.";
	/**
	 * 예외_비유효성_JSON_분석
	 */
	public final static String EXCEPTION_BAD_VALIDATION_JSON_PASER= "입력된 값은 JSON형태로 변환할 수 없습니다.";
	/**
	 * 예외_비유효성_미제공서비스
	 */
	public final static String EXCEPTION_BAD_VALIDATION_NOT_SERVICE= "제공되지 않는 메소드 이름입니다.";
	/**
	 * 예외_비유효성_YAML_EMPTY
	 */
	public final static String EXCEPTION_BAD_VALIDATION_YAML_EMPTY= "YAML파일 내용이 없습니다. YAML파일을 확인하세요.";
	/**
	 * 예외_비유효성_YAML_중복
	 */
	public final static String EXCEPTION_BAD_VALIDATION_YAML_DUPLICATE= "이미 중복된 이름의 YAML파일이 있습니다.";
	/**
	 * 예외_SQL_실패
	 */
	public final static String EXCEPTION_SQL_FAIL= "SQL쿼리에 실패하였습니다.";
	/**
	 * 예외_SQL_실패_삭제
	 */
	public final static String EXCEPTION_SQL_EXCEPTION= "DB쿼리에 유효하지 않는 값입니다.";
	/**
	 * 예외_SQL_실패_입력
	 */
	public final static String EXCEPTION_SQL_FAIL_SAVE= "SQL INSERT에 실패하였습니다. 서버관리자에게 문의하세요.";
	/**
	 * 예외_SQL_실패_수정
	 */
	public final static String EXCEPTION_SQL_FAIL_UPDATE= "SQL UPDATE에 실패하였습니다. 서버관리자에게 문의하세요.";
	/**
	 * 예외_SQL_실패_삭제
	 */
	public final static String EXCEPTION_SQL_FAIL_DELETE= "SQL DELETE에 실패하였습니다. 서버관리자에게 문의하세요.";
	/**
	 * 예외_미발견
	 */
	public final static String EXCEPTION_NOT_FOUND= "탐색 결과 값이 없습니다.";
	/**
	 * 예외_미발견_USER
	 */
	public final static String EXCEPTION_NOT_FOUND_USER= "입력된 값에 대한 USER를 찾을 수 없습니다.";
	/**
	 * 예외_미발견_BUILDING
	 */
	public final static String EXCEPTION_NOT_FOUND_BUILDING= "탐색된 BUILDING이 없습니다.";
	/**
	 * 예외_미발견_내부정보
	 */
	public final static String EXCEPTION_NOT_FOUND_INSIDEINFO= "탐색된 내부정보가 없습니다.";
	/**
	 * 예외_미발견_파일
	 */
	public final static String EXCEPTION_NOT_FOUND_FILE= "탐색된 파일이 없습니다.";
	/**
	 * 예외_미발견_이력
	 */
	public final static String EXCEPTION_NOT_FOUND_HISTORY= "탐색된 작업이력이 없습니다.";
	/**
	 * 예외_입출력_실패
	 */
	public final static String EXCEPTION_IO_FAIL= "파일 입출력 작업에 실패하였습니다. 관리자에게 문의하세요.";
	/**
	 * 예외_입출력_실패_삭제
	 */
	public final static String EXCEPTION_IO_FAIL_DELETE= "파일 삭제 도중 문제가 발생하였습니다. 관리자에게 문의하세요.";
	/**
	 * 예외_입출력_실패_저장
	 */
	public final static String EXCEPTION_IO_FAIL_SAVE= "파일 저장 도중 문제가 발생하였습니다. 관리자에게 문의하세요.";
	/**
	 * 예외_YAML_분석_실패
	 */
	public final static String EXCEPTION_YAML_PARSE_FAIL= "YAML 파일이 유효하지 않습니다. 내용을 확인하세요. ";
	/**
	 * 예외_입출력_변환_실패
	 */
	public final static String EXCEPTION_IO_CONVERT_FAIL= "파일 변환을 실패하였습니다. 파일을 다시 확인하세요.";
	/**
	 * 예외_통신_에러_실패
	 */
	public final static String EXCEPTION_HTTP_SERVER_ERROR_FAIL= "게이트웨이 api 접근에 실패하였습니다.";
	/**
	 * 예외_통신_에러_타임아웃
	 */
	public final static String EXCEPTION_HTTP_SERVER_ERROR_TIMEOUT= "게이트웨이 접속이 runtime out 되었습니다. 해당 게이트웨이 관리자에게 문의하세요. ";
	/**
	 * 예외_통신_에러_예외
	 */
	public final static String EXCEPTION_HTTP_SERVER_ERROR_EXCEPTION= "게이트웨이 api 실행에 실패하였습니다. 게이트웨이 관리자에게 문의하세요.";
	/**
	 * 예외_로그인_성공
	 */
	public final static String EXCEPTION_LOGIN_OK= "정상 로그인 처리 되었습니다.";
	/**
	 * 일반_전송_실패
	 */
	public final static String EXCEPTION_LOGIN_NEED= "로그인이 필요합니다.";
	/**
	 * 예외_비유효성_중복_닉네임
	 */
	public final static String EXCEPTION_BAD_VALIDATION_DUPLICATE_NICKNAME= "중복된 닉네임입니다. 다른 닉네임을 입력하세요.";
	/**
	 * 중복없음
	 */
	public final static String COMMON_USE_OK= "사용가능 합니다.";
	/**
	 * 예외_비유효성_중복_전화번호
	 */
	public final static String EXCEPTION_BAD_VALIDATION_DUPLICATE_PHONE= "중복된 전화번호입니다. 다른 전화번호를 입력하세요.";
	/**
	 *  세션종료
	 */
	public final static String DAY_PT_LIMIT= "포인트 일일 적립 한도가 초과하였습니다.";
	/**
	 *  세션종료
	 */
	public final static String SESSION_DOWN= "세션에 종료되었습니다.";
}
