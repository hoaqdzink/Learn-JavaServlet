<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <section class="container">
        <h1 class="heading mt-4 mb-4">Find Favorite Videos of User</h1>
        <hr>
        <form action="FindFavouriteVideoController" method="post" class="mt-4">
            <div class="mb-3 row">
                <label for="userId" class="col-sm-1 col-form-label">User Id: </label>
                <div class="col-sm-4">
                	<input type="text" class="form-control col-sm-4" name="userId" id="userId" placeholder="example@gmail.com"/>
                </div>
                <div class="col-sm-2">
                	<button class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>
        <div class="card">
        	<div class="card-body">
        		<ul class="">
        			<li>User Id: ${user.id }</li>
        			<li>Email: ${user.email }
        		</ul>
        	</div>
        </div>
        <table class="mt-4 table table-triped table-hover">
        	<tr class="table-info">
        		<th>ID</th>
        		<th>Title</th>
        		<th>Views</th>
        		<th>Active</th>
        	</tr>
        	<c:forEach var="item" items="${user.favourites }">
        	<tr>
        		<td>${item.video.id }</td>
        		<td>${item.video.title }</td>
        		<td>${item.video.views }</td>
        		<td>${item.video.active }</td>
        	</tr>
        	</c:forEach>
        </table>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>