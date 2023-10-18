package edu.kh.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;

import edu.kh.project.admin.model.service.AdminService;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("admin") // admin이라는 주소에서 나오는 모든 걸 다 처리한다
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	/** 관리자 메인 페이지
	 * @return "admin/admin-main"
	 */
	@GetMapping("main")
	public String adminMain() {
		// forward : 요청 위임
		// 화면 대신 만들어서 응답좀 해달라
		// Thymeleaf 
		// - prefix : classpath:/templates/
		// - suffix : .html
		return "admin/admin-main";
	}
	
	@GetMapping("selectMember")
	public String selectMember(String inputEmail, Model model) {
		
		// 이메일이 일치하는 회원이 존재하는 경우 
		// model.addAttribute("searchMember", value);
		// return "admin/success"; // forward
		
		Member searchMember = service.selectMember(inputEmail);
		
		if(searchMember != null) {
			model.addAttribute("searchMember", searchMember);
			return "admin/success";
		}
			
		// 이메일이 일치하는 회원이 존재하지 않는 경우
		// return "admin/fail" // forward
		
		return "admin/fail";
	}

}
