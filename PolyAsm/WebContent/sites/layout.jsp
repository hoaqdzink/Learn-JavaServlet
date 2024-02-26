<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <base href="/PolyAsm/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <title>${page.title}</title>
</head>
<body>
    <main class="container">
        <header class="row pt-5 pb-2">
            <div class="col-9">
                <h1>Online Entertainment</h1>
            </div>
            <div class="col-3 text-right">
                <img src="./images/Poly.png" alt="" class="mr-4" width="100%">
            </div>
        </header>
        <nav class="row">
            <nav class="col navbar navbar-expand-lg navbar-light " style="background: #CCFFFF;">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">OnEn</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="HomePage">
                                   <i class="fa fa-home"></i> Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                   <i class="fa fa-info"></i> About Us</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                   <i class="fa fa-id-card"></i> Contact Us</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                   <i class="fa fa-comments"></i> My Favorites</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                  <i class="fa fa-user"></i> My Accout
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <c:if test="${not isLogin }">
                                    <li><a class="dropdown-item" href="Login">Login</a></li>
                                    <li><a class="dropdown-item" href="#">Forgot Password</a></li>
                                    <li><a class="dropdown-item" href="Registration">Registration</a></li>
                               	</c:if>
                                    <li><hr class="dropdown-divider"></li>
                                <c:if test="${isLogin }">
                                    <li><a class="dropdown-item" href="Logoff">Logout</a></li>
                                    <li><a class="dropdown-item" href="ChangePassword">Change Password</a></li>
                                    <li><a class="dropdown-item" href="EditProfile">Edit Profile</a></li>
                                </c:if>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </nav>
        <section class="row">
            <jsp:include page="${page.contentUrl }"></jsp:include>
        </section>
        <footer class="row">
            <div class="col text-center border-top">
                <strong>Fpt Poly &copy;2020. All rights reserved</strong>
            </div>
        </footer>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
	<c:if test="${not empty page.scriptUrl }">
		<jsp:include page="${page.scriptUrl }"></jsp:include>
	</c:if>
</body>
</html>