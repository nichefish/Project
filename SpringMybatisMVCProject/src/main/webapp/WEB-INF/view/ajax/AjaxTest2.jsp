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
	$("#btn1").click(function() {
		$.ajax({
		});
	});
	$("#btn3").click(function() {
		$("frm").ajaxSubmit({
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
	$("#btn4").click(function() {
		var option = {
			type : "post",
			url : "AjaxTest2",
			dataType : "html",
			success : function () {
				$("#notice_content").html(result);
			},
			error : function () {
				alert('에러가 나왔다 홀홀홀...');
				return;
			}
		}
		$("frm").ajaxSubmit(option);
	});
	$("#btn5").click(function() {
		var option = {
			type : "post",
			url : "AjaxTest2",
			dataType : "html",
			beforeSubmit : beforeTest,		// 자바스크립트 함수명... 괄호 안씀
			success : okTest,
			error : function () {		// 요거는 익명함수...
				alert('에러가 나왔다 홀홀홀...');
				return;
			}
		}
		$("frm").ajaxSubmit(option);
	});
});
function testDiv(n) {		// AjaxTest?n=2 식으로...
	$.ajax({
		type : "post",
		url : "AjaxTest2",
		dataType : "html",
		data : "n=" + n,
// 		beforeSubmit : function (result) { },
		success : function (result) {
			$("#notice_content").html(result);
		},
		error : function () {
			alert('에러가 나왔다 홀홀홀...');
			return;
		}
	});
}
function beforeTest() {
	if ($("#n").val() == "") {
		alert("값을 입력해주세요.");
		$("n").focus();
		return false;
	} else {
		alert("Ajax가 실행되기 전에 사용하는 함수...");
	}
}
function okTest(responseText, statusTet, xhr, $form) {		// 날라오는 매개변수명이 정해져 있음.. $form은 내가 사용했었던 form...
	alert(responseText);
	if (statusText = "success") {
		$("#notice_content").html(responseText);
		$form.css('background', 'red');
	}
}
</script>
</head>
<body>
	<c:if test="${n == 1}">
		<div class="person_bod" id="op1" >
			<ul class="person_tab">
				<li class="person_tab01"><h3>경력3년이상</h3></li>
				<li class="person_tab02" onclick="testDiv(2);"><h3>석박사급</h3></li>
				<li class="person_tab03" onclick="testDiv(3);"><h3>IT·개발</h3></li>
			</ul>
			<table cellspacing="0" cellpadding="0" border="0" summary="board" class="re_bod">
				<caption></caption>
				<colgroup>
					<col width="18%" />
					<col width="44%" />
					<col width="14%" />
					<col width="12%" />
					<col width="12%" />
				</colgroup>
				<thead>
					<tr>
						<th>ID(성별,연령)</th>
						<th>이력서제목</th>
						<th>학력</th>
						<th>경력</th>
						<th>희망연봉</th>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td class="left">aa11</td>
						<td class="left">bb11</td>
						<td>cc11</td>
						<td>dd11</td>
					</tr>
				</tbody>
			</table>
		</div>
		</c:if>
		<c:if test="${n == 2}">
		<div class="person_bod" id="op2">
			<ul class="person_tab">
				<li class="person_tab01" onclick="testDiv(1);"><h3>경력3년이상</h3></li>
				<li class="person_tab02" ><h3>석박사급</h3></li>
				<li class="person_tab03" onclick="testDiv(3);"><h3>IT·개발</h3></li>
			</ul>
			<table cellspacing="0" cellpadding="0" border="0" summary="board" class="re_bod">
				<caption></caption>
				<colgroup>
					<col width="18%" />
					<col width="44%" />
					<col width="14%" />
					<col width="12%" />
					<col width="12%" />
				</colgroup>
				<thead>
					<tr>
						<th>ID(성별,연령)</th>
						<th>이력서제목</th>
						<th>학력</th>
						<th>경력</th>
						<th>희망연봉</th>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td class="left">aa222</td>
						<td class="left">bb222</td>
						<td>cc11</td>
						<td>dd11</td>
					</tr>
				</tbody>
			</table>
		</div>
		</c:if>
		<c:if test="${n == 3}">
		<div class="person_bod" id="op3">
			<ul class="person_tab">
				<li class="person_tab01" onclick="testDiv(1);"><h3>경력3년이상</h3></li>
				<li class="person_tab02" onclick="testDiv(2);"><h3>석박사급</h3></li>
				<li class="person_tab03" ><h3>IT·개발</h3></li>
			</ul>
			<table cellspacing="0" cellpadding="0" border="0" summary="board" class="re_bod">
				<caption></caption>
				<colgroup>
					<col width="18%" />
					<col width="44%" />
					<col width="14%" />
					<col width="12%" />
					<col width="12%" />
				</colgroup>
				<thead>
					<tr>
						<th>ID(성별,연령)</th>
						<th>이력서제목</th>
						<th>학력</th>
						<th>경력</th>
						<th>희망연봉</th>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td class="left">aa3333</td>
						<td class="left">bb3333</td>
						<td>cc11</td>
						<td>dd11</td>
					</tr>
				</tbody>
			</table>
		</div>
		</c:if>
<div id="notice_content">
	<form id="frm" action="AjaxTest2">
		<input type="text" id="n" value="1" name="n" />
		<input type="submit" value="전송" />
	</form>
	<button id="btn2" onclick="javascript:testDiv(1)" >버튼2</button>
	<button id="btn3" >버튼3</button>
	<button id="btn4" >버튼4</button>
	<button id="btn4" >버튼5</button>
</div>
</body>
</html>