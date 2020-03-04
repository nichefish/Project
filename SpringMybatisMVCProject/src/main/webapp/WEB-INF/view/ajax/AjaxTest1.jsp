<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.form/js"></script>
<script type="text/javascript">
$(function() {
	$("#btn1").click(function() {
		$.ajax({
		});
	});
	$("#btn3").click(function() {
		$("frm").$.ajaxSubmit({
			type : "post",
			url : "AjaxTest2",
			dataType : "html",
// 			beforeSubmit : function (result) { },
			success : function () {
				$("#notice_content").html(result);
			},
			error : function () {
				alert('에러가 나왔다 홀홀홀...');
				return;
			}
		});
	});
});
function testDiv(n) {		// AjaxTest?n=2 식으로...
	$.ajax({
		type : "post",
		url : "AjaxTest2",
		dataType : "html",
		data : "n=" + n,
// 		beforeSubmit : function (result) { },
		success : function () {
			$("#notice_content").html(result);
		},
		error : function () {
			alert('에러가 나왔다 홀홀홀...');
			return;
		}
	});
}
</script>
</head>
<body>
<div id="notice_content">
	<form id="frm" action="AjaxTest2">
		<input type="text" id="n" value="1" name="n" />
		<input type="submit" value="전송" />
	</form>
	<button id="btn2" onclick="javascript:testDiv(1)" >버튼1</button>
	<button id="btn3" onclick="javascript:testDiv(1)" >버튼2</button>
</div>
</body>
</html>