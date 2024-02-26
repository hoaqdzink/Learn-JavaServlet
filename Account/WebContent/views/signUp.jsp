<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Title</title>
    <base href="/Account/" />
</head>
<body>
    <h1 class="text-center">Đăng kí</h1>
    <div class="container d-flex justify-content-center">
        <form action="UserServlet/sign-up" method="post" style="width: 300px;">
        	<div class="form-group">
				<c:if test="${not empty validate }">
					<div class="alert alert-danger">${validate}</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="exampleInputUserID1" class="form-label">User Id</label>
				<input type="text" name="userId" class="form-control"
					id="exampleInputUserID1" aria-describedby="UserID1Help">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" name="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" name="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			<div class="mb-3">
				<label for="exampleInputFullname1" class="form-label">Fullname</label>
				<input type="text" name="fullname" class="form-control"
					id="exampleInputFullname1" aria-describedby="fullnameHelp">
			</div>
			<div class="form-check">
				<input class="form-check-input" value="1" type="radio" name="admin"
					id="flexRadioDefault1"> <label class="form-check-label"
					for="flexRadioDefault1"> Admin </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" value="0" type="radio" name="admin"
					id="flexRadioDefault2" checked> <label
					class="form-check-label" for="flexRadioDefault2"> User </label>
			</div>
			<button type="submit" class="btn btn-primary">Đăng ký</button>
			<a href="./UserServlet/sign-in" style="float:right">Quay lại</a>
		</form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>