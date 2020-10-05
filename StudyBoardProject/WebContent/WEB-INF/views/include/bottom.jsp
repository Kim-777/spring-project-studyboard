<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>

<!-- footer 부분의 html입니다. -->
   <footer>
       <div id="footerWrap">
           <div id="authorInfo">
         	      작성자 : 김예찬 010 - 9938 - 8190
           </div>
           <div id="gitHub">소스보기 : <a href="https://github.com/Kim-777">https://github.com/Kim-777</a></div>
           <div class="logo_box">
               <img class="skill_logo" src="${root}images/html-css-js-logo.png">
               <img class="skill_logo" src="${root}images/java-logo.png">
               <img class="skill_logo" src="${root}images/ajax-logo.png">
               <img class="skill_logo oracle_logo" src="${root}images/oracle-logo.png">         
           </div>
       </div>
   </footer>