package me.co.kim.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	// 모든 요청을 처음 받는 메서드 입니다.
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		
		//System.out.println(request.getServletContext().getRealPath("/"));
		
		// 브라우저에게 redirect를 전달함으로써 브라우저가 다시 요청을 하도록 합니다.
		// index jsp를 반환해줍니다.
		return "redirect:/index";
	}

}
