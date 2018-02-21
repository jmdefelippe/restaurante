<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link href="css/estilos.css" rel="stylesheet">
	<head>	
		<script>
			function showUser(str) {
			    if (str == "") {
			        document.getElementById("txtHint").innerHTML = "";
			        return;
			    } else { 
			        if (window.XMLHttpRequest) {
			            // code for IE7+, Firefox, Chrome, Opera, Safari
			            xmlhttp = new XMLHttpRequest();
			        } else {
			            // code for IE6, IE5
			            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			        }
			        xmlhttp.onreadystatechange = function() {
			            if (this.readyState == 4 && this.status == 200) {
			                document.getElementById("mesas").innerHTML = this.responseText;
			            }
			        };
			        xmlhttp.open("GET","ajaxLayout.jsp?q="+str,true);
			        xmlhttp.send();
			    }
			}
		</script>
	</head>
	
	
	<h1> Layout</h1>
	<body background="imagenes/fondo.jpeg">
		<form>
		<select name="mesas" onchange="showUser(this.value)">
			<option value="">Select a person:</option>
			<option value="1">Mesa 1</option>
			<option value="2">Mesa 2</option>
			<option value="3">Mesa 3</option>
			<option value="4">Mesa 4</option>
			<option value="5">Mesa 5</option>
			<option value="6">Mesa 6</option>
			<option value="7">Mesa 7</option>
			<option value="8">Mesa 8</option>
			<option value="9">Mesa 9</option>
			<option value="10">Mesa 10</option>	
		  </select>
		</form>
		<br>
		<div id="mesas"><b>Person info will be listed here...</b></div>

	</body>






	</body>

</html>