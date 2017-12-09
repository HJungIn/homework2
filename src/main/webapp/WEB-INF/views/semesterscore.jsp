<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<h2 >학기별 이수 학점 조회 입니다</h2>
	<hr>

	<table class="form" cellpadding="5" cellspacing="0" border="1" align="center" style="border-collapse:collapse; border:1px gray solid;">
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수학점</th>
			<th>상세보기</th>
		</tr>
		<tr>
			<td>${year15}</td>
			<td>${semester1}</td>
			<td>${y15s1}</td>
			<td><a
				href="${pageContext.request.contextPath}/semesterscore1?year=${year15}&semester=${semester1}">링크</a></td>
		</tr>
		<tr>
			<td>${year15}</td>
			<td>${semester2}</td>
			<td>${y15s2}</td>
			<td><a
				href="${pageContext.request.contextPath}/semesterscore1?year=${year15}&semester=${semester2}">링크</a></td>
		</tr>
		<tr>
			<td>${year16}</td>
			<td>${semester1}</td>
			<td>${y16s1}</td>
			<td><a
				href="${pageContext.request.contextPath}/semesterscore1?year=${year16}&semester=${semester1}">링크</a></td>
		</tr>
		<tr>
			<td>${year16}</td>
			<td>${semester2}</td>
			<td>${y16s2}</td>
			<td><a
				href="${pageContext.request.contextPath}/semesterscore1?year=${year16}&semester=${semester2}">링크</a></td>
		</tr>
		<tr>
			<td>${year17}</td>
			<td>${semester1}</td>
			<td>${y17s1}</td>
			<td><a
				href="${pageContext.request.contextPath}/semesterscore1?year=${year17}&semester=${semester1}">링크</a></td>
		</tr>
		<tr>
			<td>${year17}</td>
			<td>${semester2}</td>
			<td>${y17s2}</td>
			<td><a
				href="${pageContext.request.contextPath}/semesterscore1?year=${year17}&semester=${semester2}">링크</a></td>
		</tr>
	</table>

</body>
</html>