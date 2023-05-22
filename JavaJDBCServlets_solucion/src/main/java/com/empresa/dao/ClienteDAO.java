package com.empresa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empresa.model.Cliente;

//Data access object : capa de gestion de datos : CRUD
public class ClienteDAO {

	private String endpoint="jdbc:mysql://localhost:3306/test?useSSL=false";
	private String user="root";
	private String pass="";
	
	
	
	public Connection conectar() {
		Connection connection =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(endpoint, user, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}//cierra metodo conectar
	
	
	//insertar
	public void insertCliente(Cliente c) {
        
        // try-with-resource statement will auto close the connection.
        
        	Connection connection = conectar(); 
        	PreparedStatement ps;
			try {
				ps = connection.prepareStatement("INSERT INTO hito4 VALUES (?,?,?,?,?);");
				ps.setInt(1, c.getSessions());
				ps.setInt(2, c.getCompeticiones());
	            ps.setString(3, c.getNombre());
	            ps.setString(4, c.getNivel());
	            ps.setString(5, c.getPeso());
	            ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	
        
    }
	public Cliente mostrarCliente(String nombre1) {
	    Connection connection = conectar();
	    PreparedStatement ps;
	    ResultSet rs;
	    Cliente cliente = null;

	    try {
	        ps = connection.prepareStatement("SELECT * FROM hito4 WHERE nombre = ?;");
	        ps.setString(1, nombre1);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            int sessions = rs.getInt("sessions");
	            int competiciones = rs.getInt("competiciones");
	            String nombre = rs.getString("nombre");
	            String nivel = rs.getString("nivel");
	            String peso = rs.getString("peso");

	            // Crear el objeto Cliente con los datos obtenidos
	            cliente = new Cliente(sessions, competiciones, nombre, nivel, peso);
	        }

	        rs.close();
	        ps.close();
	        connection.close(); // Cerrar la conexión

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return cliente;
	}



}
