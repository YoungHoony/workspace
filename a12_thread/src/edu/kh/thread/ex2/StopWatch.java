package edu.kh.thread.ex2;

public class StopWatch implements Runnable {
	@Override
	public void run() {
		int count = 0;
		
		int min = 0; // 분
		int sec = 0; // 초
		
		while(!Thread.currentThread().isInterrupted()) {
			
			try {
				Thread.sleep(10); // 1/1000초
				count++; // 0.01초 마다 카운트 증가
				
				if(count == 100) { // 1초가 되었을 때
					sec++; // 초 단위를 1 증가
					count = 0; // 0으로 초기화
				}
				
				if(sec == 60) { // 60초(1분)이 되었을 때
					min++; // 분 단위 1증가
					sec =0; // 초 단위 0으로 초기화	
				}
				
				for(int i=0 ; i<70 ; i++) System.out.println();
				System.out.printf("%02d분 %02d초 %02d \n", min,sec,count);
				
			} catch (InterruptedException e) {
//				e.printStackTrace();
				System.out.println("=== 인터럽트에 의해서 종료 ===");
				
				// sleep() 중 interrupt() 메서드가 호출되면 
				// InterruptedException이 발생하고
				// interrupted 필드 값이 true로 변하지 못하게 된다. 
				// -> catch문에서 interrupted 필드 값을 true 변경
				Thread.currentThread().interrupt(); // false -> true 변경
					
			}
		}
	}

}
