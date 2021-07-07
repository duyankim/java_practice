<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index.jsp</title>
	<link href="${path }/resources/css/styles.css" rel="stylesheet" />
	<link href="${path }/resources/css/search.css" rel="stylesheet" />
	<!-- Font Awesome icons (free version)-->
	<script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"
		crossorigin="anonymous"></script>
	<!-- Google fonts-->
	<link
		href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
		rel="stylesheet" type="text/css" />
	<link
		href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
		rel="stylesheet" type="text/css" />
	<!-- Core theme CSS (includes Bootstrap)-->
	
</head>
<body>
	<%
		String pageTitle = request.getParameter("pageTitle");
		String pageSubTitle = request.getParameter("pageSubTitle");
	%>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">Cinephile</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                    <c:forEach var="menu" items="${menu}">
				        <li class='nav-item'><a class='nav-link' href='postlist.jsp?board=${menu.id}'>${menu.title}</a></li>
				    </c:forEach>
				</ul>
				<div class="searchbar">
					<form class="searchForm" method="post" action="search.jsp">
						<input class="search_input" type="text" name="search"
							placeholder="Search..." required>
						<button type="submit" class="search_icon"></button>
						<i class="fas fa-search"></i>
					</form>
				</div>
			</div>
		</div>
	</nav>
	
	<!-- Page Header-->
	<header class="masthead"
		style="background-image: url('https://images.unsplash.com/photo-1514320291840-2e0a9bf2a9ae?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1><%=pageTitle%></h1>
						<span class="subheading"><%=pageSubTitle%></span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Bootstrap core JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="/js/scripts.js"></script>
</body>
</html>