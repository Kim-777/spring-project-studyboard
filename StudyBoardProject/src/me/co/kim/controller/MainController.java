package me.co.kim.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import me.co.kim.domain.Board;
import me.co.kim.domain.Content;
import me.co.kim.service.MainService;
import me.co.kim.service.TopMenuService;

@Controller
public class MainController {

	
	//MainService 객체를 주입 받습니다.
	@Autowired
	private MainService mainService;
	
	@Autowired
	private TopMenuService topMenuService;
	
	// HomeController가 redirect 한 index를 브라우저를 통해 요청 받습니다.
	// index.jsp를 반환합니다.
	@GetMapping("/index")
	public String index(Model model) {
		
		//Content를 담고 있는 list를 ArrayList에 담아줍니다.
		ArrayList<List<Content>> list = new ArrayList<List<Content>>();

		
		// 6번 동안 for문을 돌며 생성한 content가 담긴 list들을 arraylist에 담아주는 로직입니다.
		for(int i=1; i<= 6; i++) {
			List<Content> list1 = mainService.getMainList(i);
			list.add(list1);
		}
		
		// model에 list를 담아 jsp에서 쓸 수 있도록 해줍니다.
		model.addAttribute("list", list);
		
		// board의 list들을 가져옵니다.
		List<Board> board_list = topMenuService.getTopMenuList();
		model.addAttribute("board_list", board_list);
		
	
		
		return "index";
	}
}
