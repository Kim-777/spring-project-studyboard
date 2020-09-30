package me.co.kim.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.co.kim.domain.User;
import me.co.kim.service.UserService;
import me.co.kim.validator.UserValidator;


// 유저에 관련된 모든 요청을 받는 컨트롤러 입니다.
@Controller
@RequestMapping("/user")
public class UserController {
	
	
	// service 객체를 자동 주입 받습니다.
	@Autowired
	private UserService userService;
	
	//session 영역에 있는 객체를 자동 주입 받습니다.
	@Resource(name ="loginUser")
	@Lazy
	private User loginUser;
	
	// user/login 요청을 받아드리는 메서드입니다.
	// user 폴더에 있는 login 페이지를 반환해줍니다.
	@GetMapping("/login")
	public String login(@ModelAttribute("tryLoginUser") User tryLoginUser,
						@RequestParam(value="fail", defaultValue = "false") boolean fail,
						Model model) {
		
		model.addAttribute("fail", fail);
		
		return "user/login";
	}
	
	
	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("tryLoginUser") User tryLoginUser, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.getLoginUserInfo(tryLoginUser);
		
		if(loginUser.isUserLogin() == true) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}
		
	}
	
	//user/join 요청을 받아드리는 메서드입니다.
	// user/join 페이지를 반환해줍니다.
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUser") User joinUser) {
		return "user/join";
	}
	
	
	// user/join_pro 요청을 받는 메서드입니다.
	// 유효성 검사를 하기 위해 command 객체와 BindingResult 객체를 파라미터로 주입 받습니다.
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUser") User joinUser, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/join";
		}
		
		userService.addUserInfo(joinUser);
		
		return "user/join_success";
		
	}
	
	
	// user/modify 요청을 받아드리는 메서드입니다.
	// user/modify 페이지를 반환해줍니다.
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUser") User modifyUser) {
		
		userService.getModifyUserInfo(modifyUser);
		
		return "user/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyUser") User modifyUser, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/modify";
		}
		
		userService.modifyUserInfo(modifyUser);
		
		return "user/modify_sucess";
	}
	
	// user/logout 요청을 받아드리는 메서드입니다.
	// user/logout을 반환해줍니다.
	@GetMapping("/logout")
	public String logout() {
		
		loginUser.setUserLogin(false);
		
		return "user/logout";
	}
	
	@GetMapping("/not_login")
	public String not_login() {
		return "user/not_login";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//유저발리데이터를 추가해줍니다.
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}
}
