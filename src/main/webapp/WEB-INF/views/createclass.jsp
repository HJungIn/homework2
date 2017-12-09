<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>2018년 1학기에 신청할 예상 교과목을 입력해주세요</h2>
<hr>

	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="cla">

		<table class="formtable">
			<tr>
				<td class="label">  년도 : </td>
				<td><sf:input class="control" type="text" path="year" value="2018"/><br/>
				<sf:errors path="year" class="error" /></td>
			</tr>
			<tr>
				<td class="label">  학기 : </td>
				<td><sf:input class="control" type="text"  path="semester" value="1"/> <br />
				<sf:errors path="semester" class="error" /></td>
			</tr>
			<tr>
				<td class="label"> 교과코드 : </td>
				<td><sf:input class="control" type="text"  path="code" /> <br />
				<sf:errors path="code" class="error" /></td>
			</tr>
			<tr>
				<td class="label"> 교과목명 : </td>
				<td><sf:input class="control" type="text"  path="name" /> <br />
				<sf:errors path="name" class="error" /></td>
			</tr>
			<tr>
				<td class="label">  구분 : </td>
				<td><sf:input class="control" type="text"  path="kind" /> <br />
				<sf:errors path="kind" class="error" /></td>
			</tr>
			<tr>
				<td class="label">  학점 : </td>
				<td><sf:input class="control" type="text"  path="score" /> <br />
				</td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input  type="submit" value="새 교과목 저장" /></td>
			</tr>
		</table>

	</sf:form>

</body>
</html>