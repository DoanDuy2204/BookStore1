//Use ajax Change quantity of Order
function change(btn){
	var http = new XMLHttpRequest();
	var url = btn.value;
	http.onreadystatechange = function (){
		if(this.status==200 && this.readyState==4){
			myFunction(this);
		}
	}
	http.open('Get',url,true);
	http.send();
}
function myFunction(resp){
	var order = JSON.parse(resp.response);
	var id = order.id;
	var inputPaymoney = document.getElementById('valuepaymoney');
	var inputAmountOld = document.getElementById("amountOld" + id);
	var paymoneyNew = inputPaymoney.value - inputAmountOld.value + order.amount;
	if(order.quantity==0)
		document.getElementById("order"+id).innerHTML="";
	else {
		document.getElementById("quantity" + id).innerHTML = order.quantity;
		document.getElementById("amount" + id).innerHTML = order.amount.toLocaleString();
	}
	if (paymoneyNew == 0) {
		document.getElementById('tablecart').innerHTML = "<p  style='color: white; font-size: 18px; padding: 1.5em;''> " +
				"											* Không có sản phẩm nào trong giỏ hàng.</p>";
	} else {
		document.getElementById('paymoney').innerHTML = paymoneyNew.toLocaleString();
		inputPaymoney.value = paymoneyNew;
		inputAmountOld.value = order.amount;
	}
}
