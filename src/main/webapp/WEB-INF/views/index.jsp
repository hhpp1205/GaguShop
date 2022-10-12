<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<html>
<head>
    <title>가구점</title>
    <link rel="stylesheet" href="/css/index.css">
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
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="gagu/cart"><b>Cart</b></a></li>
      </ul>
    </div>
  <!-- 상단 메뉴바 끝-->
<%--이미지슬라이드 시작--%>
  <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
      <div class="carousel-item active" data-bs-interval="10000">
        <img src="/slideImg/11.jpg" class="d-block w-100 h-75" alt="...">
      </div>
      <div class="carousel-item" data-bs-interval="2000">
        <img src="/slideImg/22.jpg" class="d-block w-100 h-75" alt="...">
      </div>
      <div class="carousel-item">
        <img src="/slideImg/33.png" class="d-block w-100 h-75" alt="...">
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
<%--  이미지슬라이드 끝--%>

  <!-- 카테고리 메뉴바 -->
  <div class="menuContainer">
    <ul>
      <li><a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal"><h2>침실</h2></a></li>
      <li><a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal2"><h2>거실</h2></a></li>
      <li><a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal3"><h2>주방</h2></a></li>
    </ul>
  </div>
  <%--  카테고리 메뉴바 끝--%>

  <!-- 침실 Modal 시작-->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">침실</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div>
            <a href="#">침대</a>
          </div>
          <div>
            <a href="#">매트리스</a>
          </div>
          <div>
            <a href="#">옷장</a>
          </div>
          <div>
            <a href="#">화장대</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 침실 Modal 끝-->

  <!-- 거실 Modal 시작-->
  <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel2">거실</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div>
            <a href="#">테이블</a>
          </div>
          <div>
            <a href="#">거실장</a>
          </div>
          <div>
            <a href="#">소파</a>
          </div>
          <div>
            <a href="#">악세서리</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 거실 Modal 끝-->

  <!-- 주방 Modal 시작-->
  <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel3">주방</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div>
            <a href="#">식탁</a>
          </div>
          <div>
            <a href="#">수납장</a>
          </div>
          <div>
            <a href="#">의자</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 주방 Modal 끝-->

<!-- 상품목록 불러오기 -->
  <div class="content">
    <c:forEach var="item" items="${list}">

      <div class="card item">
        <a href="gagu/info/${item.id}">
        <img src="/loadImg/${item.gaguImg}" class="card-img-top itemImg" alt="...">
        <div class="card-body center">
          <h5 class="card-title">${item.name}</h5>
          <p class="card-text">${item.price}원</p>
          <form method="post" action="gagu/addDeleteCart/${item.id}">
          <button class="btn ${item.cartId > 0  ? 'btn-danger' : 'btn-secondary'}">♥</button>
          <input value="${item.cartId}" type="hidden" name="cartId">
          </form>
        </div>
        </a>
      </div>
      

      <c:choose>
        <c:when test="${sessionScope.member.id.equals('admin')}">
          <a href="gagu/update/${item.id}">변경</a>
          <a href="gagu/delete/${item.id}">삭제</a>
        </c:when>
        <c:when test="${sessionScope.member.id.equals(item.memberId)}">
          <a href="gagu/update/${item.id}">변경</a>
          <a href="gagu/delete/${item.id}">삭제</a>
        </c:when>
      </c:choose>

    </c:forEach>
  </div>
<!-- 상품목록 불러오기 끝-->
  <div>
    <a href="gagu/add" class="btn btn-primary ">제품등록</a>
  </div>
  <!-- Footer 시작-->
  <footer class="text-center text-lg-start bg-light text-muted">
    <!-- Section: Social media -->
    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
      <!-- Left -->
      <div class="me-5 d-none d-lg-block">
        <span>Get connected with us on social networks:</span>
      </div>
      <!-- Left -->

      <!-- Right -->
      <div>
        <a href="" class="me-4 text-reset">
          <i class="fab fa-facebook-f"></i>
        </a>
        <a href="" class="me-4 text-reset">
          <i class="fab fa-twitter"></i>
        </a>
        <a href="" class="me-4 text-reset">
          <i class="fab fa-google"></i>
        </a>
        <a href="" class="me-4 text-reset">
          <i class="fab fa-instagram"></i>
        </a>
        <a href="" class="me-4 text-reset">
          <i class="fab fa-linkedin"></i>
        </a>
        <a href="" class="me-4 text-reset">
          <i class="fab fa-github"></i>
        </a>
      </div>
      <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
      <div class="container text-center text-md-start mt-5">
        <!-- Grid row -->
        <div class="row mt-3">
          <!-- Grid column -->
          <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
            <!-- Content -->
            <h6 class="text-uppercase fw-bold mb-4">
              <i class="fas fa-gem me-3"></i>Company name
            </h6>
            <p>
              Here you can use rows and columns to organize your footer content. Lorem ipsum
              dolor sit amet, consectetur adipisicing elit.
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">
              Products
            </h6>
            <p>
              <a href="#!" class="text-reset">Angular</a>
            </p>
            <p>
              <a href="#!" class="text-reset">React</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Vue</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Laravel</a>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">
              Useful links
            </h6>
            <p>
              <a href="#!" class="text-reset">Pricing</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Settings</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Orders</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Help</a>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
            <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
            <p>
              <i class="fas fa-envelope me-3"></i>
              info@example.com
            </p>
            <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
            <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
          </div>
          <!-- Grid column -->
        </div>
        <!-- Grid row -->
      </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
      © 2021 Copyright:
      <a class="text-reset fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
  </footer>
  <!-- Footer 끝-->
</body>
</html>
