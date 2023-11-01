package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

@Controller
public class CustomerController {
//	
//	@Autowired
//	private CustomerService service;
//	
//	@PostMapping("addCustomer")
//	public String addCustomer( Customer inputMember, String memberAddress, RedirectAttributes ra ) {
//		
//		int result = service.addCustomer(inputMember, memberAddress);
//		
//		return "result";
//	}
//	
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("updateCustomer")
	public String updateCustomer(String inputMember) {
		
		int result = service.updateCustomer(inputMember);
		
		String message = null;
		
		if(result>0) {
			message = "수정 성공!!!";
			return "result";
			
		} 
		
		message ="회원 번호가 일치하는 회원이 없습니다.";
		return "result";
		
		
	}

	
	

}
