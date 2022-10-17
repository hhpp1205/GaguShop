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
       // cache : false,
       data : {
            "count" : $('.product_count_num').data("count"),
            "gaguId" : $('#gaguId').val()
       },
       success : function (data){
           console.log(data);
       }
   })
});


