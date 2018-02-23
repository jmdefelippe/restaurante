<%@page import="java.util.*" %>
<%@page import="datos.Mesa" %>
<%@page import="negocio.Facade" %>
<%@page import="java.io.PrintWriter" %>

<% 
	Mesa mesa = new Mesa();
	Facade facade = new Facade();	

	List<Mesa> mesas = facade.getMesaABM().traerMesa();
	PrintWriter salida = response.getWriter();
		
	salida.println("<option value='' selected disabled> Seleccione una mesa: </option>");
	
	for(int i=0 ; i<mesas.size() ; i++){
		salida.println("<option value='"+mesas.get(i).getIdMesa()+"'> Mesa "+(i+1)+" </option>");
	}


%>