<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>약관 내용</h2>
<p>약관</p>
<form action="regist" method="post">	
	<!-- register/agree(.jsp)에서 온 거니까. 이 action 주소는 register/regist가 되는 거임.. -->
	<!-- 앞 주소를 바꿀라면 ../regist 요런식으로 쓰면 된다. 현재주소가 어딘지 이해하고 쓰기... -->
	<label>
		<input type="checkbox" name="agree" value="true"> 약관동의
	</label>
	<input type="submit" value="다음단계" />
</form>
</body>
</html>