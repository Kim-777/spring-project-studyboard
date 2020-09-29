package me.co.kim.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.co.kim.domain.Board;

// Board 테이블에 접근하는 객체를 만들어 줍니다.
@Repository
public class TopMenuDao {

	// mybatis를 이용해 디비에 접근할 수 있게끔 해주는 SqlSessionTemplate객체를 자동 주입 받습니다.
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	//Board_info 테이블에 접근해서 board_info를 가져와 list에 담아주는 메서드입니다.
	public List<Board> getTopMenuList() {
		List<Board> topMenuList	= sqlSessionTemplate.selectList("topmenu.get_topmenu_list");
		
		return topMenuList;
	}
	
}
