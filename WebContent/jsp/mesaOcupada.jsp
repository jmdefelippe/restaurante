<%@page import="java.util.*" %>
<%@page import="datos.*" %>
<%@page import="negocio.Facade" %>
<%@page import="java.io.PrintWriter" %>

<input type="hidden" id="idMesa" value="<%= request.getParameter("idMesa") %>" />
<table class="tablaComanda">
<%
Facade facade = new Facade();
Comanda comanda = new Comanda();
comanda = facade.getComandaABM().traerComandasPorIdMesaConCamareroYCliente(Integer.parseInt(request.getParameter("idMesa"))).get(0);


int cantidad = facade.getItemComandaABM().traerItemsComandaPorComandaConComponente(comanda.getIdComanda()).size();
String contenidoComandas = "";

//Si la cantidad de comandas es igual a cero, muestro que no hay comandas.
if (cantidad == 0) {
	contenidoComandas = "<div class='error'>No hay una comanda cargada</div>";

//Si sí las hay, genero la tabla dinámicamente.
} else {

	//Coloco las cabeceras de las comandas.
	contenidoComandas += "<tr><td class='cabeceraTabla'>Componente</td>";
	contenidoComandas += "<td class='cabeceraTabla'>Cantidad</td>";
	contenidoComandas += "<td class='cabeceraTabla'>Eliminar</td></tr>";			
				
	//Genero dinámicamente el contenido de la tabla.
	for (ItemComanda ic: facade.getItemComandaABM().traerItemsComandaPorComandaConComponente(comanda.getIdComanda())) {
		  		
		contenidoComandas += "<tr>";	
						
		contenidoComandas += "<td class='contenidoTabla'>" + ic.getComponenteMenu().getNombre()  + "</td>";
		contenidoComandas += "<td class='contenidoTabla'>" + ic.getCantidad() + "</td>";
		contenidoComandas += "<td class='contenidoTabla'><div class='btnEliminarItemComanda' data-item='" + ic.getIdItemComanda() + "'>X</div></td>";
					
		contenidoComandas += "</tr>";
	}
}

%>

<%=contenidoComandas %>

</table>


<div id="contenedorComandas">
<span class="etiquetaMesa">Seleccione el componente</span>
<select id="selectComponente" value="1">

<%

//Genero dinámicamente las opciones de las comandas.
String opcionesComponentes = "";
for (ComponenteMenu cm: facade.getComponenteMenuABM().traerComponenteMenu()) 
	opcionesComponentes += "<option value='" + cm.getIdComponenteMenu() + "'>" + cm.getNombre() + "</option>";
%>
<%=opcionesComponentes %>

</select>

<span class="etiquetaMesa">Cantidad:</span>
<select id="cantidadComponente">
	<option value="1" selected>1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>	
</select>
</div>

<div id="btnAgregarComponente">AGREGAR</div>
<div id="btnTerminarMesa">TERMINAR</div>
	
