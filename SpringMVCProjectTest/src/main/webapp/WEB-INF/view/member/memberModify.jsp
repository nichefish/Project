<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	$("#modify").click(function(){
		$("#frm").submit();
	});
	$("#memPw").click(function(){
		location.href="memPw.nhn";
	})
});
</script>
</head>
<body>
<form:form name="frm" id="frm" method="post" action ="memberModifyPro" commandName="member">
	<!-- 커맨드객체는 memberDetailService의 Model로 "member"라고 날라오는 걸 받기 위해서.. member라고 이름 붙인거임.... -->
	<table border=1  width=600 align="center" cellpadding=3 >
		<tr>
			<td colspan="2">회원정보 수정 </td>
		</tr>
		<tr>
			<td>아이디와 비번</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>사용자 ID</td><td>${member.userId }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<form:password path="userPw" id="pw" />
				<form:errors path="userPw" />
			</td>
		</tr>
		<tr>
			<td>기본정보 입력</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td>사용자 이름</td><td>${member.userName}</td>
		</tr>
		<tr>
			<td>생년월일 및 성별</td>
			<td>${member.userBirth} ${member.userGender}</td>
		</tr>
		<tr>
			<td>사용자 이메일</td>
			<td>
				<form:input path="userEmail" id="email" />
				<form:errors path="userEmail" />
			</td>
		</tr>
		<tr>
			<td>사용자 주소</td>
			<td>
				<form:input path="userAddr" id="addr" />
				<form:errors path="userAddr" />
			</td>
		</tr>
		<tr>
			<td>연락처 1</td>
			<td>
				<form:input path="userPh1" id="memberPh1" />
				<form:errors path="userPh1" />
			</td>
		</tr>
		<tr>
			<td>연락처 2</td>
			<td><form:input path="userPh2" id="memberPh2" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" name="modify" id="modify" value="수   정" >
				<input type="button" value="취  소" onclick = "javascript:history.back();" />
				<!-- onclick = "javascript:location.href='main.jsp';" -->
				<input type="button" value="비밀번호 변경" id="memPw"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>