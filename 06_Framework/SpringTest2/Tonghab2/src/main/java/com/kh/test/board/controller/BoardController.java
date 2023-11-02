package com.kh.test.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("selectMember")
	public String selectMember(String inputName, Model model) {
		
		List<Board> boardList = service.selectMember(inputName);
		
		if(!boardList.isEmpty()) {
			
			model.addAttribute("boardList", boardList);
			
			return "searchSuccess";
		}
		
		return "searchFail";
	}
	

}
