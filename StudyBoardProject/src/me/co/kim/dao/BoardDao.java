package me.co.kim.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	
	public String getBoardInfoName(int board_info_idx) {
		return sqlSessionTemplate.selectOne("board.getBoardInfoName", board_info_idx);
	}
	
	//파라미터 board_info_idx의 값에 일치하는 content를 list에 담아 리턴하는 메서드입니다.
	public List<Content> getContentList(int board_info_idx, RowBounds rowBounds) {
		return sqlSessionTemplate.selectList("board.getContentList", board_info_idx, rowBounds);
	}
	
	//파라미터로 받은 content_idx와 일치하는 content 객체를 반환하는 메서드입니다.
	public Content getContentInfo(int content_idx) {
		return sqlSessionTemplate.selectOne("board.getContentInfo", content_idx);
	}
	
	// modifyContent 파라미터의 내용으로 해당 content의 게시글을 수정하는 메서드입니다. 
	public void modifyContentInfo(Content modifyContent) {
		sqlSessionTemplate.update("board.modifyContentInfo", modifyContent);
	}
	
	public void deleteContentInfo(int content_idx) {
		
		sqlSessionTemplate.delete("board.deleteContentInfo", content_idx);
		
	}
	
	// 파라미터로 받은 baord_idx의 content 개수를 반환하는 메서드입니다.
	public int getContentCnt(int content_board_idx) {
		return sqlSessionTemplate.selectOne("board.getContentCnt", content_board_idx);
	}
}
