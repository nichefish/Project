<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호: ${replies.commentDTO.commentNo}<br />
글제목: ${replies.commentDTO.commentSubject}<br />
글내용: ${replies.commentDTO.commentContent}<br />
작성일: ${replies.commentDTO.regDate}<br />
<br />
<form action="replyInsert" method="post">
	<input type="hidden" name="cUserId" value="${replies.commentDTO.cUserID}" />
	<input type="hidden" name="commentNo" value="${replies.commentDTO.commentNo}" />
	댓글쓰기: <input type="text" name="replyContent" />
	<input type="submit" value="댓글 달기" />
</form>

+++ 여기서부터 댓글목록 +++
<br />
<c:forEach items="replies" var="reply">
	답글번호: <br />
	답글작성자: <br />
	답글내용: <br />
	답글작성일시: <br />
	- - - - - -
	
</c:forEach>





</body>
</html>