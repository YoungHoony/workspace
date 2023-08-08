package edu.kh.collection.list.ex;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ListEx {
	
	// Collection 특징
	// 1) 크기 제한 X
	// 2) 추가, 수정, 삭제 등의 코드가 구현되어 있다. 
	// 3) 객체만 저장 가능
	
	/* List : 자료를 순차적으로 나열한 자료 구조 (배열과 비슷)
	 * 
	 * - 특징 1 : 인덱스를 이용해서 순서를 구분
	 * - 특징 2 : 순서가 구분되기 때문에 중복 데이터 저장 가능
	 */
	
	
	public void ex1() {
		
		// 다형성 적용
		//List list = new ArrayList(); 		
		
		List list = new ArrayList(3); 
		
		// 1. boolean add(E e) : 마지막 요소로 추가
		// E(Element) : 요소를 뜻하는 상징적인 글자 (자료형 X)
		// -> Object를 생각하면 편함
		
		// Auto Boxing
		list.add("아무거나"); // String은 객체이다!
		list.add(123);  // int  --> 기본자료형 --> Auto boxing에 의해 알아서 Integer로 바뀜
		list.add(3.14); // double --> 기본자료형  --> Auto boxing에 의해 알아서 Double로 바뀜
		
		// * 컬렉션에 저장되는 객체의 타입 제한 X
		
		// 왜? 기본 자료형이 저장될까?
		// --> Wrapper Class (감싸는 클래스) 
		
		System.out.println(list);
		
		// list의 크기 3을 초과해서 추가해도
		// 자동으로 크기가 늘어나서 에러 발생 X
		list.add("크기 3 초과");  //자동으로 크기 늘어남. 
		System.out.println(list);
		
		// 2. E get(int index) : 지정한 index요소 얻어오기
		System.out.println( list.get(2));
		System.out.println( list.get(1));
		System.out.println( list.get(0));
		
		System.out.println("---------------------------------------------------");
		
		// 진짜 자동포장 되는지 확인하는 방법 (Auto Boxing)
		System.out.println(list.get(1) instanceof Integer); // Auto boxing이 되는지 확인하는 방법 
														   	// 결과 : true
		System.out.println(list.get(2) instanceof Double); // Auto boxing이 되는지 확인하는 방법 
		
		// List + for문 + if + instanceof + 다운캐스팅
		// int list.size() : 저장된 객체의 개수를 반환 == 약간 length같은 것이다.
		
		for(int i =0 ; i <list.size() ; i++) {
			if(list.get(i) instanceof String) { // i번째 요소가 String 이면
				String s = (String)list.get(i); // 다운 캐스팅  // list : object타입인데 
				System.out.println("첫 글자 " + s.charAt(0)); //s.charAt :	
			}
			
			if(list.get(i) instanceof Integer) { //Integer인 경우
					// Auto Unboxing 자동으로 실행
				int number = (Integer)list.get(i);
				System.out.println(100 + number);
				
			}
			
			if(list.get(i) instanceof Double ) { // Double인 경우
				
				Double d = (Double)list.get(i); //다운캐스팅만
				System.out.println(d.BYTES + "바이트");
				
			}
		}
		
		
		
		
		
		
		
	}

	
	
	
	
}