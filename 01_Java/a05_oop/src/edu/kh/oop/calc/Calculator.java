package edu.kh.oop.calc;

// 계산기
public class Calculator {
	
	private final double PI = 3.141592;
	private final int MAX_VALUE = 1_000_000_000;
	private final int MIN_VALUE = -1_000_000_000;
	
	private double saveValue; // 값 저장용 필드
	
	// 기본생성자
	public Calculator () {}
	
	
	// saveValue의 setter
	
	public void setSaveValue(double saveValue) { //camel 표기법
		this.saveValue = saveValue;
		
	}
	
	// saveValue의 getter
	// 외부에서 자료를 얻어갈 수 있게 해준다라는 개념임
	
	public double getSaveValue() {
		return saveValue; 
		
	}
	
	// 더하기
	public double plus (double number) {
		saveValue += number;
		return saveValue; 
				
	}
	
	// 빼기
	public double minus(double number) {
		saveValue -= number;
		return saveValue;
	}

	//곱하기
	public double multi(double number) {
		saveValue *= number;
		return saveValue;
		
	}
	
	// 나누기
	public double div(double number) { 
		if (number == 0) { //전달받은 값이 0일 경우 
			saveValue = 0;
			return saveValue; 
			// number가 0 인 경우 saveValue를 0으로 만든 후
			// 0 return 후 메서드 종료
			// 메소드를 이 시점에서 끝내고 호출한 곳으로 돌아간다. 
			// 그러면 아래 두줄이 실행이 안된다. 
		}
		
		saveValue /= number;
		return saveValue;
		// number가 0이 아닌 경우 saveValue를 number로 나눈 값을 return 후 메서드 종료
	}
	
	// 초기화
	public double init() {
		saveValue  = 0;
		return saveValue; 
		
	}
	
	// 최대값으로 변경
	public double changeMaxValue() {
		saveValue = MAX_VALUE;
		return saveValue;
		
	}
	
	// 최소값으로 변경
	public double changeMinValue() {
		saveValue = MIN_VALUE;
		return saveValue;
	}
	
	// 원의 넓이 : PI * 반지름의 제곱
	public double theAreaOfACircle(double r) {
		saveValue = PI * r * r ;
		return saveValue;
		
	}
	
	
	
	
	
	
	
}
