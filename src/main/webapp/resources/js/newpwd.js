$('.find_pwd').click(function (){
   if($('#pwd').val() == $('#pwd_check').val()){
       $('#contentBox').submit();
   } else{
       alert('새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.');
   }
});