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
    <link rel="stylesheet" href="${root}css/board/not_writer.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Place your kit's code here -->
    <script src="https://kit.fontawesome.com/5c7b32b093.js" crossorigin="anonymous"></script>
    <!-- 글자체를 임포트합니다. -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">	
    <title>잘못된 접근입니다.</title>
</head>
<body>
	<!-- 잘못된 접근 색션입니다(start) -->
    <section id="wrongApproach">
        <div id="wrongBox">
            <i class="fas fa-shoe-prints"></i>
            <i class="fas fa-hand-paper"></i>
            <p>권한이 없는 잘못된 접근입니다.</p>
            <a id="goMainButton" href="${root}index">여기를 클릭 하시면 홈페이지로 돌아갑니다.</a>
        </div>
    </section>
	<!-- 잘못된 접근 색션입니다(end) -->
</body>
</html>