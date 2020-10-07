package me.co.kim.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import me.co.kim.domain.Content;
import me.co.kim.domain.User;
import me.co.kim.service.BoardService;

// 게시글을 쓰지 않은 유저가 인위적으로 접근할 떄, not_writer 페이지를 보여주는 Interceptor입니다.
public class CheckWriterInterceptor implements HandlerInterceptor{
	
	
	// loginUser를 자동 주입 받습니다.
	@Resource(name = "loginUser")
	@Lazy
	private User loginUser;
	
	@Autowired
	private BoardService boardService;

	//prehandle을 오버라이딩 합니다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		// request의 파라미터를 Integer parseInt로 변환하기 전에 temp라는 변수에 먼저 담아둔 후, int로 타입을 변경 시킵니다.
		String temp = request.getParameter("content_idx");
		int content_idx = Integer.parseInt(temp);
		
		// 들어가려고 하는 게시글의 정보를 변수에 담습니다.
		Content current_content = boardService.getContentInfo(content_idx);
		
		//만약에 게시글을 올린 작성자와 로그인 한유저의 idx의 값이 같지 않다면 not_writer를 브라우저에게 요청하게끔 redirect하는 로직입니다.
		if(current_content.getContent_writer_idx() != loginUser.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/board/not_writer");
			
			// 계속 진행하지 않도록 false를 리턴해줍니다.
			return false;
		}
		
		return true;
	}
	
}
	

