<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<base href="/BTlab5/" />
</head>
<body>
    <div id="wrapper">
        <div class="container">
            <div class="row justify-content-around">
                <form action="UserServlet" method="post" class="col-md-6 bg-light p-3">
                    <h1 class="text-center text-uppercase h3">Đăng ký tài khoản</h1>
                    <!-- UserName, Password, FullName, Age, Birthday, Gender-->
                    <div class="form-group">
                        <c:if test="${not empty message }">
                        	<div class="alert alert-success">${message}</div>
                        </c:if>
                        <c:if test="${not empty error }">
                        	<div class="alert alert-danger">${error}</div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="userId">User ID:</label>
                        <input class="form-control mt-2" value="${user.userId }" type="text" name="userId" id="userId" placeholder="Enter UserID">
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input class="form-control mt-2" value="${user.password }" type="text" name="password" id="password" placeholder="Enter Password">
                    </div>

                    <div class="form-group">
                        <label for="fullname">Fullname</label>
                        <input class="form-control mt-2" value="${user.fullname }"  type="text" name="fullname" id="fullname" placeholder="Enter FullName">
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input class="form-control mt-2" value="${user.email }" type="email" name="email" id="email" placeholder="Enter Email">
                    </div>

                    <div class="form-group">
                        <label for="Admin">Role: </label>
                        <div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" value="true" name="admin" <c:if test="${user.admin}">checked</c:if> /> Admin
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" value="false" name="admin" <c:if test="${!user.admin}">checked</c:if>/> User
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <button formaction="UserServlet/create" class="btn btn-primary">Create</button>
                        <button formaction="UserServlet/update" class="btn btn-warning">Update</button>
                        <button formaction="UserServlet/delete" class="btn btn-danger">Delete</button>
                        <button formaction="UserServlet/reset" class="btn btn-info">Reset</button>
                    </div>
                </form>
            </div>
            <div class="row">
                <table class="table table-hover">
                    <thead>
                      <tr>
                        <th scope="col">User ID</th>
                        <th scope="col">Password</th>
                        <th scope="col">Fullname</th>
                        <th scope="col">Email</th>
                        <th scope="col">Role</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody>
	                    <c:forEach var="item" items="${users }">
	                       <tr>
                            <th scope="row">${item.userId }</th>
                            <td>${item.password }</td>
                            <td>${item.fullname }</td>
                            <td>${item.email }</td>
                            <td>${item.admin ? 'Admin' : 'User'}</td>
                            <td>
                            	<a href="UserServlet/edit?userId=${item.userId }" class="form-incline btn btn-primary">Edit</a> |
                            	<a href="UserServlet/delete?userId=${item.userId }" class="form-incline btn btn-danger" >Delete</a>
                            </td>
                          </tr>
	                    </c:forEach>
                    </tbody>
                </table>
          
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script> 
</body>
</html>