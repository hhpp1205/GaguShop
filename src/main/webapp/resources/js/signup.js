let okId = null;

function checkValue(){
    const form = $('.signup-form');
    if(okId == null || okId != $('#id').val()){
        alert("중복확인을 해주세요.");
        return;
    }
    if($('#id').val() == ""){
        alert("아이디를 입력하세요.");
        return;
    }
    if($('#pwd').val() == ""){
        alert("비밀번호를 입력하세요.");
        return;
    }
    if($('#pwd').val() != $('#pwdCheck').val()){
        alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
        return;
    }
    if($('#name').val() == "") {
        alert("이름을 입력하세요.");
        return;
    }
    form.submit();
    return;
}

    $('#checkId').click(function (){
        if ($('#id').val() == null || $('#id').val() == '') {
            alert("아이디를 입력하세요.");
            return;
        }

        $.ajax({
            type : "POST",
            url : "/checkId",
            cache : false,
            data : {
                "id" : $("#id").val()
            },
            success : function (data){
                if(data == "OK"){
                    console.log(data);
                    okId = $('#id').val();
                    alert("사용 가능한 아이디 입니다");
                }else{
                    console.log(data);
                    alert("사용 불가능한 아이디 입니다");
                }
            }
        }) ;
    });