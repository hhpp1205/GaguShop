$('#add').click(function (){
    $('#attachs').append(`<div class="input-group mb-3">
                     <input type="file" name="attach" class="form-control form-control-sm attach">
                     <button class="delete" type="button">삭제</button>
                        </div>`)
});

$('#attachs').on('click', '.delete', function (){
    $(this).closest('.input-group').remove();
});


//서브사진 4개 미만으로 보내야함
$('.mt-3 .update_button').click(function (){

    //서브사진이 4개 미만일때
    if($('#attachs').find('.attach').length <= 3){
        $('#update_form').submit();
    //서브사진이 4개 미만이 아닐 때
    }else {
        alert("서브 사진은 최대 3장 입니다");
    }

});