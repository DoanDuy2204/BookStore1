//Declare variable
/**
 * This variable is used to check Element ul-down.
 */
var check = 0;
/**
 * This variable is used to check Element ul-down1.
 */
var check1 = 0;
/**
 * This method is used to check Element is block or none.
 * @param num 
 * 			if(num == 1) -> Element is ul-down
 * 			if(num == 2) -> Element is ul-down1
 */
function down(num) {
	if (num == 1) {
		if (check++ == 0)
			document.getElementById('ul-down').style.display = "block";
		else {
			check = 0;
			document.getElementById('ul-down').style.display = "none";
		}
	}
	if (num == 2) {
		if (check1++ == 0)
			document.getElementById('ul-down1').style.display = "block";
		else {
			check1 = 0;
			document.getElementById('ul-down1').style.display = "none";
		}
	}
}
/**
 * This variable is element button DashBoard in admin.jsp.
 */
var btnDashBoard = document.getElementById('btnDashboard');
var btnTransaction = document.getElementById('btnTransaction');
var btnUser = document.getElementById('btnUser');
/**
 * This function is used to load when web is opened.
 * @returns
 */
window.addEventListener('load',function(){
	onLoad(btnDashBoard,null,1,0);
},true)

/**
 * This function is used to Load data when click button in Admin.js.
 * @param btn : button is clicked in admin.jsp.
 * @param name : name is searched  if have. Default is Null.
 * @param check : variable is used to check when used funtion myFunction().
 * @param num : is number of pages.default is 1.
 * @returns
 */
function onLoad(btn,name,check,num){
	var http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(this.readyState==4 && this.status==200)
			myFunction(this,name,check,num);
	};
	http.open('Get',btn.value+(name==null?"":("&name="+name)),true);
	http.send();
}
/**
 * This function is used to process JSON when Ajax return.
 * @param resp : response of server when Ajax send request.
 * @param name : name of object search. Default is Null.
 * @param check : check in switch case.
 * @param num : number of Page.
 * @returns
 */
function myFunction(resp,name,check,num){
	var arr = JSON.parse(resp.response);
	switch(check){
		case 1:
			console.log(arr);
			dashBoard(arr);
			break;
		case 2:
			managerProduct(arr,num,name);
			break;
		case 3:
			managerTransaction(arr,num,name);
			break;
		case 4 :
			managerAccount(arr,num,name);
			break;
		case 5 :
			infoAdmin(arr);
			break;
	}
}

/**
 * This variable is used to get Element with Id 'bottom-content' in Admin.jsp.
 */
var btmContent = document.getElementById('bottom-content');
/**
 * This function is used to process response when convert Json->variable.
 * @param arr : result return of server.
 * @returns
 */
function dashBoard(arrDashBoard){
	var content = "<h2>Bảng điểu khiển</h2>";
	var i = 0;
	var graph = '';
	var arrMount = [];
	for(var data of arrDashBoard){
		var graphElem = '';
		if(i<3){
			var label = '';
			if(i==0) label = 'Số hóa đơn';
			if(i==1) label = 'Số lượt xem';
			if(i==2) label = 'Số kết nối';
			graphElem = '<div><h2>'+label
				+'</h2><p style="color: green;"><i  class="far fa-chart-bar"></i><span>'+
				data+'</div>';
		}else{
			arrMount.push(data);
		}
		graph += graphElem;
		i++;
	}
	content += '<div class="graph">'+graph+'</div>'+'<div class="chart"><canvas id="myChart"></canvas></div>';
	btmContent.innerHTML = content;
	console.log(arrMount);
	drawChart(arrMount);
}

/**
 * this function draw Chart. 
 * @param arr : result return of server.
 * @returns
 */
function drawChart(arrChart){
	var arrLabels = [];
	for(var i=0;i<12;i++)
		arrLabels.push('Tháng '+(i+1));
	var context = document.getElementById('myChart').getContext('2d');
	var chart = new Chart(context,{
		type : 'bar',
		data:{
			labels:arrLabels,
			datasets:[{
				label:'Doanh thu',
				data:arrChart,
				backgroundColor:'	rgb(255,0,0,0.6)',
				borderColor:'black',
				borderWidth:1
			}]
		},
		options:options = {
				scales:{
					yAxes:[{
						ticks:{
							beginAtZero:true
						}
					}],
					xAxes:[{
						barPercentage: 0.5
					}]
				}
		}
	});
}

/**
 * This functin is used to process result return of ajax.
 * With url='api/admin/product'.
 * @param arr : result return of server.
 * @param num
 * @param name
 * @returns
 */
