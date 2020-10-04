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
    <link rel="stylesheet" href="${root}css/board/main.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Place your kit's code here -->
    <script src="https://kit.fontawesome.com/5c7b32b093.js" crossorigin="anonymous"></script>
    <title>게시판 메인</title>
</head>
<body>
	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->

	<div class="check">check</div>
	<!-- 게시판 메인 페이지의 메인 부분입니다(start) -->
	<section>
		<div class="main_holder">
			<h1>${boardInfoName}</h1>
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
						<c:forEach var="obj" items="${contentList}">
							<tr>
								<td>${obj.content_idx}</td>
								<td><a href="${root}board/read?board_info_idx=${board_info_idx}&content_idx=${obj.content_idx}&page=${page}">${obj.content_subject}</a></td>
								<td>${obj.content_writer_name}</td>
								<td>${obj.content_date}</td>
							</tr>						
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="page_bottom_box">
				<ul class="page_button_list">
					<c:choose>
						<c:when test="${currentpage.prevPage <= 0}">
							<li class="page_item disable_check">
								<a href="#">이전</a>
							</li>							
						</c:when>
						<c:otherwise>
							<li class="page_item">
								<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${currentpage.prevPage}">이전</a>
							</li>						
						</c:otherwise>
					</c:choose>
					
					
					<c:forEach var="idx" begin="${currentpage.min}" end="${currentpage.max}">
					<c:choose>
						<c:when test="${idx == currentpage.currentPage}">
							<li class="page_item" id="nowPage">
								<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${idx}">${idx}</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page_item">
								<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${idx}">${idx}</a>
							</li>
						</c:otherwise>
					</c:choose>
					</c:forEach>
					
					<c:choose>
							<c:when test="${currentpage.max >= currentpage.pageCnt}">
								<li class="page_item disable_check">
									<a href="#">다음</a>
								</li>							
							</c:when>
							<c:otherwise>
								<li class="page_item">
									<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${currentpage.nextPage}">다음</a>
								</li>					
							</c:otherwise>
						</c:choose>									
				</ul>
			</div>
			
			<div>
				<a href="${root}board/write?board_info_idx=${board_info_idx}&page=${page}">글쓰기</a>
			</div>		
		</div>
	</section>
	<!-- 게시판 메인 페이지의 메인 부분입니다(end) -->
	
	
	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
</body>
</html>