package me.co.kim.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import me.co.kim.dao.UserDao;
import me.co.kim.domain.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Resource(name="loginUser")
	@Lazy
	private User loginUser;
	
	// 유저 아이디가 존재하는지 확인하는 메서드입니다.
	// 파라미터로 user_id를 받고 그 값으로 디비에 결과값을 가져온다면 false, 기존에 값이 없다면 true를 반환해줍니다.
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addUserInfo(User joinUser) {
		userDao.addUserinfo(joinUser);
	}
	
	//로그인을 시도하는 입력 값과 알맞는 user 객체가 있는지 확인하는 메서드입니다.
	public void getLoginUserInfo(User tryLoginUser) {
		
		// dao를 통해 값을 받아오면, user의 정보를 담는 변수입니다.
		User tryLoginUser2 =userDao.getLoginUserInfo(tryLoginUser);
		
		// 만약에 dao를 통해 주입 받는 값이 null이 아니라면 session 영역에 있는 loginUser의 값을 받아온 user 객체의 값으로 새팅해주는 if문 입니다.
		if(tryLoginUser2 != null) {
			loginUser.setUser_idx(tryLoginUser2.getUser_idx());
			loginUser.setUser_name(tryLoginUser2.getUser_name());
			loginUser.setUserLogin(true);
//			loginUser.setUser_id(tryLoginUser2.getUser_id());
			
		}
	}
	
	// 수정하고자 하는 유저의 정보를 가져오는 메서드입니다.
	public void getModifyUserInfo(User modifyUser) {
		
		// 현재 로그인 되어 있는 객체의 정보를 임시 변수 tempModifyUser에 담아 둡니다.
		User tempModifyUser = userDao.getModifyUserInfo(loginUser.getUser_idx());
		
		modifyUser.setUser_id(tempModifyUser.getUser_id());
		modifyUser.setUser_name(tempModifyUser.getUser_name());
		modifyUser.setUser_idx(loginUser.getUser_idx());
	}
	
	
	// 현재 접속되어 있는 로그인 객체의 정보를 수정하기 위해 dao에 접근하는 메서드입니다.
	public void modifyUserInfo(User modifyUser) {
		
		modifyUser.setUser_idx(loginUser.getUser_idx());	
		userDao.modifyUserInfo(modifyUser);
	}
	
	
	
}
