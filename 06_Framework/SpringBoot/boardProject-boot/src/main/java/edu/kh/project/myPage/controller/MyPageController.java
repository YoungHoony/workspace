package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	
	
	
	
	

}
