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
    <link rel="stylesheet" href="${root}css/board/write.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Place your kit's code here -->
    <script src="https://kit.fontawesome.com/5c7b32b093.js" crossorigin="anonymous"></script>
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
				<h1>게시판 글쓰기 부분입니다.</h1>
				<form:form action="${root}board/write_pro" method="post" modelAttribute="writeContent" enctype="multipart/form-data">
					<form:hidden path="content_board_idx"/>
					<input type="hidden" name="page" value="${page}"/>
					<div class="form_group">
						<form:label path="content_subject">제목</form:label>
						<form:input path="content_subject"/>
						<form:errors path= "content_subject" style="color:red"/>				
					</div>
					<div class="form_group">
						<form:label path="content_text">내용</form:label>
						<form:textarea path="content_text"/>
						<form:errors path="content_text" style="color:red"/>
					</div>
					<div class="form_group">
						<form:label path="upload_file">첨부 이미지</form:label>
						<form:input path="upload_file" accept="image/*" type='file'/>
					</div>
					<div class="form_group">
						<form:button>작성하기</form:button>
					</div>
				</form:form>		
			</div>
		</div>
	</section>
	<!-- 게시판 글쓰기 페이지 메인부분입니다(end) -->


	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>