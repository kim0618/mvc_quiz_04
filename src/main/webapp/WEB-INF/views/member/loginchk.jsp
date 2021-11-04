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
	
	<c:choose>
		<c:when test="${check == 2 }">
			<script type="text/javascript">
				alert('비밀번호가 틀렸습니다')
				location.href="${contextPath}/member/lndex"
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert('존재하지않는 아이디')
				location.href="${contextPath}/member/index"
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>