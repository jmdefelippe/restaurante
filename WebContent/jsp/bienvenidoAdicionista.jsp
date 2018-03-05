<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="datos.Mesa" %>
<%@page import="datos.Rubro" %>
<%@page import="negocio.Facade" %>
<%@page import="java.io.PrintWriter" %>
<%@include file="header.jsp" %>	
<%@page import = "javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link href="css/estilos.css" rel="stylesheet">
	
	<script src="js/jquery.min.js"></script>
	<script src="js/principal.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<h1> Bienvenido Adicionista!</h1>

	<head>

		
	
	
		<script>

	</script>
		
	
<!-- 	<script> -->
<!-- // 		$(document).on("change", "#selectMesas",  function() { -->
<!-- // 			alert("Funciona"); -->
<!-- // 			var mesaElegida = $("#selectMesas").val(); -->

<!-- // 			$("#detalleMesas").text(mesaElegida); -->

<!-- // 		}); -->
<!-- 	</script> -->
		
	
		
	</head>


	<body background="imagenes/fondo.jpeg">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#">Restaurante</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Layout</a></li>
		</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=request.getParameter("nick")%></a></li> <!-- Aca estoy sacando la variable de sesion para mostrarla en pantalla -->
				<li><a href="/Restaurante/Salir"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li> <!-- con href puedo llamar a un controlador como con un form action -->
			</ul>
			</div>
		</nav> 
	
		<input type="hidden" id="idUsuario" value="<%= session.getAttribute("idUsuario")%>"/>
		
		<div id="layout">
		</div>	
		
		
		<div id='contenedorSelectMesas'><span class='etiquetaMesa'>Seleccione su mesa:</span>
		<form>
			<select id="selectMesas" name="selectMesas" >
			<%
			Mesa mesa = new Mesa();
			Facade facade = new Facade();	

			List<Mesa> mesas = facade.getMesaABM().traerMesa();
			PrintWriter salida = response.getWriter();
				

			String imprimirSelect = "";
			for(int i=0 ; i<mesas.size() ; i++){
				imprimirSelect = imprimirSelect + "<option value='" + mesas.get(i).getIdMesa() + "'> Mesa " + (i+1);
				imprimirSelect = imprimirSelect + "</option>";
			//	salida.println();
			}
			%>
			<%= imprimirSelect %>
			
      		</select>
		</form>
		</div>
		
		<div id="detalleMesa" name="detalleMesa">
		
		</div>
		
		
		

		
	</body>

</html>