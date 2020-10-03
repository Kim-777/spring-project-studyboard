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

	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->
	
	
	<!-- index페이지의 메인 부분입니다(start) -->
	<section>
		<div class="main_holder">
			<h1>인덱스페이지입니다.</h1>
			<img src="images/ryan.jpg"/>
			<div class="main_box_list">
				<c:forEach var="sub_list" items="${list}" varStatus="idx">
					<div class="main_table_holder">
						<h4>${board_list[idx.index].board_info_name}</h4>
						<table>
							<thead>
								<tr>
									<th>글번호</th>
									<th>제목</th>
									<th>작성날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="obj" items="${sub_list}">
									<tr>
										<td>${obj.content_idx}</td>
										<td><a href="${root}board/read?board_info_idx=${board_list[idx.index].board_info_idx}&content_idx=${obj.content_idx}&page=1">${obj.content_subject}</a></td>
										<td>${obj.content_date}</td>
									</tr>								
								</c:forEach>
							</tbody>
						</table>	
						<a href="${root}board/main?board_info_idx=${board_list[idx.index].board_info_idx}">더보기</a>			
					</div>				
				</c:forEach>	
			</div>
			<div class= "clear_box"></div>	
		</div>
	</section>
	<!-- index페이지의 메인 부분입니다(end) -->
	

	<!-- bottom 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/bottom.jsp"/>
	<!-- bottom 부분을 import 합니다(end) -->
	
</body>
</html>