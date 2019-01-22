
//Use window.load 
window.addEventListener('load',
	function(){
		loadTrend();
		loadCategory();
		loadPublishingHouse();
	},false);

// Use Ajax
//Nunber page of Trend when load
var numPageTrend = 1;
var checkLoad;
function loadTrend(){
	checkLoad = 0;
	var http = new XMLHttpRequest();
	http.onreadystatechange = function(){
	if(this.readyState==4 && this.status==200)
		myFunction(this,1);
	}
	http.open("Get","/BookStore1/api/getBookTrend?d="+numPageTrend,true);
	http.send();
}

//Use Ajax get Book by Category
//Nunber page of Category when load
var numPageCategory = 1;
var checkLoad1;
function loadCategory(){
	var http = new XMLHttpRequest();
	checkLoad1=0;
	http.open("Get","/BookStore1/api/getBookByCategory?numberPage="+numPageCategory,true);
	http.onreadystatechange = function (){
		if(this.readyState==4 && this.status==200){
			myFunction(this,2);
		}
	}
	http.send();
}

//Use Ajax get Book by PublishingHouse
//Nunber page of PublishingHouse when load
var numPagePublishingHouse = 1;
var checkLoad2;
function loadPublishingHouse(){
	var http = new XMLHttpRequest();
	checkLoad2=0;
	http.open("Get","/BookStore1/api/getBookByPublishingHouse?numberPage="+numPagePublishingHouse,true);
	http.onreadystatechange = function (){
		if(this.readyState==4 && this.status==200){
			myFunction(this,3);
		}
	}
	http.send();
}

//Get response to print 
function myFunction(resp,ref){
	var arr = JSON.parse(resp.response);
	if(ref==1){
		++numPageTrend;
		if(arr.length==0){	numPageTrend = 1;loadTrend();return;}
		if(arr.length<6 || numPageTrend==4) numPageTrend=1;
		var div = document.getElementById('btn-noibat');
		var content = "";
	}
	if(ref==2){
		++numPageCategory;
		if(arr.length==0){	numPageCategory = 1;loadCategory();return;}
		if(arr.length<10 || numPageCategory==3) numPageCategory=1;
		var div = document.getElementById('category-right');
		var content = "<div>";
		var count = 0;
	}
	if(ref==3){
		++numPagePublishingHouse;
		if(arr.length==0){	numPagePublishingHouse = 1;loadPublishingHouse();return;}
		if(arr.length<10 || numPagePublishingHouse==3) numPagePublishingHouse=1;
		var div = document.getElementById('publishinghouse-right');
		var content = "<div>";
		var count = 0;
	}
	for(b of arr){
		var image = "<div><img src='/BookStore1/resources/image/books/"+b.image+"'></img>";
		var name = "<h4><a>"+b.name+"</a></h4>";
		var price = "<p>"+(b.price-(b.price*b.discount/100)).toLocaleString()+"<sup>vnđ</sup>" +
					"<span><s>"+b.price.toLocaleString()+"</s><sup>vnđ</sup></span></p>";
		var f = 0;
		var star = "";
		if(b.star%1!=0){
			star += "<i class='fas fa-star-half-alt'></i>";
			f = 0.5;
		}
		for(var check=0;check<(b.star-f);check++){
			star +=  "<i class='fas fa-star'></i>";
		}
		for(var check=0;check<(5-b.star-f);check++){
			star +=  "<i class='far fa-star'></i>";
		}
		if(ref==1 || ref==2){
			count++;
			if(count==5){
				content += "</div><div>";
			}
		}
		var cart = "<button onclick='addCart(this)' value='/BookStore1/api/cart/"+b.id+"'>Thêm vào giỏ hàng</button>";
		content += image + name + price + "<p>"+star + "<p>"+cart +"</div>";
	}
	div.innerHTML = content + "<button  onclick='load"+ref+"(this)'>Xem thêm >> </button>";
}

//User ajax get ALL book by View, Discount,soldNumber
var k = 1;
var btnLoadTrend,btnLoadCategory,btnLoadPublishing;
function check(btn,ref,ch){
	if(ref==1){ checkLoad = 1;btnLoadTrend=btn; }
	if(ref==2){checkLoad1 = 1;btnLoadCategory=btn;}
	if(ref==3){checkLoad2 = 1;btnLoadPublishing=btn;}
	if(ch==1 || ch==2 || ch==3)
		k = 1;
	else
		k++;
	console.log(k);
	var http = new XMLHttpRequest();
	var arr = [];
	http.onreadystatechange = function (){
		if(http.readyState==4 && http.status==200){
			arr = JSON.parse(this.response);
			myFunction(this,ref);
		}
	}
	http.open("Get",btn.value+"numberPage="+k);
	http.send();
	k++;
	if((ref==3 || ref==2)&& arr.length<10 && arr.length!=0)
		k=1;
	if((ref==1 && arr.length<6 && arr.length!=0))
		k=1;
	if(k==4)
		k=1;
}

//Load book countinue
function load1(btn){
	if(checkLoad==0) loadTrend();
	else check(btnLoadTrend,1,0);
}
function load2(btn){
	if(checkLoad1==0) loadCategory();
	else check(btnLoadCategory,2,0);
}
function load3(btn){
	if(checkLoad2==0) loadPublishingHouse();
	else check(btnLoadPublishing,3,0);
}

//Add to cart 
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

