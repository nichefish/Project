<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<spring:message code="register.done" arguments="${memberCommand.userName}, ${memberCommand.userEmail}" />
	<!-- ${memberCommand.userName}님.. 회원가입을 축하합니다. ${memberCommand.userEmail}로 승인 내용이 갔습니다. 요게 요거랑 똑같다... -->
	<p><a href="<c:url value='/main' />">메인으로</a></p>	<!-- c태그 안쓸라면 <a href="../main">으로 쓰면 똑같다... -->
</body>
</html>