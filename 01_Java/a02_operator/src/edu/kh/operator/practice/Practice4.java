package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice4 {
	
	public static void main(String[] args) {
		
		// 문제 4: 나이를 키보드로 입력 받아 어린이 (13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지,
		// 성인(19세 초과)인지 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : age > 13 && age <= 19 ? "청소년" : "성인" ;
		
		// age > 13 && age <= 19 : 청소년
		// age > 19 : 성인
		// 더 짧은 코드가 있기에, 더 효율적일 수 있음
		
		// (표현 방법 2) String result = age <= 13 ? "어린이" : (age >19 ? "성인" : "청소년");
		
		// (표현 방법 3) String result = age <= 13 ? "어린이" : (age <= 19 ? "청소년" : "성인");
		
		//age가 15인 경우
		// 어린이를 찾는 조건 (age <= 13)을 만족하지 못하므로 이후에는
		// age가 13 이하인 경우를 범위에서 제외하면 된다. 
		
		// -> 청소년을 찾는 조건을 age <= 19 라고만 작성해도
		// 13이하를 제외하기 때문에
		// age > 13 && age <19 조건과 동일 조건이 성립된다. 
		
		
		// 응용 공부를 해보자. 영유아, 노인, 회원 등급 다 넣어서 해보기.
		
		System.out.println(result);
		
		
		
		
	}

}
