package edu.kh.inheritance.model.dto;

// Parent를 상속 받겠다
// -> Child2가 Parent의 필드, 메서드를 내부에 포함하게 되어 자신의 것처럼 사용하게 된다. 
// -> 마음대로 못쓰는 것 : Parent의 필드 메서드 중 private으로 설정된 것은
//  					   자식이 다룰 수 없다. 

public class Child2 extends Parent{
	
	private String house;
	
	//생성자
	public Child2 () {
		super(); // 상속 관계 시 부모 객체가 먼저 생성되어야 하기 때문에
				 // 자식 생성자 첫 번째 줄에 무조건 작성!
				 // 단, 미작성 시 컴파일러가 추가
		System.out.println("Child2() 기본 생성자로 자식 객체 생성");
	}
		public Child2(String house) {
			this.house = house;
			System.out.println("Child2(String) 매개변수 생성자로 자식 객체 생성");
		}
		
		public Child2(int money, String lastName, String house) { //매개변수 3개짜리 생성
			
			//자식 객체 생성 시
			// 매개변수가 있는 super() 생성자를 이용해서
			//부모 객체의 필드도 초기화할 수 있다. 
			
			// parent에서 private이기 때문에 나오지 않는데.
//			this.money = money;   //오류 :
//			this.lastNAme = lastName; // 오류
//			this.house = house; // 오류
			super(money, lastName); // money와 lastName은 parent에 이미 작성이 되어있기때문에, 상속을 받았고
			this.house= house;					// String house만 쓰겠다
			
		}
		public String getHouse() {
			return house;
		}
		public void setHouse(String house) {
			this.house = house;
		}
		
		@Override // 오버라이딩 == 문법 검사 해줘 (컴파일러가 읽으라고 주석을 남김)
		public String toString() {
			//부모로부터 상속 받은 멤버(필드, 메서드)를 자식이 자신의 것처럼 사용 가능
			//setHouse(house);
			//setMonet(10);
//			getMoney();
//			getLastNAme();
			
			// 부모의 toString()을 호출하여 반환된 결과를 이용
			return super.toString() + " / " + house;
			// money + " / " + lastName
			// 부모의 string이와 자식의 string을 같이 쓸 수 있다
		}
		
	}

