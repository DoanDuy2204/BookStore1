<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link href='/BookStore1/resources/css/transaction.css' type="text/css" rel="stylesheet">
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<c:set var="session" value="${pageContext.request.session}"></c:set>
	<c:set var="user" value="${session.getAttribute('user')}"></c:set>
	<c:set var="orders" value="${session.getAttribute('cart')}"></c:set>
	<form:form action="${pageContext.request.contextPath}/transaction/process-transaction" method="Get" modelAttribute="transaction">
		<div class="content">
				<c:if test="${user==null}">
					<div class="div1">
					<h2>Đăng nhập/Đăng kí để bắt đầu mua hàng với chúng tôi.</h2>
					<p id="error">* Password and username is invalidate.</p>
					<table>
						<tr>
							<td>Tên đăng nhập :</td>
							<td><input type="text" id="username" placeholder="Tên đăng nhập..." /></td>
						</tr>
						<tr>
							<td colspan="2" id="error_user"><p>* Username is not empty.</p></td>
						</tr>
						<tr>
							<td>Mật khẩu :</td>
							<td><input type="password" id="password" placeholder="Mật khẩu..." /></td>
						</tr>
						<tr>
							<td colspan="2" id="error_pass"><p>* Password is not empty.</p></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<button onclick="login(this)" type="button" value='<c:url value="/api/user/login"></c:url>'>Đăng nhập</button>
								 <a href='<c:url value="/user/register"></c:url>'><button>Đăng kí</button></a>
							</td>
						</tr>
					</table>
					<input type="hidden" id="role" value="CUSTOMER">
					</div>
				</c:if>
				<c:if test="${user!=null}">
					<div class="div1">
					<input type='hidden' id="nameuser" value="${user.userName}" />
					<input type='hidden' id="namec" value="${user.customer.name}" />
					<input type='hidden' id="emailc" value="${user.customer.email}" />
					<input type='hidden' id="addressc" value="${user.customer.address}" />
					<h3>Điền đầy đủ thông tin vào form sau:</h3>
					<table>
						<tr>
							<td colspan="2" class="filename">
								Sử dụng thông tin tài khoản : 
								<input onclick="checkAddInfo()" id="checkbox_addinfo" type="checkbox" />
							</td>
						</tr>
						<tr>
							<td colspan="2"><form:errors path="name" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<th class="filename">Họ tên :</th>
							<td><form:input path="name" placeholder="Tên đầy đủ ..." /></td>
						</tr>
						<tr>
							<td colspan="2"><form:errors path="email" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<th class="filename">Email :</th>
							<td><form:input path="email" placeholder="Email ..." /></td>
						</tr>
						<tr>
							<td colspan="2"><form:errors path="phone" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<th class="filename">Phone :</th>
							<td><form:input path="phone" placeholder="Phone ..." /></td>
						</tr>
						<tr>
							<td colspan="2"><form:errors path="address" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<th class="filename">Address :</th>
							<td><form:input path="address" placeholder="Địa chỉ ..." /></td>
						</tr>
						<tr>
							<th class="filename">Thanh toán :</th>
							<td><form:checkbox path="payment" id="bangthe" class="payment" onclick="paymentShow()" value="Thanh toán bằng thẻ" /> 
								<label for="bangthe"> 
									Bằng thẻ 
								</label> 
								<form:checkbox path="payment" id="khinhan" class="payment" value="Thanh toán khi nhận" /> 
								<label for="khinhan"> 
									Sau khi nhận 
								</label>
							</td>
						</tr>
						<tr id="payment">
							<th class="filename">Liên kết :</th>
							<td><form:select path="payment_info">
									<form:option value="VietComBank">VietcomBank</form:option>
									<form:option value="VietTinBank">VietTinBank</form:option>
									<form:option value="VISA">Visa</form:option>
									<form:option value="ZaloPay">ZaloPay</form:option>
								</form:select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="submit">Tiếp tục
								</button>
							</td>
						</tr>
					</table>
					</div>
				</c:if>
			<div class="div2">
				<h3>Thông tin hóa đơn</h3>
				<table>
					<c:set var="pay" value="0"></c:set>
					<tr>
						<th>Tên sản phẩm</th>
						<th>Số lượng</th>
						<th>Số tiền</th>
					</tr>
					<c:forEach var="o" items="${orders}">
						<tr>
							<td>${o.book.name}</td>
							<td>${o.quantity}</td>
							<td>${o.amount}</td>
						</tr>
						<c:set var="pay" value="${pay+o.amount}"></c:set>
					</c:forEach>
					<tr id="allmoney">
						<td colspan="2"><b>Tổng tiền :</b></td>
						<td>${pay}</td>
					</tr>
				</table>
				<form:input path="amount" value="${pay}" type="hidden"/>
				<form:input path="status" value="0" type="hidden"/>
			</div>
		</div>
		</form:form>
		<script type="text/javascript" src='<c:url value="/resources/js/transaction-form.js"></c:url>'></script>