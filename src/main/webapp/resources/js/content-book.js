function addCart(b){
	var http = new XMLHttpRequest();
	var url = b.value;
	http.onreadystatechange = function(){
		if(this.status==200 && this.readyState==4){
			alert('Thêm giỏ hàng thành công');
		}
	}
	http.open('Get',url,true);
	http.send();
}