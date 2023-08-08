package edu.kh.exception.model.dto;

// 사용자 정의 예외
// - 자바에서 제공하지 않는 예외를 직접 만드는 방법


// 1. Exception 클래스 아무거나 상속 받기
//    단, Unchecked로 만들고 싶으면 RunTimeException 관련 예외 상속 받기
// 2. 생성자 만들기
public class UserException extends Exception {
	
	public UserException() {
		super("사용자 정의 예외 발생");
	}

	//매개 변수 생성자 하나 더 추가
	public UserException(String message) { //전달받아온 message를 받아서 문구를 띄우겠다
		super(message);
		
	}
	
}
