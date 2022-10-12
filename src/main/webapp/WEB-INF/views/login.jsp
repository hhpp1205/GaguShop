<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

<html>
  <link href="/css/login.css" rel="stylesheet">
  <link href="/css/base.css" rel="stylesheet">
  <head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
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
<div class="loginbox">
  <h2>로그인</h2>
  <form method="post">
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

<script src="/js/login.js"></script>
</body>
</html>
