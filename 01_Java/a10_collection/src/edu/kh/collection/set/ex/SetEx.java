package edu.kh.collection.set.ex;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.list.model.dto.Student;

public class SetEx {
	
	// 컬렉션 특징 : 크기 제한 X, 다양한 기능, 객체만 저장 (객체만 하고 기본 자료형은 만들수없음)
	// 제네릭 <T> : 컬렉션 타입 제한     			// Set<int> X --> Set<Integer>
	
	// Set(집합)
	// - 중복 데이터 저장 불가(같은 객체를 덮어 씌움)
	// - 순서를 유지하지 않음. (index가 없음)
	//   --> get() 메서드가 없음. 
	// hashcode를 꼭 오버라이딩을 해야한다.
	
	// Interface - 객체를 만들수 없음. 
	
	// 대표적인 자식 클래스
	//  1) HashSet : hashcode()를 이용해서 중복 비교
	//				빠른 검색 지원
	
	//  2) LinkedHashSet : 순서가 유지되는 Set
	//						hashCode() 오버라이딩 필수
	
	//  3) TreeSet : 정렬 -> 저장되는 값을 자동으로 정렬
	//		***** TreeSet을 사용하려면 Comparable 상속 필수 ******
	
	public void ex1() {
		//기본적인 Set 사용법
		Set<String> set = new HashSet<String>();
		//Set<String> set = new LinkedHashSet<String>();
		
		// String, Integer등 Java 제공 객체는
		// 기본적으로 hashCode(), equals(), compareTo() 등이
		// 오버라이딩 되어 있음.
		
		// 1. boolean set.add(E e) --> boolean값으로 나온다
		set.add("네이버");  //String만 추가할 수 있다. 
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의 민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set);
		
		// 결과창 [Console]
		// [배달의 민족, 당근마켓, 직방, 카카오, 네이버, 야놀자, 쿠팡, 라인, 토스]
		// HashSet은 순서 유지 X
		
		// 중복 저장 확인 --> 중복 저장 X (제거)
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		System.out.println(set);
		
		// --> [배달의 민족, 당근마켓, 직방, 카카오, 네이버, 야놀자, 쿠팡, 라인, 토스]

		// null : 참조하는 객체가 없음 == 주소 저장 X
		
		// set에 null도 저장되나 1개만 가능 (중복 X)
		set.add(null);
		set.add(null);
		set.add(null);
		System.out.println(set);
		
		// --> [null, 배달의 민족, 당근마켓, 직방, 카카오, 네이버, 야놀자, 쿠팡, 라인, 토스]
		
		// 2. int set.size() : 저장된 객체의 수 반환
		System.out.println("size : " + set.size());
		
		//  [결과]
		// --> size : 10
		
		// 3. set은 객체가 없음/ index가 없음 -> 원래 remove (index)
		// 	boolean remove(E e) :
		//  e와 똑같은 요소가 set에 있으면 지우고 true 반환
		//  없으면 false 반환
		
		// TIP! boolean은 if문 for문, while문과 같이 쓰인다!
		
		if(set.remove("직방")) { 
			System.out.println("직방이 제거되었습니다.");
		} else {
			System.out.println("직방이 없습니다.");
		}
		
		System.out.println(set);
		
		// [결과창]
		// 직방이 제거되었습니다.
		// [null, 배달의 민족, 당근마켓, 카카오, 네이버, 야놀자, 쿠팡, 라인, 토스]
		
		
		// 4. boolean set.contains(E e) :
		//  set에 저장된 객체 중 e와 똑같은 객체가 있으면 true, 없으면 false
		
		System.out.println("네이버 " + ( set.contains("네이버") ? "있음" : "없음"));
		System.out.println("직방 " + ( set.contains("직방") ? "있음" : "없음"));
		
		// [결과]
		// 네이버 있음
		// 직방 없음
		
		// 5. void set.clear() : set에 저장된 객체를 모두 지움
		
		set.clear();
		System.out.println("clear 후 size : " + set.size());
		
		// [결과]
		// clear 후 size : 0
		
		// 6. boolean set.isEmpty() :
		//  set에 저장된 객체가 없다면(비어있다면) true, 아님 false
		//  set.size() == 0 과 같은 뜻
		
		System.out.println("set이 " + (set.isEmpty() ? "비어있음" : "비어있지 않음"));
		
