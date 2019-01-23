<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
	<jsp:include page="../component/header.jsp"></jsp:include>
	<c:if test="${command=='login'}">
		<jsp:include page="login-form.jsp"></jsp:include>
	</c:if>
	<c:if test="${command=='register'}">
		<jsp:include page="register.jsp"></jsp:include>
	</c:if>
	<jsp:include page="../component/footer.jsp"></jsp:include>
</body>
</html>