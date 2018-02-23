<%@page import="java.util.*" %>
<%@page import="datos.Mesa" %>
<%@page import="negocio.Facade" %>
<%@page import="java.io.PrintWriter" %>
<%@page import = "javax.servlet.http.HttpServletRequest" %>
<% 
PrintWriter salida = response.getWriter();
	Mesa mesa = new Mesa();
	Facade facade = new Facade();	
	int id = Integer.parseInt(request.getParameter("idMesa"));
	mesa = facade.getMesaABM().traerMesa(id);
	
	//facade.getMesaABM().traerMesa(id).getEstadoMesa().ocupar(cliente) llamar metodos
	
	
  	salida.println("<h2> ** ID Mesa: " + mesa.getIdMesa() + "</h2>");
  	salida.println("<h2> ** Capacidad: " + mesa.getCapacidad() + "</h2>");
  	salida.println("<h2> ** Estado Mesa: " + mesa.getState()+ "</h2>");


%>