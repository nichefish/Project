<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width=50% border="1" cellpadding="0" cellspacing="0" >
		<tr align="center" valign="middle">
			<td colspan=4>회원리스트</td>
			<td align=right>회원수 : ${count} </td>
		</tr>
		<tr align="center" valign="middle">
			<td align="center">회원아이디</td>
			<td align="center">회원이름</td>
			<td align="center">회원연락처</td>
			<td align="center">이메일</td>
			<td align="center">등록일</td>
		</tr>
		<c:forEach items="${members}" var="member">
		<tr align="center" valign="middle">
			<td align="center">
				<a href="<c:url value='/edit/memberInfo/${member.userId}' />">${member.userId}</a>
				<!-- <a href="memberInfo.nhn?id=${member.userId}">${member.userId}</a> 원래는 이렇게 물음표 뒤에 썼었는데.. -->
				<!-- 원레 쓰던 쿼리스트링 방식 대신 주소처럼.. 써보겠다는 의미.. -->
			</td>
			<td align="center">${member.userName}</td>
			<td align="center">${member.userPh1}</td>
			<td align="center">${member.userEmail}</td>
			<td align="center">
				<fmt:formatDate value="${member.userRegist}" type="date" />
			</td>
		</tr>
		</c:forEach>
		<tr align=center height=20>
			<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
				<c:if test="${page <= 1}">
				[이전]&nbsp;
				</c:if>
				<c:if test="${page > 1}">
				<a href="list?page=${page-1}">[이전]</a>&nbsp;
				</c:if>
				<c:forEach begin="${startPage}" end="${endPage}" step="1" var="i" >
					<a href="list?page=${i}">[${i}]</a>
				</c:forEach>
					<a href="#"></a>&nbsp;
				<c:if test="${page == maxPage}">
				&nbsp;[다음]
				</c:if>
				<c:if test="${page < maxPage}">
				&nbsp;<a href="list?page=${page+1}">[다음]</a>
				</c:if>
			</td>
		</tr>
	</table>
	<a href="../register/agree">회원등록</a>
	<!-- <a href="<c:url value='/register/agree' />	">회원등록</a> -->
	
</body>
</html>