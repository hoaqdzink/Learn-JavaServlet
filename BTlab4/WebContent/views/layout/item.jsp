<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- san pham -->
<div class="card float-left m-3" style="width: 15rem;">
	<div class="card-header">${param.name }</div>
	<div class="card-body">
		<img src="images/${param.image }" class="img-fluid">
	</div>
	<div class="card-footer">${param.price }</div>
</div>
