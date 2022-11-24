$('.find_pwd').click(function (){

    console.log($('#pwd').val().length);
    console.log($('#pwdCheck').val().length);

    if ($('#pwd').val().length <= 3 || $('#pwdCheck').val().length <= 3) {
        alert('비밀번호는 최소 4자 이상 입력해 주세요');
        return;
    }
   if($('#pwd').val() != $('#pwdCheck').val()){
       alert('새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다');
       return;
   }
     $('#contentBox').submit();
});