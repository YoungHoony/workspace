package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	public void practice1() {
		
//		길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
//		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//		짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		
		
		
		int [] arr = { 1,2,3,4,5,6,7,8,9};
		
		int sum = 0;
		
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(i+1 + " ");
			
			if (i % 2 == 0)  {  
				
			sum += arr[i];
			
			}
			
		} System.out.println("\n짝수 번째 인덱스 합 : " + sum );
		
		
	}

	
	
	public void practice2() {
//		길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
//		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//		홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		

		int[] arr = new int[9];
		arr[0] = 9;
		arr[1] = 8;
		arr[2] = 7;
		arr[3] = 6;
		arr[4] = 5;
		arr[5] = 4;
		arr[6] = 3;
		arr[7] = 2;
		arr[8] = 1;
		
	
		int sum = 0;
		
		for (int i = 0; i < arr.length ; i++) {
			
			
			System.out.print(arr[i] + " ");
			
			if (i % 2 ==1) {
				
				sum += arr[i];
			}
			
		} System.out.println("\n홀수 번 째 인덱스 합 : " + sum);
		
		
	}
	
	
	public void practice3 () {
//		사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
//		1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(i+1 + " " );
			
			
		}
		

	}
	
	public void practice4() {
		
//		정수 5개를 입력 받아 배열을 초기화 하고
//		검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
//		배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
		
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[5];
		
		for (int i = 0; i < arr.length ; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		boolean flag = true;
		
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
		
		for (int i = 0; i < arr.length ; i++) {
			
			if (input == arr[i]) { 
				
			System.out.print("인덱스 : " + i);
			  
			 flag = false;
			 break;
			   } 
			 
			} if (flag) {
				System.out.println("일치하는 값이 존재하지 않습니다."); 
			
		} 
		
	}
	
	public void practice5 () {
		//문자열을 입력 받아 문자 하나 하나를 char배열에 대입하고 검색할 문자가 문자열에 
		// 몇개 들어가 있는, 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		
		char[] arr = new char[str.length()];
		String index = "";
		int count = 0;
		
		for (int i = 0; i <arr.length ; i++) {
			arr[i] = str.charAt(i);
			if (ch == arr[i]) {
				index += i + " ";
				count++;
			}
			
		}
		System.out.println(str + "에 " + ch + "가 존재하는 위치(인덱스) : " + index);
		System.out.println(ch + " 개수 : " + count);
		
		
	}
	
	public void practice6 () {
		
		//사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
//		배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요
//		그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		
		for (int i = 0 ; i < arr.length; i++ ) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt(); }
		
		int sum = 0;
		for (int i=0 ; i <arr.length; i++) {
			
			System.out.print(arr[i] + " "); 
			sum += arr[i];
		}
		System.out.println("\n총합 : " + sum);
		
		
	}
	
	
	public void practice7( ) {
		
		//주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요
		//단, char 배열 저장 시 성별을 나타내는 숫자 이후부터로 저장하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : " );
		String str = sc.nextLine();
		
		char [] arr = new char[str.length()];
		
		for (int i = 0; i <arr.length ; i++) {
			if (i >= 8) { 
				arr[i] = '*';
			} else { arr[i] = str.charAt(i);
				
			}System.out.print(arr[i]); 
		} 
		
		
}
	
	public void practice8 () {
		//3 이상인 홀수를 입력 받아 배열의 중간까지는 1 부터 1 씩 증가하여 오름차순으로 값을 넣고
//		중간 이후부터 끝까지는 1 씩 감소하여 내림차순으로 값을 넣어 출력하세요
//		단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 다시 입력하세요를 출력하고 다시
//		정수를 받도록 하세요
		
		Scanner sc = new Scanner(System.in);
		

		int num = 1;
		
		
		while (true) {
			System.out.print("정수 : ");
			 int input = sc.nextInt();
			
			if (input < 3 || input % 2 ==0) {
				System.out.println("다시 입력하세요.");
				
			}	else {
				 int[] arr = new int[input];
				 
				 for (int i = 0; i < arr.length; i++) {
					 if( i < arr.length/2) { 
						 arr[i] = num++; 
					 
					 } else {
						 arr[i] = num--; }
					 
					 System.out.print(arr[i] + ", ");
					 
				}
				 
			}
			
			break;}
		
	}
	
	public void practice9() {
		
		//10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		//1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요
		
		int [] arr = new int[10];
		
		System.out.print("발생한 난수 : ");
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i]  = (int)(Math.random()* 10 +1);
			
			System.out.print(arr[i] +  " ");
		 } //System.out.print("발생한 난수 : " + Arrays.toString(arr));
		
			
	}
	
	public void practice10() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		//1~10사이의 난수를 발생시켜 배열에 초기화 후 배열 전체 값과 그 값 중에서 
		//최대값과 최소값을 출력하세요
		
		int[] arr = new int[10];
		
		
		
		System.out.print("발생한 난수 : ");
		
		for (int i = 0 ; i < arr.length ; i++ ) {
		 arr[i] = (int)(Math.random() *10+1);
		 System.out.print(arr[i] + " ");}
		
		System.out.println();
		
		int max = arr[0];
		int min = arr[0];
		
		for (int i = 0 ; i < arr.length ; i++ ) {
			
			
		 	if(arr[i] > max)  {
				max = arr[i];
			} if(arr[i] < min) 
				min = arr[i];
			
		 
		 }
		  System.out.print("\n최대값 : " + max);
		  System.out.print("\n최소값 : " + min);
		
	} 
	 
	public void practice11 () {
		//10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		//1~10사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요
	
		int [] arr = new int[10];
		
		for(int i = 0 ; i <arr.length ; i ++) {
			arr [i] = (int)(Math.random() *10+1);
			
			for (int x = 0; x < i; x++) {
				if (arr[i] == arr[x]) {
					i--;
				}
			}
			
		} for(int i = 0 ; i <arr.length ; i ++) {
			System.out.print(arr[i] + " "); 
		
		}
	
	}
	
	public void practice12 () {
		//로또번호 자동 생성기 프로그램을 만들기
		//중복 값 없이 오름차순으로 정렬하여 출력하세요
		
		int [] lotto = new int[6];
		
		for (int i =0 ; i < lotto.length ; i++) {
			int random = (int)(Math.random()*45+1);
			lotto[i] = random;
			
			for (int x = 0 ; x <i ; x++) {
				if (random == lotto[x]) {
					i++;
					break;
				}
				
			}
			
			
		}	for(int i = 0 ; i <lotto.length ; i ++) {
			System.out.print(lotto[i] + " ");
		
		
	}
	
	}
	
	public void practice13 () {
		
		
	}
	
	public void practice14 () {
		
	}
	
	public void practice15() {
		
		//3행 3열짜리 문자열 배열을 선언 및 할당하고
		//인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.

		int [][] arr = new int[3][3];
	
			//() 내부 첫번째 칸의 값 0 1
			for (int row = 0 ; row < arr.length ; row++) { 
				
				//() 내부 두번째 칸의 값 0 1 2
				for(int col = 0 ; col < arr[row].length ; col++) { 
					System.out.printf("(%d,%d) " , row , col);
				}
				System.out.println();
			}
			
		
	}
	
	public void practice16() {
		//4행 4열짜리 정수형 배열을 선언 및 할당하고
		//1) 1 ~ 16까지 값을 차례대로 저장하세요. 
		// 2) 저장된 값들을 차례대로 출력하세요.
		
		int [][] arr = new int[4][4];
		
		int num  = 1;
		
		for (int row = 0 ; row < arr.length ; row++) {
			for (int col = 0 ; col < arr[row].length; col++) {
				arr[row][col] = num++;
				System.out.printf("%2d " , arr[row][col]);
			}
			System.out.println();
		}
			
		
		
	}
	
	public void practice17() {
		// 4행 4열짜리 정수형 배열을 선언 및 할당하고
		// 1) 16 ~ 1까지 값을 차례대로 저장하세요. 
		// 2) 저장된 값들을 차례대로 출력하세요.
		
		int [][] arr = new int[4][4];
		int num = 16;
		
		for (int row = 0 ; row < arr.length ; row++) { 
			for (int col = 0 ; col < arr[row].length ; col++) {
				arr[row][col] = num--;
				System.out.printf("%2d ", arr[row][col]);
			}
			System.out.println();
		}
		
		
	}
	
	
	
}
	
	
	
	
	
	

		
	
	
	
	
	
	
	
	

