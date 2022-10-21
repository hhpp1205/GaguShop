// 비밀번호찾기 눌렀을때
$('.find-pwd').on('click', function (){
    $('.find-id').removeClass('select');
    $('.find-pwd').addClass('select');
    $('#find-account').attr("action", "findPwd");

    $('#test').html("");
    $('#test').append(`
          <label for="id">아이디</label>
          <input type="text" id="id" name="id" placeholder="아이디를 입력해 주세요">
          <label for="name">이름</label>
          <input type="text" id="name" name="name" placeholder="이름을 입력해 주세요">
          <label for="phoneNumber">전화번호</label>
          <input type="text" id="phoneNumber" name="phoneNumber" placeholder="전화번호를 입력해 주세요(-없이)">
          <button type="button" class="findPwd_button">비밀번호 찾기</button>`);
});

// 아이디찾기 눌렀을때
$('.find-id').on('click', function (){
    $('.find-pwd').removeClass('select');
    $('.find-id').addClass('select');
    $('#find-account').attr("action", "findId");

    $('#test').html("");
    $('#test').append(`
      <label for="name">이름</label>
      <input type="text" id="name" name="name" placeholder="이름을 입력해 주세요">
      <label for="phoneNumber">전화번호</label>
      <input type="text" id="phoneNumber" name="phoneNumber" placeholder="전화번호를 입력해 주세요(-없이)">
      <button type="button" class="findId_button">아이디 찾기</button>`);
});

//버튼 타입 변경 하기 submit button

//아이디 찾기 (버튼) 눌렀을때
$('#find-account').on('click', '.findId_button', function (){
       $.ajax({
           type : "POST",
           url : "/findIdCheck",
           cache : false,
           data : {
               "name" : $('#name').val(),
               "phoneNumber" : $('#phoneNumber').val()
           },
           success : function (data){
               if(data == "OK"){
                   $("#find-account").submit();
               }
               if(data == "NO"){
                   alert("정보가 일치하는 아이디가 없습니다");
               }
           }
       });
   });

//비밀번호 찾기 (버튼) 눌렀을때
$('#find-account').on('click', '.findPwd_button', function (){
    $.ajax({
        type : "POST",
        url : "/findPwdCheck",
        cache : false,
        data : {
            "id" : $('#id').val(),
            "name" : $('#name').val(),
            "phoneNumber" : $('#phoneNumber').val()
        },
        success : function (data){
            if(data == "OK"){
                $("#find-account").submit();
            }
            if(data == "NO"){
                alert("정보가 일치하지 않습니다");
            }
        }
    });
});
