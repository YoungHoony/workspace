package com.kh.test.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("selectBoard")
	public String selectBoard(String inputBoard, Model model) {
		
		List<Board> boardList = service.selectBoard(inputBoard);
		
		if(!boardList.isEmpty()) {
			
			model.addAttribute("boardList", boardList);
			return "searchSuccess";
		}
		
		return "searchFail";
		
		
	}
	/* 
	 * 
	 * 
	 * @Controller
	 * 
	 * @Autowired
	 * private BoardService service;
	 * 
	 * @GetMapping("selectBoard")
	 * public String selectBoard(String inputMember, Model model)
	 * 
	 * List<Board> boardList = service.selectBoard(inputMember);
	 * 
	 * if(!boardList.isEmpty()){
	 * 
	 * model.addAttribute("boardList", boardList);
	 *
	 * return "success";}
	 * 
	 * return "fail";
	 * 
	 * 
	 * 
	 * */
//	@Autowired
//
//	private CustomerService service;
//
//	@PostMapping("updateCustomer")
//
//	public String updateCustomer(Customer customer, Model model) {
//
//	int result = service.updateCustomer(customer);
//
//	if(result > 0) model.addAttribute("message", "수정 성공!!!");
//
//	else model.addAttribute("message", "회원 번호가 일치하는 회원이 없습니다");
//
//	return "result";
//
//	}

	

}
