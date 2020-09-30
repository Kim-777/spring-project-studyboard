package me.co.kim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//board에 관련된 모든 요청을 받는 controller입니다.
@RequestMapping("/board")
public class BoardController {

	// board/main 요청을 받는 메서드입니다.
	// board/main.jsp를 리턴합니다.
	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx, Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		return "board/main";
	}
	
	// board/read 요청을 받는 메서드입니다.
	// board/read.jsp를 리턴합니다.
	@GetMapping("/read")
	public String read() {
		return "board/read";
	}
	
	// board/write 요청을 받는 메서드입니다.
	// board/write.jsp를 리턴합니다.
	@GetMapping("/write")
	public String write() {
		return "board/write";
	} 
	
	
	// board/modify 요청을 받는 메서드입니다.
	// board/modify.jsp를 리턴합니다.
	@GetMapping("modify")
	public String modify() {
		return "board/modify";
	}
	
	
	// board/delete 요청을 받는 메서드입니다.
	// board/delete.jsp를 리턴합니다.
	@GetMapping("delete")
	public String delete() {
		return "board/delete";
	}
	
}
