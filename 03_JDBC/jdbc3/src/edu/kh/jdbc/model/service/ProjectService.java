package edu.kh.jdbc.model.service;

// static 필드/메서드 호출 시 클래스명(JDBCTemplate) 생략 
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.model.dao.ProjectDAO;
import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;

public class ProjectService {

	private ProjectDAO dao = new ProjectDAO();
	
	/** 회원 가입
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출(Connection, 매개 변수 전달)
		int result = dao.insertMember(conn, member); 
		
		// 3. 트랜잭션 제어
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 view로 반환
		
		return result;
	}

	/** 로그인
	 * @param email
	 * @param pw
	 * @return
	 */
	public Member login(String email, String pw) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출
//		Member member = dao.login(conn, email, pw); PreparedStatement 방식으로 함
		
		Member member = dao.login2(conn, email, pw); // Statement방식으로 작성 (prepared랑 다른걸 보기위함)
		
		// SELECT는 트랜잭션 제어 처리가 필요 없음 -> 건너 뜀
		// 3. 커넥션 반환 (꺼주기)
		close(conn);
		
		// 4. view로 결과 반환
		
		return member;
	}
	
	
	/** MEMBER 테이블 전체 조회
	 * @param sort
	 * @return
	 */
	public List<Member> selectAllMember(int sort) {
		
		Connection conn = getConnection(); //커넥션 생성
		
		// DAO 메서드 호출 후 결과 반환 받기
		List<Member> memberList = dao.selectAllMember(conn, sort);
		
		close(conn); // 커넥션 반환
		
	
		return memberList; // 결과 반환
		
	}


	/** 회원 정보 수정
	 * @param nickname
	 * @param tel
	 * @param memberNo
	 * @return
	 */
	public int updateMember(String nickname, String tel, int memberNo) {
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, nickname, tel, memberNo); 
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn); 
		
		return result;
		
	}

	/** 회원 탈퇴
	 * @param memberNo
	 * @param pw
	 * @return
	 */

	public int updateDelfl(int memberNo, String pw) {
	Connection conn = getConnection();
		
		int result = dao.updateDelfl(conn, memberNo, pw);
		if(result > 0) commit(conn);
		else  		   rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 테이블 INSERT하기
	 * @param title
	 * @param content
	 * @param Memberno
	 * @return
	 */
	public int insertBoard(String title, String content, int MemberNo) {
		Connection conn = getConnection();
		int result = dao.insertBoard(conn, title, content,MemberNo);
		if(result > 0 ) commit(conn);
		else  		   rollback(conn);
		
		close (conn);
		
		return result;
		
	
	}

	/** 게시글 목록 조회
	 * @param conn
	 * @param boardNo
	 * @return
	 */
	public List<Board> selectBoardList() {
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectBoardList(conn);
		close(conn);
		
		return boardList;
		
	}
	

	
	
	/** 게시글 상세 조회
	 * @param boardNo
	 * @return
	 */
	public Board selectBoard(int boardNo) {
		
		Connection conn = getConnection();
		
		// 1) DAO - 게시글 상세 조회 메서드, 호출
		Board board = dao.selectBoard(conn,boardNo);
		
        // 2) 게시글 상세 조회 결과가 있을 경우 
		// -> 조회수 증가(incrementReadCount(게시글 번호)) 수행
		
		if(board != null) { 
			
			int result = dao.incrementReadCount(conn,boardNo);
			// 트랜잭션 처리
			if(result > 0 ) { 
				commit(conn);
				
				// DB와 데이터 동기화
				// (DB에서만 조회수가 1 증가하기 때문에 
				// 조회해둔 board에도 조회수 1을 증가시킨다)
				board.setReadCount(board.getReadCount() +1);
			} else rollback(conn);
	
		}
		
		close(conn); // 커넥션 반환
		return board;
	
	}

	/** 작성자 확인
	 * @param boardNo
	 * @param memberNo
	 * @return check
	 */
	public int writerCheck(int boardNo, int memberNo) {
		Connection conn = getConnection();
		int check = dao.writerCheck(conn, boardNo, memberNo);
		close(conn);
		return check;
	}
	
	
	/** 게시글 삭제
	 * @param boardNo
	 * @return result
	 */
	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0)	commit(conn);
		else 			rollback(conn);
		
		close(conn);
		return result;
	}



	/** 게시글 수정
	 * @param title
	 * @param content
	 * @param boardNo
	 * @return
	 */
	public int updateBoard(String title, String content, int boardNo) {
		Connection conn = getConnection();
		int result = dao.updateBoard(conn, title, content, boardNo);
		
		if(result > 0)	commit(conn);
		else 			rollback(conn);
		
		close(conn);
		return result;
	}






	}
	

	

