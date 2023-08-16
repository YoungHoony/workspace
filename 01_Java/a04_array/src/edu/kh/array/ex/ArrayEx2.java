package edu.kh.array.ex;

import java.util.Scanner;

public class ArrayEx2 {
	
	/*
	 * 변수 : 값을 저장하기 위한 메모리 공간
	 * 
	 * 1차원 배열 : 같은 자료형의 변수를 묶음으로 다루는 것
	 * 
	 * 2차원 배열 : 같은 자료형의 1차원 배열을 묶음으로 다루는 것 
	 * 
	 *  2차원 배열 참조 변수
	 *      -> 1차원 배열 참조 변수 묶음(배열)
	 *      	-> 각 참조 변수는 1차원 배열을 참조 
	 */
	
	
	public void ex1() {
		//2차원 배열 선언, 할당
		
		int[][] arr = new int[2][3]; // 2행 3열 
		
		// 인덱스를 이용한 초기화
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;
		
		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;
		
		
		
		//2중 for문을 이용해서 모두 
		// 배열의 모든 요소에 접근하여 출력하기
		
		
		// row <2 == row<arr.length
		// -> 2차원 배열에서 배열명.length == 행의 개수
		
		// 행 제어
		for (int row = 0; row < arr.length ; row++) {
			
			 // col <3 ==  col < arr[row].length
			// -> row번째 행이 참조하는 1차원 배열의 길이
			// == 각 행의 열의 개수
			
			// 열 제어
			for (int col = 0 ; col < arr[row].length ; col++) {
				
				System.out.print(arr[row][col] + " ");
				
			}
			
			System.out.println();
			
			
			// 배열 참조 변수.length
			// --> 참조하고 있는 배열의 길이를 반환
			
			// arr == 1차원배열 참조 변수의 묶음(배열)을 참조하는 변수
			//arr.length
			
			// arr[0] == 1차원 배열 참조 변수
			// arr[0].length == 3
			
			// arr[1] == 1차원 배열 참조 변수
			// arr[1].length == 3
	
		}
		
	}
	
	// 답 
//	7 14 21 
//	28 35 42 

	
	
	//2차원 배열 선언과 동시에 초기화
	public void ex2() {
		
		char[][] arr = { {'a','s','d' }, 
				         {'z','x','c'}, 
				         {'f','g','h'} }; //3행 3열
		
		// 입력 받은 알파벳의 위치를 검색하는 프로그램
		
		// 1. char 입력 받기
		Scanner sc = new Scanner(System.in);
		
//		String input = sc.next(); // 문자열 (단어) 입력 받기  //띄어쓰기가 없는 문자열
		
		// sc.nextChar()는 존재하지 않으므로
		// sc.next()를 이용해 문자열을 입력 받은 후
		// string == char 배열이랑 같은 것이다. 
		// String.charAt(index)를 이용해 0번 인덱스 값을 반환 받기
		// 자바가 char가 없는데, 우회해서 받을 수 있게 char.at(index)를 사용한다.
		
		
		System.out.print("검색할 알파벳을 입력해주세요 : ");
		char input = sc.next().charAt(0);
		// -> 입력된 알파벳(char) input에 대입
		
//		int input1 = sc.nextInt();
//		double input2 = sc.nextDouble();
//		long input3 = sc.nextLong();
		
		// 2차원 배열을 참조하는 arr을 이용해서
		// 2차원 배열의 모든 요소를 접근하는 2중 for문 작성
							
		// flag =신호를 주기 위한 용도의 변수
		// true :  "검색 결과 없음" 으로 의미를 부여
		// false :  " 검색 결과가 존재함"으로 의미를 부여
		
		boolean flag = false;
		
									// 3
		for (int row = 0 ; row < arr.length ; row++) {
			
			for(int col = 0 ; col < arr[row].length ; col++) {
				
				//검사를 해라, 검색을 해라. 하면 "if문을 쓴다"
				
				// 현재 접근한 2차원 배열 요소의 값이
				// 입력 받은 input과 같은지 확인
				if (arr[row][col] == input ) {
					System.out.printf("%c는 %d행 %d열에 있습니다", arr[row][col], row, col);    //%c : char
				
					flag = true; // flag 변경
				} 
				
			}
			
		}
		
		
		//2중 for문 (검색) 코드가 끝난 후 flag의 상태를 검사
		if(!flag) { // flag가 true이면 if 실행
			       // flag가 false이면 if 실행 안함
			System.out.println("검색 결과가 없습니다");
		}
		
	}
	