function managerProduct(arrBook,num,name){
	var content = '<h2>Quản lí sản phẩm<input placeholder="Tìm tên sách..." type="text" id="search"/>'
		+'<button value="book" onclick="searchBook(\'book\')">Search</button></h2><hr>';
	if(arrBook.length==0){
		btmContent.innerHTML = content +  "<h2>không có sản phẩm nào.</h2>";
	}else{	
		var product = '<div class="product"><table  cellspacing="0"><tr>'+
				'<th>STT</th>'+
				'<th>Tên sản phẩm</th>'+
				'<th>Thể loại</th>'+
				'<th>Nhà sản xuất</th>'+
				'<th>Giá (vnđ)</th>'+
				'<th>Giảm giá</th>'+
				'<th>Ngày nhập</th>'+
				'<th>Số lượng</th>'+
				'<th>Bán được</th>'+
				'<th colspan="2">Edit</th></tr>';
		var i =(num-1)*15 + 1;
		for(var p of arrBook){
			var tr = '<tr><td>'+i+'</td>'+
				'<td>'+p.name+'</td>'+
				'<td>'+p.category.name+'</td>'+
				'<td>'+p.publishingHouse.name+'</td>'+
				'<td>'+p.price.toLocaleString()+'</td>'+
				'<td>'+p.discount+'</td>'+
				'<td>'+p.doc+'</td>'+
				'<td>'+p.quantity+'</td>'+
				'<td>'+p.soldNumber+'</td>'+
				'<td><button onclick="managerDelete(this,1)" value="/BookStore1/api/admin/product/delete/'+p.id+'">Delete</button></td>'+
				'<td><button onclick="managerUpdate(this,1)" value="/BookStore1/api/admin/product/'+p.id+'">Update</button></td>';
			product += tr;
			i++;
		}
		btmContent.innerHTML =content + product + '</table></div>'
		loadNumberPage(num,1,name);
	}
}

/**
 * This funtion is used to process List<Transaction> when server return.
 * @param arrTransaction : List<Transaction> of server return.
 * @param num : number of Page.
 * @param name : name of Transaction want to search.Default is Null.
 * @returns
 */
function managerTransaction(arrTransaction,numOfPage,name){
	var content = '<h2>Quản lí Hóa đơn<input placeholder="Tên tài khoản..." type="text" id="search"/>'
		+'<button onclick="searchBook(\'transaction\')">Search</button></h2><hr>';
	if(arrTransaction.length==0){
		btmContent.innerHTML = content + "<h2>không có hóa đơn nào.</h2>";
	}else{
		var transaction = '<div class="product"><table  cellspacing="0"><tr>'+
					'<th>STT</th>'+
					'<th>Mã đơn hàng</th>'+
					'<th>Tên khách hàng</th>'+
					'<th>Email</th>'+
					'<th>Số điện thoại</th>'+
					'<th>Địa chỉ</th>'+
					'<th>Số tiền</th>'+
					'<th>Thanh toán</th>'+
					'<th>Trạng thái</th>'+
					'<th>Ngày lập</th>'+
					'<th colspan="2">Edit</th></tr>';
		var i =(numOfPage-1)*15 + 1;
		for(var t of arrTransaction){
			var tr = '<tr><td>'+i+'</td>'+
				'<td>'+t.id+'</td>'+
				'<td>'+t.name+'</td>'+
				'<td>'+t.email+'</td>'+
				'<td>'+t.phone+'</td>'+
				'<td>'+t.address+'</td>'+
				'<td>'+t.amount+'</td>'+
				'<td>'+t.payment+'</td>'+
				'<td>'+t.status+'</td>'+
				'<td>'+t.doc+'</td>'+
				'<td><button onclick="managerDelete(this,2)" value="/BookStore1/api/admin/transaction/delete/'+t.id+'">Delete</button></td>'+
				'<td><button onclick="managerUpdate(this,1)" value="/BookStore1/api/admin/transaction/'+t.id+'">Update</button></td>';
			transaction += tr;
			i++;
		}
		btmContent.innerHTML =content + transaction + '</table></div>'
		loadNumberPage(numOfPage,2,name);
	}
}

/**
 * This funtion is used to process List<User> server return.
 * @param arrAccount : List<User>
 * @param numberOfPage : number of page.default is 1.
 * @param name : name of user want to search. Default is Null.
 * @returns
 */
