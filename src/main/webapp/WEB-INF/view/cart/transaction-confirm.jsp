<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/resources/css/transaction-confirm.css"></c:url>' />
<c:set var="session" value="${pageContext.request.session}"></c:set>
<c:set var="transaction" value="${session.getAttribute('transaction')}" ></c:set>
<c:set var="orders" value="${transaction.orders}"></c:set>
<div class="content">
	<h2>Xác nhận mua hàng</h2>
	<table>
		<tr>
			<th>Hân hạnh được phục vụ quý khách</th>
			<th>Dshop/NewBook</th>
		</tr>
		<tr>
			<td><b>Tên khách hàng:</b> ${transaction.user.customer.name}</td>
			<td><b>Địa chỉ :</b> ${transaction.address}</td>
		</tr>
		<tr>
			<td><b>Email :</b> ${transaction.email} </td>
			<td><b>Phone :</b> ${transaction.phone}</td>
		</tr>
	</table>
	<table id="tableproduct">
		<tr>
			<th>Tên sản phẩm</th>
			<th>Giá(vnđ)</th>
			<th>Số lượng</th>
			<th>Thành tiền(vnđ)</th>
		</tr>
		<c:set var="payamount" value="0"></c:set>
		<c:forEach var="o" items="${orders}">
			<tr>
				<td>${o.book.name}</td>
				<td>
					<fmt:formatNumber groupingUsed="true">${o.book.price}</fmt:formatNumber>
				</td>
				<td>${o.quantity}</td>
				<td>
					<fmt:formatNumber groupingUsed="true">${o.quantity*o.book.price}</fmt:formatNumber>
				</td>
				<c:set var="payamount" value="${payamount + o.quantity*o.book.price}"></c:set>
			</tr>
		</c:forEach>
		<tr id="tongtien">
			<td colspan="3" style="text-align: right;"><b>Tổng tiền :</b></td>
			<td><fmt:formatNumber groupingUsed="true">${payamount}</fmt:formatNumber></td>
		</tr>
	</table>
	<p>
		<a href='<c:url value="/transaction/creat"></c:url>'>Quay lại</a>
		<a href='<c:url value="/transaction/confirm-transaction?command=confirm"></c:url>'>Xác nhận</a>
		<a href='<c:url value="/transaction/confirm-transaction?comamnd=delete"></c:url>'>Hủy bỏ</a>
	</p>
</div>