<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>J FurnitureStore</title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
  <!-- Bootstrap icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="/css/styles.css" rel="stylesheet" />
  <link href="/css/login.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="/">J FurnitureStore</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#!">All Products</a></li>
            <li><hr class="dropdown-divider" /></li>
            <li><a class="dropdown-item" href="#!">Popular Items</a></li>
            <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
          </ul>
        </li>
      </ul>
      <c:if test="${sessionScope.member == null}">
        <form class="d-flex" method="get" action="/login">
          <button class="btn btn-outline-dark" style="margin-right: 5px;" type="submit">
            <i class="bi bi-door-open fs-4"></i>
            Login
          </button>
        </form>
      </c:if>
      <c:if test="${sessionScope.member != null}">
        <form class="d-flex" method="get" action="/logout">
          <button class="btn btn-outline-dark" style="margin-right: 5px;" type="submit">
            <i class="bi bi-door-open-fill fs-4"></i>
            Logout
          </button>
        </form>
      </c:if>
      <form class="d-flex">
        <button class="btn btn-outline-dark" type="submit">
          <i class="bi-cart-fill me-1"></i>
          Cart
          <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
        </button>
      </form>
    </div>
  </div>
</nav>

<!--로그인 시작-->
<div class="loginbox">
  <h2>로그인</h2>
  <form method="post" class="h-100">
    <!--작성하지 않아도 문제는 없음-->
    <fieldset>
      <legend>로그인 구역</legend>
      <label for="id">아이디</label>
      <input type="text" id="id" name="id" placeholder="아이디를 입력해 주세요">
      <label for="pwd">비밀번호</label>
      <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해 주세요">
      <ul>
        <li><a href="findaccount">아이디/비밀번호찾기</a></li>
        <li><a href="signup">회원가입</a></li>
      </ul>
      <!--데이터를 서버로 전송-->
      <button class="login" type="button">로그인</button>
    </fieldset>
  </form>
</div>
<!--로그인 끝-->

<!-- Footer-->
<footer class="py-5 bg-dark mt-auto">
  <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>
<script src="/js/login.js"></script>
</body>
</html>
