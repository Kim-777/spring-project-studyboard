package me.co.kim.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.co.kim.domain.User;

//디비의  User_info에 접근하는 객체입니다. 
// user 객체에 관련되어 데이터베이스에 접속하려고 할때 사용될 dao를 정의합니다.
@Repository
public class UserDao {

	//매퍼를 사용할수 있는 객체를 자동 주입 받습니다.
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	//디비에 파라미터로 들어온 값의 아이디를 가지고 있는 회원의 이름이 있는 확인하는 메서드 입니다.
	public String checkUserIdExist(String user_id) {
		return sqlSessionTemplate.selectOne("user.checkUserIdExist", user_id);
	}
	
	//user를 데이터베이스에 저장하는 메서드입니다.
	public void addUserinfo(User joinUser) {
		sqlSessionTemplate.insert("user.addUserinfo", joinUser);
	}
	
	//로그인 시도 시, 값으로 받은 파라미터 값과 일치하는 디비의 정보가 있는지 확인하고 일치하는 객체가 있다면 반환하는  메서드입니다.
	public User getLoginUserInfo(User tryLoginUser) {
		
		return sqlSessionTemplate.selectOne("user.getLoginUserInfo", tryLoginUser);
	}
	
	
	// 수정하려고 하는 유저의 정보를 반환하는 메서드입니다. user_idx의 값과 일치하는 유저의 객체를 반환합니다.
	public User getModifyUserInfo(int user_idx) {
		return sqlSessionTemplate.selectOne("user.getModifyUserInfo", user_idx);
	}
	
	// 유저 정보를 수정하는 메서드입니다. 파라미터 값을 mapper에 전달 해줍니다.
	public void modifyUserInfo(User modifyUser) {
		sqlSessionTemplate.update("user.modifyUserInfo", modifyUser);
	}
}
