package me.co.kim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// HomeController가 redirect 한 index를 브라우저를 통해 요청 받습니다.
	// index.jsp를 반환합니다.
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
}
