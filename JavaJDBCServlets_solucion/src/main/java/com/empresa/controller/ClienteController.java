package com.empresa.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.dao.ClienteDAO;
import com.empresa.model.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String action = request.getServletPath();
		 //routing
		 switch (action) {
		case "/add":
			addCliente(request, response);
			break;
		case "/update":
			updateCliente(request, response);
			break;	
		case "/selectCliente":
			selectCliente(request, response);
			break;
		default:
			listCliente(request, response);
			break;
		}//cierra el switch
	}//cierra el doGet

	private void selectCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    // Obtén el nombre del cliente desde la solicitud
	    String nombre = request.getParameter("nombre");

	    // Crea una instancia de ClienteDAO y llama al método mostrarCliente
	    ClienteDAO dao = new ClienteDAO();
	    Cliente cliente = dao.mostrarCliente(nombre);

	    // Verifica si se encontró un cliente con el nombre especificado
	    if (cliente != null) {
	        // Obtiene los datos del cliente
	        int sessions = cliente.getSessions();
	        int competiciones = cliente.getCompeticiones();
	        String nombreCliente = cliente.getNombre();
	        String nivel = cliente.getNivel();
	        String peso = cliente.getPeso();

	        // Establece los atributos en el objeto request
	        request.setAttribute("sessions", sessions);
	        request.setAttribute("competiciones", competiciones);
	        request.setAttribute("nombre", nombreCliente);
	        request.setAttribute("nivel", nivel);
	        request.setAttribute("peso", peso);
	    }

	    // Redirige a mostrar-select.jsp
	    request.getRequestDispatcher("mostrar-select.jsp").forward(request, response);
	}



	private void listCliente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void updateCliente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void addCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    int sessions = Integer.parseInt(request.getParameter("private-sessions"));
	    int competiciones;
	    if (request.getParameter("competiciones")== null) {
	    	competiciones = 0;
	    }else {
		    competiciones = Integer.parseInt(request.getParameter("competiciones"));

	    }
	    
	    String nombre = request.getParameter("nombre");
	    String nivel = request.getParameter("nivel");
	    String peso = request.getParameter("peso");
	    Cliente cliente = new Cliente(sessions, competiciones, nombre, nivel, peso);

	    

	    ClienteDAO dao = new ClienteDAO();
	    dao.insertCliente(cliente);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
