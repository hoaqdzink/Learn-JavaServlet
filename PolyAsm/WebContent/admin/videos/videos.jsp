<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col mt-4">
	<jsp:include page="/common/inform.jsp"></jsp:include>
       <ul class="nav nav-tabs" id="myTab" role="tablist">
           <li class="nav-item" role="presentation">
             <button class="nav-link active" id="videoEditing-tab" data-bs-toggle="tab" data-bs-target="#videoEditing" type="button" role="tab"
                aria-controls="videoEditing" aria-selected="true">Video Editing</button>
           </li>
           <li class="nav-item" role="presentation">
             <button class="nav-link" id="videoList-tab" data-bs-toggle="tab" data-bs-target="#videoList" type="button" role="tab"
                aria-controls="videoList" aria-selected="false">Video List</button>
           </li>
         </ul>
         <div class="tab-content" id="myTabContent">
           <div class="tab-pane fade show active" id="videoEditing" role="tabpanel" aria-labelledby="videoEditing-tab">
               <form action="" method="post" enctype="multipart/form-data">
                   <div class="card">
                       <div class="card-body">
                           <div class="row">
                               <div class="col-3">
                                   <div class="border p-3">
                                       <img src="./images/${video.poster }" alt="" class="img-fluid">
                                       <div class="input-group mb-3 mt-3">
                                       		<div class="input-group-prepend">
                                       			<span class="input-group-text">Upload</span>
                                       		</div>
                                       		<div class="custom-file">
                                       			<input type="file" class="custom-file-input" id="cover" name="cover" />
                                       			<label for="cover">Choose File</label>
                                       		</div>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-9">
                                       <div class="form-group">
                                           <label for="youtubeId">Youtube ID</label>
                                           <input type="text" class="form-control" value="${video.videoId }" name="videoId" id="videoId" aria-describedby="youtubeIdHid" placeholder="Youtube ID"/>
                                           <small id="youtubeIdHid" class="form-text text-muted">Youtube id is required</small>
                                       </div>
                                       <div class="form-group">
                                           <label for="videoTitle">Video Title</label>
                                           <input type="text" class="form-control" value="${video.title }" name="title" id="title" aria-describedby="videoTitleHid" placeholder="Video Title">
                                           <small id="videoTitleHid" class="form-text text-muted">Video Title id is required</small>
                                       </div>
                                       <div class="form-group">
                                           <label for="viewCount">View Count</label>
                                           <input type="text" class="form-control" value="${video.views }" name="views" id="views" aria-describedby="viewCountHid" placeholder="View Count">
                                           <small id="viewCountHid" class="form-text text-muted">View Count id is required</small>
                                       </div>
                                       <div class="form-check-inline">
                                           <label><input type="radio" class="form-check-input"
                                               value="true" name="active" id="active"  ${video.active? 'checked':'' } />Active</label>
                                           <label><input type="radio" class="form-check-input"
                                               value="false" name="active" id="active" ${! video.active? 'checked':'' }/>Inactive</label>
                                       </div>
                                 </div>
                           </div>
                           <div class="row">
                               <div class="col">
                                   <label for="description">Description</label>
                                   <textarea name="description" id="description" cols="30" rows="4"  class="form-control"> ${video.description } </textarea>
                               </div>
                           </div>
                       </div>
                       <div class="card-footer text-muted">
                           <button class="btn btn-primary" formaction="Admin/VideosManagement/create">Create</button>
                           <button class="btn btn-warning" formaction="Admin/VideosManagement/update">Update</button>
                           <button class="btn btn-danger" formaction="Admin/VideosManagement/delete">Delete</button>
                           <button class="btn btn-info" formaction="Admin/VideosManagement/reset">Reset</button>
                       </div>
                   </div>
               </form>

           </div>
           <div class="tab-pane fade" id="videoList" role="tabpanel" aria-labelledby="videoList-tab">
               <table class="table table-stripe table-hover">
                   <tr>
                       <th>Youtube ID</th>
                       <th>Video Title</th>
                       <th>View Count</th>
                       <th>Status</th>
                       <th>&nbsp;</th>
                   </tr>
                   
                   <c:forEach var="item" items="${videos }"> 
                   		<tr>
	                       <td>${item.videoId }</td>
	                       <td>${item.title }</td>
	                       <td>${item.views }</td>
	                       <td>${item.active? 'Active': 'Deative' }</td>
	                       <td>
	                           <a href="Admin/VideosManagement/edit?videoId=${item.videoId }" class="btn btn-warning">Edit</a>
	                           <a href="Admin/VideosManagement/delete?videoId=${item.videoId }" class="btn btn-danger">Delete</a>
	                       </td>
                   		</tr>
                   </c:forEach>
               </table>

           </div>
         </div>
</div>