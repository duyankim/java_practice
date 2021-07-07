<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index.jsp</title>
	<c:set var="path" value="${pageContext.request.contextPath}" />
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
	<link href="${path }/resources/css/styles.css" rel="stylesheet" />
	<link href="${path }/resoreces/css/search.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="navbar.jsp">
		<jsp:param name="pageTitle" value="nihao" />
		<jsp:param name="pageSubTitle" value="subtitle" />
	</jsp:include>
	
	<!-- Board List -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<c:forEach var="menu" items="${menu}">
					<div class="post-preview">
						<a href="postlist.jsp?board=${menu.id}">
							<h2 class="post-title">${menu.title}<hr /></h2>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	
	<!-- Footer-->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<p class="copyright text-muted">Copyright &copy; kopo03</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="/js/scripts.js"></script>
</body>
</html>