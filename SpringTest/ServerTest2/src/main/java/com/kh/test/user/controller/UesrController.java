package com.kh.test.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;


@Controller
public class UesrController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("selectMember")
	public String selectMember(String inputId, Model model) {
		
		User searchMember = service.selectMember(inputId);
		
		if(searchMember != null) {
			model.addAttribute("searchMember", searchMember);
			return "searchSuccess";
		}
		
		return "searchFail";
		
	}
	

}
