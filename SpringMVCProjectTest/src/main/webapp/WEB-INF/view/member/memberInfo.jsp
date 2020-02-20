<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js" ></script>
<script type="text/javascript">
$(function(){
	$("#modify").click(function(){
		location.href="../memberModify?id=${memberCommand.userId}"
	});
	$("#memDel").click(function(){
		location.href="../memberDel?id=${memberCommand.userId}"
	});
});
</script>
</head>
<body>
	<c:if test="">
		<script>location.href="index.nhn";</script>
	</c:if>
	이름 : ${memberCommand.userName}<br />
	아이디 : ${memberCommand.userId}<br />
	이메일  : ${memberCommand.userName}<br />
	생년월일  : ${memberCommand.userBirth}<br />
	성별 : <c:choose >
		  	<c:when test="${memberCommand.userGender == 'M'}">
		  		남자
		  	</c:when>
		  	<c:when test="${memberCommand.userGender == 'F'}">
		  		여자
		  	</c:when>
		  </c:choose> <br />
	연락처 1 : ${memberCommand.userPh1}<br />
	연락처 2 : ${memberCommand.userPh2}<br />
	등록일 : ${memberCommand.userRegist}<br />
	주소  : ${memberCommand.userAddr}<br />
	<input type="button" name="modify" id="modify" value="수   정" >
	<input type="button" value="취  소" onclick="javascript:history.back();" />
	<input type="button" value="탈 퇴" id="memDel"/>
</body>
</html>