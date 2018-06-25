<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Авторизация</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
	<script src="${pageContext.request.contextPath}/static/js/fontawesome-all.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/login" method="post">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
				<br/><br/><br/><br/>
				<div class="well">
					<h2 class="text-center">Авторизация</h2>
					<br/>
					<div class="input-group">
						<span class="input-group-addon"><i class="fas fa-user"></i></span>
						<input id="username" type="text" class="form-control" name="username" placeholder="Логин" value="${param.username}">
					</div>
					<br/>
					<div class="input-group">
						<span class="input-group-addon"><i class="fas fa-lock"></i></span>
						<input id="password" type="password" class="form-control" name="password" placeholder="Пароль">
					</div>
					<br/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<button type="submit" class="btn btn-primary btn-block">Войти</button>
					<c:if test="${param.error != null}">
						<br/>
						<div class="alert alert-danger alert-dismissible">
						  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  					<strong>Неверно указан логин/пароль пользователя для входа</strong>
						</div>
					</c:if>
					<c:if test="${param.logout != null}"><br/>
						<div class="alert alert-info alert-dismissible">
						  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  					<strong>Вы вышли из системы</strong>
						</div>
					</c:if>
				</div>
				</div>
				<div class="col-sm-3"></div>
			</div>
		</form>
	</div>
</body>
</html>