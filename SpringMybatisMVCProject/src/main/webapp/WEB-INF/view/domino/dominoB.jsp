<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function() {
	$("#bsel").change(function() {
		$.ajax({
			type : "POST",
			url : "cDomino",
			data : "a1=" + $("#asel").val() + "&b1=" + $("#bsel").val(),
			datatype : "html",
			success : function(data1) {
				$("#cDTO").html(data1);
			}
		})
	});
});
</script>
</head>
<body>
<select id="bsel" name="bNum">
	<option value="">------선택하세요------</option>
	<c:forEach items="${bb}" var="bdto">
		<option value="${bdto.b1}"> ${bdto.b2} </option>
	</c:forEach>
</select>
</body>
</html>