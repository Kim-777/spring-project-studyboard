package me.co.kim.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.co.kim.domain.Content;
import me.co.kim.domain.Page;
import me.co.kim.domain.User;
import me.co.kim.service.BoardService;

@Controller
//board에 관련된 모든 요청을 받는 controller입니다.
@RequestMapping("/board")
public class BoardController {

	// service 객체를 자동 주입 받습니다.
	@Autowired
	private BoardService boardService;
	
	// session에 있는 loginUse라는 이름을 가지고 있는 User 객체를 주입 받습니다.
	@Resource(name="loginUser")
	@Lazy
	private User loginUser;
	
	// board/main 요청을 받는 메서드입니다.
	// board/main.jsp를 리턴합니다.
	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
					   @RequestParam(value="page", defaultValue = "1") int page, 
					   Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		// board_info 데이터베이스에서 파라미터로 받은 board_info_idx와 idx의 값이 일치하는 name 값을 변수에 담습니다
		// 변수 boardInfoName을 model의 속성 값으로 넘겨줘서 jsp에서 사용할 수 있게 해줍니다.
		String boardInfoName = boardService.getBoardInfoName(board_info_idx);	
		model.addAttribute("boardInfoName", boardInfoName);
		
		
		// service 객체를 통해 가져온 content의 리스트를 변수에 담아줍니다.
		List<Content> contentList = boardService.getContentList(board_info_idx, page);
		model.addAttribute("contentList", contentList);
		
		Page currentpage = boardService.getContentCnt(board_info_idx, page);
		model.addAttribute("currentpage", currentpage);
		
		model.addAttribute("page", page);
		
		return "board/main";
	}
	
	// board/read 요청을 받는 메서드입니다.
	// board/read.jsp를 리턴합니다.
	@GetMapping("/read")
	public String read(@RequestParam("board_info_idx") int board_info_idx,
					   @RequestParam("content_idx") int content_idx, 
					   @RequestParam("page") int page, 
					   Model model) {
		
		//model에 board_info_idx와 content_idx를 담습니다.
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
		// 리퀘스트파람 content_idx와 일치하는 content의 정보를 읽어와 변수 readContent에 담습니다.
		Content readContent = boardService.getContentInfo(content_idx);
		model.addAttribute("readContent", readContent);
		
		// 로그인된 객체를 model에 담아 줍니다.
		model.addAttribute("loginUser", loginUser);
		
		// page를 model에 담습니다.
		model.addAttribute("page", page);
		
		return "board/read";
	}
	
	// board/write 요청을 받는 메서드입니다.
	// board/write.jsp를 리턴합니다.
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContent") Content writeContent,
						@RequestParam("board_info_idx") int board_info_idx,
						@RequestParam("page") int page,
						Model model) {
		
		//content에 현제 board_idx 번호를 새팅하비다.
		writeContent.setContent_board_idx(board_info_idx);
		
		// 현제 페이지 번호를 model에 담습니다.
		model.addAttribute("page", page);
		
		return "board/write";
	} 
	
	// board/write_pro 요청을 받는 메서드입니다.
	// 유효성 검사를 하는 파라미터가 통과하면 board/write_pro.jsp 를 , 통과 하지 못하면 board/write.jsp를 리턴합니다.
	@PostMapping("/write_pro")
	public String write_pro(@Valid @ModelAttribute("writeContent") Content writeContent, BindingResult result,
							@RequestParam("page") int page, Model model) {
		
		//page를 모델에 담습니다.
		model.addAttribute("page", page);
		
		// 만약 유효성 검사에 통과되지 못하는 경우가 있다면 board/write를 리턴합니다.
		if(result.hasErrors()) {
			return "board/write";
		}
		
		//service 객체를 이용해서 새로운 content를 데이터베이스에 담습니다.
		boardService.addContentInfo(writeContent);
		
		return "board/write_success";
	}
	
	
	// board/modify 요청을 받는 메서드입니다.
	// board/modify.jsp를 리턴합니다.
	@GetMapping("/modify")
	public String modify(@RequestParam("board_info_idx") int board_info_idx,
						 @RequestParam("content_idx") int content_idx,
						 @ModelAttribute("modifyContent") Content modifyContent, 
						 @RequestParam("page") int page, 
						 Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
		//service 객체를 통해 현재 페이지의 content의 정보를 변수에 담습니다.
		Content tempContent = boardService.getContentInfo(content_idx);
		
		//수정할 content의 기본 정보를 담습니다.
		modifyContent.setContent_writer_name(tempContent.getContent_writer_name());
		modifyContent.setContent_date(tempContent.getContent_date());
		modifyContent.setContent_subject(tempContent.getContent_subject());
		modifyContent.setContent_text(tempContent.getContent_text());
		modifyContent.setContent_file(tempContent.getContent_file());
		modifyContent.setContent_writer_idx(tempContent.getContent_writer_idx());
		modifyContent.setContent_board_idx(board_info_idx);
		modifyContent.setContent_idx(content_idx);
		
		//페이지를 모델에 담습니다.
		model.addAttribute("page", page);
		
		return "board/modify";
	}
	
	//게시글 수정 요청을 받는 메서드입니다.
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyContent") Content modifyContent, BindingResult result,
							 @RequestParam("page") int page,
							 Model model) {
		
		//페이지를 모델에 담습니다.
		model.addAttribute("page", page);
		
		// 유효성 검사에 통과하지 못하면 board/modify를 리턴합니다.
		if(result.hasErrors()) {
			return "board/modify";
		}
		
		// service 객체를 이용해서 데이터베이스에 접근해 수정된 content를 업데이트 합니다.
		boardService.modifyContentInfo(modifyContent);
		
		
		return "board/modify_success";
	}
	
	
	// board/delete 요청을 받는 메서드입니다.
	// board/delete.jsp를 리턴합니다.
	@GetMapping("/delete")
	public String delete(@RequestParam("board_info_idx") int board_info_idx,
						 @RequestParam("content_idx") int content_idx, Model model) {
		
		boardService.deleteContentInfo(content_idx);
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		return "board/delete";
	}
	
	// 작성자가 아니지만, 직접 검색창에 치고 들어온 유저에게 not_writer 페이지를 리턴하는 메서드입니다.
	@GetMapping("/not_writer")
	public String not_writer() {
		return "board/not_writer";
	}
	
	
}
