<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js" ></script>
</head>
<body>
	<table cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle"><td colspan="5">MVC 게시판</td></tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16"><div align="center">글쓴이&nbsp;&nbsp;</div></td>
			<td style="font-family:돋음; font-size:12">${board.boardName}&nbsp;&nbsp;//&nbsp;&nbsp;${board.ipAddr}</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16"><div align="center">제 목&nbsp;&nbsp;</div></td>
			<td style="font-family:돋음; font-size:12">${board.boardSubject}</td>
		</tr>
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;"></td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12"><div align="center">내 용</div></td>
			<td style="font-family:돋음; font-size:12">
				<table border=0 width=490 height=250 style="table-layout:fixed">
					<tr>
						<td valign=top style="font-family:돋음; font-size:12">${board.boardContent}</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12"><div align="center">첨부파일</div></td>
			<td style="font-family:돋음; font-size:12"><a href="AnswerBoard/update/${board.storeFileName}"> ${board.originalFileName }</a> / ${board.fileSize}byte</td>
		</tr>
		
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr align="center" valign="middle">
			<td colspan="5">
				<font size=2>
				<a href="answerBoardReply.ab?num=${board.boardNum}">[답변]</a>&nbsp;&nbsp;
				<a href="boardModify.ab?num=${board.boardNum}">[수정]</a>&nbsp;&nbsp;
				<a href="boardDelete.ab?num=${board.boardNum}">[삭제]</a>&nbsp;&nbsp;
				<a href="answerBoard.ab">[목록]</a>&nbsp;&nbsp;
				</font>
			</td>
		</tr>
	</table>
</body>
</html>