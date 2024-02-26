<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-1">
        <h1 class="text-center text-uppercase p-2">List Users</h1>
        <div class="p-4">
            <a type="button" href="./UsersServlet?action=AddOrEdit" class="form-incline btn btn-primary">Add Users</a>
        </div>
        <table class="table table-hover ">
            <thead>
              <tr>
                <th scope="col">Username</th>
                <th scope="col">Password</th>
                <th scope="col">Fullname</th>
                <th scope="col">Age</th>
                <th scope="col">Birthday</th>
                <th scope="col">Gender</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
            	<c:forEach var="user" items="${LIST_USER }">
            	<tr>
	                <th scope="row">${user.username }</th>
	                <td>${user.password }</td>
	                <td>${user.fullname }</td>
	                <td>${user.age }</td>
	                <td><fmt:formatDate value="${user.birthday}" pattern="dd/MM/yyyy"/></td>
	                <td>${user.gender ? 'Nam' : 'Nữ'}</td>
	                <td>
	                    <a href="UsersServlet?action=AddOrEdit&username=${user.username }" class="form-incline btn btn-primary">Edit</a> |
	                    <a href="UsersServlet?action=Delete&username=${user.username }" class="form-incline btn btn-danger" >Delete</a>
	                </td>
	              </tr>
            	</c:forEach>
            </tbody>
        </table>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script> 
</body>
</html>