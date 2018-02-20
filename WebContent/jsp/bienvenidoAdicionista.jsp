<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link href="css/estilos.css" rel="stylesheet">
	<h1> Bienvenido Adicionista!</h1>

	<body background="imagenes/fondo.jpeg">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#">Restaurante</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">dejarDisponible</a></li>
				<li><a href="#">ocupar</a></li>
				<li><a href="#">terminar</a></li>
				<li><a href="#">ABM Comanda</a></li>
				<li><a href="#">emitirPreTicket</a></li>
				<li><a href="#">emitirTicket</a></li>
				<li><a href="#">sumarImporte</a></li>
				<li><a href="#">ABM Usuario</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
<%-- 				<li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=request.getAttribute("usuario")%></a></li> <!-- Aca estoy sacando la variable de sesion para mostrarla en pantalla --> --%>
				<li><a href="/Restaurante/Salir"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li> <!-- con href puedo llamar a un controlador como con un form action -->
			</ul>
			</div>
		</nav> 
	</body>

</html>