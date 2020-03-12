<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script>
// a href 링크로 하는 게 동기식. 이제 ajax로 바꾸는 게 비동기식- 둘 다 할 줄 알아야-
// $(function() {
// 	$().click(function() {});
// });
$(function() {
	$("#wishBtn").click(function() {
		alert("!!!");
		$.ajax({
			type : "POST",
			url : "goodsWishAdd",
			data : "seq=${goods.goodsSeq}",
			dataType : "html",
			success: wish_ok,
			error : function() {
				alert('서버오류입니다. 잠시 후 다시해주세요.');
				return;
			}
		});
	});
	$("#cartBtn").click(function() {
		$.ajax({
			type : "POST",
			url : "goodsCartAdd",
			data : "seq=${goods.goodsSeq}",
			dataType : "html",
			success: cart_ok,
			error : function() {
				alert('로그인 정보가 삭제되었습니다.\n다시 로그인해주세요.');
				location.href = "../main";
				return;
			}
		});
	});
});
function wish_ok(responseText, statusText, xhr, $form) {
	if (statusText == "success") {
		if(confirm("장바구니로 가실려면 예를 눌러 주세요.")) {
// 			location.href="goodsCartList";
		}
	}
}
function cart_ok(responseText, statusText, xhr, $form) {
	var i = responseText.trim();
	if (statusText == "success") {
		alert("장바구니에 등록되었습니다.");
	} else {
		alert("관심상품에서 삭제되었습니다.");
	}
}
</script>
</head>
<body>
<p><c:out value="${authInfo.id}" /></p>
<table align="center" width="600" border="1">
		<tr bgcolor="orange">
			<div><a href="goodsWishList">관심상품 가기</a></div><br/>
			<td align="right">조회수 : ${goods.goodsVisit}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="wishBtn">관심상품 버튼</button>
				<c:if test="${param.num eq 0 || empty param.num}">
					<a href="goodsWishAdd?seq=${goods.goodsSeq}">(${param.num})관심상품 담기</a>
				</c:if>
				<c:if test="${param.num eq 1}">
					<a href="goodsWishAdd?seq=${goods.goodsSeq}">(${param.num})관심상품 빼기</a>
				</c:if>
				<a href="../goods/goodsWishList">관심상품 목록 보기</a>
				<button id="cartBtn">장바구니 추가 버튼</button>
				<a href="../goods/goodsCartAdd?seq=${goods.goodsSeq}">장바구니 추가</a>
				<a href="../goods/goodsCartList">장바구니로 가기</a>
			</td>
		</tr>
			
	</table>
	<table align="center" width="600">
		<tr>
			<td rowspan="4">
				<c:forTokens items="${goods.goodsImage}" delims="-" var="goodsImage" varStatus="status">
		    	<c:if test="${status.index == 0}">
					<img src="../GoodsView/update/${goodsImage}" />
				</c:if>
				</c:forTokens>
			</td>
			<td>상품명 : ${goods.goodsName}</td>
		</tr>
		<tr>
			<td>가격: ${goods.goodsPrice}</td>
		</tr>
		<tr>
			<td>수량: ${goods.goodsQty}</td>
		</tr>
		<tr>
			<td>상품 설명: ${goods.goodsContent}</td>
		</tr>
	    <tr>
	    	<td colspan="2" align="center">
	    		<a href="goodsList">목록보기</a>
	    		<a href="goodsDelete.gd?seq=${goods.goodsSeq}&image=${goods.goodsImage}">상품 삭제</a> |
	    		<a href="goodsModify.gd?seq=${goods.goodsSeq}">상품 수정</a>
	    	</td>
	    </tr>
	</table>
</body>
</html>