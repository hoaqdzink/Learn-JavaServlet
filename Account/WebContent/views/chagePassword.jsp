<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <title>Đổi mật khẩu</title>
</head>
<body>
    <h1 class="text-center">Nhập lại mật khẩu</h1>
  <div class="container mt-5  d-flex justify-content-center">
    <form action="./change-password" method="post" style="width: 300px;">
			<div class="form-group">
				<c:if test="${not empty messageMail }">
					<div class="alert alert-danger">${messageMail}</div>
				</c:if>
			</div>
			<div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Nhập mật khẩu</label>
        <div class="input-group">
          <input type="password" class="form-control" id="exampleInputPassword1" name="password">
          <button class="btn btn-outline-secondary" type="button" id="togglePassword">
            <i class="bi bi-eye"></i>
          </button>
        </div>
      </div>

      <div class="mb-3">
        <label for="exampleInputPassword2" class="form-label">Nhập mật mới</label>
        <div class="input-group">
          <input type="password" class="form-control" id="exampleInputPassword2" name="password">
          <button class="btn btn-outline-secondary" type="button" id="togglePassword2">
            <i class="bi bi-eye"></i>
          </button>
        </div>
      </div>

      <div class="mb-3">
        <label for="exampleInputPassword3" class="form-label">Nhập lại mật khẩu</label>
        <div class="input-group">
          <input type="password" class="form-control" id="exampleInputPassword3" name="password">
          <button class="btn btn-outline-secondary" type="button" id="togglePassword3">
            <i class="bi bi-eye"></i>
          </button>
        </div>
      </div>

      <button type="submit" class="btn btn-primary">Submit</button>

    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
  <script>
    document.getElementById('togglePassword').addEventListener('click', function () {
      const passwordInput = document.getElementById('exampleInputPassword1');
      const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
      passwordInput.setAttribute('type', type);
    });
    document.getElementById('togglePassword2').addEventListener('click', function () {
        const passwordInput = document.getElementById('exampleInputPassword2');
        const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordInput.setAttribute('type', type);
    });
    document.getElementById('togglePassword3').addEventListener('click', function () {
    const passwordInput = document.getElementById('exampleInputPassword3');
    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
    passwordInput.setAttribute('type', type);
    });
  </script>

</body>
</html>
