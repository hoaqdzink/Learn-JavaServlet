<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col mt-4">
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active" id="UserEditing-tab" data-bs-toggle="tab"
                data-bs-target="#UserEditing" type="button" role="tab" aria-controls="UserEditing"
                aria-selected="true">User Editing</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="userList-tab" data-bs-toggle="tab" data-bs-target="#userList"
                type="button" role="tab" aria-controls="userList" aria-selected="false">User List</button>
        </li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="UserEditing" role="tabpanel"
            aria-labelledby="UserEditing-tab">
            <form action="" method="post">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group mt-3">
                                    <label for="username">Username</label>
                                    <input type="text" class="form-control" name="username" id="username"
                                        aria-describedby="usernameHid" placeholder="Username">
                                    <small id="usernameHid" class="form-text text-muted">Username is
                                        required</small>
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password"
                                    aria-describedby="passwordHid" placeholder="Password">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group mt-3">
                                <label for="fullname">Fullname</label>
                                <input type="text" class="form-control" name="fullname" id="fullname"
                                    aria-describedby="fullnameHid" placeholder="Fullname">
                                <small id="fullnameHid" class="form-text text-muted">Fullname is
                                    required</small>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group mt-3">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" name="email" id="email"
                                    aria-describedby="emailHid" placeholder="Email">
                                <small id="emailHid" class="form-text text-muted">Email is required</small>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="card-footer text-muted">
                    <button class="btn btn-primary">Create</button>
                    <button class="btn btn-warning">Update</button>
                    <button class="btn btn-danger">Delete</button>
                    <button class="btn btn-info">Reset</button>
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="userList" role="tabpanel" aria-labelledby="userList-tab">
            <table class="table table-stripe table-hover">
                <tr>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>&nbsp;</th>
                </tr>
                <tr>
                    <td>VinhNH</td>
                    <td>Nguyễn Hoàng Vinh</td>
                    <td>vinhnh@gmail.com</td>
                    <td>Active</td>
                    <td>
                        <a href="" class="btn btn-warning">Edit</a>
                        <a href="" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>