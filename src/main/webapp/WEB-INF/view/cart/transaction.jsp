<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" 
integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:include page="../component/header.jsp"></jsp:include>
	<c:if test="${command=='transaction-form'}">
		<jsp:include page="transaction-form.jsp"></jsp:include>
	</c:if>
	<c:if test="${command=='transaction-confirm'}">
		<jsp:include page="transaction-confirm.jsp"></jsp:include>
	</c:if>
	<c:if test="${notice=='Success'}">
	<div style="width: 80%;margin: 1em auto;padding:2em 2em;background: #32383e;color:white;">
			<h2 style="padding:3em 0;">Xác nhận thành công. Đơn hàng sẽ được gửi tới bạn sớm nhất.</h2>
			<p style="padding-bottom:2em;">
			Tiếp tục mua hàng với chúng tôi
			<a
				style="text-decoration: underline; color: #00ccd8; padding: 1.5em;"
				href='<c:url value="/"></c:url>'>Quay trở về trang chủ.</a>
			</p>
	</div>
	</c:if>
	<jsp:include page="../component/footer.jsp"></jsp:include>
</body>
</html>