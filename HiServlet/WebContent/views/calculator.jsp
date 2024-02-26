<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Calculator</h1>
	<hr>
	<form action="CalculatorServlet" method="post">
		<p> <input type="text" name="numberA" placeholder="numberA"/> </p>
		<p> <input type="text" name="numberB" placeholder="numberB"/> </p>
		<hr>
		<p> 
			<input type="submit" value="+" name="action"/> 
			<input type="submit" value="-" name="action"/>
			<input type="submit" value="x" name="action"/>
			<input type="submit" value="/" name="action"/>
		</p>
	</form>
</body>
</html>