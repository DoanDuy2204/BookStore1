<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="session" value="${pageContext.request.session}"></c:set>
<c:set var="user" value="${session.getAttribute('user')}"></c:set>
<!DOCTYPE html>
<html>
<head>
	<title>Admin</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/admin.css"></c:url>'>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	<c:if test="${updatesucess!=null}">
		<script>
			alert("UPLOAD THÀNH CÔNG")
		</script>
	</c:if>
	<script type="text/javascript" src='<c:url value="/resources/js/Chart.min.js"></c:url>'></script>
</head>
<body>
	<div class="left">
		<h3>XIN CHAO ${user.userName} </h3>
			<ul>
				<li>
					<button id="btnDashboard" value='<c:url value="/api/admin/dashBoard"></c:url>'  onclick="onLoad(this,null,1,0)">
					<i class="fas fa-globe-americas"></i>Bảng điều khiển
					</button>
				</li>
				<li><button><i class="fas fa-users"></i>Quản lí<i style="margin-left:4em;" onclick="down(1)" class="fas fa-angle-down"></i></button>
					<ul id="ul-down">
						<li><button id="btnProduct" value='<c:url value="/api/admin/product?numberPage=1"></c:url>' onclick="onLoad(this,null,2,1)"><i class="fas fa-book"></i>Sản phẩm</button></li>
						<li><button id="btnTransaciton" onclick="onLoad(this,null,3,1)" value='<c:url value="/api/admin/transaction?numberPage=1"></c:url>'><i class="fas fa-clipboard-list"></i>Đơn hàng</button></li>
						<li><button id="btnUser" onclick="onLoad(this,null,4,1)" value='<c:url value="/api/admin/account?numberPage=1"></c:url>'><i class="far fa-user"></i>Tài khoản</button></li>
					</ul>
				</li>
				<li><button><i class="fas fa-solar-panel"></i>Tài khoản<i onclick="down(2)" class="fas fa-angle-down"></i></button>
					<ul id="ul-down1">
						<li><button id="btnInforUser" value='<c:url value="/api/admin/getUser?username=${user.userName}"></c:url>' onclick="onLoad(this,null,5,0)" ><i class="fas fa-book"></i>Thông tin</button></li>
						<li><button id="btnUpdateUser" value='<c:url value="/api/admin/updateAdmin"></c:url>' onclick="click()"><i class="fas fa-clipboard-list"></i>Cập nhật</button></li>
					</ul>
				</li>
				<li><button onclick="onload(this,9)"><i class="fas fa-users-cog"></i>Cài đặt</button></li>
				<li><button><i class="fas fa-sign-out-alt"></i><a style="color:#8d9795;" href='<c:url value="/user/logout"></c:url>'>Đăng xuất</a></button></li>
			</ul>
	</div>
	<div class="right">
		<div class="top">
			<img src='<c:url value="/resources/image/logoAdmin.png"></c:url>'>
			<button><i class="fas fa-user"></i>${user.userName}</button>
			<button><i class="fas fa-sign-out-alt"></i><a href='<c:url value="/user/logout"></c:url>'>Đăng xuất</a></button>
		</div>
		<div id="bottom-content" class="bottom"></div>
		<p id="numberPage"></p>
	</div>
	<script type="text/javascript" src='<c:url value="/resources/js/admin.js"></c:url>'></script>
</body>
</html>