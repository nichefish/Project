<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkQty (seq, qty) {
	if (qty > 1) {
		location.href = "goodsCartQtyDown?seq="+seq;
	} else {
		return false;
	}
}
</script>
</head>
<body>
	<form action="goodsCartRemove" method="post" name="frm">
		<table align="center" width="600" border="1">
			<tr align="center" bgcolor="orange">
				<td>번호	</td>
				<td>상품이미지</td>
				<td>상품명</td>
				<td>가격</td>
				<td>수량</td>
				<td align="center"><input type="submit" value="삭제" /></td>
			</tr>
			<c:forEach var="cart" items="${cartList}" step="1" >
			<tr align="center" bgcolor="orange">
				<td>${cart.goodsSeq}	</td>
				<td>
					<img src="GoodsView/update/${cart.goodsImage}" width="30"/>
				</td>
				<td>${cart.goodsName}</td>
				<td>${cart.goodsPrice}</td>
				<td><a href="goodsCartQtyUp?seq=${cart.goodsSeq}"> + </a> ${cart.goodsQty} <a href="javascript:checkQty('${cart.goodsSeq}',${cart.goodsQty})"> - </a></td>
				<td align="center"><input type="checkbox" name="delete" value="${cart.cartNum}" /></td>
			</tr>	
			</c:forEach>
		</table>
	</form>
	<table align="center" width="600" border="0">
		<tr align="center" bgcolor="yellow">
			<td align="right" colspan="6"><font color ="gray" size="5">총 결제금액 : ${totalMoney }</font><font color ="black" size="5">원</font></td>
		</tr>
	</table>
	<a href="goodsList" >목록으로 가기</a>
</body>
</html>