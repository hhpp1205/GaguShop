<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
  <!-- Bootstrap icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="/css/styles.css" rel="stylesheet" />
  <link href="/css/gagumanager.css" rel="stylesheet">
</head>
<body>
  <h1>가구관리</h1>
  <div class="menu">
    <ul>
      <li><a href="/gagu/add">추가</a></li>
      <li><a href="/gagu/dummy">더미추가</a></li>
      <li><a href="/gagu/init">더미삭제</a></li>
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
    <c:forEach var="pager" items="${pager.list}">
      <a href="/admin/gagumanager?page=${pager}">${pager}</a>
    </c:forEach>
    <%--    <strong>2</strong>--%>
    <a href="?page=${pager.last}" class="direction"><span>&rsaquo;</span></a>
  </div>
  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="/js/scripts.js"></script>
</body>
</html>
