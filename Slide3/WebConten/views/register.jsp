<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register New Student</h1>
	<hr/>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		Name: <input type="text" name="name" placeholder="Name" /> <br/> <br/>
		Image: <input type="file" name="image" placeholder="Image"/><br/> <br/>
		
		<input type="submit" value = "Register"/>
		<input type="reset" value ="Reset"/>
	</form>
</body>
</html>