<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link href="/css/info.css" rel="stylesheet">
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
                <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
            </button>
        </form>
    </div>
    </div>
</nav>
<%--제품상세정보--%>
<div class="container position-relative mt-5 product_container">
<%--    <c:set var="item" value="${item}"/>--%>
    <div class="product_imgs">
        <img class="product_mainImg" src="/loadImg/${item.gaguImg}">
        <div class="row row-cols-4 img_wrapper">
            <div class="col">
                <img class="product_img_etc" src="/loadImg/${item.gaguImg}">
            </div>
            <c:forEach var="attach" items="${item.attachs}">
                <div class="col">
                    <img class="product_img_etc" src="/loadImg/${attach.filename}">
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="product_info">
        <div class="item_name">
            <p>제품명 : ${item.name}</p>
            <input id="gaguId" type="hidden" value="${item.id}">
        </div>
        <div class="item_price">
            <span>${item.price}원</span>
        </div>
        <hr class="info_hr">
        <div class="product_count">
            <button type="button" class="count_button plu"> > </button>
            <span class="product_count_num" data-count="1">1</span>
            <button type="button" class="count_button miu"> < </button>
        </div>
        <div class="product_total_price">
            <b>총 구매가</b>
            <span data-price="${item.price}">${item.price}원</span>
        </div>
        <hr class="info_hr">
        <div class="product_buttons">
                <button type="button" class="btn btn-danger buy_button"
                        data-gaguid="${item.id}"
                        data-gaguimg="${item.gaguImg}"
                        data-name="${item.name}"
                        data-price="${item.price}">결제하기</button>
                <button type="button" class="btn btn-secondary cart_button">장바구니에 담기</button>
        </div>
        <div class="etc_button">
            <%--좋아요(하트)버튼--%>
            <button type="button" class="btn ${item.wishId == 0 ? "add_like_button btn-secondary" : "delete_like_button btn-danger"}">
                <i class="bi bi-suit-heart fs-3"></i>
            </button>
            <%--공유하기버튼--%>
            <button type="button" class="btn btn-secondary share_button">
                <i class="bi bi-share-fill fs-3"></i>
            </button>
        </div>
    </div>
    <%--댓글--%>
    <c:forEach var="review" items="${reviewList}">
    <hr>
        <div class="row review-box">
            <div class="col-3">
                <c:if test="${review.reviewImg != null}">
                    <img class="review-img" src="/loadImg/${review.reviewImg}">
                </c:if>
            </div>
            <div class="col review-comment">
                <div class="star-wrapper">
                  <c:choose>
                      <c:when test="${review.reviewStar == 1}"><span>⭐</span></c:when>
                      <c:when test="${review.reviewStar == 2}"><span>⭐⭐</span></c:when>
                      <c:when test="${review.reviewStar == 3}"><span>⭐⭐⭐</span></c:when>
                      <c:when test="${review.reviewStar == 4}"><span>⭐⭐⭐⭐</span></c:when>
                      <c:when test="${review.reviewStar == 5}"><span>⭐⭐⭐⭐⭐</span></c:when>
                  </c:choose>
                </div>
                <div style="width: 530px;">
                    ${review.comment}
                </div>

            </div>
            <div class="col col-lg-3 review-detail">
                <span>
                ${review.memberId} |
                <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${review.regDate}" />
                </span>
                <c:if test="${sessionScope.member.id == review.memberId}">
                    <a href="/gagu/updateReview/${review.id}/${review.memberId}" data-bs-toggle="modal" data-bs-target="#staticBackdrop${review.id}">수정</a>
                    <a href="/gagu/deleteReview/${review.id}/${review.memberId}/${review.gaguId}">삭제</a>
                </c:if>
            </div>
        </div>
        <hr>

        <!-- 댓글 Modal -->
        <div class="modal fade" id="staticBackdrop${review.id}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel${review.id}">리뷰 수정</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form id="reviewUpdate_form" method="post" action="/gagu/updateReview">
                        <div class="modal-body">
                            <input type="hidden" name="gaguId" value="${review.gaguId}">
                            <input type="hidden" name="id" value="${review.id}">
                            <input type="hidden" name="memberId" value="${review.memberId}">
                            <div class="form-floating mb-3">
                                <textarea class="form-control review_comment" id="floatingTextarea" name="comment" style="height: 400px; resize: none;">${review.comment}</textarea>
                                <label for="floatingTextarea">최대 370자까지 가능</label>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                            <button type="button" class="btn btn-primary updateReview_button">수정</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </c:forEach>
</div>



<!-- Footer-->
<footer class="py-5" style="background-color: #EBE1D7;">
    <div class="container"><p class="m-0 text-center" style="color: #525252;">Daejeon Polytechnic &reg; HongSeongMin</p></div>
</footer>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>
<script src="/js/info.js"></script>
</body>
</html>
