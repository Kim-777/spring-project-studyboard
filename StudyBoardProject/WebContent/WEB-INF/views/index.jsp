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
    <link rel="stylesheet" href="css/index.css">
    <!-- ajax를 사용하기 위한 script입니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!-- Place your kit's code here -->
    <script src="https://kit.fontawesome.com/5c7b32b093.js" crossorigin="anonymous"></script>
    <!-- 글자체를 임포트합니다. -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">	
    <title>메인</title>
</head>
<body>

	<!-- header 부분을 import 합니다(start) -->
	<c:import url="/WEB-INF/views/include/top.jsp"/>
	<!-- header 부분을 import 합니다(end) -->
	
	
	<!-- index페이지의 메인 부분입니다(start) -->
	<section>
		<div id="mainHolder">
			<div class="main_box_list">
				<c:forEach var="sub_list" items="${list}" varStatus="idx">			
					<div class="main_table_holder">
						<div class="table_shadow">
							<h4 class="main_table_title">${board_list[idx.index].board_info_name}</h4>
							<table class="main_table">
								<thead>
									<tr>
										<th class="main_text_number">글번호</th>
										<th class="main_text_subject">제목</th>
										<th class="main_text_date">작성날짜</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="obj" items="${sub_list}">
										<tr >
											<td class="main_text_number">${obj.content_idx}</td>
											<td class="main_text_subject"><a href="${root}board/read?board_info_idx=${board_list[idx.index].board_info_idx}&content_idx=${obj.content_idx}&page=1">${obj.content_subject}</a></td>
											<td class="main_text_date">${obj.content_date}</td>
										</tr>								
									</c:forEach>
								</tbody>
							</table>
							<div class="show_more">
								<a href="${root}board/main?board_info_idx=${board_list[idx.index].board_info_idx}">더보기</a>	
							</div>
						</div>		
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