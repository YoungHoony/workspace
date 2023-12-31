package edu.kh.jdbc.model.dao;

//static 필드/메서드 호출 시 클래스명(JDBCTemplate) 생략 
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member; 


public class ProjectDAO {
	
	// JDBC 객체 참조 변수 선언
	
	// Connection : DB 연결 정보를 담고있는 객체
	// Statement : Connection을 통해 생성
	// SQL 수행 후 결과를 반환 받는 객체 
	
	// PreparedStatement : Connection을 통해 생성
	// SQL 중간에 삽입될 변수 자리를 ?(placeholder)로 지정해
	// SQL을 변수 값에 따라 쉽게 변화시킬 수 있는 Statement 자식 객체 
	
	
	// ResultSet : SELECT 구문 수행 결과를 저장할 객체 
	//  1행씩 접근하면서 컬럼 값을 얻어올 수 있음. 
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	/** 회원가입
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertMember(Connection conn, Member member) {
		
		// 1. 결과 저장용 변수 선언
		int result = 0;
		
		// 2. SQL 작성
		String sql = "INSERT INTO MEMBER "
				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)";
		
		try {
			// 3. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?(placeholder)에 알맞은 값 대입
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			// 5. SQL(INSERT) 수행 후 결과(성공한 행의 개수) 반환 받기
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			//6. 사용한 JDBC 객체 자원 반환(close)
		}
		
		// 7. SQL 수행 결과 반환
		return result;
		
	}

	/** 로그인
	 * @param conn
	 * @param email
	 * @param pw
	 * @return
	 */
	public Member login(Connection conn, String email, String pw) {

		// 1. 결과 저장용 변수 선언
		Member member = null;
		
		// 2. SQL 작성
		String sql = "SELECT MEMBER_NO, MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDRESS, \r\n"
				+ "	TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI:SS') ENROLL_DATE \r\n"
				+ "FROM MEMBER\r\n"
				+ "WHERE MEMBER_EMAIL = ? \r\n"
				+ "AND MEMBER_PW = ? \r\n"
				+ "AND MEMBER_DEL_FL = 'N'";
		
		try {
			// 3. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?에 값 대입
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			
			
			// 5. SQL 수행 후 결과(ResultSet) 반환 받기
			// SELECT -> executeQuery
			// DML 	  -> executeUpdate 
			rs = pstmt.executeQuery();
			
			// 6. ResultSet이 조회된 다음 행이 있는지 확인
			// -> 아이디, 비밀번호가 일치하는 경우는 1행 밖에 없으므로 
			// while(조건식) 대신 if(조건식) 사용 가능
			
			// while(rs.next()) { // 반복이 필요하지 않은 경우는 if을 사용하는것이 성능적으로 좋다
			if(rs.next()) { // 결과가 있을 때 무조건 1행이면 if 사용 권고
				
				// 7. 조회 결과가 있을 경우 컬럼 값을 모두 얻어오기
				int memberNo = rs.getInt("MEMBER_NO");
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String memberTel = rs.getString("MEMBER_TEL");
				String memberAddress = rs.getString("MEMBER_ADDRESS");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				// + 매개 변수 email
				
				// 8. Member 객체를 생성하여 얻어온 값을 모두 세팅
				member = new Member();
				// 결과 저장용 변수가 Member 객체를 참조
				// == null 아님
				
				member.setMemberEmail(email);
				member.setMemberNo(memberNo);
				member.setMemberNickname(memberNickname);
				member.setMemberTel(memberTel);
				member.setMemberAddress(memberAddress);
				member.setEnrollDate(enrollDate);
				
			}
			
			
		} catch(SQLException e ) {
			e.printStackTrace();
			
		} finally {
			// 9. 사용한 JDBC 객체 반환(역순)
			// pstmt, rs
			close(rs);
			close(pstmt);
			
		}
	
		// member == null -> 로그인 실패
		// member != null -> 로그인 성공
		
		return member;
	}