function managerAccount(arrAccount,numOfPage,name){
	var content = '<h2>Quản lí Hóa đơn<input placeholder="Tên tài khoản..." type="text" id="search"/>'
		+'<button onclick="searchBook(\'user\')">Search</button></h2><hr>';
	if(arrAccount.length==0){
		var notice = "<h2>Không có Tài khoản nào.</h2>"
		btmContent.innerHTML = content + notice;
	}else{
		var transaction = '<div class="product"><table  cellspacing="0"><tr>'+
					'<th>STT</th>'+
					'<th>Tên tài khoản</th>'+
					'<th>Tên khách hàng</th>'+
					'<th>Email</th>'+
					'<th>Số điện thoại</th>'+
					'<th>Địa chỉ</th>'+
					'<th>Doc</th>'+
					'<th>Enable</th>'+
					'<th>Role</th>'
					'<th colspan="2">Edit</th></tr>';
		var i =(numOfPage-1)*15 + 1;
		for(var a of arrAccount){
			var tr = '<tr><td>'+i+'</td>'+
				'<td>'+a.userName+'</td>'+
				'<td>'+a.customer.name+'</td>'+
				'<td>'+a.customer.email+'</td>'+
				'<td>'+000+'</td>'+
				'<td>'+a.customer.address+'</td>'+
				'<td>'+a.customer.doc+'</td>'+
				'<td>'+((a.customer.enable==0)?"Lock" : "UnLock")+'</td>'+
				'<td>'+a.role+'</td>'+
				'<td><button onclick="managerDelete(this,3)" value="/BookStore1/api/admin/account/delete/'+a.username+'">Delete</button></td>'+
				'<td><button onclick="managerUpdate(this,1)" value="/BookStore1/api/admin/account/'+a.username+'">Update</button></td></tr>';
			transaction += tr;
			i++;
		}
		btmContent.innerHTML =content + transaction + '</table></div>'
		loadNumberPage(numOfPage,3,name);
	}
}
/**
 * This function is used to Get number of Page of all Object.
 * @param num : is page in current time.
 * @param check : check and assign url.
 * @param name : name of Object want to search.
 * @returns
 */
function loadNumberPage(num,check,name){
	var http = new XMLHttpRequest();
	var url = '';
	switch(check){
		case 1:
			url = "/BookStore1/api/admin/product/getNumPage";
			break;
		case 2:
			url = "/BookStore1/api/admin/transaction/getNumPage";
			break;
		case 3:
			url = "/BookStore1/api/admin/account/getNumPage";
			break;
	}
	http.onreadystatechange = function (){
		if(this.readyState==4 && this.status==200){
			loadPage(this,num,name,check);
		}
	}
	http.open("Get",url +((name!=null)?("?name="+name):""),true);
	http.send();
}
 
function loadPage(resp,num,name,check){
	var arr = JSON.parse(resp.response);
	console.log("numpage");
	console.log(arr);
	if(arr>1){
	var p = '';
	var url = '';
	switch(check){
		case 1:url = '/BookStore1/api/admin/product?numberPage=';
			break;
		case 2:url = '/BookStore1/api/admin/transaction?numberPage=';
			break;
		
	}
	for(var i=1;i<=arr;i++){
		var style = '';
		if(i==num)
			style='style="color:red;text-decoration:underline;"';
		p+="<button " +style+ " onclick='onLoad(this,\""+name+"\",2,"+i+")' value='"+url+i+((name!=null)?("&name="+name):"")+"'>"+i+"</button>";
	}
	document.getElementById('numberPage').innerHTML = p;
	}else{
		document.getElementById('numberPage').innerHTML="";
	}
}

/**
 * This function is used to Search Book.
 * @returns
 */
function searchBook(check){
	var url = "";
	switch(check){
		case 'book': url = "/BookStore1/api/admin/product?numberPage=1&name="; 
			break;
		case 'transaction': url = "/BookStore1/api/admin/transaction?numberPage=1&id=";
			break;
		case 'user': url = "/BookStore1/api/admin/account?numberPage=1&name=";
			break;
	}
	var name = document.getElementById('search').value;
	var http = new XMLHttpRequest();
	http.onreadystatechange= function(){
		if(this.readyState==4 && this.status==200){
			var arr = JSON.parse(this.response);
			switch(check){
			case 'book': managerProduct(arr,1,name); 
				break;
			case 'transaction': managerTransaction(arr,1,name);
				break;
			case 'user': managerAccount(arr,1,name);
				break;
		}
		}
		
	}
	http.open("Get",url+name,true);
	http.send();
}

/**
 * This function is used to delete Book if check = 1 and delete transaction if check =2 , and delete account if check = 3.
 * @param check : check object delete.
 * @param btn : button is clicked.
 * @returns
 */
function managerDelete(btn,check){
	var http = new XMLHttpRequest();
	http.onreadystatechange = function (){
		if(this.readyState==4 && this.status==200){
			if(check==1) onLoad(btnDashBoard,null,1,1);
			if(check==2) onLoad(btnTransaction,null,2,1);
			if(check==3) onLoad(btnUser,null,3,1);
		}
	}
	http.open('Delete',btn.value,true);
	http.send();
}
/**
 * This function is used to Get book or Transaction, Account.
 * @param btn : button on click
 * @param check
 * @returns
 */
function managerUpdate(btn,check){
	var http = new XMLHttpRequest();
	http.onreadystatechange = function (){
		if(this.readyState==4 && this.status==200){
			if(check==1) updateBook(this);
			if(check==2) updateTransaction(this);
			if(check==3) updateAccount(this);
		}
	}
	http.open('Get',btn.value,true);
	http.send();
}

