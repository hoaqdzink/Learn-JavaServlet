<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Upload File</title>
  </head>
  <body>
    <div class="conainer">
      <div class="row">
        <div class="alert alert-success">Upload Image and Document</div>
      </div>
      <div class="row">
        <div class="col">
          <form action="UploadServlet" enctype="multipart/form-data" method="post">
            <div class="custom-file mb-4">
              <label for="image" class="custom-file-lable">Image</label>
              <input type="file" class="custom-file-input" id="image" name="image"/>
            </div>
            <div class="custom-file mb-4">
              <lable for="document" class="custom-file-lable">Document</lable>
              <input type="file" class="custom-file-input" id="document" name="document"/>
            </div>
            <hr/>
            <button class="btn btn-primary">Upload</button>
          </form>
        </div>
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>