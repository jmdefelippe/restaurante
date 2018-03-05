var pantallaIniciada = false;


//FUNCIÓN DE ACTUALIZAR EL LAYOUT
function actualizarLayout() {
	
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        	document.getElementById("layout").innerHTML = this.responseText;
    		
    		
        }
    };
    xmlhttp.open("GET","jsp/ajaxLayout.jsp?",true);
    xmlhttp.send();
	
}


//FUNCIÓN DE ACTUALIZAR EL LAYOUT
function actualizarDetalleMesa(parametros) {
	
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
         //$('#layout').append(this.responseText);
        	document.getElementById("detalleMesa").innerHTML = this.responseText;
    		
    		actualizarLayout();
        }
    };
    xmlhttp.open("GET","/Restaurante/Mesas?" + parametros,true);
    xmlhttp.send();
	
}



$(document).ready(function() {
	
	
	//Ocupar comanda.
	if (pantallaIniciada == false) {
		pantallaIniciada = true;
		actualizarDetalleMesa("Metodo=0&idMesa=1");
	}
	

	//Se cambió el valor del select.
	$(document).on("change", "#selectMesas",  function(){
        actualizarDetalleMesa("Metodo=0&idMesa=" + $("#selectMesas").val());
	});

	
	
	//Botón de ocupar la mesa.
	$(document).on("click", "#btnOcupar", function() {

		var parametros = '';
		parametros = "idMesa=" + $("#selectMesas").val() + "&idCamarero=" + $("#selectCamareros").val() + "&idCliente=" + $("#selectClientes").val() + "&Metodo=1";
		actualizarDetalleMesa(parametros);
		
	});


	
	
	//Botón de agregar a la comanda.
	$(document).on("click", "#btnAgregarComponente", function() {
		
		var idComponente = $("#selectComponente").val();
		var cantidadComponente = $("#cantidadComponente").val();
		var idMesa = $("#idMesa").val();
		parametros = "idComponenteMenu=" + idComponente + "&cantidadComponente=" + cantidadComponente + "&idMesa=" + idMesa +  "&Metodo=4";
		actualizarDetalleMesa(parametros);
		})
	
	
		
		
		
	//Botón de eliminar la comanda.
	$(document).on("click", ".btnEliminarItemComanda", function(event) {
		
		var idItemComanda = $(event.target).attr("data-item");
		var idMesa = $("#idMesa").val();
		parametros = "idItemComanda=" + idItemComanda + "&idMesa=" + idMesa + "&Metodo=5";
	
		//Pido la confirmación ed que quiere eliminar la comanda.
		if (confirm("Esta seguro que desea elminar este componente de la comanda?")
 == false) 	return false;
			actualizarDetalleMesa(parametros);
	})

	
	
	//Botón de terminar la mesa.
	$(document).on("click", "#btnTerminarMesa", function() {
		
		var parametros = '';
		parametros = "idMesa=" + $("#selectMesas").val() + "&idUsuario=" + $("#idUsuario").val() + "&Metodo=2";
		actualizarDetalleMesa(parametros);
	
	});
	
	
	
	//Botón de liberar la mesa.
	$(document).on("click", "#btnLiberarMesa", function() {
		
		var parametros = '';
		var esCortesia = $("#selectCortesia").val();
		parametros = "idMesa=" + $("#selectMesas").val() + "&esCortesia=" + esCortesia + "&Metodo=3";
		actualizarDetalleMesa(parametros);
	
	});
	
	
});
