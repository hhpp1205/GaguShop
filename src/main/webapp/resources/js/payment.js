function addressSearch() {
    new daum.Postcode({
        oncomplete: function(data){
            let roadAddr = data.roadAddress;

            document.getElementById('address').value = roadAddr;
        }
    }).open();
}