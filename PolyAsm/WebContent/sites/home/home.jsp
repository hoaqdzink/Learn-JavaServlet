<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <div class="col-9">
    <div class="row p-2">
        <!-- Card -->
        <c:forEach var="item" items="${videos }">
        <div class="col-3 mt-2">
            <div class="card text-center">
                <div class="card-body">
                    <img src="./images/${item.poster }" width="90%" class="img-fluid" alt="">
                    <div class="row border-top mt-2">
                        <b>${item.title }</b>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="LikeVideo?videoId=${item.videoId }" class="btn btn-success">Like</a>
                    <a href="ShareVideo?videoId=${item.videoId }" class="btn btn-Info">Share</a>
                </div>
            </div>
        </div>
		 </c:forEach>
        
    </div>
    <div class="row">
        <div class="col">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                    </li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<div class="col-3">
    <div class="row mt-3 mb-3">
        <div class="cod">
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-thumbs-up" aria-hidden="true"></i>Favorites
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Laptop</li>
                    <li class="list-group-item">Computer</li>
                    <li class="list-group-item">Phone</li>
                    <li class="list-group-item">TV&AV</li>
                    <li class="list-group-item">Watch</li>
                </ul>
            </div>
        </div>
    </div>
</div>