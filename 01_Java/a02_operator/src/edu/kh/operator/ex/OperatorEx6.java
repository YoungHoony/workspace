package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx6 {

	public static void main(String[] args) {
	
		//Scanner 작성 후 ctrl + spacebar -> Scanner  - java.util선택하면 import 구문 자동 완성
	Scanner sc = new Scanner(System.in);
	
	System.out.println("[홀짝 검사기]");
	
	System.out.print("정수를 입력하세요 : ");
	int input1 = sc.nextInt();
	
	// 삼항 연산자
	// 조건식 (true/false) ? true인 경우 : false인 경우;
	
	
	String result = input1 % 2 == 0 ? "짝수" : "홀수";
	                                   //" "  리터럴 표기법에 의해 string 문자이기 때문에
	// 조건식이 true이면 "짝수"
	// 조건식이 false이면 "홀수"
	// 를 result 변수에 저장
	
	System.out.println(result);
	
		
	}
	
}
