<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<html>
<head>
    <title>제품등록</title>
</head>
<body>
    <form method="post" enctype="multipart/form-data">
    <div>
        <label>제품명: </label>
        <input type="text"name="name">
    </div>
    <div>
        <label>가격: </label>
        <input type="number" name="price">
    </div>
    <div>
        <select name="keyword">
            <c:forEach var="item" items="${list}">
             <option value="${item.keyword}">${item.keyword}</option>
            </c:forEach>
        </select>
    </div>
    <div class="button">
        <label for="file">대표사진</label>
        <input type="file" id="file" name="file" accept="image/*">
    </div>
    <div>
        <button class="btn btn-sm btn-primary" id="add" type="button">추가</button>
    </div>
    <div id="attachs">

    </div>
        <button>등록</button>
    </form>
        <button><a href="../">취소</a> </button>
<script src="/js/add.js"></script>
</body>
</html>
