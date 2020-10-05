<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="김예찬">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--  css를 사용하기 위한 링크입니다. -->
    <link rel="stylesheet" href="${root}css/common.css">
    <link rel="stylesheet" href="${root}css/board/read.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Place your kit's code here -->
    <script src="https://kit.fontawesome.com/5c7b32b093.js" crossorigin="anonymous"></script>
    <!-- 글자체를 임포트합니다. -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">	
    <title>게시판 글보기</title>
</head>
<body>
	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->


	<!-- 게시판 글읽기 메인 부분입니다(start) -->
	<section>
		<div id="mainHolder">
			<h1>게시판 글읽기 부분입니다.</h1>
			<div class="read_box">
				<label for="board_writer_name">작성자</label>
				<input type="text" id="board_writer_name" name="board_writer_name" value="${readContent.content_writer_name}" disabled="disabled"/>
			</div>
			<div class="read_box">
				<label for="board_date">작성 날짜</label>
				<input type="text" id="board_date" name="board_writer_name" value="${readContent.content_date}" disabled="disabled"/>
			</div>
			<div class="read_box">
				<label for="board_subject">제목</label>
				<input type="text" id="board_subject" name="board_subject" value="${readContent.content_subject}" disabled="disabled"/>
			</div>
			<div class="read_box">
				<label for="board_content">내용</label>
				<textarea id="board_content" name="board_content" rows="10" style="resize:none" disabled="disabled">${readContent.content_text}</textarea>
			</div>
			<c:if test="${readContent.content_file != null }">
				<div class="read_box">
					<label for="board_file">첨부이미지</label>
					<img src="${root}upload/${readContent.content_file}" width="10%"/>
				</div>			
			</c:if>
			<div class="button_boxs_holder">
				<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${page}">목록보기</a>
				<c:if test="${loginUser.user_idx == readContent.content_writer_idx}">
					<a href="${root}board/modify?board_info_idx=${board_info_idx}&content_idx=${content_idx}&page=${page}">수정하기</a>
					<a href="${root}board/delete?board_info_idx=${board_info_idx}&content_idx=${content_idx}">삭제하기</a>				
				</c:if>
			</div>
		</div>
	</section>	
	<!-- 게시판 글읽기 메인 부분입니다(end) -->


	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>