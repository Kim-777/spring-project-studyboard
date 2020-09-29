package me.co.kim.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//디비의  User_info에 접근하는 객체입니다. 
@Repository
public class UserDao {

	//매퍼를 사용할수 있는 객체를 자동 주입 받습니다.
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	//디비에 파라미터로 들어온 값의 아이디를 가지고 있는 회원의 이름이 있는 확인하는 메서드 입니다.
	public String checkUserIdExist(String user_id) {
		return sqlSessionTemplate.selectOne("user.checkUserIdExist", user_id);
	}
	
	
}
