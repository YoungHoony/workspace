package edu.kh.poly.run;

import edu.kh.poly.model.dto.Car;
import edu.kh.poly.model.dto.Porsche;
import edu.kh.poly.model.dto.Spark;

//import 자동 완성 : ctrl + shift + o 

public class CarRun {
	public static void main(String[] args) {
		
		// 선수 지식
		// 1. 컴퓨터의 값 처리 원칙
		//  - 같은 자료형끼리만 연산이 가능
		//  - 연산 결과도 같은 자료형
		// 2. 상속 메모리 구조
		//  - 자식 객체 생성 시
		//    부모 객체가 먼저 생성되고
		//    그 부모를 감싸고 있는것이 자식이며, 자식 객체가 포함하는 형태라고 한다
		//    (감싸고 있는 형태) // 그림 참조

		// 부모 참조 변수 = 부모 객체 생성
		
		Car c1 = new Car();
		
		// 자식 참조 변수 = 자식 객체 생성
		
		Porsche p1 = new Porsche();
		Spark s1 = new Spark();
		
		// * 다형성! (업캐스팅) ! *
		
		// 부모 참조 변수 = 자식 객체 생성
		
		Car c2 = new Porsche(); // ? 왜 에러가 발생 안하지? 
		// -> 컴퓨터의 값 처리 원칙이 무시/위배된걸로 보임
		// 실상은 그렇지 않다. (위배 x)
		
		// c2 부모 타입 참조 변수가
		// 자식 타입의 객체를 참조하게 되면
		// 자식 내 부모 부분만 참조가 가능하다!
		
		// * c2가 자식 (Porsche) 객체를 참조하고 있지만
		//   부모 객체만 바라 보고 있으므로
		//  c2가  Car (부모객체) 객체를 참조하고 있는 것처럼 느껴짐 
		//         -> 자식 Porsche가 Car로 변한 것처럼 느껴짐 
		//         -> 자식이 부모로 변했다 -> Up Casting(부모로 변함)
		
		// c2.setOpenTheDoor(true); // porsche 자식꺼라 안된다!!!
		c2.setWheel(4);  // 부모꺼라 된다!! 똑같은 부모과 타입이라, 자식을 찾아왔는데
					     // 자식을 싸그리 무시하고, 부모만 참조 new porsche --> porsche 안에 부모 부분만
						 // 멀리서 보거나, 모르는 사람이 보면 c2가 부모를 보고 있다. 
		
		System.out.println("업캐스팅 확인");
		// 다형성 업캐스팅
		// - 부모 타입 참조 변수로
		//   자식 타입의 객체를 참조하는 것 
		// - 참조하는 자식 객체 중 부모 부분만 볼 수 있음 (그림 참조하면 자식이 부모를 품고 있는 모양)
		
		// 1. 다형성과 객체 배열
		Car[] carArr = new Car [3];
							//  Car (부모) Car 객체 참조 변수 3개의 묶음
		
		// 부모   =  부모
		carArr[0] = new Car(4,5,"경유");
		
		// 부모   =  자식 -> (자식안에 있는) 부모처럼 upcasting
		carArr[1] = new Porsche(4,2,"고급 휘발유", true);
						// 두가지의 모습을 띌 수 있다. = 다형성 (다양한 형질을 띈다) (porsche, car, object -> 3개)
	
		// 부모   = 자식 -> 부모 (업캐스팅)
		carArr[2] = new Spark(4,4,"휘발유", 0.5);
		
		
		for(int i=0 ; i < carArr.length ; i++) {
			System.out.printf("%d / %d / %s \n", 
					 		carArr[i].getWheel(), 
					 		carArr[i].getSeat(), 
					 		carArr[i].getFuel());
				
		}
		
		// 다운 캐스팅
		// - 부모 참조 변수  = 자식 개체의 형태에서
		//   부모 참조 변수를 자식 타입으로 강제 형변환해서
		//   다시 자식 객체를 온전히 참조할 수 있게 만드는 것 
		
		 					
		System.out.println("다운 캐스팅 확인");
		//다운 캐스팅 (참조 변수를 자식 타입으로 바꾸는 것)
		System.out.println( ((Porsche)carArr[1]).isOpenTheDoor() );  //강제형변환
		System.out.println(((Spark)carArr[2]).getDiscountRate());  // "." 이 우선순위가 높기 때문에,
																   // ()를 꼭 붙혀서 강제형변환을 먼저해야한다
		
		
		// git 연습 중입니다 
		
		
		
	}

}
