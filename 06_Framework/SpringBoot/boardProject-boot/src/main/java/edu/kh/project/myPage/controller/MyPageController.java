package edu.kh.project.myPage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("myPage")
@SessionAttributes({"loginMember"})
@Slf4j
public class MyPageController {
	
	@Autowired
	private MyPageService service;
	
	// 마이 페이지 화면 전환 (forward)
	
	@GetMapping("info") // /myPage/info (이런 모양의 요청이 왔을 때!)
	public String info() {
		
		// templates/myPage/myPage-info.html로 forward하겠다라는 뜻
		return "myPage/myPage-info";
	}
	
	@GetMapping("profile") // /myPage/info (이런 모양의 요청이 왔을 때!)
	public String profile() {
		
		// templates/myPage/myPage-profile.html로 forward하겠다라는 뜻
		return "myPage/myPage-profile";
	}
	
	@GetMapping("changePw") // /myPage/info (이런 모양의 요청이 왔을 때!)
	public String changePw() {
		
		// templates/myPage/myPage-changePw.html로 forward하겠다라는 뜻
		return "myPage/myPage-changePw";
	}
	
	@GetMapping("secession") // /myPage/info (이런 모양의 요청이 왔을 때!)
	public String secession() {
		
		// templates/myPage/myPage-secession.html로 forward하겠다라는 뜻
		return "myPage/myPage-secession";
	}
	
	// ------------------------------------------------------------------
	
	
	/** 회원정보 수정
	 * @param updateMember : 수정된 회원 정보가 담긴 커맨드 객체
	 * @param memberAddress : 주소 값이 담긴 배열
	 * @param loginMember : 현재 로그인한 회원의 정보가 담긴 객체 (session 에서 얻어옴)
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달하는 용도 (message 보낼 때 쓸것임)
	 * @return
	 */
	@PostMapping("info")
	public String info(Member updateMember, String[] memberAddress,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) {
		
		// 1. loginMember에서 회원 번호만 얻어와 updateMember에 세팅 
		updateMember.setMemberNo( loginMember.getMemberNo() ); 
		
		// 2. 회원 정보 서비스 호출 후 결과 반환 받기
		int result = service.info(updateMember, memberAddress);
		
		// 3. 서비스 처리 결과에 따라 응답 제어 
		
		String message = null;
		// 성공 했을 때,
		// - message = "회원 정보가 수정되었습니다"
		// - session에 세팅된 이전 회원 정보를 수정된 회원 정보로 다시 세팅
		
		if(result > 0) {
			message = "회원 정보가 수정되었습니다.";
			
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
			
		}
		
		// 실패했을 때,
		// - message = "회원 정보 수정 실패..."
		
		else {
			message = "회원 정보 수정 실패..";
		
		}
		
		ra.addFlashAttribute("message", message);
	
		return "redirect:info";
	
	}
	
	
	
	/** 비밀번호 변경
	 * @param currentPw : 현재 비밀번호 (@RequestParam 생략)
	 * @param newPw : 새 비밀번호( @RequestParam 생략)
	 * @param loginMember : 로그인한 회원 (session)
	 * @param ra : 리다이렉트 시 데이터 전달
	 * @return
	 */
	@PostMapping("changePw")
	public String changePw( String currentPw, String newPw, 
			@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra) {
		
		// 비밀번호 변경 서비스 호출
		
		int memberNo = loginMember.getMemberNo();
		
		int result = service.changePw(currentPw, newPw, memberNo);
		
		String path = null;
		String message = null;
		
		if(result > 0) {
			message = "비밀번호 수정이 완료되었습니다";
			path="redirect:info";
		}
		
		else {
			message = "현재 비밀번호가 일치하지 않습니다";
			path = "redirect:changePw";
		}
		
		ra.addFlashAttribute("message", message);
		return path;
		
	}
	
	@PostMapping("secession")
	public String secession(String memberPw, @SessionAttribute("loginMember") Member loginMember, 
			RedirectAttributes ra, SessionStatus status) {
		
		int memberNo = loginMember.getMemberNo();
		
		int result = service.secession(memberPw, memberNo);
		
		String path = null;
		String message = null;
		
		if(result > 0) {
			message = "탈퇴 되었습니다.";
			path = "redirect:/";
			status.setComplete();
		}
		
		else {
			message = "비밀번호가 일치하지 않습니다.";
			path = "redirect:secession";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	// ------------------------------------------------------------------------------------------
	
	// MultipartFile : multipart/form-data 형식으로 제출된 파라미터 중 
	//  				file타입 데이터만 추출해 저장하는 Spring제공 객체 
	// - 실제 파일
	// - 파일 이름
	// - 파일 크기 
	// - 업로드된 파일을 지정된 경로에 저장하는 메서드 
	
	// 파라미터인데 파일이네? 잘 업로드 됏으면 
	// 1) session 2) DB 3) 파일 서버 저장 까지 생각해야함. 
	
	
	/** 프로필 이미지 수정
	 * @param profileImg : 실제 업로드된 프로필 이미지
	 * @param loginMember
	 * @param ra
	 * @return
	 */
	@PostMapping("profile")
	public String profile(
			@RequestParam("profileImg") MultipartFile profileImg, @SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) throws IllegalStateException, IOException {
		
		// 프로필 이미지 수정 서비스 호출 후 결과 반환
		int result = service.profile(profileImg, loginMember);
							// 실제 이미지 파일, 세션에 저장된 회원 정보
		
		// 서비스 결과에 따라 응답 제어
		String message = null;
		
		if(result > 0) { 
			message = "프로필 이미지가 변경 되었습니다.";
		} else {
			message = "프로필 변경 실패!";
			
		}
		
		ra.addFlashAttribute("message", message);
		
		// 프로필 페이지로 리다이렉트
		return "redirect:profile";
		
	}
	
	
	
	
	

}