	public Member login2(Connection conn, String email, String pw) {

		// 1. 결과 저장용 변수 선언
		Member member = null;
		
		// 2. SQL 작성
		String sql = "SELECT MEMBER_NO, MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDRESS, \r\n"
				+ "	TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI:SS') ENROLL_DATE \r\n"
				+ "FROM MEMBER\r\n"
				+ "WHERE MEMBER_EMAIL = '"+email+"'\r\n"
				+ "AND MEMBER_PW = '"+pw+"'\r\n"
				+ "AND MEMBER_DEL_FL = 'N'" ;
		
		try {
			
			// 3. Statement 객체 생성
			stmt = conn.createStatement(); 
			//Statement 객체 생성 시 SQL을 전달하지 않음
			
			
			// 4. SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			// Statement가 SQL을 수행하려고 할 때 SQL을 전달해줌,
			
			// 5. ResultSet에 조회된 다음 행이 있는지 확인
			if(rs.next()) { // 결과가 있을 때 무조건 1행이면 if 사용 권고
				
				// 6. 조회 결과가 있을 경우 컬럼 값을 모두 얻어오기
				int memberNo = rs.getInt("MEMBER_NO");
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String memberTel = rs.getString("MEMBER_TEL");
				String memberAddress = rs.getString("MEMBER_ADDRESS");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				// + 매개 변수 email
				
				// 7. Member 객체를 생성하여 얻어온 값을 모두 세팅
				member = new Member();
				// 결과 저장용 변수가 Member 객체를 참조
				// == null 아님
				
				member.setMemberEmail(email);
				member.setMemberNo(memberNo);
				member.setMemberNickname(memberNickname);
				member.setMemberTel(memberTel);
				member.setMemberAddress(memberAddress);
				member.setEnrollDate(enrollDate);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			// 8. 사용한 JDBC 객체 반환
			close(rs);
			close(stmt);
				
		}
			
		return member;
	}

	
	/** MEMBER 테이블 전체 조회
	 * @param conn
	 * @param sort
	 * @return
	 */
	public List<Member> selectAllMember(Connection conn, int sort) {
		
		// 1. 결과 저장용 객체 생성
		List<Member> memberList = new ArrayList<Member>();
		
		// 2. SQL 작성
		String sql = "SELECT * FROM MEMBER ORDER BY MEMBER_NO";
		
		// sort 값에 따라 SQL 변경
		if(sort == 1) sql += " DESC";
		
		try {
			// ----- 3.Statement 버전 -----
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
			
			// ------ 3.PreparedStatement 버전 ------
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 4. 조회 결과 1행씩 접근 (여러 행이면 while, 1행이면 if)
			while(rs.next()) {
				
//				int memberNo = rs.getInt("MEMBER_NO"); // 컬럼명
				int memberNO 			= rs.getInt(1); // 컬럼 순서
				String memberEmail  	= rs.getString(2);
				String memberPw			= rs.getString(3);
				String memberNickname   = rs.getString(4);
				String memberTel 		= rs.getString(5);
				String memberAddress 	= rs.getString(6);
				
				// java.sql.Date
				Date enrollDate 		= rs.getDate(7);
				String memberDelFl 		= rs.getString(8);
				
				// 5. Member 객체를 생성하여 컬럼 값 세팅 후 리스트에 추가
				Member member = new Member(memberNO, memberEmail, 
						                  memberPw, memberNickname, memberTel, 
						                  memberAddress,
						                  enrollDate.toString(),// 7번째 매개변수
						                  memberDelFl);
				
				memberList.add(member);
					
			} // While문 끝
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			// 6. 사용한 JDBC 객체 반환
			close(rs);
			close(pstmt);
		}
		
		// 7. 결과 반환
		return memberList;			
	}
	
	/** 회원 정보 수정
	 * @param conn
	 * @param member
	 * @return
	 */

	public int updateMember(Connection conn, String nickname, String tel, int memberNo) {
		
		int result = 0;
		
		String sql = "UPDATE MEMBER SET \r\n"
				+ "MEMBER_NICKNAME = ?, \r\n"
				+ "MEMBER_TEL = ?\r\n"
				+ "WHERE MEMBER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nickname);
			pstmt.setString(2, tel);
			pstmt.setInt(3, memberNo);
			
			//executeUpdate() : DML 할때 작성
			// executeQuery() : SELECT 작성할 때
			
			result = pstmt.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
			
		}

		return result;
	}

	/** 회원 탈퇴
	 * @param conn
	 * @param memberNo
	 * @param pw
	 * @return
	 */
	public int updateDelfl(Connection conn, int memberNo, String pw) {
		int result = 0;
		
		
		String sql = "UPDATE MEMBER SET MEMBER_DEL_FL = 'Y'\r\n"
				+ "WHERE MEMBER_NO = ?\r\n"
				+ "AND MEMBER_PW = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,memberNo);
			pstmt.setString(2, pw);
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
	
		return result;
	}

