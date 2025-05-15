package com.acorn.mybatisSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	
	@Autowired
	BoardRepository repository;
	 
	
	@RequestMapping("/board")
	public String  getSearch( SearchCondition condition , Model model) throws Exception {	
		


		System.out.println( condition);
		System.out.println( condition.getCondition());
		System.out.println( condition.getKeyword());

		List<BoardDTO> list  =repository.searchCondition(condition);	
		
		System.out.println( list);
		model.addAttribute("list", list);
		return "list";		
		
	}

	
	
}
