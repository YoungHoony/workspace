package edu.kh.poly.run;

import edu.kh.poly.model.dto.Calculator;
import edu.kh.poly.model.dto.JYHCalculator;
import edu.kh.poly.model.dto.JYHCalculatorV2;
import edu.kh.poly.model.dto.JYJCalculator;

public class CalculatorRun {
	public static void main(String[] args) {
		
		// 1. 인터페이스는 객체 생성이 가능할까?
		// 인터페이스는 추상 메서드밖에 안된다. 그렇기 때문에 메서드가 빵구가 났기 때문에,
		// 객체 생성을 할 수 없다. 
		
		// Calculator calc = new Calculator();  --> 안됨

		// 2. 인터페이스는 부모 참조 변수가 될 수 있을까?
		//    (다형성)
		//Calculator calc = new JYHCalculator();
		
		//Calculator calc = new JYHCalculator();
		Calculator calc = new JYJCalculator();
		
		
		// 동적 바인딩 확인
		System.out.println( calc.plus (10,5) );
		
		System.out.println( calc.minus(20,30));
		
		System.out.println( calc.multi(8,9));
		
		System.out.println( calc.div(5, 3));
		
		System.out.println( calc.mod(5, 3));
		
		System.out.println( calc.areaOfCircle(2.5));
		
		System.out.println( calc.pow(2, 5));
		
		
		
		
		
		
	}
	
	

}
