<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.form/js"></script>
<script type="text/javascript">
$(function() {
	$("#asel").change(function() {
		$.ajax({
			type : "POST",
			url : "bDomino",
			data : "a1=" + $("#asel").val(),
			datatype : "html",
			success : function(data) {
				$("#bDTO").html(data);
				$("#cDTO").html("<h2>세번째 도미노</h2><select id='csel' name='cNum'><option value=''>------선택하세요------</option></select><div id='cDTO'></div>");
			}
		})
// 		location.href = "bDomino?num=" + $("#asel").val();
	});
});
</script>
</head>
<body>
<h2>첫번째 도미노</h2>
<select id="asel" name="aNum">
	<option value="">------선택하세요------</option>
	<c:forEach items="${aa}" var="adto" varStatus="status" >
		<option value="${adto.a1 }">${adto.a2 }</option>
	</c:forEach>
</select>
<h2>두번째 도미노</h2>
<div id="bDTO">
<select id="bsel" name="bNum">
	<option value="">------선택하세요------</option>
</select></div>
<h2>세번째 도미노</h2>
<div id="cDTO">
<select id="csel" name="cNum">
	<option value="">------선택하세요------</option>
</select></div>
</body>
</html>