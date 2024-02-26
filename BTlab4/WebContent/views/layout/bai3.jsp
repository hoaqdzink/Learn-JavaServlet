<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="card border border-danger" style="width: 200px; height: 330px;">
            <div class="name mt-2">
                <h6 class="text-center">${ITEMS.name }</h6>
            </div>
            <div class="img text-center border border-warning">
                <img src="views/images/${ITEMS.image }" alt="" width="190px" height="160px" class="p-1">
            </div>
            <div class="price border border-primary">
                <ul>
                    <li>Giá gốc: <strike>${ITEMS.price }$</strike></li>
                    <li>Giá mới: <c:set var="newprice" value="${ITEMS.price *(1-ITEMS.discount) }"></c:set>
                    			<fmt:formatNumber value="${newprice }"></fmt:formatNumber>$
                    </li>
                    <li>Mức giá: <c:choose>
                    				<c:when test="${newprice > 800 }">Giá cao</c:when>
                    				<c:when test="${newprice <600 }">Giá thấp</c:when>
                    				<c:otherwise>Bình thường</c:otherwise>
                    			</c:choose>
                    </li>
                </ul>
            </div>
            <div class="date">
                <p class="text-center text-justify p-2">Ngày: <fmt:formatDate value="${ITEMS.date }" pattern="dd/MM/yyyy"/> </p>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>