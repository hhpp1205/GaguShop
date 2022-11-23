$('#review-submit-button').click(function (){
    let textCnt = $('#floatingTextarea').val().length;
    if(textCnt <= 370 && textCnt > 0){
        $('#review-form').submit();
    }else {
        if(textCnt <= 0) {
            alert("최소 글자 수 1자 이상 입력해 주세요");
        }else{
            alert("최대 글자 수 370자를 초과 했습니다 현재 글자수 : " + textCnt + "자");
        }
    }
});