<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp<br>
	<form action="${contextPath }/member/login">
		<input type="text" name="id" placeholder="id"><br>
		<input type="password" name="pwd" placeholder="password"><br>
		<input type="submit" value="login">
	</form>
	<a href="${contextPath}/member/register_view">회원가입</a>
	<a href="${contextPath}/member/member_list">모든회원보기</a>
</body>
</html>