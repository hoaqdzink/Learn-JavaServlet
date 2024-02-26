<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>

    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css">
  <body>
    <div class="container">
    	<!-- header -->
        <%@include file="layout/header.jsp" %>
       <!-- menu -->
       <%@include file="layout/menu.jsp" %>
        <section class="row">
            <article class="col-9">
            	<!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                <!-- sản phẩm -->
                <jsp:include page="layout/item.jsp">
                	<jsp:param value="Nokia" name="name"/>
                	<jsp:param value="sanPham.jpg" name="image"/>
                	<jsp:param value="200$" name="price"/>
                </jsp:include>
                
                
            </article>
            <aside class="col-3">
                <%@include file="layout/aside.jsp" %>
            </aside>
        </section>
        <!-- footer -->
        <%@include file="layout/footer.jsp" %>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>