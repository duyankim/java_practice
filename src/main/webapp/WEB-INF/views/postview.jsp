<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link href="${path }/resoreces/css/writeComment.css" rel="stylesheet" />
</head>
<body>
  <!-- header -->
  <jsp:include page="navbar.jsp">
    <jsp:param name="pageTitle" value="${post.title}" />
    <jsp:param name="pageSubTitle"
      value=" Posted by ${post.author} on ${post.date}" />
  </jsp:include>

  <!-- Post Content-->
  <article>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto"
          style="white-space: pre-line">
          <c:out value="${post.content}" />
        </div>
      </div>
    </div>
  </article>
  <hr />

  <!-- Comment -->

  <Section>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <!--comment writer-->
          <form class="form-block">
            <div class="row mt-5">
              <div class="col-xs-12 col-sm-6">
                <div class="form-group fl_icon">
                  <div class="icon">
                    <i class="fa fa-user"></i>
                  </div>
                  <input class="form-input" type="text"
                    placeholder="Your name" name="comAuthor" required>
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 fl_icon">
                <div class="form-group fl_icon">
                  <div class="icon">
                    <i class="far fa-calendar-check"></i>
                  </div>
                  <input class="form-input" type="text"
                    placeholder="date" readonly> <input
                    type="text" name="comRelevel" value="1"
                    class="d-none">
                </div>
              </div>
              <div class="col-lg-12 mx-auto">
                <div class="form-group">
                  <textarea class="form-input" required
                    name="comContent" placeholder="Your comment"></textarea>
                </div>
              </div>
              <div class="container mb-3">
                <div class="d-flex justify-content-end">
                  <div class="btn-group" role="group" aria-label="">
                    <button type="button" class="btn btn-primary"
                      value="submit"
                      formaction="postview.jsp?post=postid">
                      write comment</button>
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </Section>
  <hr />

  <!-- Bootstrap core JS-->
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="./assets/js/scripts.js"></script>
</body>
</html>