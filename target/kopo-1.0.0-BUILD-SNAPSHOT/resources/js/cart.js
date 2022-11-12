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
                location.href = "/gagu/cart";
            }else {
                alert("주문에 실패 했습니다");
            }
        }
    });
});

//전체주문 버튼 눌렀을 때
$('.orderButton_wrapper .allOrder_button').click(function (){

    $('input:checkbox[name="chbox"]').each(function (){
        const tr = $(this).closest("tr");
        const gaguId = tr.find('.addOrder_button').data("gaguid");
        const count = tr.find('.addOrder_button').data("count");
        const price = tr.find('.addOrder_button').data("price");
        const total = price * count;

        $.ajax({
           url:"/order/",
           method:"POST",
           data: {
               "gaguId" : gaguId,
               "count" : count,
               "price" : price,
               "total" : total
           },
            success: data => {
                console.log(data);
            }
        });
    });
        alert("주문이 완료 되었습니다");
        location.href = "/gagu/cart";
});

//선택상품 주문 눌렀을 때
$('.orderButton_wrapper .selectOrder_button').click(function (){

    $('input:checkbox[name="chbox"]').each(function (){
        if( this.checked ==true){
            const tr = $(this).closest("tr");
            const gaguId = tr.find('.addOrder_button').data("gaguid");
            const count = tr.find('.addOrder_button').data("count");
            const price = tr.find('.addOrder_button').data("price");
            const total = price * count;

            $.ajax({
                url:"/order/",
                method:"POST",
                data: {
                    "gaguId" : gaguId,
                    "count" : count,
                    "price" : price,
                    "total" : total
                },
                success: data => {
                    console.log(data);
                }
            });
        }
    });
    alert("주문이 완료 되었습니다");
    location.href = "/gagu/cart";
});

$('.delete_cart').click(function (){
    const cartId = $(this).data('cartid');

    $.ajax({
        type: 'POST',
        url : '/gagu/deleteCart',
        data : {
            'cartId' : cartId
        },
        success : data =>{
            if (data == 'OK') {
                $(this).closest('tr').remove();
            } else {
                alert("삭제실패");
            }
        }
    })

})






