package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Login;
import datos.Mesa;
import negocio.Facade;

/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorDetalleMesa")
public class ControladorDetalleMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorDetalleMesa() {
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
		 * cuando pulso el boton entrar ingreso a este metodo donde tengo que
		 * buscar al usuario en la base de datos para autenticarlo
		 */
		HttpSession session = request.getSession();
		
		String idMesa = request.getParameter("idMesa");
		
		/*
		 * con request.getParameter("nombreInput") capturo los datos ingresados
		 * por el usuario en este caso el nick y su clave y los almaceno en una
		 * variable local del metodo para buscarlo en la base
		 */
		
		Facade facade = new Facade();

		PrintWriter out = response.getWriter();

		try {
			Mesa mesa = facade.getMesaABM().traerMesa(Integer.parseInt(idMesa));
			
			int intIdMesa = mesa.getIdMesa();
			
			session.setAttribute("idMesa", idMesa);
			
			request.getRequestDispatcher("/jsp/ajaxDetalleMesa.jsp").forward(request, response);
								

		} catch (Exception e) {						
		
			e.printStackTrace(out);
		}


	}

}
