<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardDeletePro" name="deleteForm" method="post">
	<input type="hidden" name="boardNum" value="${num}"/>
	<table border=1>
	<tr>
		<td>
			<font size=2>글 비밀번호 : </font>
		</td>
		<td>
			<input type="password" name="boardPass" >
			<div>${passError}</div>
		</td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<a href="javascript:deleteForm.submit()">삭제</a>
			&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">돌아가기</a>
		</td>
	</tr>
	</table>
</form>
</body>
</html>