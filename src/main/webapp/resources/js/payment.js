
const gaguArr = JSON.parse(sessionStorage.getItem("gaguArr"));
// 페이지 로드 시 상품 목록 불러오기
$(function (){
    // sessionStorage.removeItem("gaguArr");
    gaguArr.forEach((i) => {
        $('tbody').append(
            '<tr>' +
            '<td><img src="/loadImg/' + i.gaguImg + '"/></td>' +
            '<td>' + i.name + '</td>' +
            '<td>₩ ' + i.price + '</td>' +
            '<td>' + i.cartCount + '</td>' +
            '<td >₩ ' + i.price * i.cartCount + '</td>' +
            '</tr>'
        );
    });
});

// 주소찾기 눌렀을 때
function addressSearch() {
    new daum.Postcode({
        oncomplete: function(data){
            let roadAddr = data.roadAddress;

            document.getElementById('address').value = roadAddr;
        }
    }).open();
}
//결제하기 버튼 눌렀을 때
$('.payment_button').click(function (){
    if($('#address').val() != '' && $('#address').val() != null){
        if($('#addressDetail').val() != '' && $('#addressDetail').val() != null){
            //주소 정보 저장
            const address = $('#address').val();
            const addressDetail = $('#addressDetail').val();
            //상품정보 저장
            for (const item of gaguArr) {
                $.ajax({
                    type: 'POST',
                    url : '/order/payment',
                    data : {
                        'gaguId' : item.id,
                        'count' : item.cartCount,
                        'price' : item.price,
                        'total' : item.price * item.cartCount,
                        'cartId' : item.cartId,
                        'address' : address,
                        'addressDetail' : addressDetail
                    },
                    success : data =>{
                        if (data == 'OK') {
                            location.href = "/";
                        } else {
                            alert("삭제실패");
                        }
                    }
                });
            }
        }else{
            alert("상세주소를 입력해 주세요");
            return;
        }
    }else{
        alert("주소를 입력해 주세요");
        return;
    }
});