	/** 게시글 작성하기
	 * @param conn
	 * @param title
	 * @param content
	 * @param memberNo
	 * @return
	 */
	public int insertBoard(Connection conn, String title, String content, int memberNo) {
		int result = 0; // 삽입 결과 (INSERT 입력한 결과 저자용 변수)
		
		String sql = "INSERT INTO BOARD b \r\n"
				+ "VALUES (SEQ_BOARD_NO.NEXTVAL, "
				+ "?,"
				+ "?,"
				+ " DEFAULT, DEFAULT, DEFAULT, "
				+ "?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);		
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e ) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}

		return result;
	}

	// ------------------ 게시글 목록 조회(selectBoardList) ------------------
	// 게시글 번호, 제목, 작성일, 조회수, 작성자번호, 작성자 닉네임
	// 게시글 번호 내림차순으로 조회
	// 단, 삭제되지 않은 글만 조회(BOARD_DEL_FL = 'N')
	
	//public List<Member> selectAllMember(Connection conn, int sort) {
		
		// 1. 결과 저장용 객체 생성
		//List<Member> memberList = new ArrayList<Member>();
	
	
	
	public List<Board> selectBoardList(Connection conn) {
		
		List<Board> boardList = new ArrayList<Board>();
		
		String sql = "SELECT BOARD_NO, BOARD_TITLE, \r\n"
				+ "	TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD HH24:MI:SS') B_CREATE_DATE,\r\n"
				+ "	READ_COUNT, MEMBER_NO, MEMBER_NICKNAME \r\n"
				+ "FROM BOARD \r\n"
				+ "JOIN MEMBER USING(MEMBER_NO)\r\n"
				+ "WHERE BOARD_DEL_FL = 'N'\r\n"
				+ "ORDER BY BOARD_NO DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				
				Board b = new Board();
				 
				b.setBoardNo(rs.getInt("BOARD_NO"));
				b.setBoardTitle(rs.getString("BOARD_TITLE"));
				b.setBoardCreateDate(rs.getString("B_CREATE_DATE"));
				b.setReadCount(rs.getInt("READ_COUNT"));
				b.setMemberNo(rs.getInt("MEMBER_NO"));
				b.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
		
				 boardList.add(b);
				 
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			close(rs);
			close(pstmt);	
			
		}
	
		
		return boardList;
		
	}


	
	/** 게시글 상세 조회
	 * @param conn
	 * @param boardNo
	 * @return
	 */
	public Board selectBoard(Connection conn, int boardNo) {

		//결과 저장용 변수 선언
		Board board = null;
		
		// 게시글 번호를 입력 받아 일치하는 게시글의
        // 제목, 내용, 작성일, 조회수, 작성자번호, 작성자 닉네임 조회
        // 단, 삭제되지 않은 게시글만 조회 가능(BOARD_DEL_FL = 'N')

		String sql = "SELECT BOARD_TITLE, BOARD_CONTENT ,TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD HH24:MI:SS') B_CREATE_DATE ,READ_COUNT ,MEMBER_NO,MEMBER_NICKNAME\r\n"
				+ "FROM BOARD\r\n"
				+ "JOIN MEMBER USING(MEMBER_NO)\r\n"
				+ "WHERE BOARD_DEL_FL = 'N'\r\n"
				+ "AND BOARD_NO = ?";
		
		try {
			// pstmt 생성
			pstmt = conn.prepareStatement(sql);
			
			// ? 에 알맞은 값 세팅
			pstmt.setInt(1, boardNo);
			
			// sql(SELECT) 수행 후 결과(ResultSet) 반환 받기
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 조회 결과가 있을 경우
				
				 board = new Board();
				 
				 board.setBoardTitle( rs.getString("BOARD_TITLE"));
				 board.setBoardContent(rs.getString("BOARD_CONTENT"));
				 board.setBoardCreateDate(rs.getString("B_CREATE_DATE"));
				 board.setReadCount(rs.getInt("READ_COUNT"));
				 board.setMemberNo(rs.getInt("MEMBER_NO"));
				 board.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
				 
				 board.setBoardNo(boardNo);			 
			
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return board;
	}

	/** 조회수 증가
	 * @param conn
	 * @param boardNo
	 * @return
	 */
	public int incrementReadCount(Connection conn, int boardNo) {
		
		int result = 0;
		
		String sql = "UPDATE BOARD SET \r\n"
				+ "READ_COUNT = READ_COUNT + 1\r\n"
				+ "WHERE BOARD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,  boardNo);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
		
	}

	/** 작성자 확인
	 * @param conn
	 * @param boardNo
	 * @param memberNo
	 * @return check
	 */
	public int writerCheck(Connection conn, int boardNo, int memberNo) {
		int check = 0;

		String sql = "SELECT COUNT(*) CHK FROM BOARD\r\n"
				+ "WHERE BOARD_NO = ?\r\n"
				+ "AND MEMBER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);
			
			rs = pstmt.executeQuery(); // SELECT문 수행 -> ResultSet 반환
			
			if(rs.next()) { // 조회 결과가 1행 밖에 없어서 if문 사용
				check = rs.getInt("CHK"); //  CHK 컬럼의 값을 얻어옴
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return check;
	}
	
	
	/** 게시글 삭제
	 * @param conn
	 * @param boardNo
	 * @return
	 */
	public int deleteBoard(Connection conn, int boardNo) {
		int result = 0;

		String sql = "UPDATE BOARD SET \r\n"
				+ "BOARD_DEL_FL = 'Y'\r\n"
				+ "WHERE BOARD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 게시글 수정
	 * @param conn
	 * @param title
	 * @param content
	 * @param boardNo
	 * @return result
	 */
	public int updateBoard(Connection conn, String title, String content, int boardNo) {
		int result = 0;

		String sql = "UPDATE BOARD SET \r\n"
				+ "BOARD_TITLE = ?,\r\n"
				+ "BOARD_CONTENT = ?\r\n"
				+ "WHERE BOARD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}





	
	

	
	
} // DAO 클래스 끝
