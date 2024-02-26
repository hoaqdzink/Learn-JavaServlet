<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="offser-3 col-6 mt-4 mb-4">
    <form action="" method="post">
        <div class="card">
            <div class="card-header">Send Video to Your Friends</div>
            <div class="card-body">
                <div class="form-group">
                    <label for="email">Your Friends' emails:</label>
                    <input type="email" class="form-control" name="email"
                    id="email" aria-describedby="emailHelperId" placeholder="Emails">
                    <small id="emailHelperId" class="form-text text-muted">
                        Email is required!
                    </small>
                </div>
            </div>
            <div class="card-footer">
                <button class="btn btn-success">Send</button>
            </div>
        </div>
    </form>
</div>