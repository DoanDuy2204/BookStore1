/**
 * 
 */
var username = document.getElementById("userName");
username.addEventListener('blur',function (){
	var http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(this.readyState==4 && this.status==200){
			myfunction(this);
		}
	}
	http.open("Get","/BookStore1/api/user/check/"+username.value,true);
	http.send();
	},true
);
function myfunction(resp){
	var check = JSON.parse(resp.response);
	if(check){
		username.focus();
		document.getElementById('userError').style.display="table-row";
		return false;
	}
	else{
		document.getElementById('userError').style.display="none";
		return true;
	}
}
var customerNameError = document.getElementById("customer.name.errors");
var userNameError = document.getElementById("userName.errors");
var passwordError = document.getElementById("password.errors");
var emailError = document.getElementById("customer.email.errors");
var addressError = document.getElementById("customer.address.errors");

var customerName = document.getElementById("customer.name");
var userName = document.getElementById("userName");
var password = document.getElementById("password");
var email = document.getElementById("customer.email");
var address = document.getElementById("customer.address");

customerName.addEventListener('blur',function(){
	if(customerName.value!="")	customerNameError.style.display = "none";
},true);
userName.addEventListener('blur',function(){
	if(userName.value!="") userNameError.style.display = "none";
},true);
password.addEventListener('blur',function(){
	if(password.value!="")	passwordError.style.display = "none";
},true);
email.addEventListener('blur',function(){
	if(email.value!="") emailError.style.display = "none";
},true);
address.addEventListener('blur',function(){
	if(address.value!="")	addressError.style.display = "none";
},true);