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
    <link rel="stylesheet" href="${root}css/user/join.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Place your kit's code here -->
    <script src="https://kit.fontawesome.com/5c7b32b093.js" crossorigin="anonymous"></script>
    <!-- 글자체를 임포트합니다. -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">	
    <title>회원가입 페이지</title>
    <!-- 아이디를 중복 확인하는 코드입니다. ajax를 이용해 비동기를 이용합니다. -->
    <script>
    	function checkUserIdExist() {
    		
    		// 유저의 아이디 값의 담긴 값을 변수 user_id에 담습니다.
    		var user_id = $("#user_id").val()
    		
    		//길이가 0이라면 입력된 값이 없다는 소리임으로 아이디를 입력해달라는 alert을 띄웁니다.
    		if(user_id.length == 0) {
    			alert('아이디를 입력해주세요')
    			return
    		}
	
    		$.ajax({
    			url : '${root}user/checkUserIdExist/' + user_id,
    			type : 'get',
    			dataType : 'text',
    			success : function(result) {
    				if(result.trim() == 'true') {
    					alert('사용할 수 있는 아이디입니다.')
    					$('#userIdExist').val('true')
    				} else {
    					alert('사용할 수 없는 아이디입니다.')
    					$('#userIdExist').val('false')
    				}	
    			}
    		})	
    	}
    	
    	// 중복확인 이후에, 다른 아이디를 입력했을 때 다시 중복확인을 요청하게 하는 메서드입니다.
    	function resetUserIdExist() {
    		$('#userIdExist').val('false')
    	}
    </script>
</head>
<body>
	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->
	
	<!-- 회원가입 페이지 메인 부분입니다(start) -->
	<section>
		<div id="mainHolder">
			<h1>회원가입 페이지입니다.</h1>
			<div id="formHolder">
				<form:form id="joinForm" action="${root}user/join_pro" method="post" modelAttribute="joinUser">
				<form:hidden path="userIdExist"/>
					<div class="form_group">
						<form:label id="labelUserName" path="user_name">이름</form:label>
						<form:input id="inputUserName" path="user_name"/><br/>
						<form:errors class="error_box" path="user_name"/>
					</div>
					<div class="form_group">
						<form:label id="labelUserId" path="user_id">아이디</form:label>
						<form:input id="inputUserId" path="user_id" onkeypress="resetUserIdExist()"/><br/>
						<form:errors class="error_box" path="user_id"/>
						<button id="checkIdButton" type="button" onclick="checkUserIdExist()">중복확인</button>
					</div>
					<div class="form_group">
						<form:label id="labelUserPw" path="user_pw">비밀번호</form:label>
						<form:password id="userPw" path="user_pw"/><br/>
						<form:errors class="error_box" path="user_pw"/>
					</div>
					<div class="form_group">
						<form:label id="labelUserPwChk" path="user_pw_chk">비밀번호 확인</form:label>
						<form:password id="UserPwChk" path="user_pw_chk"/><br/>
						<form:errors class="error_box" path="user_pw_chk"/>
					</div>
					<div class ="form_group">
						<div class="button_box">
							<form:button class="join_button">회원가입</form:button>
						</div>
					</div>		
				</form:form>				
			</div>
		</div>
	</section>
	<!-- 회원가입 페이지 메인 부분입니다(end) -->
	
	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>