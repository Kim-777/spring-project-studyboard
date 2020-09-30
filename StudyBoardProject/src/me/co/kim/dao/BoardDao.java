package me.co.kim.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.co.kim.domain.Content;

@Repository
public class BoardDao {

	//매퍼를 사용할수 있는 객체를 자동 주입 받습니다.
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// content_info 테이블에 접근해서 content 객체를 저장하는 메서드입니다.
	public void addContentInfo(Content writeContent) {
		sqlSessionTemplate.insert("board.addContentInfo", writeContent);
	}
}
