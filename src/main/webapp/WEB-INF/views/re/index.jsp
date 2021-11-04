<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>index<br>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<img src="resources/cm.png" width="100px" height="100px">
<img src="${contextPath }/resources/cm.png" width="100px" height="100px">
<img src="<c:url value='/resources/cm.png'/>" width="100px" height="100px">
<hr>
<img src="resources/test/cm.png" width="100px" height="100px">

	<form action="result">
		<input type="text" name="id"><br>
		<input type="submit" value="전송">
	</form>

</body> 
</html>