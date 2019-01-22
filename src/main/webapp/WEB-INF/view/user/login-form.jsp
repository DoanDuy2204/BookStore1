<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link type="text/css" rel="stylesheet" href='<c:url value="/resources/css/login-form.css"></c:url>'>
<div class="content">
	<form:form action='${pageContext.request.contextPath}/user/process-login'
		modelAttribute="user" method="POST">
		<h1>Tài khoản của tôi</h1>
		<h2>Đăng nhập</h2>
		<c:if test="${error!=null}">
			<i style="color: red; font-size: 13px;"> * ${error}.</i>
			<br>
		</c:if>
		<p>Tên đăng nhập * :</p>
		<p><form:errors path="userName" cssClass="error"></form:errors></p>
		<p><form:input path="userName"  placeholder="Tên đăng nhập...." /></p>
		<p>Mật khẩu * :</p>
		<p><form:errors path="password" type="password" cssClass="error"></form:errors></p>
		<p><form:input path="password" type="password" placeholder="Mật khẩu ..." /></p>
		<input type="submit" value="Đăng nhập" class="button1" />
		<a href="${pageContext.request.contextPath}/user/register" id="register">Đăng kí</a>
		<a href="">Quên mật khẩu?</a>
	</form:form>
</div>
