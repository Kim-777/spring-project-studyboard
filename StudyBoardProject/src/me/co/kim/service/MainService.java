package me.co.kim.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.co.kim.dao.BoardDao;
import me.co.kim.domain.Content;


// index 화면을 구성하는데 필요한 service 객체입니다.
@Service
public class MainService {

	
	// BoardDao를 주입 받습니다.
	@Autowired
	private BoardDao boardDao;
	
	
	// 컨텐츠의 리스트를 반환하는 메서드입니다.
	public List<Content> getMainList(int board_info_idx) {
		
		//0~5개의 로우를 선택하는 객체를 생성합니다.
		RowBounds rowBounds = new RowBounds(0, 5);
		
		return boardDao.getContentList(board_info_idx, rowBounds);
	}
	
}
