package me.co.kim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.co.kim.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
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
	
}
