// 상품 이미지 변경 시작
$('.img_wrapper').click(function (e){
    $('.product_mainImg').attr("src", $(e.target).attr("src"));
});

//상품 주문 갯수
let countProduct = 1;
//총 구매가
let totalPrice = 0;

// 상품 주문갯수 감소 버튼
$('.miu').click(function (){
    if(countProduct > 1){
        countProduct = countProduct - 1;
        $('.product_count_num').attr('data-count',countProduct);
        $('.product_count_num').text(countProduct);
    }else{
        alert("상품 주문갯수는 최소 1개 입니다");
    }
});
// 상품 주문갯수 증가 버튼
$('.plu').click(function (){
        countProduct = countProduct + 1;
        $('.product_count_num').attr('data-count',countProduct);
        $('.product_count_num').text(countProduct);
});
//최종금액 증감 메소드
$('.count_button').click(function (){
    totalPrice = $('.product_total_price span').data("price");

   totalPrice = totalPrice * countProduct;

    $('.product_total_price span').text(totalPrice + "원");
});

//결제하기
$('.buy_button').click(function (){
    let gaguArr = [];

    const gaguId = $(this).data("gaguid");
    const gaguImg = $(this).data("gaguimg");
    const name = $(this).data("name");
    const count = countProduct;
    const price = $(this).data("price");

    const gagu = {
        'id' : gaguId,
        'name' : name,
        'price' : price,
        'gaguImg' : gaguImg,
        'cartCount' : count,
    }
    gaguArr.push(gagu);
    sessionStorage.setItem("gaguArr", JSON.stringify(gaguArr));
    location.href = "/order/payment";
});

//장바구니 버튼 기능
$('.cart_button').click(function (){
    $.ajax({
        type : "POST",
        url : "/gagu/addCart",
        data : {
            "gaguId" : $('#gaguId').val(),
            "count" : countProduct
        },
        success : function (data) {
            if(data == "add"){
                alert("장바구니에 추가되었습니다");
            }else if(data == "alreadyExist") {
                alert("이미 장바구니에 존재하는 상품 입니다");
            }else {
                console.log(data);
                alert("로그인후 이용해 주세요");
                location.href = "/login";
            }
        }
    });
});

//좋아요add 버튼 기능
$('.etc_button').on('click', '.add_like_button', function (e){
    const button = $(e.target).closest('.etc_button').find('.add_like_button');

    $.ajax({
        type : "POST",
        url : "/gagu/addWish",
        data : {
            "gaguId" : $('#gaguId').val()
        },
        success : function (data) {
            if (data == "add") {
                $(button).removeClass("btn-secondary");
                $(button).addClass("btn-danger");
                $(button).removeClass("add_like_button");
                $(button).addClass("delete_like_button");
            }else{
                location.href = "/login";
            }
        }
    });
});
//좋아요delete 버튼 기능
$('.etc_button').on('click', '.delete_like_button', function (e){
    const button = $(e.target).closest('.etc_button').find('.delete_like_button');
    console.log(button);

    $.ajax({
        type : "POST",
        url : "/gagu/deleteWish",
        data : {
            "gaguId" : $('#gaguId').val()
        },
        success : function (data) {
            if(data == "delete") {
                $(button).removeClass("btn-danger");
                $(button).addClass("btn-secondary");
                $(button).removeClass("delete_like_button");
                $(button).addClass("add_like_button");
            }
        }
    });
});

//좋아요 버튼 클릭시 로그인전 로그인 알림
$('.like_button').click(function (){
   if($(this).hasClass("beforeLogin")){
       alert("로그인후 이용해 주세요");
   }
});

//공유 버튼 클릭시
$('.share_button').click(function (){
    let url = '';
    const textarea = document.createElement("textarea");
    document.body.appendChild(textarea);
    url = window.document.location.href;
    textarea.value = url;
    textarea.select();
    document.execCommand("copy");
    document.body.removeChild(textarea);
    alert("URL이 복사되었습니다.");
});
//ReviewUpdate시 글자 수 검사
$('.updateReview_button').click(function (){
     const form = $(this).closest("form");
    const textCnt = $(form).find("textarea").val().length;

    if(textCnt <= 370 && textCnt > 0){
        form.submit();
    }else {
        if(textCnt <= 0) {
            alert("최소 글자 수 1자 이상 입력해 주세요");
        }else{
            alert("최대 글자 수 370자를 초과 했습니다 현재 글자수 : " + textCnt + "자");
        }
    }
});




