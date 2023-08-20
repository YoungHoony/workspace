package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	
	public void start() {

		
		String ip = "127.0.0.1"; 
		int port = 8500; 
		
		Socket socket = null;  
		
		InputStream is = null; 
		OutputStream os = null; 

		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {  
			System.out.println("[Client 입니다]");
			
			socket = new Socket(ip, port);
			
			if(socket != null) { 
				
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				String serverMessage = br.readLine(); 			
				System.out.println(serverMessage);
				
				Scanner sc = new Scanner(System.in);
				
				System.out.print("서버로 전달할 메시지 : ");
				String clientMessage = sc.nextLine();
				
				pw.println(clientMessage); 
				pw.flush(); 
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {  
			
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
