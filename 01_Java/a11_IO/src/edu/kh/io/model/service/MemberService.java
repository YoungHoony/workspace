package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.io.model.dto.Member;
import edu.kh.io.view.MemberView;

public class MemberService {

	//회원 목록 참조 변수 선언
	private List<Member> memberList = null;
	
	// 기본 생성자 (기본 생성자에 try, catch 문까지 전체가 기본 생성자 안에 작성)
	public MemberService() {
		
		// 외부 파일에 작성된 객체(List<Member>)를 읽어와 
		// memberList에 대입하는 코드 작성

		// FileInputStream, ObjectInputStream (객체만 있는 파일을 읽어오겠다)
	
		ObjectInputStream ois = null;
		
		try {
			
			// 파일이 있으면 읽어와 저장된 객체(List<Member>)를 memberList에 저장하겠다라는 의미
			ois = new ObjectInputStream(new FileInputStream("object/memberList.txt"));
			//memberList는 List<Member> 타입으로 제한되어있는데, readObject는 Object 타입이기 때문에 다운 캐스팅 해야한다.
			memberList = (List<Member>)ois.readObject();
			// 				//(다운캐스팅)	//(Object)
			
		} catch (FileNotFoundException e) {
			System.out.println("[[ memberList.txt 파일이 존재하지 않습니다.]]");
			
			//파일이 존재하지 않으면, 위에 참조 변수에 저장하려고 했는데, null이 아니라 비어있는 것이라도 넣겠다. 
			memberList = new ArrayList<Member>(); // 비어있는 리스트를 memberList에 대입
			
		} catch (IOException e) { //다른게 있으면 에러 작업
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) { // (List<Member>)ois.readObject();위에서 다운캐스팅 때문에 에러가 뜨고, 오른쪽 클릭해서 자동완성한다.

			e.printStackTrace();
		} finally {
			
			try {
				if( ois != null) ois.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	} 
	
	/** 회원 목록 반환 service
	 * @return memberList
	 */
	public List<Member> selectAll() {
		return memberList;
	}

	/** 회원 가입 service
	 * @param id
	 * @param pw
	 * @param name
	 * @param point
	 * @return 성공 true / 아이디 중복 false
	 */
	public boolean signUp(String id, String pw, String name, int point) {
		
		// 아이디 중복 검사
		for(Member mem : memberList) { //memberList 전체 리스트에서, 하나하나 Member들을 떠낸다
			if(mem.getId().equals(id)) { //id는 String이기 때문에 equals를 써야한다.  //아이디 중복인 경우 --> false
				return false;
			}
		}
		
		// ----------------------------------------------------------------------
		// 중복 아닌 경우
		
		// 1. 전달 받은 값을 이용해 Member객체 생성 후 memberList에 추가 
		memberList.add(new Member(id,pw,name,point));
		
		// 2. 회원이 추가된 memberList를
		// memberList.txt 파일로 출력
		ObjectOutputStream oos = null;
								 
		try {            //보조 stream
			oos = new ObjectOutputStream( new FileOutputStream("object/memberList.txt"));
		
			oos.writeObject(memberList); // 밖으로 memberList를 내보내겠다. 
			
		} catch (IOException e) {
		    e.printStackTrace();
		    
		} finally {
		
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return true;
	}

	/** ID/PW 일치하는 회원 반환 service
	 * @param id
	 * @param pw
	 * @return 일치하면 Member객체 주소  / 없으면 null
	 */
	public Member selectOne(String id, String pw) {
		
			for (Member mem : memberList ) {
				if(mem.getId().equals(id) && mem.getPw().equals(pw)) {
					return mem;
				} 
	
			}
	
		return null;
	}
	


}
