package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.LoginABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorLogin")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * cuando pulso el boton sign in ingreso a este metodo donde tengo que
		 * buscar al usuario en la base de datos para autenticarlo
		 */

		String nick = request.getParameter("nick");
		String clave = request.getParameter("clave");

		/*
		 * con request.getParameter("nombreInput") capturo los datos ingresados
		 * por el usuario en este caso el nick y su clave y los almaceno en una
		 * variable local del metodo para buscarlo en la base
		 */

		TipoUsuarioABM tipoUsuarioABM = new TipoUsuarioABM();
		LoginABM loginABM = new LoginABM();
		UsuarioABM usuarioABM = new UsuarioABM();

		PrintWriter out = response.getWriter();

		try {
			loginABM.traerLogin(nick);

		} catch (Exception e) {						
			e.printStackTrace(out);
		}
		
		//request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);

		// new java.io.PrintWriter("<div class=container><div
		// class=col-xs-12><div class=alert-spot alert-spot-danger><div
		// class=alert-link-text><h4> Usuario o contraseña incorrectos
		// </h4><p>Si ha olvidado su contraseña, pongase en contacto con un
		// administrador del sistema.</p></div></div></div></div>")
		/*
		 * if(nick.compareTo("asd")==0){
		 * request.setAttribute("usuario","Pizarro Maximiliano");
		 * request.getRequestDispatcher("/jsp/bienvenido.jsp").forward(request,
		 * response); }else{
		 * request.getRequestDispatcher("/jsp/index.jsp").forward(request,
		 * response); }
		 */
		/*
		 * con request.getRequestDispatcher("/jsp/nombreVista.jsp") lo que hago
		 * es decirle a que vista voy a pasar con request.setAttribute asigno
		 * una variable de sesion para poder llamar en otra vista ver bienvenido
		 * 
		 * 
			// 
			out.write("<div class=container><div class=col-xs-12>" + "<div class=alert-spot alert-spot-danger>"
					+ "<div class=alert-link-text><h4> Usuario o contraseña incorrectos </h4>"
					+ "<p>Si ha olvidado su contraseña, pongase en contacto con un administrador del sistema.</p>"
					+ "</div></div></div></div>" + "	<body background=imagenes/fondo.jpeg>" + "<div class=container>"
					+ "<form class=form-signin  method=POST action=/Restaurante/Inicio >"
					+ "<h2 class=form-signin-heading>Login</h2>"
					+ "<label for=inputEmail class=sr-only>Usuario: </label>"
					+ "<input type=text id=inputEmail class=form-control placeholder=Usuario required autofocus name=nick autocomplete=off>"
					+ "<br><label for=inputPassword class=sr-only>Contraseña: </label>"
					+ "<input type=password id=inputPassword class=form-control placeholder=Contraseña required name=clave autocomplete=off>"
					+ "<br><button class=btn btn-lg btn-primary btn-block type=submit>Sign in</button> </form></div></body> ");
			
		 */

	}

}
