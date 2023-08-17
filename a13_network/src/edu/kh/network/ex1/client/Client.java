package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Client (고객) : 서버가 제공하는 서비스를 요청해서 제공 받는 컴퓨터

public class Client {
	
	public void start() {
		
		// 1. 서버의 IP 주소와
		// 	  서버가 정한 포트 번호를 이용해서
		//    서버와 연결하는 소켓 객체 생성
		
		String ip = "127.0.0.1";  // loop back ip (현재 같은 건물 /컴퓨터 나타내는 IP주소로써 약속으로 정해져 있는거임) 
		int port = 8500; // 서버에서 지정한 포트 번호를 입력. 
		
		Socket socket = null;  // 클라이언트 - 서버를 연결
		
		InputStream is = null; // 클라이언트(로) <-- 서버(에서) 스트림
		OutputStream os = null; // 클라이언트(에서) --> 서버(로) 스트림
		
		// 성능 향상용 보조 스트림
		BufferedReader br = null;
		PrintWriter pw = null;
		

		try {  //외부랑 네트워크 연결을 할거면 무조건!! try catch문 exception을 작성한다. 
			System.out.println("[Client 입니다]");
			
			// 127.0.0.1:8500 (서버 프로그램)과 연결되는 소켓을 생성하는 코드임
			// -> 소켓이 생성됨과 동시에 서버로 연결 요청
			// -> ip,port 번호가 잘못 작성되거나, 연결 거부되면
			//    UnknownHostException이 발생됨. 
			socket = new Socket(ip, port);
			
			if(socket != null) { // 서버와 연결이 성공한 경우
				
		// 2. 서버와의 입출력 스트림을 생성 (소켓에서 얻어옴)
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
		// 3. 보조 스트림을 이용해 성능 개선 코드
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
		// 4. 스트림을 통해서 읽고 쓰는 입출력
				
		// 4-1) 서버 -> 클라이언트로 전달된 메시지를 화면에 출력하는 코드
				String serverMessage = br.readLine(); // 메시지 한줄 읽기				
				System.out.println(serverMessage);
				// [결과창] 2023-08-17 10:15:33[서버 접속 성공]
				
		// 4-2) 클라이언트 -> 서버로 키보드로 입력 받은 메시지 전달 
				Scanner sc = new Scanner(System.in);
				
				System.out.print("서버로 전달할 메시지 : ");
				String clientMessage = sc.nextLine();
				
				pw.println(clientMessage); // 서버로 메시지 출력
				pw.flush(); // 스트림에 있는 메시지 밀어내기 
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {  // 클라이언트에선 3개만 닫는다. 
			
			// 메모리 누수 관리
			try {
				
				if(br != null) br.close();
				if(pw != null) pw.close();
					
				if(socket != null) socket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}

}
