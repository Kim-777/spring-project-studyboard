<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/><!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="김예찬">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--  css를 사용하기 위한 링크입니다. -->
    <link rel="stylesheet" href="${root}css/common.css">
    <link rel="stylesheet" href="${root}css/user/modify.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Place your kit's code here -->
    <script src="https://kit.fontawesome.com/5c7b32b093.js" crossorigin="anonymous"></script>
    <!-- 글자체를 임포트합니다. -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">	
    <title>수정 페이지</title>
</head>
<body>

	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->

	<!-- 회원정보 수정 페이지 메인부분입니다(start) -->
	<section>
		<div id="mainHolder">
			<div class="form_holder">
				<h1>회원정보 수정 페이지입니다.</h1>
				<form:form class="user_modify_form" action="${root}user/modify_pro" method="post" modelAttribute="modifyUser">
					<div class="form_group">
						<div class="label_box">
							<form:label id="labelUserName" path="user_name">이  름 :</form:label>							
						</div>
						<div class="input_box">
							<form:input id="inputUserName" path="user_name" readonly="true"/>						
						</div>
						<div class="clear_box"></div>
					</div>
					<div class="form_group">
						<div class="label_box">
							<form:label id="labelUserId" path="user_id">아 이 디 :</form:label>						
						</div>	
						<div class="input_box">
							<form:input id="inputUserId" path="user_id" readonly="true"/>						
						</div>
						<div class="clear_box"></div>
					</div>
					<div class="form_group">
						<div class="label_box">
							<form:label id="labelUserPW" path="user_pw">비 밀 번 호 :</form:label>						
						</div>	
						<div class="input_box">			
							<form:password id="passwordUserPw" path="user_pw"/>
						</div>					
						<div class="error_box">
							<form:errors id="errorsUserPw" path="user_pw" style="color:red"/>
						</div>
						<div class="clear_box"></div>					
					</div>
					<div class="form_group">
						<div class="label_box">
							<form:label id="labelUserPwChk" path="user_pw_chk">비밀번호 확인 :</form:label>						
						</div>	
						<div class="input_box">
							<form:password id="passwordUserPwChk" path="user_pw_chk"/>						
						</div>
						<div class="error_box">
							<form:errors id="errorsUserPwChk" path="user_pw_chk" style="color:red"/>						
						</div>
						<div class="clear_box"></div>
					</div>
					<div class ="form_group">
						<div class="button_box">
							<form:button>정보수정</form:button>
						</div>
					</div>		
				</form:form>					
			</div>
		</div>
	</section>
	<!-- 회원정보 수정 페이지 메인부분입니다(end) -->
	
	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>