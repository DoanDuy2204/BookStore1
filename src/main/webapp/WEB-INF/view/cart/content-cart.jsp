<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href='<c:url value="/resources/css/content-cart.css"></c:url>' type="text/css"
	rel="stylesheet">
<!-- start content -->
<div class="section">
	<div class="cart">
		<c:if test="${notice==null}">
			<h4>Giỏ hàng</h4>
			<table id="tablecart">
				<tr id="tr1">
					<td>Hình ảnh</td>
					<td>Tên sách</td>
					<td>Giá</td>
					<td>Số lượng</td>
					<td>Thành tiền</td>
				</tr>
				<c:set var="paymoney" value="0"></c:set>
				<c:forEach var="c" items="${cart}">
					<tr id="order${c.id}">
						<td>
							<img src='<c:url value="/resources/image/books/${c.book.image}"></c:url>'>
							<input type="hidden" value="${c.amount}" id="amountOld${c.id}">
						</td>
						<td>${c.book.name}</td>
						<td>
							<fmt:formatNumber groupingUsed="true">${c.book.price-(c.book.price*(c.book.discount/100))}</fmt:formatNumber> vnđ
						</td>
						<td>
							<span id="quantity${c.id}">${c.quantity}</span>
							<button onclick="change(this)" value='<c:url value="/api/cart/change?id=${c.id}&num=1"></c:url>'>
								<i class="fas fa-plus"></i></button>
							<button onclick="change(this)" value='<c:url value="/api/cart/change?id=${c.id}&num=-1"></c:url>'>
								<i class="fas fa-minus"></i></button>
						</td>
						<td >
							<span id="amount${c.id}"><fmt:formatNumber groupingUsed="true">${c.amount}</fmt:formatNumber></span> vnđ
						</td>
					</tr>
					<c:set var="paymoney" value="${paymoney+c.amount}"></c:set>
				</c:forEach>
				<tr>
					<td style="padding: 1em; padding-right: 2em; text-align: end; border-top: 1px solid white;"
						 colspan="4">
						Tổng tiền :</td>
					<td style="border-top:1px solid white;"><span id="paymoney"><fmt:formatNumber groupingUsed="true">${paymoney}</fmt:formatNumber></span> vnđ
						<input type="hidden" value="${paymoney}" id="valuepaymoney"></td>
				</tr>
				<tr>
					<td id="thanhtoan" colspan="5"><a href='<c:url value="/transaction/creat"></c:url>'>Thanh toán</a></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${notice!=null}">
			<p style="color: white; font-size: 18px; padding: 1.5em;">*
				${notice}</p>
			<a
				style="text-decoration: underline; color: #00ccd8; padding: 1.5em;"
				href='<c:url value="/"></c:url>'>Quay trở về trang chủ.</a>
		</c:if>
	</div>
</div>
<script src='<c:url value="/resources/js/cart.js"></c:url>'></script>