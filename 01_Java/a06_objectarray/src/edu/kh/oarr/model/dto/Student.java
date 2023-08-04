package edu.kh.oarr.model.dto;

public class Student {
	//학년, 반, 번호, 이름, 국어점수, 영어점수, 수학
	private int grade;
	private int ban;
	private int number;
	
	private String name;
	
	private int kor;
	private int eng;
	private int math;
	
	//생성자
	// - 기본 생성자
	public Student () {}
	
	// 매개변수 생성자 (학년, 반, 번호, 이름) // 오버로딩
	public Student(int grade, int ban, int number, String name) { // 오버로딩 적용
		this.grade = grade;
		this.ban = ban;
		this.number = number;
		this.name = name;
		
	}
	
	//getter //필드에 있는 객체의 값을 얻어갈 수 있겠끔
		// setter // 외부에 있는 값을 가지고 오는
	
	public int getGrade() {
		return grade;	
	}
	
	public void setGrade(int grade) {  //전달받은 객체의 grade를 세팅하겠다
		this.grade = grade;
		
	}
	
	public int getBan() {
		return grade;
	}
	
	public void setBan(int ban) {
		this.ban = ban;
		
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	// alt + shift + s -> r 버튼 누르면 (Generate Getters and Setters....)
	
	
	// - 필드를 하나의 문자열로 만들어 반환하는 메서드
	public String toString() {
		
		 return String.format("%d학년 %d반 %d번 %s [%d, %d, %d]", grade, ban, number, name, kor, eng, math);
		// toString : 객체의 필드 값을 하나의 문자열로 반환
		// 전반적인 프로그래밍 언어에 공용으로 쓰인다
		
	}

}
