package edu.kh.thread.ex1;

//스레드 생성 방법 2 : Runnable 인터페이스 상속

// thread로 만드는 것을 
public class TestThread2 implements Runnable {

// 장점 : run() 메서드 오버라이딩이 강제된다.
// 단점 : 해당 스레드를 생성 시키는 구문이 조금 더 길어짐.
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 실행");
		
		for(int i=0; i<10 ;i++) {
			System.out.println("1번 스레드" + i);
		}
	}
	
	

}
