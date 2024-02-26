<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="offset-4 col-4 mt-4 mb-4">
    <form action="" method="post">
        <div class="card">
            <div class="card-header">
                <b>Forgot Password</b>
            </div>
            <div class="card-body">
                <div class="form-group mt-3">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" name="username" id="username" aria-describedby="usernameHid" placeholder="Username">
                    <small id="usernameHid" class="form-text text-muted">Username is required</small>
                </div>

                <div class="form-group mt-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHid" placeholder="Email">
                    <small id="emailHid" class="form-text text-muted">Email is required</small>
                </div>
            </div>
            <div class="card-footer text-muted">
                <button class="btn btn-success">Retrieve</button>
            </div>
        </div>
    </form>
</div>