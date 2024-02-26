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
        <h1 class="heading mt-4 mb-4">Report of Favorite Video</h1>
        <hr>
        <table class="mt-4 table table-triped table-hover">
        	<tr class="table-info">
        		<th>Title</th>
        		<th>Favorite Count</th>
        		<th>Newest Date</th>
        		<th>Oldest Date</th>
        	</tr>
        	<c:forEach var="item" items="${reports }">
        	<tr>
        		<td>${item.title }</td>
        		<td>${item.likeCount }</td>
        		<td>${item.newest }</td>
        		<td>${item.oldest }</td>
        	</tr>
        	</c:forEach>
        </table>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>