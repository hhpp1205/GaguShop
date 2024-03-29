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
  <link href="/css/gagumanager.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="/">J FurnitureStore</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
        <%--하트--%>
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/gagu/wish"><i class="bi bi-suit-heart-fill fs-4"></i></a></li>
        <%--돋보기--%>
        <li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="bi bi-search fs-4"></i></a></li>
        <%--어드민--%>
        <c:if test="${sessionScope.member.id == 'admin'}">
          <li class="nav-item"><a class="nav-link active" aria-current="page" href="/admin"><i class="bi bi-person-square fs-3"></i></a></li>
        </c:if>
        <c:if test="${sessionScope.member.id != 'admin'}">
          <li class="nav-item"><a class="nav-link active" aria-current="page" href="/order/"><i class="bi bi-person-square fs-3"></i></a></li>
        </c:if>
        <%--검색 모달창--%>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">검색</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form method="get" action="/gagu/search">
                  <div class="col-auto">
                    <label class="visually-hidden" for="autoSizingInputGroup">Username</label>
                    <div class="input-group">
                      <div class="input-group-text"><i class="bi bi-search fs-5"></i></div>
                      <input type="text" class="form-control" id="autoSizingInputGroup" name="keyword">
                    </div>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                    <button type="submit" class="btn btn-primary">검색</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </ul>
    </div>
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
    <form class="d-flex" method="get" action="/gagu/cart">
      <button class="btn btn-outline-dark" type="submit">
        <i class="bi-cart-fill me-1"></i>
        Cart
      </button>
    </form>
  </div>
  </div>
</nav>
  <div class="menu container">
    <h1>가구관리</h1>
    <ul>
      <li><a href="/gagu/add"><button type="button" class="btn btn-primary mt-5 mb-4">추가</button></a></li>
      <li><a href="/gagu/dummy"><button type="button" class="btn btn-primary mb-4">더미추가</button></a></li>
      <li><a href="/gagu/init"><button type="button" class="btn btn-primary">더미삭제</button></a></li>
    </ul>
  </div>

  <div class="container px-4 px-lg-5 mt-5">
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 "> <%-- justify-content-center--%>
      <c:forEach var="item" items="${list}">
        <div class="col mb-5">
          <div class="card h-100">
            <!-- Sale badge-->
              <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem"><a class="delete_button" href="/gagu/delete/${item.id}">삭제</a></div>
            <!-- Product image-->
            <img class="card-img-top h-75" src="/loadImg/${item.gaguImg}" alt="..." />
            <!-- Product details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- Product name-->
                <h5 class="fw-bolder">${item.name}</h5>
                <!-- Product price-->
                ₩ ${item.price}
              </div>
            </div>
            <!-- Product actions-->
            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
              <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/gagu/update/${item.id}">제품정보 변경</a></div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
  </section>
  <%--페이지네이션--%>
<div class="ssmc-pagenation">
  <a href="?page=1" class="direction"><span>&lsaquo;</span></a>
  <c:forEach var="pagers" items="${pager.list}">
    <a class="${pager.page == pagers ? 'selected' : ''}" href="/admin/gagumanager?page=${pagers}">${pagers}</a>
  </c:forEach>
  <a href="?page=${pager.last}" class="direction"><span>&rsaquo;</span></a>
</div>
  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="/js/scripts.js"></script>
</body>
</html>
