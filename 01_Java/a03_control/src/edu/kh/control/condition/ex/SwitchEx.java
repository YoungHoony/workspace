package edu.kh.control.condition.ex;

import java.util.Scanner;

//기능용 클래스
public class SwitchEx {
	
	/* switch 문
	 * - 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	 *   -> 식의 결과에 맞는 case 구문이 수행됨
	 *   
	 *   [작성법]
	 *   
	 *   switch(식){  // 식의 결과는 정수 또는 문자열
	 *   
     *   case 결과1 : 결과1의 수행 코드; break;
	 *   case 결과2 : 결과2의 수행 코드; break;
	 *   case 결과3 : 결과3의 수행 코드; break;
	 *   ...
	 *   
	 *   default : 모든 case가 만족하지 못할 때 수행할 코드
	 *   
	 *   }
	 */
	
	//switch 예제 1
	
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		
		//키보드로 정수를 입력 받아
		// 1 : RED
		// 2 : ORANGE
		// 3 : YELLOW
		// 4 : GREEN
		// 5 : BLUE
		// 1~5가 아니면 : Black 
		
		System.out.print("정수를 입력 하세요 : ");
		int input = sc.nextInt();
		
		String result; //결과 저장용 변수
		
		//if 문 버전
		
//		if (input == 1 ) { 
//			result = "RED";
//		} else if ( input == 2) {
//			result = "ORANGE";
//		} else if (input == 3) {
//			result = "YELLOW";
//		} else if (input == 4) {
//			result = "GREEN";
//	    } else if (input == 5) {
//	    	result = "BLUE";
//		} else {
//			result = "Black";
//		}
		
		// Switch 버전 (switch는 : 로 시작하여 ; (세미콜론)으로 끝나는 것)
		switch (input) {
		case 1 : result = "RED"; break;
		case 2 : result = "ORANGE"; break;
		case 3 : result = "YELLOW"; break;
		case 4 : result = "GREEN"; break;
		case 5 : result = "BLUE"; break;
		default : result = "BLACK" ; break; //default에서는 break를 안써도 된다!
		}
		
