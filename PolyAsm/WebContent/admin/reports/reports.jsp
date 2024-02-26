<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col mt-4">
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
          <button class="nav-link active" id="favorites-tab" data-bs-toggle="tab" data-bs-target="#favorites" type="button" role="tab"
             aria-controls="favorites" aria-selected="true">Favorites</button>
        </li>
        <li class="nav-item" role="presentation">
          <button class="nav-link" id="favoritesUser-tab" data-bs-toggle="tab" data-bs-target="#favoritesUser" type="button" role="tab"
             aria-controls="favoritesUser" aria-selected="false">Favorites User</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="shareFriends-tab" data-bs-toggle="tab" data-bs-target="#shareFriends" type="button" role="tab"
               aria-controls="shareFriends" aria-selected="false">Share Friends</button>
          </li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="favorites" role="tabpanel" aria-labelledby="favorites-tab">
            <table class="table table-bordered table-hover mt-3">
                <tr>
                    <th>Video Title</th>
                    <th>Favorites Count</th>
                    <th>Lasted Date</th>
                    <th>Oldest Date</th>
                </tr>
                <c:forEach var="item" items="${favList }">
                <tr>
                    <td>${item.videoTitle }</td>
                    <td>${item.favoriteCount }</td>
                    <td><fmt:formatDate value="${item.newestDate}" pattern="dd-MM-yyyy" /></td>
                    <td><fmt:formatDate value="${item.oldestDate}" pattern="dd-MM-yyyy" /></td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div class="tab-pane fade" id="favoritesUser" role="tabpanel" aria-labelledby="favoritesUser-tab">
            <form action="" method="get">
                <div class="row mt-3">
                    <div class="col">
                        <div class="form-inline">
                            <div class="form-group">
                                <label>Video Title
                                    <select name="videoUserId" id="videoUserId" class="form-select ml-3">
                                        <c:forEach var="item" items="${videoList }">
                                        <option value="${item.videoId }" ${item.videoId == videoUserId ? 'selected':'' }>${item.title }</option>
                                        </c:forEach>
                                    </select>
                                </label>
                                <button class="btn btn-info ml-2">Report</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col mt-3">
                        <table class="table table-bordered">
                            <tr>
                                <th>Username</th>
                                <th>Fullname</th>
                                <th>Email</th>
                                <th>Favorite Date</th>
                            </tr>
                            <c:forEach var="item" items="${favUser }">
                            <tr>
                                <td>${item.username }</td>
                                <td>${item.fullname }</td>
                                <td>${item.email }</td>
                                <td>${item.likeDate }</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="shareFriends" role="tabpanel" aria-labelledby="shareFriends-tab">
            <form action="" method="get">
                <div class="row mt-3">
                    <div class="col">
                        <div class="form-inline">
                            <div class="form-group ">
                                <label>Video Title
                                    <select name="" id="" class="form-select ml-3">
                                        <option value="">Java Programming</option>
                                    </select>
                                </label>
                                <button class="btn btn-info ml-2">Report</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col mt-3">
                        <table class="table table-bordered">
                            <tr>
                                <th>Sender Name</th>
                                <th>Sender Email</th>
                                <th>Receiver Email</th>
                                <th>Sent Date</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>