package edu.kh.variable;

import java.util.Scanner; //Scanner 가져오기

public class VariableEx7 {
	
	public static void main(String [] args) {
		
		//Scanner 생성하기
		Scanner sc = new Scanner(System.in);
		
		
		// 이름 : 홍길동
		// 나이 : 20
		// 성별 : 남자
		// 키 : 177.4
		// 희망 재산 : 1000000000000 
		
		//홍길동님은 20세 남자이며 키는 177.4cm, 희망 재산은 1000000000000원 입니다. 
		
		// System.out.println(); //출력후 줄바꿈 O
		
		System.out.print("이름 : "); // 출력 후 줄바꿈 X
		String name = sc.next(); //입력 받은 문자열을 name에 저장
		
		//키보드 값 입력값 받기 (문자열) : sc.next(); 또는 sc.nextline();
		// --> sc.nextline();의 경우 문제가 있음. 
		
		System.out.print("나이 : ");
		int age = sc.nextInt(); //정수를 입력할 때
		
		System.out.print("성별 : ");
		String gender = sc.next();
		
		System.out.print("키 : ");
		double height = sc.nextDouble();
		
		System.out.print("희망 재산 : ");
		long property = sc.nextLong();
		
		//홍길동님은 20세 남자이며 키는 177.4cm, 
		// 희망 재산은 1000000000000원 입니다. 
		
		String result = name + "님은 ";
		
		result = result + age + "세 ";
		
		result = result + gender + "이며 ";
		
		result = result + "키는 " + height + "cm, ";
		
		result = result + "희망 재산은 " + property + "원 입니다.";
		
		
		System.out.println(result); 
		
		
		
	}
	
	

}
