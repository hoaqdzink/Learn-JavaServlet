<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div id="wrapper">
        <div class="container">
            <div class="row justify-content-around">
                <form action="UsersServlet" method="post" class="col-md-6 bg-light p-3">
                    <h1 class="text-center text-uppercase h3">Đăng ký tài khoản</h1>
                    <!-- UserName, Password, FullName, Age, Birthday, Gender-->
                    <div class="form-group">
                        <label for="username">UserName</label>
                        <input class="form-control mt-2" type="text" name="username" id="username" value="${USER.username }" placeholder="Enter UserName">
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input class="form-control mt-2" type="text" name="password" id="password" value="${USER.password }" placeholder="Enter Password">
                    </div>

                    <div class="form-group">
                        <label for="fullname">Fullname</label>
                        <input class="form-control mt-2" type="text" name="fullname" id="fullname" value="${USER.fullname }" placeholder="Enter FullName">
                    </div>

                    <div class="form-group">
                        <label for="age">Age</label>
                        <input class="form-control mt-2" type="text" name="age" id="age" value="${USER.age }" placeholder="Enter Age">
                    </div>

                    <div class="form-group">
                        <label for="birthday">BirthDay</label>
                        <input class="form-control mt-2" type="date" name="birthday" value="${USER.birthday }" id="birthday">
                    </div>

                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" value="1" type="radio" name="gender"  id="0" <c:if test="${USER.gender}">checked</c:if> /> Male
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" value="0" type="radio" name="gender" id="1" <c:if test="not ${USER.gender }">checked</c:if>   /> Female
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <input type="submit" class="form-incline btn btn-primary" value="Submit" />
                        <input type="reset" class="form-incline btn btn-primary" value="Cencel" />
                        <a href="./UsersServlet?action=List" class="btn btn-primary" value="">Display Users</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script> 
</body>
</html>