//전체 선택 체크박스 눌렀을 떄
$('#allCheck').click(function (){
    // let select = $('input:checkbox[id="allCheck"]').is(":checked");
    //
    // if(select){
    //     $('input:checkbox[name="chbox"]').attr("checked", true);
    // }else {
    //     $('input:checkbox[name="chbox"]').attr("checked", false);
    // }

    let select = $("#allCheck").is(":checked");

    if(select){
        $('input:checkbox[name="chbox"]').prop("checked", true);
    }else {
        $('input:checkbox[name="chbox"]').prop("checked", false);
    }
});

$('.oneCheck').click(function (){
    const totalBox = $('input:checkbox[name="chbox"]').length;
    let checkedBox = $('input:checkbox[name="chbox"]:checked').length;

    console.log("totalBox = " + totalBox);
    console.log("checkBox = " + checkedBox);

    if(totalBox == checkedBox){
        $("#allCheck").prop("checked", true);
    }else {
        $("#allCheck").prop("checked", false);
    }
});