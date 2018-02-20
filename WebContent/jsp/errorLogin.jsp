<%@include file="header.jsp" %>	
 
<html>
	<body background="imagenes/fondo.jpeg">
	    <div class="container">
	    	<h3> Los datos ingresados no corresponden a un usuario válido </h3>
	    	
			<form class="form-signin"  method="POST" action="/Restaurante/Inicio ">
				<h2 class="form-signin-heading">Login</h2>
				<label for="inputEmail" class="sr-only">Usuario: </label>
				<input type="text" id="inputEmail" class="form-control" placeholder="Usuario" required autofocus name="nick" autocomplete="off">
				<br> 
				<label for="inputPassword" class="sr-only">Contraseña: </label>
				<input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required name="clave" autocomplete="off">
				<br> 
			 	<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
			</form>
	    </div>
	</body>
</html>