<%@page import="java.util.*" %>
<%@page import="datos.Mesa" %>
<%@page import="datos.Rubro" %>
<%@page import="negocio.Facade" %>
<%@page import="java.io.PrintWriter" %>

<% 
 	Mesa mesa = new Mesa();
	Facade facade = new Facade();	
	
	String color = "";
	List<Mesa> mesas = facade.getMesaABM().traerMesa();
	PrintWriter salida = response.getWriter();
	//salida.println("<input type='button' value=''/>");
	
	String libre = "libre";
	String ocupada = "ocupada";
	String reservada = "reservada";
	String auxEstado = "";
	int auxSalon = 0;
	
	int contadorLibresSalon1 = 0;
	int contadorOcupadasSalon1 = 0;
	int contadorReservadasSalon1 = 0;
	int contadorLibresSalon2 = 0;
	int contadorOcupadasSalon2 = 0;
	int contadorReservadasSalon2 = 0;
	
	for(int i=1 ; i<=mesas.size() ; i++){
		auxEstado = mesas.get(i-1).getState();
		auxSalon = mesas.get(i-1).getSalon().getIdSalon();
				
		if	(auxEstado.compareTo(libre)== 0) {
			color = "#00FF00";
			if (auxSalon == 1)
				contadorLibresSalon1++;
			else if (auxSalon == 2)
				contadorLibresSalon2++;
		} else if (auxEstado.compareTo(ocupada)==0){
			color = "#FF0000";
			if (auxSalon == 1)
				contadorOcupadasSalon1++;
			else if (auxSalon == 2)
				contadorOcupadasSalon2++;

		} else if (auxEstado.compareTo(reservada)==0){
			color = "#FFAA00";
			if (auxSalon == 1)
				contadorReservadasSalon1++;
			else if (auxSalon == 2)
				contadorReservadasSalon2++;
		}
		
		salida.println("<div id='mesa"+i+"' style='width: 60px; height: 50px; margin: 10px; display: inline-block; background-color: " + color + ";' > Mesa " + i + "  </div>");
		
	}

	salida.println("<br><br>");
	salida.println("<h2> REPORTE DE ESTADOS </h2>");
	salida.println("<h2> ---------- SALON 1 ---------- </h2>");
	salida.println("<h2> ** Mesas libres: " + contadorLibresSalon1 + "</h2>");
	salida.println("<h2> ** Mesas ocupadas: " + contadorOcupadasSalon1 + "</h2>");
	salida.println("<h2> ** Mesas reservadas: " + contadorReservadasSalon1 + "</h2>");
	
	salida.println("<h2> ---------- SALON 2 ---------- </h2>");
	salida.println("<h2> ** Mesas libres: " + contadorLibresSalon2 + "</h2>");
	salida.println("<h2> ** Mesas ocupadas: " + contadorOcupadasSalon2 + "</h2>");
	salida.println("<h2> ** Mesas reservadas: " + contadorReservadasSalon2 + "</h2>");
// 	salida.println("<h2> ----------------------------------- </h2>");
// 	salida.println("<h2> ----------------------------------- </h2>");	
	//salida.println("<option value='"+mesas.get(i-1).getIdMesa()+"'>"+mesas.get(i-1).getCapacidad()+"</option>");	
	
	//salida.println('<div style="width: 100px; height: 100px; margin: 10px; background-color: ' + Color + '"></div>');
	
%>