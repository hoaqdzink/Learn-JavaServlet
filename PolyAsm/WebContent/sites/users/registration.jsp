<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="offset-2 col-8 mt-4 mb-4">
    <form action="Registration" method="post">
        <div class="card">
            <div class="card-header">
                <b>Registration</b>
            </div>
            <div class="card-body">
            	<jsp:include page="/common/inform.jsp"></jsp:include>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group mt-3">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" name="username" id="username" aria-describedby="usernameHid" placeholder="Username">
                            <small id="usernameHid" class="form-text text-muted">Username is required</small>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group mt-3">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="password" id="password" aria-describedby="passwordHid" placeholder="Password">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group mt-3">
                            <label for="fullname">Fullname</label>
                            <input type="text" class="form-control" name="fullname" id="fullname" aria-describedby="fullnameHid" placeholder="Fullname">
                            <small id="fullnameHid" class="form-text text-muted">Fullname is required</small>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group mt-3">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" name="email" id="email" aria-describedby="emailHid" placeholder="Email">
                            <small id="emailHid" class="form-text text-muted">Email is required</small>
                        </div>
                    </div>
                </div>
               
            </div>
            <div class="card-footer text-muted">
                <button class="btn btn-success">Sign up</button>
            </div>
        </div>
    </form>
</div>