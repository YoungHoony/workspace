package edu.kh.oop.basic;

public class Nation {
	
	String pNo;  
	String name; 
	char gender; 
	String address; 
	String phone; 
	int age; 
	
	private String job; 
	
	//* 기능 *//
	public void speakKorean() {
		System.out.println("가나다라 한국어 가능");
	}
	
	public void 납세의의무() {
		System.out.println("세금 ... 내야지...");
	}
	
	public void introduce() { 
		System.out.printf("저의 이름은 %s이고, 직업은 %s 입니다. \n", name, job);
		
		
	}
	
	public void setJob(String job) {  
		this.job = job;
		
	}
	
	public String getJob() {
		return job; 
	}

}
