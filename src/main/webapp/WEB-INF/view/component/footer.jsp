<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/resources/css/footer.css"></c:url>'>
	<c:set var="session" value="${pageContext.request.session}"></c:set>
<!-- start footer -->
<div class="footer">
	<div class="content-footer">
		<div>
			<ul>
				<h3>THỂ LOẠI</h3>
				<c:forEach var="c" items="${session.getAttribute('categories')}">
					<li><a href='<c:url value="/book/books?numberPage=1&command=category&categoryId=${c.id}"></c:url>'>${c.name}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<ul>
				<h3>DANH MỤC</h3>
				<c:set var="catelog" value="Sách nổi bật"></c:set>
				<li><a href='<c:url value="/book/books?numberPage=1&command=catelog&catelog=${catelog}"></c:url>'>Ưa thích</a></li>
				<c:set var="catelog" value="Sách nhiều view"></c:set>
				<li><a href='<c:url value="/book/books?numberPage=1&command=catelog&catelog=${catelog}"></c:url>'>Nhiều người xem</a></li>
				<c:set var="catelog" value="Sách bán chạy"></c:set>
				<li><a href='<c:url value="/book/books?numberPage=1&command=catelog&catelog=${catelog}"></c:url>'>Nhiều người mua</a></li>
				<c:set var="catelog" value="Sách mới nhất"></c:set>
				<li><a href='<c:url value="/book/books?command=catelog&numberPage=1&catelog=${catelog}"></c:url>'>Mới nhất</a></li>
			</ul>
		</div>
		<div>
			<ul>
				<h3>CHĂM SÓC KHÁCH HÀNG</h3>
				<li><a href="">Chính sách bảo hành</a></li>
				<li><a href="">chính sách đổi trả</a></li>
				<li><a href="">Chính sách giao hàng</a></li>
				<li><a href="">Bảo mật thông tin</a></li>
				<li><a href="">Điều khoản sử dụng</a></li>
			</ul>
		</div>
		<div>
			<ul id="ul1">
				<h3>CHI NHÁNH</h3>
				<li>Bắc Từ Liêm, Hà Nội</li>
				<li>Tp Bắc Giang, Bắc Giang</li>
				<li>Từ Sơn, Bắc Ninh</li>
				<li> Diễn Châu, Nghệ An</li>
			</ul>
			<form action="">
				<input type="email" name="email">
				<button type="submit">Email</button>
			</form>
		</div>
	</div>
	<p>@ DOANVANDUY22041998@GMAIL.COM</p>
</div>
<!-- end footer -->