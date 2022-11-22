$('#review-submit-button').click(function (){
    let textCnt = $('#floatingTextarea').val().length;
    if(textCnt <= 370){
        $('#review-form').submit();
    }else {
        alert("최대 글자 수 370자를 초과 했습니다. 현재 글자수 : " + textCnt + "자");
    }
});