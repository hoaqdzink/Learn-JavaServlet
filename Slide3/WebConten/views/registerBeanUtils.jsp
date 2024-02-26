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
	<form action="BeanServlet" method="post" enctype="multipart/form-data">
		Name: <input type="text" name="name" placeholder="Name" /> <br/> <br/>
		Image: <input type="file" name="image" placeholder="Image"/><br/> <br/>
		
		Gender: <input type="radio" name="gender" value="true" checked="checked" /> Male
				<inpuy type="radio" name="gender" value="false"/> Female
				<br/> <br/>
				
		Bob: <input type="date" name="dob" />
		<br/> <br/>
		Country:
		<select name="country">
			<option value="vn">Viet Nam</option>
			<option value="thai">Thai Lan</option>
			<option value="tq">Trung Quoc</option>
			<option value="cam">Campuchia</option>
		</select>>
		<input type="submit" value = "Register"/>
		<input type="reset" value ="Reset"/>
	</form>
</body>
</html>