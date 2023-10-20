package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;

@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("member")
public class MemberController_prac {
	
	@Autowired
	private MemberService service;
	
	public String login(Member inputMember, Model model, RedirectAttributes ra ) {
		
		return "member/login";
	}
	
	
	
	
		

	
	
	
	

}
