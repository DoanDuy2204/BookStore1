<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/resources/css/header.css"></c:url>'>
<c:set var="session" value="${pageContext.request.session}"></c:set>
<!-- start header -->
<div class="header">
	<div class="account">
		<c:set var="user" value="${session.getAttribute('user')}"></c:set>
		<c:if test="${user==null}">
			<a href='<c:url value="/user/login"></c:url>'>Đăng nhập<i class="fas fa-user-circle"></i>
			</a>
			<a href='<c:url value="/user/register"></c:url>'> Đăng kí <i class="fas fa-user-edit"></i></a>
		</c:if>
		<c:if test="${user!=null}">
			<a>${user.userName}</a>
			<a href='<c:url value="/user/logout"></c:url>'>Đăng xuất <i
				class="fas fa-sign-out-alt"></i></a>
		</c:if>
	</div>
	<div class="bottom-header">
		<div class="container">
			<div class="logo">
				<img src='<c:url value="/resources/image/logo.png"></c:url>'>
			</div>
			<div class="nav">
				<ul>
					<li><a href='<c:url value="/"></c:url>'>Trang chủ</a></li>
					<li><a
						href='<c:url value="/book/books?numberPage=1&command=book"></c:url>'>Sách</a></li>
<%-- 					<li><a href='<c:url value="/blog"></c:url>'>Blog</a></li> --%>
					<li><a href='<c:url value="/contact"></c:url>'>Liên hệ</a></li>
					<li><a href='<c:url value="/cart/carts"></c:url>'><i
							class="fas fa-shopping-cart"></i>Giỏ hàng</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="header-slide">
		<a href="" style="padding-right: 3em;"><img src='<c:url value="/resources/image/banner/slide4.png"></c:url>'></a>
		<a href=""><img src='<c:url value="/resources/image/banner/nhagiakim2.png"></c:url>'></a>
		<a href=""><img src='<c:url value="/resources/image/banner/chagiauchangheo1.png"></c:url>'></a>
	</div>
	<div class="nav-bottom">
		<div class="container">
			<div class="select">
				<ul>
					<li>Xem theo :</li>
					<li class="menu2">Danh mục
						<ul>	
							<c:set var="catelog" value="Sách mới nhất"></c:set>
							<li>
								<a href='<c:url value="/book/books?command=catelog&numberPage=1&catelog=${catelog}">
								</c:url>'>Mới nhất</a></li>
							<c:set var="catelog" value="Sách nổi bật"></c:set>
							<li>
							    <a href='<c:url value="/book/books?command=catelog&numberPage=1&catelog=${catelog}">
							    </c:url>'>Xu hướng</a></li>
							<c:set var="catelog" value="Sách nhiều view"></c:set>
							<li>
								<a href='<c:url value="/book/books?command=catelog&numberPage=1&catelog=${catelog}">
								</c:url>'>Nhiều lượt xem</a></li>
						</ul>
					</li>
					<li class="menu2">Giá cả
						<ul>
							<li>
								<a href='<c:url value="/book/books?numberPage=1&command=price&kind=max">
								</c:url>'>Cao -> Thấp</a>
							</li>
							<li>
								<a href='<c:url value="/book/books?numberPage=1&command=price&kind=max">
								</c:url>'>Thấp -> Cao</a>
							</li>
						</ul>
					</li>
					<li class="menu2">Thể loại
						<ul>
							<c:forEach var="c" items="${session.getAttribute('categories')}">
								<li>
									<a href='<c:url value="/book/books?numberPage=1&command=category&categoryId=${c.id}">
									</c:url>'>${c.name}</a>
								</li>
							</c:forEach>
						</ul>
					</li>
				</ul>
			</div>
			<div class="collections">
				<form action='<c:url value="/book/books"></c:url>' method="get">
					<input type="hidden" name="command" value="search">
					 <input type="hidden" name="numberPage" value="1"> 
					 <input type="text" name="search" placeholder="search book..."><button type="submit"><i class="fas fa-search"></i></button>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- end header -->