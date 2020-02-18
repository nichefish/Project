<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register" /></title>	<!-- 요런 식으로 코드를 집어넣고. 유지보수할 때 label.property만 건드리면 되는 거다.. -->
</head>
<body>
<h2>약관 내용</h2>
<p><spring:message code="term" /></p>
<form action="regist" method="post">	
	<!-- register/agree(.jsp)에서 온 거니까. 이 action 주소는 register/regist가 되는 거임.. -->
	<!-- 앞 주소를 바꿀라면 ../regist 요런식으로 쓰면 된다. 현재주소가 어딘지 이해하고 쓰기... -->
	<label>
		<input type="checkbox" name="agree" value="true"> <spring:message code="term.agree" />
	</label>
	<input type="submit" value="<spring:message code="next.btn" />" />
</form>
</body>
</html>