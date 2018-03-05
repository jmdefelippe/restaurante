<%@page import="java.util.*" %>
<%@page import="datos.*" %>
<%@page import="negocio.Facade" %>
<%@page import="java.io.PrintWriter" %>

<input type="hidden" id="idMesa" value="<%= request.getParameter("idMesa") %>" />
<div id="contenedorOcupar">
<span class="etiquetaMesa">Seleccione un cliente</span>
<select id="selectClientes">
	
	<%
	
	//Obtengo dinámicamente las opciones de clientes.
	String opcionesClientes = "";
	Facade facade = new Facade();
	for (Cliente c: facade.getClienteABM().traerCliente()) 
		opcionesClientes += "<option value='" + c.getIdCliente() + "'>" + c.getNombre() + " " + c.getApellido() + "</option>";

	%>
	<%=opcionesClientes %>
</select>

<span class="etiquetaMesa">Seleccione un camarero</span>
<select id="selectCamareros">

<%
	//Obtengo las opciones de los camareros.
	String opcionesCamareros = "";
	for (Camarero ca: facade.getCamareroABM().traerCamarero()) 
		opcionesCamareros += "<option value='" + ca.getIdCamarero() + "'>" + ca.getNombre() + " " + ca.getApellido() + "</option>";

%>
	<%=opcionesCamareros %>
</select>


</div>

<div id="btnOcupar">OCUPAR</div>
