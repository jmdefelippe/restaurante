<%@page import="java.util.*" %>
<%@page import="datos.Mesa" %>
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
	String reservada = "terminada";
	String auxEstado = "";
	int auxSalon = 0;
	
	int contadorLibresSalon1 = 0;
	int contadorOcupadasSalon1 = 0;
	int contadorReservadasSalon1 = 0;
	int contadorLibresSalon2 = 0;
	int contadorOcupadasSalon2 = 0;
	int contadorReservadasSalon2 = 0;
	
	//salida.println("<div style='width: 60px; height: 50px; margin: 10px; display: inline-block; background-color: #00FF00;'> </div>");

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

		} else if (auxEstado.compareTo("terminada")==0){
			color = "#FFAA00";
			if (auxSalon == 1)
				contadorReservadasSalon1++;
			else if (auxSalon == 2)
				contadorReservadasSalon2++;
		}
		
		salida.println("<div id='mesa"+i+"' class='mesa' style='display: inline-block; background-color: " + color + ";' > Mesa " + i + "  </div>");
	}

	
%>



<div id="contenedorEtiquetasEstados">
	<span style="color: #FFFFFF">ESTADOS POSIBLES:</span>
	<br/><br/>
	<span style="color: #00FF00">LIBRE</span>
	<span style="color: #FF0000">OCUPADA</span>
	<span style="color: #FFAA00">TERMINADA</span>
</div>

<div id="contenedorEstado">
<div class="etiquetaMesa">REPORTE DE ESTADO</div>
</div>

<table id="estadoSalon">
<tr><td class="cabeceraEstadoSalon">SAL&Oacute;N 1</td><td class="acomodarCabeceraEstadoSalon"></td></tr>
<tr><td>Mesas libres</td><td class="numeroEstadoSalon"><%=contadorLibresSalon1 %></td></tr>
<tr><td>Mesas ocupadas</td><td class="numeroEstadoSalon"><%=contadorOcupadasSalon1 %></td></tr>
<tr><td>Mesas terminadas</td><td class="numeroEstadoSalon"><%=contadorReservadasSalon1 %></td></tr>
<tr><td class="cabeceraEstadoSalon">SAL&Oacute;N 2</td><td class="acomodarCabeceraEstadoSalon"></td></tr>
<tr><td>Mesas libres</td><td class="numeroEstadoSalon"><%=contadorLibresSalon2 %></td></tr>
<tr><td>Mesas ocupadas</td><td class="numeroEstadoSalon"><%=contadorOcupadasSalon2 %></td></tr>
<tr><td>Mesas terminadas</td><td class="numeroEstadoSalon"><%=contadorReservadasSalon2 %></td></tr>
</table>


<%
// 	salida.println("<h2> ----------------------------------- </h2>");
// 	salida.println("<h2> ----------------------------------- </h2>");	
	//salida.println("<option value='"+mesas.get(i-1).getIdMesa()+"'>"+mesas.get(i-1).getCapacidad()+"</option>");	
	
	//salida.println('<div style="width: 100px; height: 100px; margin: 10px; background-color: ' + Color + '"></div>');
	
%>