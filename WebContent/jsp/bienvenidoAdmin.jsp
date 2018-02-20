<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link href="css/estilos.css" rel="stylesheet">
	<h1> Bienvenido Administrador!</h1>

	<body background="imagenes/fondo.jpeg">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#">Restaurante</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">ABM ComponenteMenu</a></li>
				<li><a href="#">ABM Menu</a></li>
				<li><a href="#">ABM Producto</a></li>
				<li><a href="#">ABM Rubro</a></li>
				<li><a href="#">ABM Subrubro</a></li>
				<li><a href="#">Alta y modificación Plato</a></li>
				<li><a href="#">ABM Ingrediente</a></li>
				<li><a href="#">ABM Conversion</a></li>
				<li><a href="#">ABM Mesa</a></li>
				<li><a href="#">emitirLayout</a></li>
				<li><a href="#">traerTicketsCortesia</a></li>
				<li><a href="#">ABM ListaPrecio</a></li>
				<li><a href="#">ABM TipoCliente</a></li>
				<li><a href="#">emitirReporteVentasProducto</a></li>
				<li><a href="#">emitirReporteVentasPeriodo</a></li>
				<li><a href="#">ABM Login</a></li>
				<li><a href="#">ABM Usuario</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
<%-- 				<li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=request.getAttribute("nick")%></a></li> <!-- Aca estoy sacando la variable de sesion para mostrarla en pantalla --> --%>
				<li><a href="/Restaurante/Salir"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li> <!-- con href puedo llamar a un controlador como con un form action -->
			</ul>
			</div>
		</nav> 
	</body>

</html>