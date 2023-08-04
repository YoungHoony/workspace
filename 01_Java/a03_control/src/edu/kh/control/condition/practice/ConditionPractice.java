package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	// 실습 문제 1
	
	//키보드로 입력 받은 정수가 양수이면서 짝수일 때만 “짝수입니다.”를 출력하고
//	짝수가 아니면 “홀수입니다.“를 출력하세요.
//	양수가 아니면 “양수만 입력해주세요.”를 출력하세요.
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();
		
		if (input > 0 && input % 2 == 0) { //양수 + 짝수
			System.out.println("짝수입니다.");
		}		else if (input > 0 && input % 2 == 1) { //양수 + 홀수
			System.out.println("홀수입니다.");
		}
		
		else {
			System.out.println("양수만 입력해주세요.");
		}
		
		
	}
	
	/* practice1 - 중첩 if로 해보기
	 * if(input > 0) { //양수
	 * 
	 *    if (input % 2 == 0) {
	 *       System.out.println("짝수 입니다.");
	 *       } else {
	 *       System.out.println("홀수입니다."); 
	 *        }
	 * } else { //양수 아님
	 *
	 * System.out.println("양수만 입력해주세요.");
	 * }
	 */
		
	// 실습 문제 2
	
	// 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계싼하고
	// 합계와 평균을 이용하여 합격/ 불합격 처리하는 기능을 구현하세요.
	//(합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
	//합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고
	//불합격인 경우에는 “불합격입니다.”를 출력하세요.
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		//합계
		int sum = kor + math + eng ;
		
		//평균
		double avg = (kor + math + eng) / 3 ;

		//합격 여부 
		if (kor >= 40 && math >= 40  && eng >= 40 && avg >= 60) {
			System.out.printf("국어 : %d \n", kor);
			System.out.printf("수학 : %d \n", math);
			System.out.printf("영어 : %d \n", eng);
			System.out.printf("합계 : %d \n", sum);
			System.out.printf("평균 : %.1f  \n", avg);
			System.out.println("축하합니다, 합격입니다!");
					            
			
		}else { //불합격
				System.out.println("불합격입니다.");
	
			}
		}
		
		
	// 실습 문제 3
	
	// 1~12 사이의 수를 입력 받아 해당 달의 일수를 출력하세요. (2월 윤달은 생각하지 않습니다.)
	//잘 못 입력한 경우 " OO월은 잘못 입력된 달입니다."를 출력하세요. (switch문 사용) 
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		String result = "월";
		
		boolean flag = false;
		
		switch (month) {
		
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : result = "31일"; break;
		case 4 : case 6 : case 9 : case 11 : result = "30일"; break; 
		case 2 : result = "28일"; break;
		default : flag = true; 
		}
		
		
		if (!flag) {
			System.out.printf("%d월은 %s까지 있습니다.", month, result);
			
		} else { 
			System.out.printf("%d월은 잘못 입력된 달입니다.", month);
		}
		
				
		}
		
	
	// 실습 문제 3 (다른 방법)
	/* Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		int day = 0; // 해당하는 달의 마지막 일 (날짜)을 저장
		             // 단 1~12월이 아니면 0을 저장
		              * 
		switch(month) {
		case 1: case 3:  case 5: case 7: case 8: case 10: case 12: day = 31; break;
		
		case 4: case 6: case 9: case 11: day = 30 ; break;
		
		case 2 : day = 28; break;
		
		    // default : day = 0 ;  (위에 day = 0으로 뒀기 때문에, 위에 케이스에 없는 숫자라면 그냥 0이 된다. 
		     * 
		if (day == 0) { //1 ~12사이가 입력되지 않았을 때
		system.out.printf("%d월은 잘못 입력된 달입니다." , month);
		
		} else {   // 1~12사이가 입력되었을 때,
		 system.out.printf("%월은 %d일까지 있습니다." , month, day);
	
	 */
	
	
	// 실습 문제 4
