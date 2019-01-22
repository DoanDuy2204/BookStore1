<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/resources/css/content.css"></c:url>'>
<!-- start content -->
<div class="content">
	<div class="noibat">
		<div class="top">
			<h3>Nổi bật</h3>
			<div>
				<ul>
					<li>
						<button onclick="check(this,1,1)" value='<c:url value="/api/getBookBySoldNumber?"></c:url>'>Bán chạy nhất</button>
					</li>
					<li>
						<button onclick="check(this,1,1)" value='<c:url value="/api/getBookByView?"></c:url>'>Nhiều người xem</button>
					</li>
					<li>
						<button onclick="check(this,1,1)" value='<c:url value="/api/getBookByDiscount?"></c:url>'>Siêu giảm giá</button>
					</li>
				</ul>
			</div>
		</div>
		<div id="btn-noibat" class="bottom-noibat"></div>
	</div>
	<div class="category">
		<div class="top">
			<h3>Sách giáo khoa</h3>
			<div>
				<ul>
					<c:forEach var="c" varStatus="i" items="${categories}">
						<c:if test="${i.index!=0}">
							<li><button onclick="check(this,2,2)" value='<c:url value="/api/getBookByCategoryId?total=10&categoryId=${c.id}&"></c:url>'>${c.name}</button></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="bottom">
			<div class="left">
				<a href=""> <img style="padding-bottom: 1.5em;" 
					src="<c:url value='/resources/image/advertise/tienlamchucuocchoi.png'></c:url>"></a>
				<a><img src='<c:url value="/resources/image/advertise/nhagiakim1.png"></c:url>'>
				</a> <a><img src='<c:url value="/resources/image/advertise/chagiauchangheo.png"></c:url>'></a>
			</div>
			<div class="right" id="category-right"></div>
		</div>
	</div>
	<div class="publishinghouse">
		<div class="top">
			<h3>Kim Đồng</h3>
			<div>
			<ul>
				<c:forEach var="p" varStatus="i" items="${publishingHouses}">
					<c:if test="${i.index!=0}">
						<li><button  onclick="check(this,3,3)" value='<c:url value="/api/getBookByPublishingHouseId?total=10&publishingHouseId=${p.id}&"></c:url>'>${p.name}</button></li>
					</c:if>
				</c:forEach>
			</ul>
			</div>
		</div>
		<div class="bottom">
			<div class="left">
				<a href=""> <img style="padding-bottom:2em;" src="<c:url value='/resources/image/advertise/vocungtannhanvocungyeuthuong.png'></c:url>"></a>
				<a><img src='<c:url value="/resources/image/advertise/chuyenconmevahaiau1.png"></c:url>'>
				</a> <a><img src='<c:url value="/resources/image/advertise/kheoannoisecoduocthienha.png"></c:url>'></a>
			</div>
			<div class="right" id="publishinghouse-right"></div>
		</div>
	</div>
</div>
<script src='<c:url value="/resources/js/content.js"></c:url>'></script>