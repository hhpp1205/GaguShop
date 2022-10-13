<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/info.css">
    <link rel="stylesheet" href="/css/base.css">
</head>
<body>
<!-- 상단 메뉴바 -->
<div class="header">
    <form method="post" action="search" id="search_box" >
        <div class="input-group flex-nowrap">
            <input type="text" class="form-control" id="keyword" name="keyword" placeholder="검색" aria-label="Username" aria-describedby="addon-wrapping">
            <button class="input-group-text" id="addon-wrapping">🔍</button>
        </div>
    </form>



    <ul class="nav justify-content-end nav_card">
        <a href="/">
            <h1><img src="/slideImg/logo.png"></h1>
        </a>
        <c:if test="${sessionScope.member == null}">
            <li class="nav-item"><a class="nav-link active" aria-current="page" href="login"><b>Login</b></a></li>
        </c:if>
        <c:if test="${sessionScope.member != null}">
            <li class="nav-item"><a class="nav-link active" aria-current="page" href="logout"><b>Logout</b></a></li>
        </c:if>
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#"><b>Cart</b></a></li>
    </ul>
</div>
<!-- 상단 메뉴바 끝-->

<c:set var="item" value="${item}"/>
        <div><h3>제품 상세정보</h3></div>
    <div><label>제품명 : ${item.name}</label></div>
        <div><label>가격 : ${item.price}</label></div>

</body>
</html>
