<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="offset-2 col-8 mt-4 mb-4">
    <form action="ChangePassword" method="post">
        <div class="card">
            <div class="card-header">
                <b>Change Password</b>
            </div>
            <div class="card-body">
            <jsp:include page="/common/inform.jsp"></jsp:include>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group mt-3">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" name="username" value="${username }" id="username" aria-describedby="usernameHid" placeholder="Username" disabled>
                            <small id="usernameHid" class="form-text text-muted">Username is required</small>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group mt-3">
                            <label for="password">New Password</label>
                            <input type="password" class="form-control" name="password" id="password" aria-describedby="passwordHid" placeholder="Password">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group mt-3">
                            <label for="currentPassword">Current Password</label>
                            <input type="password" class="form-control" name="currentPassword" id="currentPassword" aria-describedby="currentPasswordHid" placeholder="Current Password">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group mt-3">
                            <label for="confirmPassword">Confirm Password</label>
                            <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" aria-describedby="confirmPasswordHid" placeholder="Confirm Password">
                        </div>
                    </div>
                </div>
               
            </div>
            <div class="card-footer text-muted">
                <button class="btn btn-success">Change Password</button>
            </div>
        </div>
    </form>
</div>