		// [결과]
		// set이 비어있음
		
	}
	
	public void ex2() {
		
		// Set에 저장된 값 꺼내쓰는 방법
		
		// 1. Iterator (반복자) 
		// - 컬렉션 객체의 요소를 순서대로 하나씩 꺼내서 반복 접근할 수 있는 객체
		//  (순서대로 요소 하나씩 꺼내는 객체)
		
		Set<String> set = new HashSet<String>();
		set.add("포카칩");
		set.add("빅파이");
		set.add("몽쉘");
		set.add("메로나");
		set.add("하겐다즈");
		set.add("꼬북칩");
		
		// Iterator set.iterator() :
		// set의 내용을 순차(반복) 접근할 수 있는 형태로 변경해서 반환
		Iterator<String> it = set.iterator();
		
		// boolean it.hasNext() :
		// 다음 꺼낼 요소가 있으면 true, 없으면 false 
		// 하나씩 꺼내면, 그건 없어지는 것임. 그래서 마지막엔 남는게 없으니 false가 된다
		while(it.hasNext()) { // 다 꺼낼때까지 무한 반복하는거임
			
			// E it.next() : 다음 요소 꺼내서 반환
			String temp = it.next();
			
			System.out.println(temp);
		}
		
		//----------------------------------------------------------------------
		
		// 2. 향상된 for문
		System.out.println("--------------------------");
		
		//for ( (한가지 타입) : 컬렉션 요소)
		for ( String s : set) {
			System.out.println(s);
		}
		
	}
	// [결과]
	// 메로나
	//	포카칩
	//	하겐다즈
	//	빅파이
	//	몽쉘
	//	꼬북칩
	//	--------------------------
	//	메로나
	//	포카칩
	//	하겐다즈
	//	빅파이
	//	몽쉘
	//	꼬북칩

	
	public void ex3() {
		
		// Set이 중복을 확인하는 방법
		// -> 새로 추가하려는 객체와
		//    Set에 있는 객체가 
		//    equals() 수행 시 true
		//    hashCode() 비교 시 true이면 중복으로 판단
		
//		***************************************************************
		// * Set 이용하려면 equals()와 hashCode() 필수로 오버라이딩 *
//		***************************************************************
		// 현재 Student 클래스에 equals()와 hashCode()가 되어있기 때문에 됨. 
		// 둘중에 하나라도 없으면 중복 확인이 가능하지 않음
		Set<Student> set = new HashSet<Student>();
		
		set.add( new Student(3, 4, 5, "홍길동", 'M', 86));
		set.add( new Student(3, 4, 5, "홍길동", 'M', 86));
		
		System.out.println("size : " + set.size());

		for(Student s : set) {
			System.out.println(s);
		}
		
		// [결과]
		// size : 1
		// Student [grade=3, ban=4, number=5, name=홍길동, gender=M, score=86]

	}
	
	public void createLottoNumber() {
		
		// 로또 번호 (1~45 난수, 6개, 중복X, 오름차순)
		
		Random random = new Random(); // 난수 생성 객체
		
		// 컬렉션은 기본 자료형 저장 불가 (ex. int, double)
		// --> Wrapper 클래스 이용 ( ex. Integer, Double..)
//		Set<Integer> lotto = new HashSet<Integer>();
		Set<Integer> lotto = new TreeSet<Integer>(); // 오름차순 정렬 Set
		
		
		while(lotto.size() < 6) { // lotto에 저장된 난수가 6개 미만이면 반복
			lotto.add(random.nextInt(45) + 1); //  (0~44) + 1 == 1 ~45
		}
		
		System.out.println(lotto);
		
	}
	
	public void lottoVersion2() {
		
		// 금액을 입력 받아서(천원 단위)
		// 3천원이면 3회, 5천원이면 5회 치 
		// 로또 번호를 자동으로 생성해서 출력
		
		Scanner sc = new Scanner(System.in);
		
		while(true) { //계속해서 반복문 실행
		try {  // 예외처리 위해서 (inputmismatchException)
			System.out.print("금액을 입력하세요 : ");
			int money = sc.nextInt();
			
			if(money == 0) { // 0원을 입력하면 멈추기
				break;
			}
			
			if (money < 1000) { // 1000원 이하면 밑에 문구
				System.out.println("1000원 이상만 입력해주세요.");
				//return;
			} 
			
			for (int i = 1 ; i <= (money/1000) ; i++) {
				System.out.print(i + "회 : ");
			
			Random random = new Random();
			
			Set<Integer> lotto = new TreeSet<Integer>();
			
			while(lotto.size() < 6 ) { 
				lotto.add(random.nextInt(45)+1);
			}
			
			System.out.println(lotto);
			
			} 
		} catch(InputMismatchException e) { // 숫자 이외에 대해서 예외처리
			System.out.println("숫자만 입력해주세요.");
			sc.nextLine(); // 입력버퍼에 남음 문자열 제거 // 무한 반복 해결
			}
		}
		
		
		}
	
	
	
	
	
	}
	


