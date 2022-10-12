<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<html>
<head>
    <title>회원가입</title>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
  <link href="/css/base.css" rel="stylesheet">
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
  <fieldset>
    <legend>회원가입</legend>
    <form class="signup-form" method="post" name="signup_form">
      <div>
        <label>아이디:</label>
        <input type="text" name="id" id="id">
        <button type="button" id="checkId">중복확인</button>
      </div>
      <div>
        <label>비밀번호:</label>
        <input type="password" id="pwd" name="pwd">
      </div>
      <label>비밀번호확인:</label>
      <input type="password" id="pwdCheck" name="pwdCheck">
      </div>
      <div>
        <label>이름:</label>
        <input type="text" id="name" name="name">
      </div>
      <div>
        <label>전화번호:</label>
        <input type="number" id="phoneNumber" name="phoneNumber" placeholder="- 없이 입력하세요">
      </div>
      <button type="button" onclick="checkValue()">가입하기</button>
      <button><a href="/">취소</a></button>
    </form>
  </fieldset>
  <script src="/js/signup.js"></script>
</body>
</html>
