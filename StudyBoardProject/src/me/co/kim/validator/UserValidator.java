package me.co.kim.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import me.co.kim.domain.User;

// Validator를 구현하는 객체입니다.
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		
		return User.class.isAssignableFrom(clazz);
	}

	//값으로 들어온 user_pw와 user_pw_chk가 일치하는 지 확인하는 메서드입니다.
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		
		// target을 User로 형변환해줍니다.
		User user = (User) target;
		
		
		//회원가입과 로그인에 사용된 user 객체를 각각 유효성 검사를 하기 위해 객체의 이름을 담는 변수를 선언합니다.
		String beanName =errors.getObjectName();
		
		// 객체의 이름이 joinUser 일 경우만 실행되는 로직입니다.
		if(beanName.equals("joinUser") || beanName.equals("modifyUser")) {
			
			if(user.getUser_pw().equals(user.getUser_pw_chk())==false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw_chk", "NotEquals");
			}
			
			if(beanName.equals("joinUser")) {
				
				if(user.isUserIdExist() == false) {
					errors.rejectValue("user_id", "DontCheckUserIdExist");
				}
			}

		}
	}

}
