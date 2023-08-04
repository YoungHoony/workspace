package edu.kh.control.loop.practice;

import java.util.Scanner;

public class LoopPractice {
	
// 실습문제 1
//	사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
//	단, 입력한 수는 1보다 크거나 같아야 합니다.
//	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		
		
public void practice1() {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("1이상의 숫자를 입력하세요 : ");
	int input = sc.nextInt();

	
	for (int i = 1 ; i <= input ; i++ ) {
		if (input > 0) {
			System.out.print(i + " ");
		} 
	 else { 

	} 
} System.out.println("1 이상의 숫자를 입력해주세요.");

}



//실습문제 2
//사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
//단, 입력한 수는 1보다 크거나 같아야 합니다.

public void practice2() { 
	
	Scanner sc = new Scanner(System.in);
	System.out.print("1이상의 숫자를 입력하세요 : ");
	int input = sc.nextInt();
	
	for (int i = input ; i >= 1 ; i-- ) {
		if ( input >= 1) { 
			System.out.print(i + " ");
		
		} else {
			
	} 

} System.out.println("1 이상의 숫자를 입력해주세요.");

}


//실습 문제 3
// 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.

public void practice3() {

	Scanner sc = new Scanner(System.in);
	System.out.print("정수를 하나 입력하세요 : ");
	int input = sc.nextInt();
	
	int sum = 0;

	for (int i = 1 ; i <= input ; i++) {
		sum += i;
		
		System.out.print(i);
		if (i == input) {
			System.out.print(" = ");
			
		} else { System.out.print(" + ");
	}
		}
		System.out.println(sum);
	} 
	
	
	

	
//	Scanner sc = new Scanner(System.in);
//	System.out.print("정수를 하나 입력하세요 : ");
//	int input = sc.nextInt();
//	
//	int sum = 0;
//	
//	
//	for (int i = 1 ; i <= input ; i++) {
//		sum += i; 
//		System.out.printf("%d + ", i);
//	}
//	
//} 




//실습 문제 4
//사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요
//만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요 를 출력하세요

public void practice4() {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("첫 번째 숫자 : ");
	int input1 = sc.nextInt();
	
	System.out.print("두 번째 숫자 : ");
	int input2 = sc.nextInt();
	
	if (input1  > 0 && input2  > 0 ) {
		
		
		if (input1 < input2) {
		
	for (int i = input1 ; i <=input2 ; i++) {
		System.out.print(i + " ");
		for (int x = input2 ; x <=input1 ; x++) {
	} 

	} } else if ( input1 >= input2) {
		for (int i = input2 ; i <= input1 ; i++) {
			System.out.print(i + " ");
		}
	}
		
	} else  {
		System.out.println("1 이상의 숫자를 입력해주세요.");
	
	
} 

}

// practice4 풀이 (쉬운 버전)
//Scanner sc = new Scanner(System.in);
//
//System.out.print("첫 번째 숫자 : ");
//int input1 = sc.nextInt();
//
//System.out.print("두 번째 숫자 : ");
//int input2 = sc.nextInt();

// 작은 수부터 큰 수까지 1씩 증가하며 반복

// if (input1 <= input2) { //먼저 입력한 수가 작거나 같을 때
 //for (int i =input1; in<=input2 ; i++) {
// System,out.print(i + " ");
//}
//} else { //나중에 입력한 수가 작을 때
//	for (int i = input2 ; i <= input1 ; i++) {
//  System,out.print(i + " ");
// } } 
//} else { 
// System.out.print(i + " ");
//}
//}

/* practice4 풀이 (어려운 버전) - 생각을 좀 해봐야되는 방법 + 변수를 아는가?
 * //Scanner sc = new Scanner(System.in);

	System.out.print("첫 번째 숫자 : ");
	int input1 = sc.nextInt();

	System.out.print("두 번째 숫자 : ");
 	int input2 = sc.nextInt();

 // 작은 수부터 큰 수까지 1씩 증가하며 반복
  * if (input1 > input2) { 
  *	// 먼저 입력한 수가 더 큰 경우
 * } 
 *  for (int i=inpu1 ; i<=input2 ; i++) {
 *    System,out,print(i + " "); 
 * 
 * input1 와 input2의 두 변수의 값 교환(임시 변수 필요)
 * "대신 들고 있을 것이 필요함." "사람 손은 두개라 하나는 받고, 하나는 줄수 있는데" 
 * "컴퓨터는 한손만 있어서, 다른 손이 필요함"
 * 
 *  int temp = input1;
 *  input1 = input2;
 *  input2 = temp; 
 *  
 *  temp
 *  input1 = 5
 *  input2 = 3
 * 
 * 
 * 
 * 
 * 
 */




public void practice5 () {
	
	//사용자로부터 입력 받은 숫자의 단을 출력하세요.
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("숫자 : ");
	int input = sc.nextInt();
	
	System.out.printf("====== %d단 ====== \n", input);
	
	for ( int i = 1 ; i <= 9 ; i++) {
		System.out.printf("%d * %d = %d \n", input, i, i*input);
		
	}
	
	
	
}


public void practice6() {
	
	//사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
	//단, 2~9를 사이가 아닌 수를 입력하면 "2~9사이 숫자만 입력해주세요"를 출력하세요. 
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("숫자 : ");
	int input = sc.nextInt();
	
	if (input >=2 && input <=9 ) { 
		
		
		for (int x = input ; x <=9 ; x++) { 
			System.out.printf("========= %d단 ========== \n", x);
		
			for (int i = 1 ; i <=9 ; i++) { 
			System.out.printf("%d x %d = %d \n", x, i, i*x);
		
	}
		
	} }   else  { 
  		System.out.println("2~9사이 숫자만 입력해주세요.");
			} 
		
	} 

	public void practice7() {
		
		//다음과 같은 실행 예제를 구현하세요
		// *
		// ** 
		// ***
		// ****	
		
	
	for (int row = 1 ; row <= 4 ; row++) {
		for (int col = 1; col <= row  ; col++) {
			System.out.print(col + " ");
			
		}
		System.out.println();
	}
	
	}
public void practice8() {
	
	//다음과 같은 실행 예제를 구현하세요.
	// **** 4 3 2 1
	// ***  3 2 1
	// **   2 1 
	// *    1
	
	
	
	for (int row = 4 ; row >=1 ; row-- ) { // 4 3 2 1
		for (int col = row ; col >= 1 ; col--) {
			System.out.print(col + " ");
		} System.out.println();
	}
	
	
	
	
}

public void practice9() {
	// 다음과 같은 실행 예제를 구현하세요.
	//    *
	//   **
	//  ***
	// ****
	
	for ( int row = 1 ; row <= 4 ; row++) {
		for (int col = 1 ; col <= row ; col++) {
		System.out.print(col + " ");
		} System.out.println();
	} 
		
}

}