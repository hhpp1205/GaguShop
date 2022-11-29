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


    if(totalBox == checkedBox){
        $("#allCheck").prop("checked", true);
    }else {
        $("#allCheck").prop("checked", false);
    }
});
//단일 상품 주문하기 버튼
$('.addOrder_button').click(function (){
    let gaguArr = new Array();

    const gaguId = $(this).data("gaguid");
    const gaguImg = $(this).data("gaguimg");
    const name = $(this).data("name");
    const count = $(this).data("count");
    const price = $(this).data("price");
    const cartId = $(this).data("cartid");

    const gagu = {
        'id' : gaguId,
        'name' : name,
        'price' : price,
        'gaguImg' : gaguImg,
        'cartCount' : count,
        'cartId' : cartId
    }
    gaguArr.push(gagu);

    sessionStorage.setItem("gaguArr", JSON.stringify(gaguArr));
    location.href = "/order/payment";
});

//전체주문 버튼 눌렀을 때
$('.orderButton_wrapper .allOrder_button').click(function (){
    let gaguArr = new Array();

    $('input:checkbox[name="chbox"]').each(function (){
        const tr = $(this).closest("tr");
        const gaguId = tr.find('.addOrder_button').data("gaguid");
        const gaguImg = tr.find('.addOrder_button').data("gaguimg");
        const name = tr.find('.addOrder_button').data("name");
        const count = tr.find('.addOrder_button').data("count");
        const price = tr.find('.addOrder_button').data("price");
        const cartId = tr.find('.addOrder_button').data("cartid");

        const gagu = {
            'id' : gaguId,
            'name' : name,
            'price' : price,
            'gaguImg' : gaguImg,
            'cartCount' : count,
            'cartId' : cartId
        }
        gaguArr.push(gagu);

        console.log(cartId);
    });
    sessionStorage.setItem("gaguArr", JSON.stringify(gaguArr));
    location.href = "/order/payment";
});

//선택상품 주문 눌렀을 때
$('.orderButton_wrapper .selectOrder_button').click(function (){
    let gaguArr = [];

    $('input:checkbox[name="chbox"]').each(function (){
        if( this.checked ==true){
            const tr = $(this).closest("tr");
            const gaguId = tr.find('.addOrder_button').data("gaguid");
            const gaguImg = tr.find('.addOrder_button').data("gaguimg");
            const name = tr.find('.addOrder_button').data("name");
            const count = tr.find('.addOrder_button').data("count");
            const price = tr.find('.addOrder_button').data("price");
            const cartId = tr.find('.addOrder_button').data("cartid");

            const gagu = {
                'id' : gaguId,
                'name' : name,
                'price' : price,
                'gaguImg' : gaguImg,
                'cartCount' : count,
                'cartId' : cartId
            }
            gaguArr.push(gagu);
        }
    });
    sessionStorage.setItem("gaguArr", JSON.stringify(gaguArr));
    location.href = "/order/payment";
});

//장바구니 삭제 버튼 눌렀을 때
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
    });

})






