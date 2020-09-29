package me.co.kim.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import me.co.kim.domain.Board;
import me.co.kim.service.TopMenuService;

// 모든 페이지에 적용되는 탑 메뉴를 구성하기 위해 인터샙터 객체를 정의합니다.
public class TopMenuInterceptor implements HandlerInterceptor {

	
	// service 객체를 자동 주입 받습니다.
	@Autowired
	private TopMenuService topMenuService;
	
	
	// preHandle 메서드를 오버라이딩합니다. 호출 된 메서드가 실행하기전 먼저 선행으로 실행되는 메서드입니다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		List<Board> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		
		return true;
	}
}
