<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${wishList}" var="goods">
<p>번호: ${goods.goodsNum }
상품명: ${goods.goodsName }</p>
</c:forEach>
</body>
</html>