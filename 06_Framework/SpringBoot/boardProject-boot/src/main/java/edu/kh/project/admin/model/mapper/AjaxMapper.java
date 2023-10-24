package edu.kh.project.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {

	/** 회원 번호로 이메일 조회
	 * @param memberNo
	 * @return  email
	 */
	public String selectMemberNo(int memberNo);

	/**  이메일로 전화번호 조회
	 * @param inputEmail
	 * @return memberTel
	 */
	public String selectEmail(String inputEmail);

	/** 회원 번호로 회원 정보 조회
	 * @param no
	 * @return
	 */
	public Member selectMember(int no);

	/** 일부 일치하는 이메일 모두 조회
	 * @param keyword
	 * @return
	 */
	public List<String> selectEmailList(String keyword);

}
