package edu.kh.network.ex2.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import edu.kh.network.ex2.thread.Receiver;
import edu.kh.network.ex2.thread.Sender;

// 클라이언트
public class ChattingClient {

	public void start() {
		Scanner sc = new Scanner(System.in);
		
		// 1. ip, port 입력 받기 
		System.out.print("접속할 ip : ");
		String serverIP = sc.next();
		
		System.out.print("포트 번호 : ");
		int port = sc.nextInt();
		sc.nextLine(); // 입력 버퍼에 남아있는 개행 문자 제거
		
		Socket socket = null; //서버랑 연결할 소켓 설정
		
		
		try {
		// 2. 서버 접속
		// 실패 시 UnknownHostException 발생함. 
			socket = new Socket(serverIP, port);
			
			if(socket != null) { // 서버 접속에 성공 시
				System.out.println("<<서버 접속 성공!!>>");
				
				System.out.print("클라이언트 이름 입력 : ");
				String clientName = sc.nextLine();
				
				// 스레드를 이용해서 코드 작성 예정 (대화를 위한 스레드(일꾼)을 지정) 	
				// --------------------------------------------------------------------------------	
				
				// 서버 <- 클라이언트 출력 역할 객체 생성
				Sender sender = new Sender(socket, clientName);
				
				// 서버 -> 클라이언트 입력 역할 객체 생성 
				Receiver receiver = new Receiver(socket);
				
				// 스레드로 생성
				Thread th1 = new Thread(sender);
				Thread th2 = new Thread(receiver);
				
				th1.start();
				th2.start();
				// 스레드가 시작되면서 입력, 출력이 동시에 
				// 무한히 수행되는 서버 완성
				
				th1.join();
				th2.join();
				
				
				// --------------------------------------------------------------------------------
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			// 메모리 누수 관리
				try {
					if(socket != null) socket.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			
		}
		
		
		
		
	}

}
