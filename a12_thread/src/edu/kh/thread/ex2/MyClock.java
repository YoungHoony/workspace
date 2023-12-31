package edu.kh.thread.ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClock implements Runnable {
	
	@Override
	public void run() {
		
		// SimpleDateFormat : 간단하게 날짜/시간 형식을 지정하는 객체 
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");
		// HH -> 24시간 표기법 (시) 
		// mm -> 분
		// ss -> 초
				
		
		//무한이 도는 시계 만들기
		while(true) { 
			
			 // java.util.Date (import) : 시간/날짜를 저장하는 표시하는 객체
			Date now = new Date(); // 현재 시간이 객체가 생성되며 저장
			
			for(int i=0 ; i<50; i++) System.out.println();
			
			
			
			// 현재 시간을 sdf에 지정된 패턴으로 바꿔서 출력
			System.out.println(sdf.format(now));
			
			try {
				Thread.sleep(1000); // 시간 출력 후 1초 일시 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
