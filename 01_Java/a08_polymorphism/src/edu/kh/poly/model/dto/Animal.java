package edu.kh.poly.model.dto;

// 추상 클래스(abstact class)
// - 미완성 부분(추상 메서드)이 포함된 클래스
// - 미완성이다 보니 단독 객체로 생성이 불가능하다!

// (단, 추상 메서드가 없어도 추상 클래스로 선언 가능!!)

public abstract class Animal {
	
	private String type; // 종, 류 (양서류, 포유류, 갑각류...)
	private String eatType; // 식성 (초식, 잡식, 육식..)
	
	
	// 기본생성자 자동완성 : ctrl + space bar -> enter 
	
	public Animal() {
		super(); // Object 생성자 호출
		// TODO Auto-generated constructor stub
	}
	
	
	//매개변수 생성자 자동완성 : alt + shift + s -> o
	public Animal(String type, String eatType) {
		this.type = type;
		this.eatType = eatType;
		
	}

	// getter/setter
	// 자동완성 alt + shift + s -> r
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEatType() {
		return eatType;
	}

	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	
	// Object의 toString() 오버라이딩 자동 완성
    // alt + shift + s -> s
	
	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
	// abstract : 추상적인
	
	// abstract method(추상메서드)
	// - 몸체(메서드 정의)가 없는 메서드
	//  -> 상속 받은 자식에 따라 코드가 달라져야되기 때문
	//  -> 자식 클래스에서 오버라이딩이 강제화
	
	
	public abstract void breath();
	
	
	}
	
	
	


