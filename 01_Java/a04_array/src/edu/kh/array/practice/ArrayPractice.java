package edu.kh.array.practice;

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
			System.out.print(i+1 + " ");
			
			if (i % 2 ==1) {
				
				sum += arr[i];
			}
			
		} System.out.println("\n홀수 번 째 인덱스 합 : " + sum);
		
		
			
		
		
	}
	
	
	
	
	
	
	
	
	
}

