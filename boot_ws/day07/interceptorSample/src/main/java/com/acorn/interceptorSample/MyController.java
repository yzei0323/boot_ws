package com.acorn.interceptorSample;

import java.io.IOException;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	
	@RequestMapping( value="/index" , method=RequestMethod.GET )
	public String  main( ) {		
		return "index";
	}


	@RequestMapping( value="/login" , method=RequestMethod.GET)
	public String login() {		
		return "login";		
	}	
	


	@RequestMapping( value="/login" , method=RequestMethod.POST)
	public String login2(String id, String pw , HttpSession session  ) {

	 	session.setAttribute("loginID", id);		
		return "loginOk";		
	}
	
	@RequestMapping( value="/logout" , method=RequestMethod.GET)
	public String logout( HttpSession session) {
		 session.invalidate();		
		 return "index";
	}

	
	@RequestMapping( value="/order.do", method=RequestMethod.GET)
	public String order() {			
		//세션확인 , 로그인이 안되었으면 로그인으로 		
		return "order";
	}
	
	
	
	@RequestMapping( value="/border.acorn", method=RequestMethod.GET)
	public String border() {			
		//세션확인 , 로그인이 안되었으면 로그인으로 	
	
		return "border";
	}
	
	
	@RequestMapping( value="/modify", method=RequestMethod.GET)
	public String modify(HttpServletRequest request ) {
	//세션 직접 
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginID");		
		System.out.println("  세션 직접 로그인여부:" + id);
		if (id !=null){
			 return "modify";	
	    }
		return "redirect:/login";
	}
		
	

}
