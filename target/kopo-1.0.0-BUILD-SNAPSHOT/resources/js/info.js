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
   $.ajax({
       type : "POST",
       url : "/order/",
       data : {
            "count" : $('.product_count_num').data("count"),
            "gaguId" : $('#gaguId').val()
       },
       success : function (data){
           console.log(data);
       }
   })
});

//장바구니 버튼 기능
$('.cart_button').click(function (){
    $.ajax({
        type : "POST",
        url : "/gagu/addCart",
        data : {
            "gaguId" : $('#gaguId').val()
        },
        success : function (data) {
            if(data == "add"){
                alert("장바구니에 추가되었습니다")
            }else {
                alert("이미 장바구니에 존재하는 상품 입니다")
            }
        }
    });
});

//좋아요 버튼 기능
$('.like_button').click(function (){
    $.ajax({
        type : "POST",
        url : "/gagu/wish",
        data : {
            "gaguId" : $('#gaguId').val()
        },
        success : function (data) {
            console.log(data);

            if(data == "add"){
                $('.like_button').removeClass("btn-secondary");
                $('.like_button').addClass("btn-danger");
            }else {
                $('.like_button').removeClass("btn-danger");
                $('.like_button').addClass("btn-secondary");
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
    alert("URL이 복사되었습니다.")
})



