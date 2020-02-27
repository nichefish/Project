<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" name="boardform" commandName="answerCommand">
	<form:hidden path="boardNum" />
	<form:hidden path="boardReRef" />
	<form:hidden path="boardReLev" />
	<form:hidden path="boardReSeq" />
	<table cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle">
			<td colspan="5">MVC 게시판</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16">
				<div align="center">글쓴이</div>
			</td>
			<td>
				<input name="boardName" type="text"/>
			</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16">
				<div align="center">제 목</div>
			</td>
			<td>
				<form:input path="boardSubject" size="50" maxlength="100" />  value="Re: ${answerCommand.boardSubject}"
		</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12">
				<div align="center">내 용</div>
			</td>
			<td>
				<form:textarea path="boardContent" cols="67" rows="15" />&nbsp;&#10;&nbsp;&#10;&nbsp;&#10;&nbsp;&#10;&nbsp;&#10;&nbsp;&#10;- - - - - -&#10;${answerCommand.boardContent}
		</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12">
				<div align="center">비밀번호</div>
			</td>
			<td>
				<input name="boardPass" type="password">
			</td>
		</tr>
		
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;">
			</td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr align="center" valign="middle">
			<td colspan="5">
			<a href="javascript:boardform.submit();">[등록]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>