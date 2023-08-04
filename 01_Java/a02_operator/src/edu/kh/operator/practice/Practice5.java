package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice5 {
	
	public static void main(String[] args) {
		
		// 문제 5: 국어, 영어, 수학에 대한 점수를 키보드를 이용해 정수로 입력 받고,
		// 세 과목에 대한 합계 (국어+영어+수학)와 평균 (합계/3.0)을 구하세요.
		// 세 과목의 점수와 평균을 가지고 합격 여부를 처리하는데
		// 세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격, 아니라면 불합격을 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : " );
		int math = sc.nextInt();
		
		// 합계
		
		int sum = kor + eng + math; 
				
		System.out.println("\n" + "합계 : " + sum);
		
		//평균
		//int / double
		// double (자동형변환) / double = double
		
		double average = sum / 3.0; 
		
		System.out.println("평균 : " + average);
		
		String result  = kor >= 40 && eng >= 40 && math >=40 && average >= 60.0 ? "합격" : "불합격";
		
		System.out.println(result);
		
		
		
		
		
		
		
	}

}
