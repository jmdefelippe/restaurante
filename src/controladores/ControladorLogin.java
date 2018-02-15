package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* cuando pulso el boton sign in ingreso a este metodo donde tengo que buscar al 
		 * usuario en la base de datos para autenticarlo 
		 */
		
		String nick= request.getParameter("nick");
		String clave= request.getParameter("clave");
		
		/* con request.getParameter("nombreInput") capturo los datos ingresados por el usuario
		 * en este caso el nick y su clave y los almaceno en una variable local del metodo para buscarlo en la base
		 */
		
		
		if(nick.compareTo("asd")==0){
		request.setAttribute("usuario","Pizarro Maximiliano");	
		request.getRequestDispatcher("/jsp/bienvenido.jsp").forward(request, response);
		}else{
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);	
		}
		/* con request.getRequestDispatcher("/jsp/nombreVista.jsp") lo que hago es decirle a que vista voy a pasar
		 * con request.setAttribute asigno una variable de sesion para poder llamar en otra vista
		 * ver bienvenido 
		 */
		
		
	}

}
