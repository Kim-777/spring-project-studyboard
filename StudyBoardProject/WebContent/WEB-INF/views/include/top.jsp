<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!-- 상단 부분을 정의하는 jsp입니다(start) -->
<header>
	<div id="headerWrap">
		<a href="${root}index">메인으로돌아가기</a>
		<ul>
			<li><a href="${root}board/main">게시판 바로가기</a></li>
		</ul>
		<h1>탑부분입니다</h1>
		<!-- 로그인, 회원가입, 정보수정, 로그아웃 회원 정보에 대한 링크를 가지고 있는 부분입니다(start) -->
		<div class="user_box">
			<ul>
				<li><a href="${root}user/login">로그인</a></li>
				<li><a href="${root}user/join">회원가입</a></li>
				<li><a href="${root}user/modify">정보수정</a></li>
				<li><a href="${root}user/logout">로그아웃</a></li>
			</ul>
		</div>
		<!-- 로그인, 회원가입, 정보수정, 로그아웃 회원 정보에 대한 링크를 가지고 있는 부분입니다(end) -->
	</div>
</header>
<!-- 상단 부분을 정의하는 jsp입니다(start) -->
