<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style rel="stylesheet" type="text/css">
	.contact{width: 80%;padding:3em;margin:1em auto;
				box-shadow: 0 0 15px -3px;border-radius: 0.5em;}
	.contact h2{padding:1em;}
	.contact p{padding:1em 1.5em;font-size:1em;}
</style>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:include page="component/header.jsp"></jsp:include>
	<c:if test="${contact==null}">
		<jsp:include page="component/content.jsp"></jsp:include>
	</c:if>
	<c:if test="${contact!=null}">
		<div class="contact">
			<H2>NHÀ SÁCH HÀ NỘI KÍNH CHÀO MỌI NGƯỜI</H2>
			<p>LIÊN HỆ :</p>
			<p>Địa chỉ: Cổng trường Đại học công nghiệp HÀ NỘI.</p>
			<p>Số điện thoại : 0343620808</p>
			<p>Địa chỉ email : NhasachHN@gmail.com</p>
			<h2>Chúng tôi mong nhận được sự liên hệ từ quý vị !!!</h2>
		</div>
	</c:if>
	<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>