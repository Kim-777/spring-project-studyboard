package me.co.kim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.co.kim.dao.TopMenuDao;
import me.co.kim.domain.Board;

@Service
public class TopMenuService {

	
	//Board 테이블에 접근하는를 dao 자동 주입 받습니다.
	@Autowired
	private TopMenuDao topMenuDao;
	
	// dao 객체를 이용해서 board객체를 리스트에 담는 메서드입니다.
	public List<Board> getTopMenuList() {
		List<Board> topMenuList = topMenuDao.getTopMenuList();
		
		return topMenuList;
	}
	
}
