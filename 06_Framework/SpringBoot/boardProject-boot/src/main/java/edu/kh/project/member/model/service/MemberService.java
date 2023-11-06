package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember);

	/** 회원 가입 서비스
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int signup(Member inputMember, String[] memberAddress);


	/** 이메일 중복검사
	 * @param email
	 * @return 0 또는 1
	 */
	int checkEmail(String email);

	/** 닉네임 중복검사
	 * @param nickname
	 * @return 0 또는 1
	 */
	int checkNickname(String nickname);

	Member quickLogin(String memberEmail);

}
