$('#add').click(function (){
    $('#attachs').append(`<div class="input-group mb-3">
                     <input type="file" name="attach" class="form-control form-control-sm">
                     <button class="delete" type="button">삭제</button>
                        </div>`)
});

$('#attachs').on('click', '.delete', function (){
    $(this).closest('.input-group').remove();
});