var arrCategory = [];
getAll(1,function(output){
	arrCategory=output;
})
var arrPublishingHouse = [];
getAll(2,function(output){
	arrPublishingHouse = output;
})
var arrAuthor = [];
var arrAuthor = getAll(3,function(output){
	arrAuthor = output;
})
/**
 * This function is used to update book.
 * @param resp
 * @returns
 */
function  updateBook(resp){
	var book = JSON.parse(resp.response);
	var content = '<h2>Cập nhật sách<input placeholder="Tên sách..." type="text" id="search"/>'
				+'<button onclick="searchBook(\'user\')">Search</button></h2><hr>';
	var category = '';
	var publishingHouse = '';
	var author = '';
	for(var a of arrCategory)
		category += '<option value="'+a.id+'"'+(book.category.id==a.id?" selected":"")+'>'+a.name+'</option>';
	console.log(category);
	for(var a of arrPublishingHouse)
		publishingHouse += '<option value="'+a.id+'"'+(book.publishingHouse.id==a.id?"selected":"")+'>'+a.name+'</option>';
	for(var a of arrAuthor){
		var check = true;
		for(var au of book.authors)
			if(au.id==a.id) check = false;
			author += '<span><label for="'+a.id+'"><input type="checkbox" value="'+a.id+'" name="author"'+(!check?"checked":"")+'>' +a.name+'</label></span>';
			if(!check) check=true;
	}
	content += '<div class="update"><form action="/BookStore1/book/updateBook" enctype="mutilpart/form-data">'
				+'<input type="hidden" name="idBook" value="'+book.id+'"/>'
				+'<table><tr><th>Tên sản phẩm : </th><td>'
				+'<input type="text" name="nameBook" value="'+book.name+'" /></td></tr>'
				+'<tr><th>Thể loại : </th><td>'
				+'<select name="category">'+category+'</select></td></tr>'
				+'<tr><th>Giá(VNĐ) : </th><td><input type="text" name="price" value="'+book.price.toLocaleString()+'"></td></tr>'
				+'<tr><th>Giảm giá(VNĐ) : </th><td><input type="number" name="discount" value="'+book.discount+'"></td></tr>'
				+'<tr><th>Số lượng(VNĐ) : </th><td><input type="number" name="quantity" value="'+book.quantity+'"></td></tr>'
				+'<input type="file" name="name" value="'+book.name+'" /></td></tr>'
				+'<tr><th>Nhà xuất bản : </th><td>'
				+'<select name="publishingHouse">'+publishingHouse+'</select>'
				+'<tr><th>Tác giả : </th><td id="tdauthor">'+author+'</td>'
				+'<tr><td id="tdbtn" colspan="2">'
				+'<button type="submit">Update</button>'
				+'<button type="reset">Reset</button></td></tr>'
				+'</table></form></div>';
	btmContent.innerHTML = content;
	document.getElementById('numberPage').innerHTML="";
}

/**
 * This function is used to get all category,publishinghouse,author in DB.
 * @returns
 */
function getAll(check,handleData){
	var http = new XMLHttpRequest();
	http.onreadystatechange = function (){
		if(this.readyState==4 && this.status==200){
			handleData(JSON.parse(this.response));
		}
	}
	var url ='';
	if(check==1) url='/BookStore1/api/admin/getAllCategory';
	if(check==2) url='/BookStore1/api/admin/getAllPublishingHouse';
	if(check==3) url='/BookStore1/api/admin/getAllAuthor';
	http.open("Get",url,true);
	http.send();
}

/**
 * This method is used to get Information of Admin.
 * @param arr
 * @returns
 */
function infoAdmin(arr){
	var content = '<h2>Thông tin của Admin</h2><hr>'
		+'<div class="infor"><table><tr>'
		+'<th>Tên của Admin : </th>'
		+'<td>Đoàn Văn Duy</td></tr><tr>'
		+'<th>Ngày sinh : </th><td>1998-04-22</td>'
		+'</tr><tr><th>Địa chỉ : </th>'
		+'<td>Việt Tiến Việt Yên, Bắc Giang</td></tr>'
		+'<tr><th>Email : </th><td>doanvanduy22041998@gmail.com</td>'
		+'</tr><tr><th>Sinh viên : </th><td>Đại học công nghiệp Hà Nội</td>'
		+'</tr><tr><th>Sở thích : </th><td>Lập trình ngôn ngữ JAVA</td></tr></table>';
	btmContent.innerHTML = content;
}
function click(){
	var content = '<h2>Cập nhật thông tin</h2><hr><h3>Chức năng này đang được cập nhật.</h3>';
	btmContent.innerHTML = content;
		
}
