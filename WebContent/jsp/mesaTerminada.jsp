<%@page import="java.util.*" %>
<%@page import="datos.*" %>
<%@page import="negocio.Facade" %>
<%@page import="java.io.PrintWriter" %>

<%

	//Obtengo le ticket.
	Facade facade = new Facade();
	int idTicket = facade.getComandaABM().traerComandasPorIdMesaConCamareroYCliente(Integer.parseInt(request.getParameter("idMesa"))).get(0).getTicket().getIdTicket();

%>
<input type="hidden" id="idMesa" value="<%= request.getParameter("idMesa") %>" />
<div id="contenedorTicket">
<div id="tituloPreTicket">
PRETICKET
</div>
<table id="ticket">
<%

//Genero dinámicamente el contenido del ticket.
String contenidoTicket = "";
for (ItemTicket it: facade.getItemTicketABM().traerItemTicketPorTicketConComponenteMenu(idTicket)) {
	
	//Imprimo la cantidad
	contenidoTicket += "<tr><td class='cantidadPreTicket'>" + it.getCantidad() + "</td>";
	contenidoTicket += "<td class='itemPreTicket'>" + it.getComponenteMenu().getNombre() + "</td>";
	contenidoTicket += "<td class='precioPreTicket'>$" + it.getImporte() + "</td></tr>";
}

%>
<%=contenidoTicket %>

<tr>
	<td class="cantidadPreTicket"></td>
	<td class="itemPreTicket">TOTAL</td>
	<%
		float totalFinal = facade.getTicketABM().traerTicket(idTicket).getTotal();
	%>
	<td class="precioPreTicket"><%=totalFinal %></td>
</tr>
</table>
</div>

<div id="contenedorCortesia">
<span class="etiquetaMesa">Es de cortes&iacute;a?</span>
<select id="selectCortesia">
	<option value="0">No</option>
	<option value="1">S&iacute;</option>
</select>
</div>

<div id="btnLiberarMesa">LIBERAR</div>	