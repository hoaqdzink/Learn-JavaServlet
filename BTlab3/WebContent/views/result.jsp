<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> RESULT</h1>
    <div class="container">
        <div class="row">
            <ul>
                <li>Your image file: ${image } <br>
                    <img src="views/upload/${image }" alt="" width="80px" height="80px"/>
                </li>
                <li>
                    Yur document file: ${document } <br>
                    <a href="views/upload/${document }">Click here to download</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>