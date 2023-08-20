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


public class Server {

	public void start() {
		
		int port = 8500;
		
		ServerSocket serverSocket = null; 
		Socket clientSocket = null;
		
		InputStream is = null; 
		OutputStream os = null; 
		
		BufferedReader br = null; 
		PrintWriter pw = null; 
					
		try {
			
			InetAddress inet = InetAddress.getLocalHost(); 
			System.out.println("서버 IP 주소 : " + inet.getHostAddress());
		
			serverSocket = new ServerSocket(port); 
			
			System.out.println("[Server 입니다]"); 
			System.out.println("클라이언트의 접속을 기다리고 있습니다...");
			
			clientSocket = serverSocket.accept(); 
			
			System.out.println("[클라이언트 접속 성공]");
			
			is = clientSocket.getInputStream(); 
			os = clientSocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));   
			pw = new PrintWriter(os);
					
			Date now = new Date(); 
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
			String message = sdf.format(now) + "[서버 접속 성공]";
			
			pw.println(message); 
			pw.flush();  
			
			String clientMessage = br.readLine();
			
			String clientIP = clientSocket.getInetAddress().getHostAddress();
			
			System.out.println(clientIP +  "로 부터 받은 메시지 : " + clientMessage);
						
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally { 
			
			try {  
				
				if(br != null) br.close(); 
				if(pw != null) pw.close();
				
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
					
			
	}

}
	
}

