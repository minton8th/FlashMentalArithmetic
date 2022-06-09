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
				<th style="font-size: 100px;">
				<%
					Integer result = (Integer) request.getAttribute("result");
				%>
				<%= result %>
				</th>
			</tr>
		</table>
		<h3>合っていましたでしょうか？</h3><br>
		<form action="http://localhost:8080/flashMentalArithmetic/start" method="get">
			<input type="submit" value="メニュー画面に戻る" id="returnButton">
		</form>
	</body>
</html>