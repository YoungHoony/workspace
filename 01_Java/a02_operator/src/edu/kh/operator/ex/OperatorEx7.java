package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[홀짝 검사기 v2]");
		
		System.out.print("정수를 입력하세요 : ");
		
		int input = sc.nextInt();
		
		// tip. 다음 ; (세미콜론)이 나타날 때 까지가 한 줄이다! 
	
		// 조건식 (true/false) ? true인 경우 : false인 경우;
		// 짝수, 홀수, 0 입니다. 
		
		String result = input == 0 ? "0입니다" : 
			                (input % 2 == 0 ?  "짝수" : "홀수");
		
		//위와 같은 내용인데 한줄로 쓰기 >> 
		// String result = input == 0 ? "0입니다" : (input % 2 == 0 ?  "짝수" : "홀수");
		
		System.out.println(result);
		
			                
			                
			                
			                
	}
}
