<%@include file="header.jsp" %>	
 
<html>


	<body background="imagenes/fondo.jpeg">

    <div class="container">
		<form class="form-signin"  method="POST" action="/Restaurante/Inicio ">
			<h2 class="form-signin-heading">Login</h2>
			<label for="inputEmail" class="sr-only">Usuario: </label>
			<input type="text" id="inputEmail" class="form-control" placeholder="Usuario" required autofocus name="nick" autocomplete="off">
			<br> 
			<label for="inputPassword" class="sr-only">Contraseña: </label>
			<input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required name="clave" autocomplete="off">
			<br> 
	<!--	<div class="checkbox">
				<label>
					<input type="checkbox" value="remember-me"> Recordarme
				</label>
			</div>
	--> 	<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>
    </div> 
    
  </body>



	</body>
</html>