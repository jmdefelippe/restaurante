<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
			  <a class="navbar-brand" href="#">Restaurante</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Page 1</a></li>
			<li><a href="#">Page 2</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=request.getAttribute("usuario")%></a></li> <!-- Aca estoy sacando la variable de sesion para mostrarla en pantalla -->
			<li><a href="/Restaurante/Salir"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li> <!-- con href puedo llamar a un controlador como con un form action -->
		</ul>
		</div>
	</nav> 

	<body background="imagenes/fondo.jpeg">
	</body>
</html>