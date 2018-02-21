<%@page import="java.util.*" %>
<%@page import="datos.Mesa" %>
<%@page import="datos.Rubro" %>
<%@page import="negocio.Facade" %>
<%@page import="java.io.PrintWriter" %>

<% 
 	Mesa mesa = new Mesa();
	Facade facade = new Facade();	
	
// 	String color;
// 	List<Mesa> mesas = facade.getMesaABM().traerMesa();
	PrintWriter salida = response.getWriter();
// 	salida.println("<option value='' selected disabled>Seleccionar</option>");
// 	for(int i=1 ; i<=mesas.size() ; i++){
// 	  salida.println("<option value='"+mesas.get(i-1).getIdMesa()+"'>"+mesas.get(i-1).getCapacidad()+"</option>");
// 	}

	Rubro rubro = facade.getRubroABM().traerRubro(1);
	salida.println(rubro.getNombre());
	salida.println("<input type='text'>");
	out.write("dsfjdsfldklfa");
	
	
	
%>