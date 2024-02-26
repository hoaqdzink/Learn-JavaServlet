<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Quên mật Khẩu</title>
</head>
<body>
    <h1 class="text-center">Quên mật khẩu.</h1>
    <div class="container d-flex justify-content-center">
        <form action="./forgot-password" method="post" style="width: 300px;">
			<div class="form-group">
				<c:if test="${not empty validateMail }">
					<div class="alert alert-danger">${validateMail}</div>
				</c:if>
			</div>
			<div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">Nhập Email cần lấy</label>
              <input type="email" class="form-control" name="email" id="exampleInputEmail1"/>
            </div>
            <button type="submit" class="btn btn-primary">Send Email</button>
            <a href="./sign-in" style="float:right">Quay lại</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>