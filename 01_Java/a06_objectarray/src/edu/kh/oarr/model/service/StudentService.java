package edu.kh.oarr.model.service;

import java.util.Random;

import edu.kh.oarr.model.dto.Student;

public class StudentService {
	
	// 필드
	private Student[] studentArr = new Student[10];
	// 학생 객체 참조 변수 10개의 묶음 Student[]을 할당하고
	// 그 주소를 studentArr에 대입. 
	
	// studentArr[0], studentARr[1], studentArr[2] ...
	// 각 배열 요소 하나하나는 Student 객체 참조 변수가 된다. 
	
	// - 기본 생성자
	// 학생 객체 배열에 들어갈 샘플 학생 데이터를 3개 추가
	
	public StudentService ( ) {
		studentArr[0] = new Student(1,2,3, "홍길동");
		studentArr[1] = new Student(2,3,13, "박철수");
		studentArr[2] = new Student(3,7,23, "최미영");
		
		Random random = new Random(); // 랜덤 객체를 생성(자바에서 제공)
		
		for(int i =0 ; i<studentArr.length ; i++) {
			// studentArr[3]부터 참조하는 학생 객체가 없음
			// studentArr[3]부터 저장된 값은 null
			// * null : 참조하는 객체가 없음을 뜻하는 값 *
			
			if(studentArr[i] == null) { //3,4,5~ 뒤는 참조할 객체가 없음
				break; //학생 객체가 없으면 반복을 정지
			}
			
			// random.nextInt(101)
			// - 정수형 난수 0이상 101 미만의 정수형 난수를 반환 (= 0점부터 100점까지)
			studentArr[i].setKor(random.nextInt(101)); //학생 참조 변수를  
			studentArr[i].setEng(random.nextInt(101)); //학생 참조 변수를  
			studentArr[i].setMath(random.nextInt(101)); //학생 참조 변수를  
		}
		
		}
	

	/** 학생 추가 서비스 입니다. */   //설명용 주석 "/** /*
	//학생 추가
	public boolean addStudent(int grade, int ban, int number, String name) {
		
		// 1. studentArr의 요소 중
		// 	  참조하는게 없는 배열요소를 찾아
		// 	  그 중 index 번호가 가장 낮은 요소에 학생 객체 주소를 대입
		//    true 반환
		for(int i=0 ; i < studentArr.length ; i++) {
			
			if(studentArr[i] == null) { //참조하는게 없을 경우
				// 학생 객체를 생성하여 주소를 대입
				studentArr[i] = new Student(grade, ban, number, name);
				
				//return : 현재 메서드를 즉시 멈추고 호출한 곳으로 돌아감. 
				return true;	
			}
			
		}
		
		// 2. studentArr의 요소 중
		// 	  참조하는게 없는 배열 요소가 없을 경우 (꽉찬 경우)
		// 	  false를 반환
		
	
		return false;
		
	}

	/**학생 전체 조회 서비스 */
	
	public Student[] selectAll() {
		
		return studentArr;
	}
	
	/** 학생 1명 정보 조회(인덱스) 서비스 */
	
	public Student selectIndex(int index) { //매개변수로 index하나 받을거야
		
		// index가 배열 범위를 초과하거나
		// studentArr[index] 요소가 저장한 값이 null인 경우
		// null을 반환
		
		if(index < 0 || index >= studentArr.length || studentArr[index] == null) {
			return null;
		}
		
		// index번째 요소에 학생 객체를 참조하는 주소가 있는 경우 
		// 그 주소를 반환
		return studentArr[index];
		
	}
	
	/** 학생 1명 정보 수정(인덱스) 서비스 */
	
	public void updateStudent(Student s, int kor, int eng, int math) {
		s.setKor(kor);
		s.setEng(eng);
		s.setMath(math);
		
		// return; 안쓰면 컴파일러가 알아서 해준다
		
	}
	
	
	/** 학생 1명 점수 조회(점수,합계,평균) */
	
	public String selectScore(int index) {
		
		if(index < 0 || index >= studentArr.length || studentArr[index] == null) {
			return "\n해당 인덱스에 학생 정보가 존재하지 않습니다.";
			
		}
		
		
		// studentArr[index] 쓰기 기니까 짧은 이름의 변수에 주소만 복사
		Student s = studentArr[index];
		
		int sum = s.getKor() + s.getEng() + s.getMath();
		
		
	
		
		return String.format("\n[%s] 국어:%d, 영어:%d, 수학:%d, 합계:%d, 평균:%.1f",
				              s.getName(), s.getKor(), s.getEng(), s.getMath(), sum, sum/3.0 );
		
		//전체가 문자열인데, printf열로 만약에 작성하면, 바로 결과가 나온다. 결과를 출력을 위한 문임.
		
		
		// format: 문자열 자체로 저장하는 용도이고 , 문자열로 저장만 하고 출력을 안하겠다. 그래서 format + syso 문 쓰면 
		//그게 printf열인것이다.
		
		// printf = String.format + syso.print구문임.
		
	}


