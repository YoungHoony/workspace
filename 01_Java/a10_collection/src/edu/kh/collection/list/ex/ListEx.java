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

	public void ex2() {
		
		//컬렉션 장점 중 "여러 타입 저장 가능"
		// 때문에 instanceof로 타입 검사를 해야하는 코드가 추가되어 
		// 코드 길이가 늘어나는 문제점이 발생한다.
		//  -> 그래서 타입을 하나로 제한!
		//  --> Generics (제네릭)을 이용
		
		// String으로 저장되는 타입이 제한된 List
		// -> 컴파일 단계에서 강력한 타입 체크
		List<String> list = new ArrayList<String> (); // 양쪽이 똑같아야 문제가 발생하지 않는다
		
		list.add("닭갈비");
		list.add("삼계탕");
		list.add("치킨");
		list.add("보쌈정식");
		list.add("샐러드");
		
		// [0] : 닭갈비 
//		[1] : 삼계탕 
//		[2] : 치킨 
//		[3] : 보쌈정식 
//		[4] : 샐러드 
		

		// list.add (int index, E e) : 중간에 추가(삽입)
		list.add(0, "곰탕");
		list.add(3, "카레");
		
		//[0] : 곰탕 
//		[1] : 닭갈비 
//		[2] : 삼계탕 
//		[3] : 카레 
//		[4] : 치킨 
//		[5] : 보쌈정식 
//		[6] : 샐러드 
		

		// E(반환형) list.set(int index, E e) : 
		// 지정된 index의 요소를 바꿈.(수정) 
		// 반환되는 값은 바뀌기 이전 요소
		
		String before = list.set(1, "치즈닭갈비");
		System.out.println("before : " + before);
		
		// before : 닭갈비
//		[0] : 곰탕 
//		[1] : 치즈닭갈비 
//		[2] : 삼계탕 
//		[3] : 카레 
//		[4] : 치킨 
//		[5] : 보쌈정식 
//		[6] : 샐러드
		
		// E list. remove(int index) : 
		// index 번째 요소를 list에서 제거
		// 반환되는 값은 제거된 요소
		
		String target = list.remove(6); //샐러드
		System.out.println(target + "제거");
		
//		before : 닭갈비
//		샐러드제거
//		[0] : 곰탕 
//		[1] : 치즈닭갈비 
//		[2] : 삼계탕 
//		[3] : 카레 
//		[4] : 치킨 
//		[5] : 보쌈정식 
		
		// list.contains(E e) :
		// list에 요소가 포함되어  있는지 확인
		System.out.println(list.contains("삼계탕"));
		System.out.println(list.contains("누룽지 삼계탕"));
			
//		before : 닭갈비
//		샐러드제거
//		true
//		false
//		[0] : 곰탕 
//		[1] : 치즈닭갈비 
//		[2] : 삼계탕 
//		[3] : 카레 
//		[4] : 치킨 
//		[5] : 보쌈정식 

		// int list.indexOf(E e) :
		//  list에 요소가 존재하면 해당 index 반환
		//  없으면 -1 반환
		//  어떤 index에 저장되어있는지 찾기같은 느낌 //정영훈
		
		System.out.println(list.indexOf("삼계탕"));
		System.out.println(list.indexOf("누룽지 삼계탕"));
		
//		before : 닭갈비
//		샐러드제거
//		true
//		false
//		2
//		-1
//		[0] : 곰탕 
//		[1] : 치즈닭갈비 
//		[2] : 삼계탕 
//		[3] : 카레 
//		[4] : 치킨 
//		[5] : 보쌈정식 
		
		//void list.clear() : 요소 모두 삭제
		list.clear();
		
//		before : 닭갈비
//		샐러드제거
//		true
//		false
//		2
//		-1

		//boolean list.isEmpty() :
		// 비어 있으면 true, 아니면 false
		System.out.println("비어있음? " + list.isEmpty());
		
//		before : 닭갈비
//		샐러드제거
//		true
//		false
//		2
//		-1
//		비어있음? true
		
		
		for(int i = 0 ; i < list.size() ; i++) { //list.length가 아니라 collection은 size이다
			// list.get(i)
			//  --> String으로 제한된 리스트 요소를 꺼내오기 때문에
			//      꺼낸 요소의 자료형은 무조건 String
			System.out.printf("[%d] : %s \n", i, list.get(i));
		}
		
	}
	
	
	
}
