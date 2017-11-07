<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >



<html>
	<head>
		<title>Restaurante</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="js/bootstrap.min.js"></script>
		<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="shortcut icon" type="image/png" href="imagenes/favicon.png" />
		
	</head>
	<body>
<!-- 		<body style="background-color:#3c3c3c;"> -->

		<FORM method="POST" action="/Restaurante/Inicio ">
			<p><h5> Restaurante </h5> </p>
				  <div class="col-lg-2">
					<label>Usuario: </label>
					<input class="form-control " name="nick" type="text">
					<br>
					<label>Contraseña: </label>
					<input class="form-control " name="clave" type="password">
					<br>
					<input type="submit" value="Entrar">
				  </div>
		</FORM>



	</body>
</html>