	/** 학생  이름으로 조회 서비스 */
	
	public Student[] selectName(String name) {
		
		// 기본 자료형 || 참조형(주소) || null 비교 시
		// 비교 연산자 (==, !=)
		
		// String || 객체가 가지고 있는 모든 필드 비교
		// A.equals(B) 사용 
		// string은 계산 연산자가 거의 불가능하다.  (가능은 한데 지금 어렵다)
		// 이름을 비교해야해서 우선 알려주는 것임
		
		//1. 반환하려는 Student 객체 배열의 크기를
		//   studentArr과 똑같이 만든 후
		//	 검색한 학생을 차례대로 배열에 추가 후 반환 
		//   -> for 문으로 출력시 배열 요소가 null인 경우 반복 종료

		//2. 같은 이름의 학생을 studentArr 배열에서 찾아 카운트 한 후 
		// 카운트한 크기 만큼의 학생 객체 배열을 생성 후
		// 같은 이름의 학생을 찾아 생성한 배열에 추가 
		// 필요없는 공간을 줄일 수 있어 좋은데, 더 많은 코드를 써야한다. 
		
		int count = 0;
		
		for( Student s : studentArr) {  //향상된 for문 
			//for문이라는게 반복인데, studentArr 이라는게 있다. 0,1,2,3,4 index.
			//for 문이 한바퀴 돌때마다. 0에서 하나 가져오고, 두번째 바퀴때는, 다음꺼를 s에 담아서 아래 코드를 실행하겠다
			// 2번 index 코드를 s에 담아서 코드. 
			// studentArr index에 있는 것을 지속적으로 들어간다. 
			// 각 객체가 있는 곳에서 0번 index를 꺼냈을때, 밑에 null 아니면 밑에 if문 실행
			// 0,1,2까지는 주소가 있음(데이터 있음), 3번은 null, 4번 null 이면 밑에 if 문의 break에서 멈추고 나감. 
			
			// NullPointerException (null을 참조해서 필드, 메서드 접근시 발생)
			// 방지 하기
			if(s == null) {
				break;
			}
			
			if(s.getName().equals(name)) {
				//s.getName()과 name의 값이 같을 때
				count++; // count 1 증가
			}
			
			
		}
		// count == 0인 경우 ( 검색한 이름의 학생이랑 같은 학생이 없다)
		if (count == 0) {
			return null;  // 다시 돌아갔을 때 null ==> 같은 학생이 없네
		}
		
		// 검색된 학생을 저장할 배열 생성
		
		Student[] arr = new Student[count];
		
		int index = 0; // 검색된 학생 객체의 주소를
						// arr 배열의 몇 번 인덱스 대입해야 되는지를 제어
		
		for(Student s : studentArr) {
			
			if(s == null) { // NullPointerException 방지
				break;
			}
			
			if(s.getName().equals(name)) { // 이름이 일치하는 학생일 경우
				arr[index] = s;
				index++;
				
			}
			
		}
		
		
		return arr;
	}

	/** 평균 최고점, 최저점 학생 찾기 서비스 */
		public Student[] selectMaxMin() {
		
			Student[] arr = new Student[2]; //[0]:최고점, [1]: 최저점
			
			// 인덱스
			int max = 0;
			int min = 0;
			
		
			//인덱스를 다루는 for문은 향상된 for문을 쓰면 안된다
			for(int i =0 ; i<studentArr.length ; i++) {
				
				if(studentArr[i] == null) { // 더 이상 학생이 없으면 멈춤
					break;				
				}
				
				// 최고점의 합
				Student s1 = studentArr[max];
				int maxSum = s1.getKor() + s1.getEng() + s1.getMath();
				
				// 최저점의 합
				Student s2 = studentArr[min];
				int minSum = s2.getKor() + s2.getEng() + s2.getMath();
				
				// 현재 인덱스(i) 번째 요소의 합
				Student s3 = studentArr[i];
				int sum = s3.getKor() + s3.getEng() + s3.getMath();
				
				if(sum > maxSum) { // 최대값 보다 큰 경우
					max = i; // 현재 인덱스를 max에 저장
				
				}
				
				if(sum < minSum) { //최저점 보다 작은 경우
					min = i;		
				}
		
			}
			
			// 최고점 학생을 0번, 최저점 학생을 1번 인덱스에 대입
			arr[0] = studentArr[max];
			arr[1] = studentArr[min];
			
			return arr;
	}


	
	
	
	
}


