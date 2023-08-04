package edu.kh.inheritance.model.dto;
		// 상속 불가 //내가 대를 끊는다. 상속을 안한다
								// Object는 모든 클래스의 최상위 클래스이다. 
public /*final*/ class Parent extends Object {
								// 미작성 시 컴파일러가 Object를 추가해준다. 
	
	
	private int money = 100_000_000; // 1억
	private String lastName = "홍";
	
	public Parent () {  //기본 생성자 만들기
		System.out.println("Parent() 기본생성자로 부모 객체 생성");
		
	}
	
	public Parent(int money, String lastName) { //오버로딩)
		System.out.println("Parent(int, String) 매개변수 생성자로 부모 객체 생성");
		this.money = money;
		this.lastName = lastName;
		
	}
	
	//getter / setter
			//오버라이딩 불가 (final을 쓰면 더이상 바꿀수없다.) 
	public /*final*/ int getMoney() {  //getter 호출했을때 얻어가게 해주는 (주는)
		return money;
	}
	
	public void setMoney(int money) { //외부로 부터 전달을 받아야하는 (받는) //받는것이니까 void (반환 no)
		this.money = money;
	}
		
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}
	
	//toString() : 객체의 필드를 하나의 문자열로 반환
	@Override // Object의 toString() 오버라이딩을 한 것이다. // Object는 저절로 컴파일러에 의해서 최상위로 만들어진다. 
	public String toString() {
		return money + " / " + lastName;
		
	}
	
	//final 자료형 변수명;
//	- public final class 클래스명 -> 상속 불가
//	- public final void 메서드명() -> 오버라이딩 불가

	
}
