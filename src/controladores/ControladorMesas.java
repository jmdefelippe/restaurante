package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Comanda;
import datos.Login;
import datos.Mesa;
import negocio.Facade;
import negocio.LoginABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorMesas")
public class ControladorMesas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorMesas() {
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

		

		try {

			//Obtengo los datos enviados por el usuario.
			
			PrintWriter salida = response.getWriter();
			Mesa mesa = new Mesa();
			Comanda comanda = new Comanda();

			
			Facade facade = new Facade();	

			
//		 	//Constantes de métodos
			final int ocuparMesa = 1;
			final int terminarMesa = 2;
			final int liberarMesa = 3;
			final int agregarComponente = 4;
			final int quitarComponente= 5;
			
				
//		 	//Obtengo los parámetros enviados por el usuario.
		 	int idMesa = Integer.parseInt(request.getParameter("idMesa"));
		 	mesa = facade.getMesaABM().traerMesa(idMesa);

		  	int metodoInt = Integer.parseInt(request.getParameter("Metodo"));
		 
//		  	int metodoInt = 0;
//		  	if (metodo != null) {
//		 		salida.println("<h2>HAY UN METODO</h2>");
//		  		metodoInt = Integer.parseInt(metodo);
//		  	}
		 	
		 	//Obtengo le ID de la comanda.
		 	int idComanda = 0;
		 	if (request.getParameter("idComanda") != null) idComanda = Integer.parseInt(request.getParameter("idComanda"));
		 	
		 
			//Obtengo el componente del menú.
		 	int idComponenteMenu = 0;
		 	if (request.getParameter("idComponenteMenu") != null) idComponenteMenu = Integer.parseInt(request.getParameter("idComponenteMenu"));
		 	
		 	//Obtengo la cantidad del componente de la comanda.
			int cantidadComponente = 0;
		 	if (request.getParameter("cantidadComponente") != null) cantidadComponente = Integer.parseInt(request.getParameter("cantidadComponente"));

		 	//Obtengo el ID del cliente.
		 	int idCliente = 1;
		 	if (request.getParameter("idCliente") != null) idCliente = Integer.parseInt(request.getParameter("idCliente"));

		 	//Obtengo el ID del camarero.
		 	int idCamarero = 0;
		 	if (request.getParameter("idCamarero") != null) idCamarero = Integer.parseInt(request.getParameter("idCamarero"));

		 	//Obtengo el ID del item de la comanda.
		 	int idItemComanda = 0;
		 	if (request.getParameter("idItemComanda") != null) idItemComanda = Integer.parseInt(request.getParameter("idItemComanda"));

		 	//Obtengo el ID del usuario.
		 	int idUsuario = 0;
		 	if (request.getParameter("idUsuario") != null) idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

		 	//Obtengo el ID del usuario.
		 	int esCortesia = 0;
		 	if (request.getParameter("esCortesia") != null) esCortesia = Integer.parseInt(request.getParameter("esCortesia"));
		 	
		 	
		 	//Coloco si he cargado una comanda o no.
		 	boolean comandaCargada = false;

		 	//Si la hay, obtengo la comanda.
			if (mesa.getState().compareTo("libre") != 0) {
		   		comanda = facade.getComandaABM().traerComandasPorIdMesaConCamareroYCliente(mesa.getIdMesa()).get(0);
		   		comandaCargada = true;
		   	}

		 	
		 	//Realizo el método enviado.
		   	switch(metodoInt) {
			
		 		//OCUPAR MESA (el id de la mesa, cliente y camarero por parámetro)
		   		case 1:

		   			//MOdifico el estado de la mesa.
					mesa.setState("ocupada");
				 	facade.getMesaABM().modificar(mesa);
				
				 	//Genero la nueva comanda para agregar a la mesa.
		   		 	comanda.setCamarero(facade.getCamareroABM().traerCamarero(idCamarero));
		   		 	comanda.setCliente(facade.getClienteABM().traerCliente(idCliente));
		   		 	comanda.setMesa(mesa);
			   		GregorianCalendar fecha = new GregorianCalendar();
			   		comanda.setFechaHora(fecha);
		   			  		 	
			   		//Agrego la comanda y modifico las variables internas. 
		  			facade.getComandaABM().agregar(comanda);
				 	idComanda = comanda.getIdComanda();
					comandaCargada = true;
		   		break;
				
				
		   		//Terminar la mesa:
		   		case 2:
		   			
		   			//Cambio el estado de la mesa y menciono que fue terminada.
		   			mesa.setState("terminada");
		   			facade.getMesaABM().modificar(mesa);
		   			
		   			//Genero el preticket.
		   			facade.getTicketABM().emitirPreTicket(mesa.getIdMesa(), facade.getRestaurantABM().traerRestaurant(1), facade.getUsuarioABM().traerUsuario(idUsuario)).toString();
		  			
			
		   		break;
				
		   			
		   		
		   		//Quiero liberar la mesa.
		   		case 3:
		   			
		   			//Cambio el estado de la mesa.
		   			mesa.setState("libre");
		   			facade.getMesaABM().modificar(mesa);

		   			//Obtengo el ticket
		   			int idPreTicket = facade.getComandaABM().traerComandasPorIdMesaConCamareroYCliente(idMesa).get(0).getTicket().getIdTicket();

		   			//Convierto el preticket en ticket.
		   			if (esCortesia == 0) {
			   			facade.getTicketABM().emitirTicket(facade.getTicketABM().traerTicket(idPreTicket));
		   			} else {
		   				facade.getTicketABM().esCortesia(facade.getTicketABM().traerTicket(idPreTicket));
		   			}
		   			
		   			
		   			
		   		break;
		   		
				
				
				
			//Agregar itemComanda (recibe la comanda, idComponente y cantidad son parámetro)
			case 4:
				facade.getItemComandaABM().agregar(cantidadComponente, facade.getComponenteMenuABM().traerComponenteMenu(idComponenteMenu), comanda);
			break;

			//Eliminar itemComanda (recibe el id del item de la comanda))
			case 5:
				facade.getItemComandaABM().eliminar(idItemComanda);
			break;
			
			
		   	}
			
			
		   	//Según el estado de la mesa, muestro una vista distinta.
		   	if (mesa.getState().compareTo("libre") == 0) {
		   		request.getRequestDispatcher("/jsp/mesaLibre.jsp").include(request, response);
		   	} else if (mesa.getState().compareTo("ocupada") == 0) {
		   		request.getRequestDispatcher("/jsp/mesaOcupada.jsp").include(request, response);		   		
		   	} else if (mesa.getState().compareTo("terminada") == 0) {				
		   		request.getRequestDispatcher("/jsp/mesaTerminada.jsp").include(request, response);
		   	}
		   		
		} catch (Exception e) {						
			//request.getRequestDispatcher("/jsp/errorLogin.jsp").forward(request, response);
			//response.sendError(500, "Los datos ingresados no corresponden a un usuario válido." );
			e.printStackTrace();
		}
		


	}

}
