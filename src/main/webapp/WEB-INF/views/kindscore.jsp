<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 >이수 구분별 학점 조회 입니다</h2>
	<hr>

	<table class="form" cellpadding="5" cellspacing="0" border="1" align="center" style="border-collapse:collapse; border:1px gray solid;">
		<tr>
			<th>교필</th>
			<th>핵교A</th>
			<th>핵교B</th>
			<th>전지</th>
			<th>전기</th>
			<th>전선</th>
			<th>자율</th>
			<th>총학점</th>
		</tr>
		<tr>
			<td><c:out value="${pg}"></c:out></td>
		    <td><c:out value="${hga}"></c:out></td>
		    <td><c:out value="${hgb}"></c:out></td>
			<td><c:out value="${jj}"></c:out></td>
			<td><c:out value="${jg}"></c:out></td>
			<td><c:out value="${js}"></c:out></td>
			<td><c:out value="${jy}"></c:out></td>
			<td><c:out value="${total}"></c:out></td>
		</tr>

	</table>
</body>
</html>