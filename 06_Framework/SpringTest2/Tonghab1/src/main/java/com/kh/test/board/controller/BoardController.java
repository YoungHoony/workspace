package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("/")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("selectBoard")
	public String selectBoard(String inputBoard, Model model) {
		
		Board searchBoard = service.selectBoard(inputBoard);
		
		if(searchBoard != null) {
			
			model.addAttribute("searchBoard", searchBoard);
			return "searchSuccess";
		}
		
	
		return "searchFail";
		
		
		
		
	}
	
		
	
	

}
