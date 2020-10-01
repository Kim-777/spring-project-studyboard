package me.co.kim.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.co.kim.domain.Content;
import me.co.kim.service.BoardService;

@Controller
//board에 관련된 모든 요청을 받는 controller입니다.
@RequestMapping("/board")
public class BoardController {

	
	@Autowired
	private BoardService boardService;
	
	// board/main 요청을 받는 메서드입니다.
	// board/main.jsp를 리턴합니다.
	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx, Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		// board_info 데이터베이스에서 파라미터로 받은 board_info_idx와 idx의 값이 일치하는 name 값을 변수에 담습니다
		// 변수 boardInfoName을 model의 속성 값으로 넘겨줘서 jsp에서 사용할 수 있게 해줍니다.
		String boardInfoName = boardService.getBoardInfoName(board_info_idx);	
		model.addAttribute("boardInfoName", boardInfoName);
		
		
		// service 객체를 통해 가져온 content의 리스트를 변수에 담아줍니다.
		List<Content> contentList = boardService.getContentList(board_info_idx);
		model.addAttribute("contentList", contentList);
		return "board/main";
	}
	
	// board/read 요청을 받는 메서드입니다.
	// board/read.jsp를 리턴합니다.
	@GetMapping("/read")
	public String read(@RequestParam("board_info_idx") int board_info_idx,
					   @RequestParam("content_idx") int content_idx, Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		// 리퀘스트파람 content_idx와 일치하는 content의 정보를 읽어와 변수 readContent에 담습니다.
		Content readContent = boardService.getContentInfo(content_idx);
		model.addAttribute("readContent", readContent);
		
		return "board/read";
	}
	
	// board/write 요청을 받는 메서드입니다.
	// board/write.jsp를 리턴합니다.
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContent") Content writeContent,
						@RequestParam("board_info_idx") int board_info_idx) {
		
		writeContent.setContent_board_idx(board_info_idx);
		
		return "board/write";
	} 
	
	// board/write_pro 요청을 받는 메서드입니다.
	// 유효성 검사를 하는 파라미터가 통과하면 board/write_pro.jsp 를 , 통과 하지 못하면 board/write.jsp를 리턴합니다.
	@PostMapping("/write_pro")
	public String write_pro(@Valid @ModelAttribute("writeContent") Content writeContent, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/write";
		}
		
		boardService.addContentInfo(writeContent);
		
		return "board/write_success";
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
