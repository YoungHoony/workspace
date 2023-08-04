package edu.kh.variable;

public class VariableEx2 {

	//main method : 자바 프로그램 실행용 구문
	
	public static void main(String[] args) {
		
		/* 변수 : 메모리에 값을 저장하기 위한 공간 (어떤 박스에 넣을 것인가?)
		 * 
		 * 변수 선언 : 메모리에 값을 저장할 공간을 생성 (할당)
		 * 
		 * 자료형 (Type) : 변수의 종류(크기, 형식) 
		 * 
		 * 자바의 기본 자료형 8가지 
		 * 
		 * - 논리형 : boolean (1byte), true/false 만 저장 
		 * 
		 * - 정수형 : byte (1byte) , short (2byte), int (4byte, 정수 기본형), long (8byte)
		 * 
		 * - 실수형 : float (4byte), double (8byte, 실수 기본형) 
		 * 
		 * - 문자형 : char (2byte, 유니코드(UTF-16))
		 * 
		 */
		
		boolean isTrue; //변수 선언
		// 논리형 데이터(true/false)를 저장할 공간
		// 1byte를 메모리에 할당하고
		//그 공간을 isTrue라고 부르겠다. 
		
		int number1;
		// 정수형 데이터를 저장할 공간
		// 4byte를 메모리에 할당하고
		// 그 공간을 number1라고 부르겠다. 
		
		double number2;
		// 실수형 데이터를 저장할 공간
		// 8byte를 메모리에 할당하고
		// 그 공간을 number2라고 부르겠다. 
		
		// 대소문자가 구분되며 길이 제한이 없다
		int aaa;
		
		//예약어를 사용하면 안된다 ex) true, final, string
		int aaA;
	
		//숫자로 시작하면 안된다.
		int age1;
		
		//특수문자는 '_'와 '$'만을 허용한다. 
		int $ag_e;
		
		//카멜 표기법 (첫 시작 글자는 소문자가 관례, 단어의 첫 글자를 대문자로 한다)
		int userAge; // 카멜 표기법(낙타봉 표기법)
		
		int showMeTheMoney;
		
		//변수의 이름을 지을 때, 한글, 아랍어.. 등등 된다 (대신, 한글을 안쓰는게 좋다, 맥이나 영어 os에서는 깨질 수 있음)
		
		int 변수명이지롱;
		int 나이; //한글도 가능은 하지만 사용 X
		
		//값 대입 : 변수 (메모리 공간)에 값을 집어 넣는 것
		
		// f(x) = x + 2
		// x = 0 -> f(0) = 0 + 2
		// x = 10 -> f(10) = 10 + 2 = 12
		
		
		isTrue = true; // boolean형 변수에 true 대입했다. 
		//boolean 리터럴 표기법 :  true/false
		
		number1 = 12345; //int형 변수에 12345 대입
		//int 리터럴 표기법 : -10, 0 , 1과 같은 일반적인 정수 
		
		number2 = 999.9999; //double형 변수에 999.9999를 대입
		//double 리터럴 표기법 : -1.23, 0.0, 1.0, 3.14과 같은 일반적인 실수 
		
		
		System.out.println("isTrue에 저장된 값: "  + isTrue);
		System.out.println("number1에 저장된 값: " + number1);
		System.out.println("number2에 저장된 값: " + number2);
		
		long number3 = 10000000000L; //100억
		//10000000000 (int형 100억)
		// The literal 10000000000 of type int is out of range (int형에서 벗어나는 range이기 때문에 에러)
		//10000000000L (long형 100억) 
		
		float number4 = 3.14f; //실수형 4byte 
		// 3.14는 double 리터럴 표기법
		// -> 3.14f (소문자 f로 사용함) float 리터럴 표기법이다. 
		
		
		char ch1 = 'A'; //문자형 
		// 문자형의 리터럴 표기법은 ' ' (quotation mark 홑따옴표) 
		
		//리터럴 표기법 L, f, '' 가 출력 되는지 확인
		// -> 출력되지 않음. 
		// -> 변수에 저장할 때 자료형에 맞게 인식하는 용도 
		
		System.out.println("number3에 저장된 값 : " + number3);
		System.out.println("number4에 저장된 값 : " + number4);
		System.out.println("ch1에 저장된 값 : " + ch1);
		
		
		
		
	}
	
	
	
}
