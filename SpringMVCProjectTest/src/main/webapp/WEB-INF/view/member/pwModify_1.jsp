<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js" ></script>
<script type="text/javascript">
$(function(){
	$("#sbm").click(function(){
		if($("#pw").val()==""){
			alert("현재 비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}
		if($("#newPw").val()==""){
			alert("새 비밀번호를 입력하세요.");
			$("#newPw").focus();
			return false;
		}
		if($("#newPw").val() != $("#reNewPw").val()){
			alert("비밀번호확인이 일치하지 않습니다.");
			$("#reNewPw").focus();
			return false;
		}
		$("#frm").submit();
	});
});
</script>
</head>
<body>
<form:form action ="pwModifyPro" method="post" name="frm" id="frm" commandName="changePwdCommand">
	<form:hidden path="userId" />
	현재비밀번호 : <form:password path="pw" id="pw" />
			   <form:errors path="pw" id="pw" /><br />
	새 비밀번호 : <form:password path="newPw" id="newPw" />
			  <form:errors path="newPw" id="newPw" /><br />
	새 비밀번호 확인 : <form:password path="reNewPw" id="reNewPw" />
				  <form:errors path="reNewPw" id="reNewPw" /><br />
	<input type="button" value="비밀번호변경" id="sbm"/>
</form:form>	             
</body>
</html>