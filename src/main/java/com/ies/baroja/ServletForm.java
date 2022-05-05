package com.ies.baroja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Jugadores;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**1-recoger datos*/
		Jugadores jugador=new Jugadores(request.getParameter("nombre"),
		request.getParameter("procedencia"),
		request.getParameter("altura"),
		request.getParameter("peso"),
		request.getParameter("posicion"),
		request.getParameter("nombre_equipo"));
		
		System.out.println("jugador desde html "+ jugador);
		/**2-insertar datos en base de datos*/
		
		boolean bResIns=Controller.insertarJugador(jugador);
		/**3-Mostrar resultado por pantalla*/
		if(bResIns) {
			System.out.println("Exito ");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>insercion correcta </h1>");
		}else {
			System.out.println("fracaso ");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>ERROR </h1>");
		}
	}

}
