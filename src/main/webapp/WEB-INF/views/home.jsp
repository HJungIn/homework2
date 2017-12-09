<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	Hello homework2!  
</h1>
 
	<p>
		<a href="${pageContext.request.contextPath}/courses"> Show current Classes</a>
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/semesterscore"> 1. 학기별 이수 학점 조회</a>
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/kindscore"> 2. 이수 구분별 학점 조회</a>
	</p>
	
 	<p>
		<a href="${pageContext.request.contextPath}/createclass"> 3. 수강 신청하기</a>
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/newclass"> 4. 수강 신청 조회</a>
	</p>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>