	// 답
//	검색할 알파벳을 입력해주세요 : b
//	검색 결과가 없습니다.
//	검색할 알파벳을 입력해주세요 : d
//	d는 0행 2열에 있습니다
	
	
	public void ex3() {
		
		int[][] arr = { {30, 56, 13, 27},
						{50, 70, 80, 80},
						{104, 20, 12, 86}};
		
		// 2차원 배열에 저장된 모든 요소의 합/평균을 출력 
		// hint. sum, 2중 for문을 이용한 2차원 배열요소 모두 접근. 
		int sum = 0;
		
		
//		for ( int row = 0 ; row < arr.length ; row++ ) {
//			for (int col = 0 ; col < arr[row].length ; col++) {
//			
//				sum	+= arr[row][col];
//			}
//			
//		}
		// 향상된 for문 : 모든 배열 요소를 접근하는 용도의 for 문
		// 장점 : 작성이 간단함
		// 단점 : 시작, 끝, 증감, 인덱스 지정 불가
		
		// for ( 배열 요소의 자료형으로 된 변수  : 배열명 ) 
		//     -> 오른쪽에 작성한 배열에 요소를 
		// 		  순서대로 하나씩 꺼내와 대입
		
		for(int[] row : arr) {
			for (int col : row) {
				sum+=col;
			}
		}
		
		
		System.out.println("합 : " + sum);
		System.out.println("평균 : " + sum/ (arr.length * arr[0].length));
		
		
//		합 : 628
//		평균 : 52
		
		
	}
	

	public void ex4() {
		// 4행 4열짜리 정수형 2차원 배열을 생성
		
		int[][] arr = new int[4][4] ;
		
		// 각 배열 요소에 1~100 사이 난수를 대입
	
		
		for(int row =0 ; row < arr.length ; row++) { //행 제어
			for (int col = 0 ; col <arr[row].length ; col++) { // 열 제어
				
				int random = (int)(Math.random() *100 + 1); // 1~100 사이 난수
				
				//각 배열 요소에  random 대입
				arr[row][col] = random;
						
			}
		}
		
		//최대, 최소 찾기 == 비교를 하는 것이고 == 비교값이 존재해야함
		// --> 이럴때는 비교군의 첫 번째 값을 이용 
		int max = arr[0][0]; //최대값 저장용 변수
		int min = arr[0][0]; //최소값 저장용 변수
		
		//최대값, 최소값을 찾으려면 맨 첫번째 숫자를 입력해서 찾아봐라.
		// 첫번째 숫자보다 크면 max, 첫번째 숫자보다 크면 min 
		
		int sum = 0;
		
		        // 2차원 배열에 저장된 값을 모두 출력
				// 모든 요소의 합
		for (int row = 0 ; row  < arr.length ; row++) {
			for (int col = 0 ; col < arr[row].length ; col++) {
				
				// %d : 정수
				// %d : 정수가 출력될 공간 4칸을 만들고 오른쪽 정렬해서 출력
				System.out.printf("%4d", arr[row][col] );
				
				sum += arr[row][col];
				
				// 최대값 구하기
				if(arr[row][col] > max) { // 현재 요소의 값이 더 크면
					max = arr[row][col];  // max에 현재 요소 값을 대입
				}
				
				// 최소값 구하기
				if( arr[row][col] < min) {
					min = arr[row][col];
				}

			}
			System.out.println();  //개행
		} System.out.println("\n합계 : " + sum);
		
		// 최대값, 최소값 출력
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		
		// 출력값
//		  22  69  78  85
//		  80  85  51  94
//		  31  77  75  93
//		   8  81  47  68
//
//		합계 : 1044
//		최대값 : 94
//		최소값 : 8

		
		
		
		
		
		
	}
	
	
}
