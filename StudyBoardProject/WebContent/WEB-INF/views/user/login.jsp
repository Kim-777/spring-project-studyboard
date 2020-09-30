<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="김예찬">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--  css를 사용하기 위한 링크입니다. -->
    <link rel="stylesheet" href="${root}css/common.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <title>로그인 페이지</title>
</head>
<body>

	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->
	
	<!-- 로그인 페이지 메인 부분입니다(start) -->
	<section>
		<div class="main_holder">
			<h1>로그인 페이지입니다.</h1>
			<div class="form_holder">
				<form:form action ="${root}user/login_pro" method="post" modelAttribute="tryLoginUser">
					<c:if test="${fail==true}">
					<div class="login_fail_box">
						<h3>로그인을 실패했습니다.</h3>
						<p>아이디와 비밀번호를 확인해 주세요.</p>
					</div>
					</c:if>
					<div>
						<form:label path="user_id">아이디</form:label>
						<form:input path="user_id"/>
						<form:errors path="user_id" style="color:red"/>
					</div>
					<div>
						<form:label path="user_pw">비밀번호</form:label>
						<form:password path="user_pw"/>
						<form:errors path="user_pw" style="color:red"/>
					</div>
					<form:button>로그인</form:button>
					<a href="${root}user/join">회원가입</a>
				</form:form>
			<img src="${root}images/ryan.jpg"/>					
			</div>
		</div>
	</section>
	<!-- 로그인 페이지 메인부분입니다(end) -->
	
	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>