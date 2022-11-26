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
    console.log($('#keyword').val());
    if($('#name').val() == '' || $('#name').val() == null){
        alert("제품명을 입력해주세요");
        return;
    }
    if($('#price').val() == null || $('#price').val() == ''){
        alert("가격을 입력해주세요");
        return;
    }
    if($('#price').val() <= 10000 || $('#price').val() >= 10000000){
        alert("상품가격은 최소 10000 ~ 10000000입니다");
        return;
    }
    if($('#keyword').val() == null || $('#keyword').val() == ''){
        alert("카테고리를 선택해주세요");
        return;
    }
    if($('#file').val() == null || $('#file').val() == ''){
        alert("메인 사진을 넣어주세요");
        return;
    }
    //서브사진이 3개 이하시  submit
    if($('#attachs').find('.attach').length > 3){
        alert("서브 사진은 최대 3장 입니다");
        return;
    }
    $('#add_form').submit();
});




