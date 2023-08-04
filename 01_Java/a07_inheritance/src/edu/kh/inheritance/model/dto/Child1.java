package edu.kh.inheritance.model.dto;

// 상속 키워드 : extends
// public class 자식클래스 extends 부모클래스 {}

public class Child1 extends Parent {
	
	private String car;
	
	public Child1 () { //기본 생성자
		super();
		System.out.println("Child1() 기본 생성자로 자식 객체 생성");
	}

	public Child1(String car) { // 매개변수를 생성
		super(); // super 생성자 == 상위 생성자  == 부모 생성자
		// 부모 객체가 먼저 생성된 후 자식 객체가 생성됨. 
		// 컴파일러가 자동으로 부모 객체를 생성해준다. 
		
		this.car = car;
		
		System.out.println("Child1(String) 매개변수 생성자로 자식 객체 생성");
		
	}

	// alt + shift + s -> r 

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	// * 오버라이딩(overriding) *
	// - 위로 올라타다
	// -> 코드를 덮어 씌움
	// - 자바에서 말하는 정확한 의미는 : 부모로부터 상속받은 메서드를
	// 자식이 원하는 형태로 재정의 하는 것 
	
	//오버라이딩 특징
	// - 메서드 선언문 중 반환형 ==> 부모의 메서드와 반환형, 메서드형, 매개변수까지 똑같음
	// - 내부코드는 다름. 
	
	//@ 자바에서 쓰는 기호
	// Annotation(@, 어노테이션)
	// - 어노테이션은 컴파일러가 보는 주석이다!!! (//은 사람이 보는 주석)
	// - 컴파일러에게 어노테이션에 작성된 내용을 보고 
	//   코드가 정상 작성 되었는지, 해당 코드가 실행 되기 전에 다른 코드를 실행한다던지
	//   코드가 해석되는 순서를 작성한다던지 ..... 등이 가능
	
	@Override  // override라는 것은 이 메서드가 부모 것을 재정의 한거니까
	           // 제대로 작성했는지 검사해달라 라는 의미
	
	public String toString() {
		 // money + " / " + lastName + "/" + car; 
		// 부모 private 필드 직접 접근 불가능
		
		
		return getMoney() + " / " + getLastName() + " / " + car;
		
//	public String toString(String name) {
		//The method toString(String) of type Child1 must override or 
		// implement a supertype method
		 
		
//상속받은 Parent의 메서드를 자식이 자신의 것처럼 사용 가능
//		getMoney();  
//		getLastName();
		
	}
	
	// 오버라이딩 연습
	// 부모로부터 상속 받은 getMoney()를 재정의
	
	@Override
	public int getMoney() {
		System.out.println("오버라이딩한 getMoney()");
		
		//return (int)(getMoney() * 0.7);
					//부모의 getMoney()를 호출하는 방법 앞에 super를 붙힌다
					// 현재 오류남 . getMoney때문에
		
		return (int)(super.getMoney() * 0.7);
		//부모의 getMoney()를 호출하는 방법 앞에 super를 붙힌다
		
	}
	
}
