package edu.kh.oop.basic;


public class BasicRun {
	
	public static void main(String [] args) { 
		Nation n1 = new Nation();
		
		n1.납세의의무();
		n1.speakKorean();
		
		// 객체의 속성에 값 대입
		n1.pNo = "991212-1234567";
		n1.name = "홍길동";
		n1.gender = '남';
		n1.address = "서울시 중구 남대문로 120 청계그레이츠 2층";
		n1.phone = "010-1234-1234";
		n1.age = 23;
		
		// 객체에 저장된 속성 출력
		
		System.out.println(n1.pNo);
		System.out.println(n1.name);
		System.out.println(n1.gender);
		System.out.println(n1.address);
		System.out.println(n1.phone);
		System.out.println(n1.age);
		
		
		/* 간접 접근 기능 */
		
		n1.setJob("(돈 많이 버는) 웹 개발자");
		
		n1.introduce();
		
		// 새로운 국민(Nation) 객체 생성
		Nation n2 = new Nation();
		
		n2.name = "김영희";
		n2.age = 20;
		
		Nation n3 = new Nation();
		n3.name = "박영민";
		n3.age = 30;
		
		System.out.printf("%s의 나이는 %d세 입니다.\n", n1.name, n1.age);
		System.out.printf("%s의 나이는 %d세 입니다.\n", n2.name, n2.age);
		System.out.printf("%s의 나이는 %d세 입니다.\n", n3.name, n3.age);
		
		n1.납세의의무();
		n2.납세의의무();
		n3.납세의의무();
		
		
		
		
		
		
		
		
	}
	
	

}
