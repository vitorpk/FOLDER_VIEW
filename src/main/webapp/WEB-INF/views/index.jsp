<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Приложение на Java</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
	<script src="${pageContext.request.contextPath}/static/js/fontawesome-all.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</head>
<body>
  <nav class="navbar navbar-inverse">
  	<div class="container-fluid">
    	<div class="navbar-header navbar-brand">
      	Организация по развитию бизнеса
    	</div>
    	<ul class="nav navbar-nav navbar-right">
    		<form action="${pageContext.request.contextPath}/logout" method="post">
    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    			<button type="submit" class="btn btn-link navbar-btn"><span class="fas fa-sign-out-alt"></span>Выйти</button>
    		</form>
    	</ul>
  	</div>
	</nav>
	<div id="root"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bundle.js"></script>
</body>
</html>
