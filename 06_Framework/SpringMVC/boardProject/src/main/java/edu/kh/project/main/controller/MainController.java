package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// "/"(최상위 주소)로 요청을 받게되면 common/main으로 나타낸다. 
	@RequestMapping("/")
	public String mainpage() {
		
		
		return "common/main";
		// -> /WEB-INF/views/common/main.jsp로 forward한다 (prefix, suffix 추가)
	}
	
	
	
}
