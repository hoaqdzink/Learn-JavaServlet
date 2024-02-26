<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Đăng nhập</title>
    <base href="/Account/" />
</head>
<body>
    <h1 class="text-center">Đăng nhập</h1>
	<div class="container d-flex justify-content-center">
        <form action="UserServlet" method="post" style="width: 300px;">
			<div class="form-group">
				<c:if test="${not empty message }">
					<div class="alert alert-danger">${message}</div>
				</c:if>
				<c:if test="${not empty error }">
					<div class="alert alert-danger">${error}</div>
				</c:if>
			</div>
			<div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">Email address</label>
              <input type="email" class="form-control" name="email">
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Password</label>
              <input type="password" name="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="mb-3 form-check">
              <input type="checkbox" class="form-check-input" id="isRemember" name="isRemember"/>
              <label class="form-check-label" for="exampleCheck1">Nhớ mật khẩu</label>
            </div>
            <a href="./UserServlet/sign-up" class="text-center" >Đăng kí</a>
            <a href="./UserServlet/forgot-password" style="float: right;">Quên mật khẩu</a> <br>
            <button type="submit" class="btn btn-primary"  formaction="./UserServlet/sign-in">Submit</button>
        </form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>