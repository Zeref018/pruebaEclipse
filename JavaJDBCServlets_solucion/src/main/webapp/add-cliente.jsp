<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Formulario de Solocrossfit</title>
  
  <script>
    window.addEventListener('DOMContentLoaded', (event) => {
      const nivelSelect = document.getElementById('nivel');
      const competicionesInput = document.getElementById('competiciones');

      nivelSelect.addEventListener('change', () => {
        if (nivelSelect.value === 'beginner') {
          competicionesInput.disabled = true;
          
          competicionesInput.style.display = "none";
        } else {
          competicionesInput.disabled = false;
          competicionesInput.style.display = "block";
        }
      });

      
    });
  </script>
</head>
<body>
  <h1>Formulario de Solocrossfit</h1>

  <form method="post" action="add">
    <label for="nombre">Nombre de Usuario:</label>
    <input type="text" id="nombre" name="nombre" required>

    <br>

    <label for="nivel">Nivel:</label>
    <select id="nivel" name="nivel">
      <option value="beginner">Beginner (2 sesiones por semana) - $25</option>
      <option value="intermediate">Intermediate (3 sesiones por semana) - $30</option>
      <option value="elite">Elite (5 sesiones por semana) - $35</option>
    </select>

    <br>

    <label for="private-sessions">Número de Sesiones Privadas por hora:</label>
    <input type="number" id="private-sessions" name="private-sessions" min="0" max="20">

    <br>

    <label for="competiciones">Número de Competiciones:</label>
    <input type="number" id="competiciones" name="competiciones" min="0" max="10" disabled>

    <br>

    <label for="peso">Peso en kg:</label>
    <select id="peso" name="peso">
      <option value="Flyweight">66 - 72 KG</option>
      <option value="Lightweight">73 - 80 KG</option>
      <option value="Light-Middleweight">81 - 89 KG</option>
      <option value="Middleweight">90 - 99 KG</option>
      <option value="Light-Heavyweight">100 KG</option>
      <option value="Heavyweight">100+ KG</option>
    </select>

    <br>

    <input type="submit" value="Enviar">
  </form>
</body>
</html>