		System.out.println(result);		
		
	}

	// switch 예제 2
	public void ex2() {
		
		// 점심 결정 프로그램
		
		// 난수(Math.random() ), switch문
		
		// 1부터 5사이의 난수를 발생시켜
		// 일치하는 수의 메뉴를 출력
		
		// Math.random() : 0.0 <= x < 1.0  //double 형
		
		// Math.random() * 5 : 0.0 <= x * 5 < 5.0 
		
		// Math.random() * 5 + 1 : 1.0 <= (x * 5) +1 < 6.0 
		
		// (int)Math.random() * 5 + 1) : 1 <= (int)(x * 5 +1) < 6 
		
		

		// 1~5 난수 생성
		int randomNumber = (int)(Math.random() * 5 + 1);
		
		// String menu;  //선언만 함. (초기화가 안되어있음) --> 문제가 됨. 
		String menu = null; //null : 참조하는 것이 없다. (빈칸)
		                    // 컴퓨터를 안심시키기 위해 초기화를 한다. 
		
		switch(randomNumber) {
		case 1 : menu = "제육볶음"; break;
		case 2 : menu = "서브웨이"; break;
		case 3 : menu = "국밥"; break;
		case 4 : menu = "파스타"; break;
		case 5 : menu = "초밥"; break;
		
		}
		
		System.out.printf("오늘의 점심 메뉴는 [%s] 입니다.", menu);
		
	}
	
	
	    // switch 예제 3
	public void ex3() {
		// 문자열로 메뉴를 입력 받아서
		// 해당 메뉴의 가격을 출력
		
		//[실행 화면]
		// 메뉴를 선택해주세요 (김밥, 라면, 떡볶이) : 김밥
		// 김밥의 가격은 3000원 입니다. 
		
		// 메뉴를 선택해주세요 (김밥, 라면, 떡볶이) : 샌드위치
		// 존재하지 않는 메뉴입니다. 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴를 선택해주세요(김밥, 라면, 떡볶이) : ");
		
		String menu = sc.next(); //단어(음절) 입력
		
		int price; //가격 저장용 변수 선언
		
		switch (menu) {
		case "김밥"   : price = 3000;    break; //문자열이기 때문에 ""으로 넣어야한다.
		case "라면"   : price = 2500;    break; 
		case "떡볶이" : price = 4000;    break; 
		default       : price = -1; //잘못 입력되었다는 신호로 삼는다. (임의로 저장해도 된다) (중요하다!!!!!!!!)
		
		}
		
		// ******* 값에 의미를 부여해서 조건식에 사용하는 방법을 이해해야한다! ********
		
		if(price != -1) { //정상 입력한 경우
			System.out.printf("%s의 가격은 %d 입니다." , menu, price);
			
		} else { //잘못 입력한 경우
			System.out.println("존재하지 않는 메뉴입니다.");
		}
		
	}
	
	// switch 예제 4
	
	public void ex4() {
		
		//산술 연산 계산기
		
		// - 두 정수와 1개의 연산자(+ - * / %)를 입력 받아 연산 결과를 출력
		
		// [실행화면]
		// 정수1 입력 : 5
		// 연산자 : +
		// 정수2 입력 : 4
		// 5 + 4 = 9
		
		// 정수1 입력 : 5
		// 연산자 : /
		// 정수2 입력 : 4
		// 5 / 4 = 1
		
		// 정수1 입력 : 2
		// 연산자 : @
		// 정수2 입력 : 10
		// 존재하지 않는 연산자 입니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("연산자 : ");
		String op = sc.next(); //한글자만 입력해도 String이기 때문에, string으로 저장한다!
		
		System.out.print("정수2 입력 : ");
		int num2 = sc.nextInt();
		
		int result = 0; // 계산 결과 저장용 변수 선언 및 초기화
		                // -> 초기화를 했기 때문에
		                // switch문에서 값이 대입되지 않아도
		                // 이후 result 출력 시 문제 발생 X
		boolean flag = false; // 신호용 변수(상태를 기록하고 조건문에 사용할 변수) 
		// false일 때 : 연산자를 정상적으로 입력 
		// true 일 때 : 연산자를 잘못으로 입력
		
		//String no = null;
		
		
		switch (op) {
		case "+"  : result = num1 + num2; break;
		case "-"  : result = num1 - num2 ; break;
		case "*"  : result = num1 * num2 ; break;
		case "/"  : result = num1 / num2 ; break;
		case "%"  : result = num1 % num2 ; break;
		//default   : result = -1;		
		default : flag = true ; // 연산자를 잘못 입력 -> flag를 true로 변경
		}
		
		//flag == false 와 !flag는 같은 결과 (flag 자체가 boolean이기 때문에, 조건문) 
		if(!flag) {// 정상 입력 == flag가 false  // if 구문에선 true여야지만 실행이 되기 때문에, !flag로 해서 true로 둬야지만 작동이 된다)
		//if(result != -1) {
			System.out.printf(" %d %s %d = %d", num1, op, num2, result);
		} else { 
			System.out.println("존재하지 않는 연산자 입니다.");
		}
		
		// 만약에 num1 == 3, num2 == 4 , 연산가 "-" 이면, 결과가 존재하지 않는 연산자가 됨. 
		// 이걸 해결하기 위해 변수를 하나 더 설정해준다.
		
		//if(no == "존재") {
		//	System.out.println("존재하지 않는 연산자 입니다.");
			
		//} else {	System.out.printf("%d %s %d = %d", num1 , op, num2 , result );
		//}
		
		
		
		/*switch(op) {
		 * case "+" : System.out.printf("%d %s %d = %d", num1 , op, num2 , num1+num2 ); break;
		 * case "-" : System.out.printf("%d %s %d = %d", num1 , op, num2 , num1-num2 ); break;
		 * case "*" : System.out.printf("%d %s %d = %d", num1 , op, num2 , num1*num2 ); break;
		 * case "/" : System.out.printf("%d %s %d = %d", num1 , op, num2 , num1/num2 ); break;
		 * case "%" : System.out.printf("%d %s %d = %d", num1 , op, num2 , num1%num2 ); break;
		 * default : System.out.println("존재하지 않는 연산자 입니다.")
		 * 
		 */
		
		
	}
	
	
	// switch 예제 5 - break의 역할
	
	public void ex5() {
		
		// switch문을 이용한 계절 판별기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String season; // 결과 저장
		
		// break : 멈추다
		// break의 역할 : 해당 case를 수행한 후 switch문을 멈춰서 빠져 나가라
		
		//  *break가 없는 경우 *
		// - break를 만나거나 switch가 끝날 때 까지 
		// 다음 case를 연달아 실행
		
		switch(month) {
//		case 1 : season = "겨울"; break;
//		case 2 : season = "겨울"; 
//		case 3 : season = "봄"; 
//		case 4 : season = "봄"; 
//		case 5 : season = "봄"; 
//		case 6 : season = "여름"; break;
//		case 7 : season = "여름"; break;
//		case 8 : season = "여름"; break;
//		case 9 : season = "가을"; break;
//		case 10 : season = "가을"; break;
//		case 11 : season = "가을"; break;
//		case 12 : season = "겨울"; break;
//		default : season = "잘못 입력";
		case 12 : season = "겨울"; 
		case 1 : season = "겨울"; 
		case 2 : season = "겨울"; break;
		
		case 3 : season = "봄"; 
		case 4 : season = "봄"; 
		case 5 : season = "봄"; break;
		
		case 6 : season = "여름"; 
		case 7 : season = "여름"; 
		case 8 : season = "여름"; break;
		
		case 9 : season = "가을"; 
		case 10 : season = "가을"; 
		case 11 : season = "가을"; break;
		
		default : season = "잘못 입력";
		
		/* 	
		case 12 :
		case 1 :
		case 2 : season = "겨울"; break;
		
		case 3 :
		case 4 :
		case 5 : season = "봄"; break;
		
		case 6 :
		case 7 :
		case 8 : season = "여름"; break;
		
		case 9 :
		case 10 :
		case 11 : season = "가을"; break;
		
		default : season = "잘못 입력";
		 * 
		 */
		
		/* 	
		case 12 : case 1 : case 2 : season = "겨울"; break;
		
		case 3 : case 4 : case 5 : season = "봄"; break;
		
		case 6 : case 7 : case 8 : season = "여름"; break;
		
		case 9 : case 10 : case 11 : season = "가을"; break;
		
		default : season = "잘못 입력";
		 * 
		 */
		
		}
		
		System.out.println(season);
		
	}
	
	
	
	
	
	
	
}
