package me.co.kim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.co.kim.service.UserService;

//ajax를 통해 브라우저에게 json의 형태로 데이터를 전달하는 RestController입니다.
@RestController
public class RestApiController {

	//service 객체를 주입 받습니다.
	@Autowired
	UserService userService;
	
	//브라우저로부터 데이터를 주소창을 통해 직접 받습니다.
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		
		//브라우저를 통해 주입 받은 아이디가 기존에 존재하는지 체크해줍니다.
		boolean check = userService.checkUserIdExist(user_id);
		
		return check + "";
		
	}
	
}
