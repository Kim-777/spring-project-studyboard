<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!-- 상단 부분을 정의하는 jsp입니다(start) -->
   <header>
       <div id="headerWrap">
           <div class="top_left_box">
               <a class="go_main" href="${root}index">메인으로돌아가기</a>
               <div class="top_menu_box">
                   <ul>
                   	<c:forEach var="obj" items="${topMenuList}">
                    	<li class="menu_list">
                            <a href="${root}board/main?board_info_idx=${obj.board_info_idx}">${obj.board_info_name}</a>
                        </li>
                   	</c:forEach>
                   </ul>
               </div>
           </div>
           <!-- 로그인, 회원가입, 정보수정, 로그아웃 회원 정보에 대한 링크를 가지고 있는 부분입니다(start) -->
           <div class="user_box">
               <ul>
				   <c:choose>
				     <c:when test="${loginUser.userLogin ==true}">
                  		<li class="user_list"><a href="${root}user/modify">정보수정</a></li>
                   		<li class="user_list"><a href="${root}user/logout">로그아웃</a></li>
				    </c:when>
				   	<c:otherwise>
               		    <li class="user_list"><a href="${root}user/login">로그인</a></li>
                        <li class="user_list"><a href="${root}user/join">회원가입</a></li>				   	
				   	</c:otherwise>
				   </c:choose>


               </ul>
           </div>
           <div class="clear_box"></div>
           <!-- 로그인, 회원가입, 정보수정, 로그아웃 회원 정보에 대한 링크를 가지고 있는 부분입니다(end) -->
       </div>
   </header>
<!-- 상단 부분을 정의하는 jsp입니다(start) -->
