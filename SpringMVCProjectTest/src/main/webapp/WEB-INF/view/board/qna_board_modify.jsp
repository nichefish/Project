<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="boardModifyAction" method="post" name="modifyform" commandName="boardCommand">
	<form:hidden path="boardNum" />
	<table cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle"><td colspan="5">MVC 게시판</td></tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16"><div align="center">글쓴이&nbsp;&nbsp;</div></td>
			<td style="font-family:돋음; font-size:12">
				<form:hidden path="boardName" />${boardCommand.boardName}
			</td>
		</tr>
		<tr>
			<td height="16" style="font-family:돋음; font-size:12">
				<div align="center">제 목</div>
			</td>
			<td>
				<form:input path="boardSubject" size="50" maxlength="100" />
				<form:errors path="boardSubject" size="50" maxlength="100" />
			</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12">
				<div align="center">내 용</div>
			</td>
			<td>
				<form:textarea path="boardContent" cols="67" rows="15" />
				<form:errors path="boardContent" cols="67" rows="15" />
			</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12">
				<div align="center">파일 첨부</div>
			</td>
			<td>
				&nbsp;&nbsp;파일명
			</td>
		</tr>
		<tr>
			<td height="16" style="font-family:돋음; font-size:12"><div align="center">비밀번호</div></td>
			<td>
				<form:password path="boardPass" />&nbsp;
				<form:errors path="boardPass" />
			</td>
		</tr>
		
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr align="center" valign="middle">
		<td colspan="5">
			<input type="submit" value="[등록]">
			<a href="javascript:history.go(-1)"><input type="button" value="[뒤로]"></a>
		</td>
		</tr>
	</table>
</form:form>
</body>
</html>