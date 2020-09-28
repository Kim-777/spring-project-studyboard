package me.co.kim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 유저에 관련된 모든 요청을 받는 컨트롤러 입니다.
@Controller
@RequestMapping("/user")
public class UserController {
	
	// user/login 요청을 받아드리는 메서드입니다.
	// user 폴더에 있는 login 페이지를 반환해줍니다.
	@GetMapping("login")
	public String login() {
		return "user/login";
	}
	
	//user/join 요청을 받아드리는 메서드입니다.
	// user/join 페이지를 반환해줍니다.
	@GetMapping("join")
	public String join() {
		return "user/join";
	}
	
	
	// user/modify 요청을 받아드리는 메서드입니다.
	// user/modify 페이지를 반환해줍니다.
	@GetMapping("modify")
	public String modify() {
		return "user/modify";
	}
	
	// user/logout 요청을 받아드리는 메서드입니다.
	// user/logout을 반환해줍니다.
	@GetMapping("logout")
	public String logout() {
		return "user/logout";
	}
	
}
