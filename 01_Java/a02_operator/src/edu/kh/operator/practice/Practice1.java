package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice1 {
	
	public static void main(String[] args) {
		
		// 문제 1: 모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고
		// 1인당 동일할게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int input2 = sc.nextInt();
		
	    System.out.println();
		
		int result1 = (input2 / input1);
		System.out.println("1인당 사탕 개수 : " + result1);
		
		int result2 = (input2 % input1);
		System.out.println("남는 사탕 개수 : " + result2 + "\n");
		
		System.out.printf("1인당 사탕 개수 : %d \n", input2 / input1);
		
		System.out.printf("남는 사탕 개수 : %d \n", input2 % input1);
		
		
		
		
	}

}

