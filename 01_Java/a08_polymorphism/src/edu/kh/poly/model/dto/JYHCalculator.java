package edu.kh.poly.model.dto;

// extends (확장하다) : 클래스 간의 상속 또는 인터페이스간의 상속

// implements (구현하다) : 부모 인터페이스 - 자식 클래스 상속
//			               인터페이스는 다중 상속 가능

public class JYHCalculator implements Calculator {

	@Override
	public int plus(int a, int b) {
		return a + b ;
	}

	@Override
	public int minus(int a, int b) {
		return a - b;
	}

	@Override
	public int multi(int a, int b) {
		return a * b;
	}

	@Override
	public int div(int a, int b) {
		return a / b;
	}

	@Override
	public int mod(int a, int b) {
		return a % b;
	}

	@Override
	public double areaOfCircle(double r) {
		return r * r * PI;
	}

	@Override
	public int pow(int a, int x) {
	    return (int) Math.pow(a, x);     
	
				
	}
	
	
	
	

}
