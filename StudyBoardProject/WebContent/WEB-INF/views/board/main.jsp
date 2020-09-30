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
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <title>게시판 메인</title>
</head>
<body>
	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->

	
	<!-- 게시판 메인 페이지의 메인 부분입니다(start) -->
	<section>
		<div class="main_holder">
			<h1>게시판 메인 부분입니다.</h1>
			<div class="table_holder">
				<table>
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성날짜</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>10</td>
							<td><a href="${root}board/read">글제목</a></td>
							<td>홍길동</td>
							<td>2020-9-30</td>
						</tr>
					</tbody>
				</table>
			</div>
			<img src="${root}images/ryan.jpg"/>
			
			<div>
				<a href="${root}board/write?board_info_idx=${board_info_idx}">글쓰기</a>
			</div>		
		</div>
	</section>
	<!-- 게시판 메인 페이지의 메인 부분입니다(end) -->
	
	
	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>