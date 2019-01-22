function login(btn){
	var http = new XMLHttpRequest();
	var valueBtn = btn.value;
	var role = document.getElementById('role').value;
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	if(username!="" && password!=""){
		http.onreadystatechange = function (){
			if(this.status==200 && this.readyState==4){
				myFunction(this);
			}
		}
		var url = valueBtn + "?username="+username+"&password="+password+"&role="+role;
		console.log(url);
		http.open("Get",url,true);
		http.send();
	}else{
		if(username==""){
			document.getElementById('error_user').style.display="block";
			document.getElementById('username').focus();
			return;
		}
		if(username!=""){
			document.getElementById('error_user').style.display="none";
		}
		if(password!=""){
			document.getElementById('error_pass').style.display="none";
		}
		if(password==""){
			document.getElementById('error_pass').style.display="block";
			document.getElementById('password').focus();
			return;
		}
	}
}
function myFunction(http){
	var resp = http.response;
	if(resp.length==0){
		document.getElementById('error_user').style.display="none";
		document.getElementById('error_pass').style.display="none";
		document.getElementById('error').style.display = "inline";
		document.getElementById('username').value = "";
		document.getElementById('username').focus();
		document.getElementById('password').value = "";
	}else{
		window.location.reload(false);
	}
}

//Hidden and show payment_info
function paymentShow(){
	if(document.getElementById('bangthe').checked){
		document.getElementById('payment').style.display="table-row";
	}else{
		document.getElementById('payment').style.display="none";
	}
}

//Add info of customer follow user
function checkAddInfo(){
	var name = document.getElementById('name'); 
	var email = document.getElementById('email');
	var address = document.getElementById('address');
	if(document.getElementById('checkbox_addinfo').checked){
		var username = document.getElementById('nameuser').value;
		var namec = document.getElementById('namec').value;
		var emailc = document.getElementById('emailc').value;
		var addressc = document.getElementById('addressc').value;
		name.value = namec;
		email.value= emailc;
		address.value=addressc;
	}else{
		name.value="";
		email.value="";
		address.value="";
	}
}