//	키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라
//	저체중/정상체중/과체중/비만을 출력하세요.
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요. : ");
		double weight = sc.nextDouble();
		
		double bmi = (weight / (height * height));
				
		System.out.printf("BMI 지수 : %.14f \n", bmi);
		
		if (bmi < 18.5) {
			System.out.println("저체중");
		}	else if (bmi < 23) {
				System.out.println("정상체중");
			} else if (bmi < 25) {
				System.out.println("과체중");
			  } else if (bmi < 30) {
				  System.out.println("비만");
			  } else {
				  System.out.println("고도비만");
			 }
	
		}
	
	/*  실습 문제 4 다른 방법
	 * Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요. : ");
		double weight = sc.nextDouble();
		
		double bmi = (weight / (height * height));
		
		String str; //결과 저장
		if (bmi < 18.5) {
		str = "저체중";
		
		} else if (bmi <23) {
		str = "정상체중";
		} else if (bmi <25) {
		str = "과체중";
		} else if (bmi <30) {
		str = "비만";
		
		} else {
		str = "고도비만";
	}
	System.out.println("BMI 지수 : " + bmi);
	System.out.println(str);
		
	 * 
	 */
	
	// 실습 문제 5
	
//	//중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
//	평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
//	이 때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 따진 값으로 계산하세요.
//	70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int midTerm = sc.nextInt();
		
		System.out.print("기말 고사 점수 : ");
		int finalTerm = sc.nextInt();
		
		System.out.print("과제점수 : ");
		int assignment = sc.nextInt();
		
		System.out.print("출석 횟수 :  ");
		int attendance = sc.nextInt();
		
		
		System.out.println("================결과==================");
		
		
		// 출석 횟수가 부족한 경우
		
		if (attendance <= 20 * (1-0.3)) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]" , attendance);
			
		} else { //출석은 잘했을 때
			
			// 점수를 환산

			double midScore = midTerm *0.2;
			double finalScore = finalTerm * 0.3;
			double assignmentScore = assignment * 0.3;
			double attScore = attendance * 5 * 0.2; //20회기 때문에, 100점으로 맞춘다음 계산해야한다. 그렇기 때문에 5 곱하기 20%퍼

			
			//총점
			double sum = midScore + finalScore + assignmentScore + attScore; 
			System.out.println("중간 고사 점수(20) : " + midScore);
			System.out.println("기말 고사 점수(30) : " + finalScore);
			System.out.println("과제 점수     (30) : " + assignmentScore);
			System.out.println("출석 점수     (20) : " + attScore);
			System.out.println("총점 : " + sum);
			
			if (sum >= 70) {
				System.out.println("PASS");
				
			} else {
				System.out.println("Fail [점수 미달]");
			}
		
		
		// 내가 잘못한  내용
//		double result = (midTerm*0.2) + (finalTerm*0.3) + (assignment*0.3) + attendance ; 
//				
//		if (attendance <= 14) {
//			System.out.printf("Fail [출석 횟수 부족 (%d/20)", attendance);
//		
//		} else  (result >= 70)  
//			System.out.println("중간 고사 점수(20) : " + (double)(midTerm* 0.2));
//			System.out.println("기말 고사 점수(30) : " + (double)(finalTerm* 0.3));
//			System.out.println("과제 점수     (30) : " + (double)(assignment* 0.3));
//			System.out.println("출석 점수     (20) : " + (double)(attendance));
//			System.out.println("총점 : " + result);
//			System.out.println("Pass");
//		} if (result < 70) {
//			System.out.println("중간 고사 점수(20) : " + (double)(midTerm* 0.2));
//			System.out.println("기말 고사 점수(30) : " + (double)(finalTerm* 0.3));
//			System.out.println("과제 점수     (30) : " + (double)(assignment* 0.3));
//			System.out.println("출석 점수     (20) : " + (double)(attendance));
//			System.out.println("총점 : " + result);
//			System.out.println("Fail [점수 미달]");
//			
//		}
//	
		
		
		}
	
	
	
}
}

