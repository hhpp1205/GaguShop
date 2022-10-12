<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div>
    <h3>제품정보 변경</h3>
  </div>

  <div>
    <form method="post">
      <div class="form-group">
        <label class="form-label">제품코드: ${item.id}</label>
      </div>

      <div class="form-group">
        <label class="form-label">제품명:</label>
        <input type="text" name="name" value="${item.name}" class="form-control">
      </div>

      <div class="form-group">
        <label class="form-label">가격:</label>
        <input type="text" name="price" value="${item.price}" class="form-control">
      </div>

      <div>
        <select name="kind">
          <option value="bed">침대</option>
          <option value="sofa">쇼파</option>
          <option value="shelf">선반</option>
        </select>
      </div>

      <div class="form-group mt-3">
        <button class="btn btn-sm btn-primary">변경</button>
        <a href="/"><button type="button" class="btn btn-sm btn-secondary">취소</button></a>
      </div>
    </form>
  </div>
</div>
</body>
</html>