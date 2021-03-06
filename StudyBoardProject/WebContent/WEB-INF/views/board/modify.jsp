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
    <link rel="Stylesheet" href="${root}css/board/modify.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Place your kit's code here -->
    <script src="https://kit.fontawesome.com/5c7b32b093.js" crossorigin="anonymous"></script>
    <!-- 글자체를 임포트합니다. -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">	
    <title>게시판 수정페이지</title>
</head>
<body>
	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->
	
	<!-- 게시판 수정하기 메인 부분입니다(start) -->
	<section>
		<div id="mainHolder">
			<h1>게시판 수정하기 부분입니다.</h1>		
			<div class="form_holder">
				<form:form id="modifyForm" action="${root}board/modify_pro" method="post" modelAttribute="modifyContent" enctype="multipart/form-data">
					<form:hidden path="content_idx"/>
					<form:hidden path="content_board_idx"/>
					<input type="hidden" name="page" value="${page}">
					<div class="modify_writer">
						<form:label id="labelWriter" path="content_writer_name">작성자</form:label>
						<form:input id="inputWriter" path="content_writer_name" readonly="true"/>
					</div>
					<div class="clear_box"></div>
					<div class="modify_date">
						<form:label id="labelDate" path="content_date">작성날짜</form:label>
						<form:input id="inputDate" path="content_date" readonly="true"/>
					</div>
					<div class="clear_box"></div>					
					<div class="modify_subject">
						<form:label id="labelSubject" path="content_subject">제목</form:label>
						<form:input id="inputSubject" path="content_subject"/>
						<form:errors id="errorSubject" path="content_subject" style="color:red"/>
					</div>
					<div class="clear_box"></div>
					<div class="modify_content">
						<form:label id="labelContent" path="content_text">내용</form:label>
						<form:textarea id="inputContent" path="content_text" rows="10" style="resize:none"/>
						<form:errors id="errorContent" path="content_text" style="color:red"/>
					</div>
					<div class="clear_box"></div>
					<div class="modify_img">
						<form:label id="labelImage" path="upload_file">첨부 이미지</form:label>
						<c:if test="${modifyContent.content_file !=null}">
							<div id="imgHolder">
								<img id="originImg" src="${root}/upload/${modifyContent.content_file}" width="30%">
							</div>
							<form:hidden path="content_file"/>
						</c:if>
						<form:input id="newFile" path="upload_file" type="file" accept="image/*"/>
					</div>
					<div class="clear_box"></div>
					<div class="button_box">
						<form:button id="modifyButton">수정 완료</form:button>
						<a id="cancelButton" href="${root}board/read?board_info_idx=${board_info_idx}&content_idx=${content_idx}&page=${page}">취소</a>
					</div>
				</form:form>			
			</div>	
		</div>
	</section>
	<!-- 게시판 수정하기 메인 부분입니다(end) -->

	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>