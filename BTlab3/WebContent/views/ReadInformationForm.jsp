<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Read Information</title>
</head>

<body>
    <h1 style="text-align: center;">Read Information</h1>
    <div class="container">
        <div class="row">
            <div class="col">
                <form action="RegisterServlet" enctype="multipart/form-data" method="post" style="width: 50%" />
                    Tên đăng nhập: <input type="text" placeholder="Username" name="username" /> <br> <br>
                    Mật Khẩu: <input type="password" name="password" placeholder="Password"> <br><br>
                    Hình ảnh: <input type="file" name="imageName" placeholder="hình ảnh" /> <br> <br>
                    Ngày sinh: <input type="date" placeholder="ngày sinh" name="dateBirth" /> <br> <br>
                    <div class="form-group">
                        <label>Quốc tịch</label> 
                        <select class="form-control" name="nationlity">
                            <option value="1">Viet Nam</option>
                            <option value="2">My</option>
                            <option value="3">Nhat Ban</option>
                            <option value="4">Anh</option>
                        </select>
                    </div>
                    <br> <br> 
                    Giới tính: 
                        <input type="radio" name="gender" value="Nam" checked /> Nam 
                        <input type="radio" name="gender" value="Nữ" /> Nữ 
                        <br> <br> 
                    TT hôn nhân: <input type="checkbox" name="married" value="true"> Đã có gia đình <br> <br>
                    <div class="form-group" style="wight: 20%">
                        <label>Sở thích</label>
                        <div class="checkbox">
                            <label class="checkbox-inline"><input type="checkbox" name="favorites" value="Music">Music</label>
                            <label class="checkbox-inline"><input type="checkbox" name="favorites" value="Reading" checked>Reading</label> 
                            <label class="checkbox-inline"><input type="checkbox" name="favorites" value="Shopping" checked>Shopping</label>
                        </div>
                    </div>
                    <br> <br> Ghi Chú:
                    <textarea name="note" rows="4" cols="50"></textarea>
                    <br> <br> 
                    <input type="submit" value="Submit">
                </form>
            </div>
            <div class="col">
                <h1>Thông tin đăng nhập</h1>
                <ul>
                	<li>
                		<img src="views/upload/${staff.imageName }" width="100px" height="150px" >
                	</li>
                    <li>Tên đăng nhập: ${staff.username}</li>
                    <li>Mật khẩu: ${staff.password }</li>
                    <li>Giới tính: ${staff.gender ?'Nam': 'Nữ'}</li>
                    <li>Lập gia đình: ${staff.married ? 'Đã có gia đình' :'Chưa có gia đình' } </li>
                    <li>Quốc tịch: ${staff.nationlity } </li>
                    <li>Sở thích:
					    <ul>
					        <c:forEach var="favorite" items="${staff.favorites}">
					            <li>${favorite}</li>
					        </c:forEach>
					    </ul>
					</li>
                    <li>Ghi chú: ${staff.note} </li>
                </ul>
            </div>

        </div>
    </div>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>
</body>

</html>