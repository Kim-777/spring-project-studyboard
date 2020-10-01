package me.co.kim.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import me.co.kim.domain.User;

public class CheckLoginInterceptor implements HandlerInterceptor {

	// loginUser를 자동 주입 받습니다.
	@Resource(name = "loginUser")
	@Lazy
	private User loginUser;
	

	
	//요청된 메서드를 실행 전에 로그인이 되어 있는지 확인하기 위해 먼저 실행되는 interceptor의 prehandle 메서드입니다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		// 만약 로그인이 되어 있지 않은 상태라면
		if(loginUser.isUserLogin() == false) {
			
			//request 객체로 부터 contextpath의 값을 얻은 후
			String contextPath = request.getContextPath();
			
			//브라우저에게 response의 sendRedirect를 통해 contextPath에 user/not_login을 재요청하게 합니다.
			response.sendRedirect(contextPath + "/user/not_login");
			
			// 그리고 요청된 메서드를 실행시키지 않기 위해서 false를 리턴해줍니다.
			return false;
		}
		
		return true;
	}
}
