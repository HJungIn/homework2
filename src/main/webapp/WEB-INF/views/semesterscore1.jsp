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
<h2>${ye}년 ${se}학기의 교과목 리스트입니다</h2>
<hr> 

	<c:forEach var="cla" items="${courses}"> <!-- ${offers} : OfferController의 offers -->
		<p>
			<c:out value="${cla}"></c:out>
		</p>
	</c:forEach> 
</body>
</html>