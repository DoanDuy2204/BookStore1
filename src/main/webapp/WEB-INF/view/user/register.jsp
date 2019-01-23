<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/register.css"></c:url>'>
<div class="register">
	<form:form accept-charset="UTF-8" action="${pageContext.request.contextPath}/user/process-register" modelAttribute="user" method="post">
		<table>
			<tr>
				<td colspan="2"><form:errors path="customer.name" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Tên của bạn * : </th>
				<td><form:input path="customer.name" placeholder="Tên của bạn..."/></td>
			</tr>
			<tr id="userError">
				<td colspan="2">* Username đã tồn tại.</td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="userName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Username * : </th>
				<td><form:input path="userName" placeholder="cusername..."/></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Mật khẩu * : </th>
				<td><form:input  path="password" type="password" placeholder="Mật khẩu..."/></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="passAgain" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Nhập lại mật khẩu * : </th>
				<td><form:input path="passAgain" type="password" placeholder="Nhập lại..."/></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="customer.email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Email * : </th>
				<td><form:input path="customer.email" placeholder="Email..."/></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="customer.address" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Địa chỉ * : </th>
				<td><form:input path="customer.address" placeholder="Địa chỉ..."/></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="customer.gender" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Giới tính * : </th>
				<td>
					<label for="female"><input id="female" type="radio" name="customer.gender" value="female"/>Nữ</label>
					<label for="male"><input id="male" type="radio" name="customer.gender" checked value="male"/>Nam</label>
					<label for="other"><input id="other" type="radio" name="customer.gender" value="other"/>Other</label>
				</td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="customer.phone" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Số điện thoại : </th>
				<td><form:input path="customer.phone" placeholder="Số điện thoại..."/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">Register</button>
					<button type="reset">Replace</button>
				</td>
			</tr>
		</table>
	</form:form>
</div>
<script type="text/javascript" src='<c:url value="/resources/js/register.js"></c:url>'></script>