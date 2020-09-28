<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<script>
	//로그아웃되었다는 alert을 띄우고 main으로 돌아갑니다.
	alert('로그아웃되었습니다.')
	location.href= "${root}index"
</script>