package edu.kh.network.ex1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

// Server : 클라이언트가 이용할 서비스 (코드)를 제공하는 컴퓨터
// ex) 가게 사장/직원

// Socket : 프로세스의 양 끝 단
//		--> 서버  - 클라이언트를 연결하는 통로/연결고리 
//		--> Input/Output Stream을 이용해 서버 - 클라이언트가 데이터 교환 가능

// TCP : 서버 - 클라이언트간의 1:1 소켓 통신
// 		 데이터 신뢰성을 보장 (데이터 오류 시 재전송)
public class Server {

	public void start() {
		
		// 1. 서버의 포트번호 정하기 
		int port = 8500;
		// 포트번호는 0~65535 사이로 지정 가능 (2byte 사이로 지정가능)
		// 1023번 이하는 OS에서 사용하는 경우가 많으므로 사용 권장 X	
		
		// 2. 서버용 소켓 객체 생성
		
		// ServerSocket : 지정된 포트 번호로 
		// 클라이언트 연결이 되는 것을 기다리는 소켓 객체
		
		ServerSocket serverSocket = null; 
		Socket clientSocket = null; // 클라이언트와 연결되는 소켓 
		
		InputStream is = null; // byte 기반 (클라이언트 --> 서버쪽으로 연결되는 stream) 
		OutputStream os = null; // 서버 --> 클라이언트로 (나가는) 연결되는 stream 
		
		BufferedReader br = null; // (한번에 많이 읽어들인다. buffered == 장바구니를 이용해서) 성능향상을 위한 보조스트림 (없어도 상관없음)
		PrintWriter pw = null; // 보조스트림
		
		// 서버와 클라이언트가 끝나고 난 후에 연결 스트림(둘이 연결)이 남기 때문에 없애야한다.
		
		// 소켓, 스트림 참조 변수를 try, finally에서 모두 사용할 수 있도록 
		// try 구문 위쪽에 참조 변수를 선언. 
				
		try {
			// LocalHost (가게 주인)  == 서버 컴퓨터(내 컴퓨터)의 IP 관련 정보를 얻어옴
			InetAddress inet = InetAddress.getLocalHost(); // 자바에서 있는 클라스인데, 내 서버 ip주소 알아보기위한 것임. 
			System.out.println("서버 IP 주소 : " + inet.getHostAddress());
		
			
			// 3. 클라이언트가 연결되길(접속) 기다림....
			
			serverSocket = new ServerSocket(port);  // 8500번 포트를 열고 기다리는 중이다. 
			
			System.out.println("[Server 입니다]"); // 메시지 출력
			System.out.println("클라이언트의 접속을 기다리고 있습니다...");
			
			// 4. 접속 요청이 오면
			// 해당 클라이언트에 대한 소켓 객체 생성
			// clientSocket == 서버쪽 소켓임. 클라이언트에서 오는 걸 허용하는 소켓임
			clientSocket = serverSocket.accept(); // accept : 허용하다
			
			System.out.println("[클라이언트 접속 성공]");
			
			// 5. 연결된 클라이언트와 입출력 스트림 생성 (대화를 할 수 있는)
			is = clientSocket.getInputStream(); // 클라이언트 -> 서버로 입력 // 1바이트
			os = clientSocket.getOutputStream(); // 서버 -> 클라이언트로 출력
			
			// 6. 보조 스트림을 통해 성능 개선 (네트워크를 할 때는 보조 스트림을 많이 사용한다)
			// InputStreamReader : 바이트 -> 문자 기반 입력 스트림으로 변경
			br = new BufferedReader(new InputStreamReader(is));   //2바이트짜리라 1바이트인 getInputStream을 하려면 깔때기 역할하는 객체가 필요하다
			pw = new PrintWriter(os);
			
			// 7. 스트림을 통해서 읽고 쓰기
			
			// 7-1 ) 서버 -> 클라이언트에게 메시지 전달
			
			Date now = new Date(); // 현재 시간이 객체에 저장됨
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 2023-08-16 17:18:34
			
			String message = sdf.format(now) + "[서버 접속 성공]";
			
			pw.println(message); // 서버 -> 클라이언트로 메시지 출력
			pw.flush();  // 스트림(버퍼)에 기록된/남아있는 내용을 쭉 밀어내는/없애는 코드
						 // -> 미작성 시 클라이언트쪽으로 출력되지 않음. (통로에 남아있음) 
			
			// 7-2) 서버 <- 클라이언트 메시지 받기 (입력)
			String clientMessage = br.readLine(); // 한 줄 읽기
			
			// 클라이언트 IP 주소
			String clientIP = clientSocket.getInetAddress().getHostAddress();
			
			System.out.println(clientIP +  "로 부터 받은 메시지 : " + clientMessage);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally { // try 구문에서 예외 발생 여부 관계 없이 무조건 수행
			
			// 사용한 소켓, 스트림을 닫는 코드 작성
			// (닫다 == 메모리 반환)
			// --> 메모리 누수 관리 
			
			// 소켓, 스트림 생성 역순으로 보통 close() 구문을 작성함. 
			
			try {  // 서버에선 4개 닫기
				// 보조 스트림(br,pw) close() 시 
				// 보조 스트림 생성에 사용된 기반 스트림 (is,os)도 
				// 같이 close()가 되기 때문에 굳이 쓰지 않아도 된다. 
				
				if(br != null) br.close(); //보조 스트림 닫기
				if(pw != null) pw.close(); //보조 스트림 닫기
				
//				 is.close(); // 기반 스트림/ 굳이 안써도 된다
//				 os.close(); // 기반 스트림/ 코드 낭비
				
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			
			
	}

}
	
}

