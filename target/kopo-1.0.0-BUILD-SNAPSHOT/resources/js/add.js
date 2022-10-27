$('#add').click(function (){
    $('#attachs').append(`<div class="input-group mb-3">
                     <input type="file" name="attach" class="form-control form-control-sm attach">
                     <button class="delete" type="button">삭제</button>
                        </div>`)
});

$('#attachs').on('click', '.delete', function (){
    $(this).closest('.input-group').remove();
});


//등록 버튼 눌렀을때
$('.add_button').click(function (){

    //서브사진이 4개 미만일때
    if($('#attachs').find('.attach').length <= 3){
        $('#add_form').submit();
        //서브사진이 4개 미만이 아닐 때
    }else {
        alert("서브 사진은 최대 3장 입니다");
    }
});




