<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link href="css/estilos.css" rel="stylesheet">
	
	<script src="js/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<h1> Bienvenido Adicionista!</h1>

	<head>
		<script>
			$(document).ready(function(){
				    if (window.XMLHttpRequest) {
			            // code for IE7+, Firefox, Chrome, Opera, Safari
			            xmlhttp = new XMLHttpRequest();
			        } else {
			            // code for IE6, IE5
			            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			        }
			        xmlhttp.onreadystatechange = function() {
			            if (this.readyState == 4 && this.status == 200) {
			             //$('#layout').append(this.responseText);
			            	document.getElementById("layout").innerHTML = this.responseText;
			        		
// 			            	$("#mesa1").on("click", function() {
// 			        			alert("MESAAAA 1"); 
// 			        		});
			        		
			            }
			        };
			        xmlhttp.open("GET","jsp/ajaxLayout.jsp?="+1,true);
			        xmlhttp.send();
			});
		</script>
	</head>


	<body background="imagenes/fondo.jpeg">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#">Restaurante</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Layout</a></li>
<!-- 				<li><a href="#">dejarDisponible</a></li> -->
<!-- 				<li><a href="#">ocupar</a></li> -->
<!-- 				<li><a href="#">terminar</a></li> -->
<!-- 				<li><a href="#">ABM Comanda</a></li> -->
<!-- 				<li><a href="#">emitirPreTicket</a></li> -->
<!-- 				<li><a href="#">emitirTicket</a></li> -->
<!-- 				<li><a href="#">sumarImporte</a></li> -->
<!-- 				<li><a href="#">ABM Usuario</a></li> -->
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=request.getParameter("nick")%></a></li> <!-- Aca estoy sacando la variable de sesion para mostrarla en pantalla -->
				<li><a href="/Restaurante/Salir"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li> <!-- con href puedo llamar a un controlador como con un form action -->
			</ul>
			</div>
		</nav> 
		
		
<!-- 		<form> -->
<!-- 			<select name="mesas" onchange="showUser(this.value)"> -->
<!-- 				<option value="">Seleccione una mesa:</option> -->
<!-- 				<option value="1">Mesa 1</option> -->
<!-- 				<option value="2">Mesa 2</option> -->
<!-- 				<option value="3">Mesa 3</option> -->
<!-- 				<option value="4">Mesa 4</option> -->
<!-- 				<option value="5">Mesa 5</option> -->
<!-- 				<option value="6">Mesa 6</option> -->
<!-- 				<option value="7">Mesa 7</option> -->
<!-- 				<option value="8">Mesa 8</option> -->
<!-- 				<option value="9">Mesa 9</option> -->
<!-- 				<option value="10">Mesa 10</option>	 -->
<!-- 			</select> -->
<!-- 		</form> -->
		
<!-- 		<br> -->
<!-- 		<div id="mesas"><b>Person info will be listed here...</b></div> -->
		
		<div id="layout">
			
		</div>
		
		
	</body>

</html>