<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mostrar Cliente</title>
</head>
<body>
    <h1>Datos del cliente</h1>

    <%
    // Obtén los datos del request
    int sessions = (int) request.getAttribute("sessions");
    int competiciones = (int) request.getAttribute("competiciones");
    String nombre = (String) request.getAttribute("nombre");
    String nivel = (String) request.getAttribute("nivel");
    String peso = (String) request.getAttribute("peso");

    // Calcula el precio de las competiciones
    double precioCompeticiones = competiciones * 22.00;
    String precioCompeticionesConSimbolo = String.format("%.2f£", precioCompeticiones);
    double precioSessions = sessions * 9.50;
    String precioSessionsConSimbolo = String.format("%.2f£", precioSessions);

    // Calcula el precio dependiendo del nivel
    double precioNivel = 0.0;
    if (nivel.equals("beginner")) {
        precioNivel = 5.0;
    } else if (nivel.equals("intermediate")) {
        precioNivel = 10.0;
    } else if (nivel.equals("elite")) {
        precioNivel = 15.0;
    }

    // Calcula el precio total
    double precioTotal = precioCompeticiones +  precioNivel + precioSessions;
    String precioTotalConSimbolo = String.format("%.2f£", precioTotal);
    %>

    <div>
    	<p>Nombre: <%= nombre %></p>
    	<p>Nivel: <%= nivel %></p>
    	<p>Categoría de peso: <%= peso %></p>
        <p>Sessions: <%= sessions %></p>
        <p>Precio de las sesiones: <%= precioSessionsConSimbolo %></p>
        <p>Competiciones: <%= competiciones %></p>
        <p>Precio de las competiciones: <%= precioCompeticionesConSimbolo %></p>
        <p>Precio total: <%= precioTotalConSimbolo %></p>            
    </div>
</body>
</html>


