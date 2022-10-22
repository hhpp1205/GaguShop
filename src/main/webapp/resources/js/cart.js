//전체 선택 체크박스 눌렀을 떄
$('#allCheck').click(function (){
    let select = $("#allCheck").is(":checked");

    if(select){
        $('input:checkbox[name="chbox"]').prop("checked", true);
    }else {
        $('input:checkbox[name="chbox"]').prop("checked", false);
    }
});
//상품 하나의 체크박스 눌렀을 때
$('.oneCheck').click(function (){
    const totalBox = $('input:checkbox[name="chbox"]').length;
    let checkedBox = $('input:checkbox[name="chbox"]:checked').length;

    console.log("totalBox = " + totalBox);
    console.log("checkBox = " + checkedBox);

    if(totalBox == checkedBox){
        $("#allCheck").prop("checked", true);
    }else {
        $("#allCheck").prop("checked", false);
    }
});
//단일 상품 주문하기 버튼
$('.addOrder_button').click(function (){
    const count = $(this).data("count");
    const price = $(this).data("price");
    const total = $(this).data("total");
    const gaguid = $(this).data("gaguid");

    console.log("count = " + count);
    console.log("price = " + price);
    console.log("total = " + total);
    console.log("gaguId = " + gaguid);



    $("li.item-a").closest("ul").css("background-color", "red");

    $.ajax({
        type : "POST",
        url : "/order/",
        data : {
            "count" : count,
            "price" : price,
            "total" : total,
            "gaguId" : gaguid
        },
        success : function (data) {
            if(data == "OK"){
                alert("주문이 완료 되었습니다");
                location.replace("/gagu/cart");
            }else {
                alert("주문에 실패 했습니다");
            }
        }
    });
});






