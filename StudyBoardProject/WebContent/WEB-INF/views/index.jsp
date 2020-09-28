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
    <link rel="stylesheet" href="css/common.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <title>메인</title>
</head>
<body>

	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<h1>hello spring mvc</h1>
	<img src="images/ryan.jpg"/>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성날짜</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>5</td>
				<td><a href="${root}board/read">제목입니다.</a></td>
				<td>2020-9-30</td>
			</tr>
		</tbody>
	</table>
	<a href="${root}board/main">더보기</a>
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
</body>
</html>