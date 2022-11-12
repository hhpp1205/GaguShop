
$('.wish_delete_button').click(function (){
    const gaguId = $(this).data('id');

    $.ajax({
        type : "POST",
        url : "/gagu/deleteWish",
        data : {
            "gaguId" : gaguId,
        },
        success : data =>{
            if (data == "delete") {
                $(this).closest('tr').remove();
                return;
            } else {
                alert("위시 삭제에 실패하였습니다.");
                return;
            }
        }
    })



})