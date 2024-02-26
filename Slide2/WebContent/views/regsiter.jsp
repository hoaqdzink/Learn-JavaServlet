<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
</head>
<body>
	 <div class="container" style="margin-top: 10px;">
            <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
                <div class="col-sm-12">
                    <h2>Register</h2>
                    <form action="UserServlet" method="post">
                        <input type="hidden" class="form-control" name="action" value="" >
                        <div class="form-group">
                            <label>UserName</label>
                            <input type="text" class="form-control" name="username" value=""  placeholder="Enter UserName">
                        </div>
                        
                        <div class="form-group">
                            <label>Age</label>
                            <input type="number" class="form-control" name="age" value="" placeholder="Enter age">
                        </div>

                        <div class="form-group">
                            <label>Country</label>
                            <select class="form-control" name="country">
                                <option value="1">Viet Nam</option>
                                <option value="2">My</option>
                                <option value="3">Nhat Ban</option>
                                <option value="4">Anh</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Gender</label>
                            <div class="radio"><!--value = 1 => Nam| 0 =>Nu -->
                                <label class="checkbox-inline"><input type="radio" name="gender"  value="1" >Male</label>
                                <label class="checkbox-inline"><input type="radio" name="gender"  value="0" checked> Female</label>

                            </div>
                        </div>
                        <div class="form-group">
                            <label>Hobby</label>
                            <div class="checkbox">
                                <label class="checkbox-inline"><input type="checkbox" name="hobbies"  value="Music" >Music</label>
                                <label class="checkbox-inline"><input type="checkbox" name="hobbies"  value="Reading" checked>Reading</label>
                                <label class="checkbox-inline"><input type="checkbox" name="hobbies"  value="Shopping" checked>Shopping</label>

                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="reset" class="btn btn-primary">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>