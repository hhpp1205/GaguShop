$('.login').click(function (){
    $.ajax({
        type : "POST",
        url : "/login",
        cache : false,
        data : {
            "id" : $('#id').val(),
            "pwd" : $('#pwd').val()
        },
        success : function (data){
            if(data == "OK"){
                alert("로그인성공.");
                location.href = "../..";
            }
            if(data == "NO"){
                alert("로그인정보가 일치하지 않습니다.");
                location.replace("login");
            }
        }
    });
});