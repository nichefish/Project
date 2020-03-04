<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js" ></script>
</head>
<body>
	<table cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle"><td colspan="4">MVC 게시판</td></tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16"><div align="center">글쓴이&nbsp;&nbsp;</div></td>
			<td style="font-family:돋음; font-size:12">${board.boardName}&nbsp;&nbsp;//&nbsp;&nbsp;${board.ipAddr}</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16"><div align="center">제 목&nbsp;&nbsp;</div></td>
			<td style="font-family:돋음; font-size:12">${board.boardSubject }</td>
		</tr>
		
		<tr bgcolor="cccccc">
			<td colspan="4" style="height:1px;"></td>
		</tr>
		
		<tr>
			<td style="font-family:돋음; font-size:12"><div align="center">내 용</div></td>
			<td style="font-family:돋음; font-size:12">
				<table border=0 width=490 height=250 style="table-layout:fixed">
					<tr>
						<td valign=top style="font-family:돋음; font-size:12">${board.boardContent }</td>
					</tr>
				</table>
			</td>
		</tr>

		<tr bgcolor="cccccc">
			<td colspan="4" style="height:1px;"></td>
		</tr>

		<tr align="center" valign="middle">
			<td colspan="4">
				<font size=2>
				<a href="boardReply.cb?num=${board.boardNum }">[답변]</a>&nbsp;&nbsp;
				<a href="boardModify.cb?num=${board.boardNum }">[수정]</a>&nbsp;&nbsp;
				<a href="boardDelete.cb?num=${board.boardNum }">[삭제]</a>&nbsp;&nbsp;
				<a href="./commentBoard.cb">[목록]</a>&nbsp;&nbsp;
				</font>
			</td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		
		<c:forEach items="${replyList}" var="reply" varStatus="status">
		<tr bgcolor="cccccc">
			<td>이름: ${reply.replyName }&nbsp;&nbsp;</td>
			<td>내용: ${reply.replyContent}</td>
			<td>IP: ${reply.ipAddr }&nbsp;&nbsp;</td>
			<td><a href="./boardReplyDelete.cb?num=${reply.boardNum}&replynum=${reply.replyNum}">[댓글삭제]</a></td>
		</tr>
		</c:forEach>
		
		

	</table>
</body>
</html>