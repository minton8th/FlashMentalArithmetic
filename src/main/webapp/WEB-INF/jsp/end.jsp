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
		<table border="1">
			<tr align="center">
				<th style="font-size: 50px">答えは何でしょう？</th>
			</tr>
		</table>
		<form action="http://localhost:8080/flashMentalArithmetic/application2" method="post">
			<input type="submit" value="答えを見る" id="startButton">
		</form>
	</body>
</html>