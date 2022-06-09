<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>フラッシュ暗算</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/application.css">
	</head>
	<body>
		<h1>フラッシュ暗算</h1><br>
		<h2>難易度を選んでください</h2><br>
		<form action="http://localhost:8080/flashMentalArithmetic/application">
			<input type="submit" value="初級" id="b1">
		</form>
		<form action="http://localhost:8080/flashMentalArithmetic/applicationSecond">
			<input type="submit" value="中級" id="b2">
		</form>
		<form action="http://localhost:8080/flashMentalArithmetic/applicationThird">
			<input type="submit" value="上級" id="b3">
		</form>
	</body>
</html>