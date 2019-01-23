<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url var="url" value="/"></c:url>
<!-- start content -->
<link type="text/css" rel="stylesheet"
	href="${url}resources/css/book-content.css">
<div class="content">
	<div class="left">
		<h4>DANH MỤC HÀNG ĐẦU</h4>
		<ul>
			<c:forEach var="c" items="${catelogy}">
				<li><a
					href='<c:url value="/book/books?numberPage=1&command=catelog&catelog=${c}"></c:url>'>${c}</a></li>
			</c:forEach>
		</ul>
		<hr>
		<h4>THỂ LOẠI</h4>
		<ul>
			<c:forEach var="c" items="${category}">
				<li><a
					href='<c:url value="/book/books?numberPage=1&command=category&categoryId=${c.id}"></c:url>'>${c.name}</a></li>
			</c:forEach>
		</ul>
		<hr>
		<h4>NHÀ XUẤT BẢN</h4>
		<ul>
			<c:forEach var="p" items="${publishingHouse}">
				<li><a
					href='<c:url value="/book/books?numberPage=1&command=publishingHouse&publishingHouseId=${p.id}"></c:url>'>${p.name}</a></li>
			</c:forEach>
		</ul>
		<hr>
		<h4>GIÁ BÁN</h4>
		<ul>
			<c:set var="s" value="0"></c:set>
			<c:forEach var="c" items="${cost}">
				<li><a
					href='<c:url value="/book/books?numberPage=1&command=cost&min=${s}&max=${c}"></c:url>'>
						<fmt:formatNumber groupingUsed="true">${s}</fmt:formatNumber> - <fmt:formatNumber
							groupingUsed="true">${c}</fmt:formatNumber>
				</a></li>
				<c:set var="s" value="${c}"></c:set>
			</c:forEach>
			<li><a
				href='<c:url value="/book/books?numberPage=1&command=cost&min=${s}"></c:url>'> <fmt:formatNumber
						groupingUsed="true">${s}</fmt:formatNumber></a></li>
		</ul>
	</div>
	<div id="content-right" class="right">
		<div>
			<c:if test="${books.size()==0}">
						Không có sản phẩm nào cần tìm.
			</c:if>
			<c:forEach var="b" varStatus="i" items="${books}">
				<div>
					<img src='<c:url value="/resources/image/books/${b.image}"></c:url>'>
					<p>
						<c:set var="count" value="0">
						</c:set>
						<c:if test="${b.star%1!=0}">
							<i class="fas fa-star-half-alt"></i>
							<c:set var="count" value="0.5"></c:set>
						</c:if>
						<c:forEach var="s" begin="1" end="${b.star-count}">
							<i class="fas fa-star"></i>
						</c:forEach>
						<c:forEach var="sp" begin="1" end="${5-b.star-count}">
							<i class="far fa-star"></i>
						</c:forEach>
					</p>
					<p>
						<a href="">${b.name}</a>
					</p>
					<p><fmt:formatNumber groupingUsed="true">${b.price-b.price*b.discount/100}</fmt:formatNumber>
					<sup>vnđ</sup><span><s><fmt:formatNumber groupingUsed="true">${b.price}</fmt:formatNumber></s><sup>vnđ</sup></span></p>
					<button onclick="addCart(this)" value='<c:url value="/api/cart/${b.id}"></c:url>'>Thêm vào giỏ hàng</button>
				</div>
				<c:if test="${i.index==4 || i.index==9}">
					</div><div>
				</c:if>
			</c:forEach>
		</div>
		<p style="text-align: center;">
		<c:if test="${command eq 'book'}"><c:set var="command" value="&command=${command}"></c:set></c:if>
		<c:if test="${command eq 'search'}"><c:set var="command" value="&command=${command}&search=${search}"></c:set></c:if>
		<c:if test="${command eq 'category'}"><c:set var="command" value="&command=${command}&categoryId=${id}"></c:set></c:if>
		<c:if test="${command eq 'publishingHouse'}"><c:set var="command" value="&command=${command}&publishingHouseId=${id}"></c:set></c:if>
		<c:if test="${command eq 'catelog'}"><c:set var="command" value="&command=${command}&catelog=${catelog}"></c:set></c:if>
		<c:if test="${command eq 'cost'}"><c:set var="command" value="&command=${command}&min=${min}&max=${max}"></c:set></c:if>
			<c:forEach var="i" begin="1" end="${pageNumber}">
				<a href='<c:url value="books?numberPage=${i}${command}"></c:url>'
				   style="padding:0 0.3em;<c:if test="${numberPage eq i}">text-decoration:underline;color:red;</c:if>">
					${i}</a>
			</c:forEach>
		</p>
	</div>
</div>	
<script type="text/javascript" src="${url}resources/js/content-book.js"></script>