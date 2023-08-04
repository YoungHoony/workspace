package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		
		//실습 2 키보드로 입력 받은 정수가 양수이면 "양수", 양수가 아니면 "양수 아님"를 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수 입력 : ");
		
		int input = sc.nextInt();
		

		String result = input > 0 ? "양수" : "양수 아님";
		System.out.println();
		System.out.println(result);
		
		// 위의 세줄을 한줄로 만든다. 하지만 실제로는 그렇게 쓰지는 않는다.
		//System.out.println("\n" + (input > 0 ? "양수" : "양수 아님") );
		
		
		
		
	}

}
