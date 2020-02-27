<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<td style="font-family:돋음; font-size:12">${answerCommand.boardName}&nbsp;&nbsp;//&nbsp;&nbsp;${answerCommand.ipAddr}</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16"><div align="center">제 목&nbsp;&nbsp;</div></td>
			<td style="font-family:돋음; font-size:12">${answerCommand.boardSubject}</td>
		</tr>
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;"></td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12"><div align="center">내 용</div></td>
			<td style="font-family:돋음; font-size:12">
				<table border=0 width=490 height=250 style="table-layout:fixed">
					<tr>
						<td valign=top style="font-family:돋음; font-size:12">${answerCommand.boardContent}</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12"><div align="center">첨부파일</div></td>
			<td style="font-family:돋음; font-size:12">
<!-- 				<c:forTokens items="${libraryBoardCommand.originalFileName}" delims="-" var="oriFile"> -->
<!-- 					split 안하고 쓰는 방식.. but 변수 하나일떄 아니면 뭔가 복잡쓰... 이중반복문이 되어버림.. -->
<!-- 				</c:forTokens> -->
				<c:forEach items="${storeFileName}" var="strFile" varStatus="status" >	
					<a href="../libraryBoard/update/${strFile}">${originalFileName[status.index]}</a> / ${fileSize[status.index]} / ${status.index }<br />
					<!-- 배열이니까 인덱스만 알면 요런 식으로 쓸수 있다는.. 요런 식...  -->
				</c:forEach>
			</td>
		</tr>
		
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr align="center" valign="middle">
			<td colspan="5">
				<font size=2>
				<a href="./boardReply?num=${answerCommand.boardNum}">[답변]</a>&nbsp;&nbsp;
				<a href="./boardModify?num=${answerCommand.boardNum}">[수정]</a>&nbsp;&nbsp;
				<a href="./boardDelete?num=${answerCommand.boardNum}">[삭제]</a>&nbsp;&nbsp;
				<a href="./answerBoard">[목록]</a>&nbsp;&nbsp;
				</font>
			</td>
		</tr>
	</table>
</body>
</html>