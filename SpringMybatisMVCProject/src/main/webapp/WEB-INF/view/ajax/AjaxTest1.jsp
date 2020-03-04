<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.form/js"></script>
<script type="text/jacascript">
$(function() {
	$("#btn1").click(function() {
		$.ajax({
		});
	});
});
function testDiv(n) {
	$.ajax({
		type : "post",
		url : "AjaxTest2",
		dataType : "html",
		data : "n=" + n,
		beforeSubmit : function (result) {
			$("#notice_content").html(result);
		},
		success : function () {
			alert('에러가 나왔다 홀홀홀...');
			return;
		}
	});
}
AjaxTest?n=2
</script>
</head>
<body>

</body>
</html>