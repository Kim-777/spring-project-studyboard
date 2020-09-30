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
    <title>게시판 글쓰기</title>
</head>
<body>
	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->


	<!-- 게시판 글쓰기 페이지 메인부분입니다(start) -->
	<section>
		<div class="main_holder">
			<div class="form_holder">
				<form:form action="${root}board/write_pro" method="post" modelAttribute="writeContent">
					<form:label path="content_subject">제목</form:label>
					<form:input path="content_subject"/>
					<form:errors path= "content_subject" style="color:red"/>
					<img src="${root}images/ryan.jpg"/>	
				</form:form>		
			</div>
			<h1>게시판 글쓰기 부분입니다.</h1>
		</div>
	</section>
	<!-- 게시판 글쓰기 페이지 메인부분입니다(end) -->


	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>