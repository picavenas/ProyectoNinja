<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Jugadores"%>
<%@ page import="com.ies.baroja.Controller"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Listado de jugadores de la NBA</title>
</head>
<body>
	<div class="container mt-3">
		<h1>Listado de jugadores</h1>
		<table class="table table-striped">
			<thead class="table-dark">
				<tr>
					<th>nombre</th>
					<th>procedencia</th>
					<th>altura</th>
					<th>peso</th>
					<th>posicion</th>
					<th>nombre_equipo</th>
				</tr>
			</thead>
			<tbody>
			<%
			//java code 
					LinkedList<Jugadores> lista=Controller.getJugadores();
for(int i=0; i < lista.size(); i++){
	if(i%2==0){
		out.println("<tr class='table-primary'>");
	}
	else{
		out.println("<tr class='table-sucess'>");

	}
	out.println("<td>"+lista.get(i).getNombre() + "</td>");
	out.println("<td>"+lista.get(i).getProcedencia() + "</td>");
	out.println("<td>"+lista.get(i).getAltura()+"</td>");
	out.println("<td>"+lista.get(i).getPeso()+"</td>");
	out.println("<td>"+lista.get(i).getPosicion()+"</td>");
	out.println("<td>"+lista.get(i).getNombre_equipo()+"</td>");
	out.println("</tr>");
}
			%>
			
			
			
			</tbody>
		</table>
	</div>
</body>
</html>