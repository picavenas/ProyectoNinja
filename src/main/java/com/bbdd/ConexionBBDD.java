package com.bbdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Jugadores;

/**
 * Clase que centraliza los métodos de acceso a BBDD
 * 
 * @author JAGD
 * @since 27/05/2021
 */

public class ConexionBBDD {

	Connection conexion; 
	int port = 3306;
	String host= "localhost";
	String db  = "nba";
	String user="root";
	String password="";

	String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	public void conectar() throws SQLException {
		conexion =  DriverManager.getConnection(url, user, password);
	}	
	 

	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
	}
/**
 * 
 * @param sentencia
 * @return
 */
	public ResultSet ejecutarConsulta(String sentencia) {
		ResultSet rsResultado = null;
		try {
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
			rsResultado = prepStatement.executeQuery();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		return rsResultado;
	}
	
	public int insertarVehiculo(String sentencia, String sMatricula, String sMarca, String sModelo) {
		int iRes=0;
		try {
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
			prepStatement.setString(1,sMatricula);
			prepStatement.setString(2,sMarca);
			prepStatement.setString(3,sModelo);
			iRes =  prepStatement.executeUpdate();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		return iRes;
	}
	/**
	 * 
	 * @param jugador
	 * @return
	 */
	public int insertarJugador(Jugadores jugador) {
		int iRes=0;
	String sInsert="insert into Jugadores(Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo)"
			+ "values(?,?,?,?,?,?)";
	try {
		System.out.println("ejecutando: " + sInsert);
		System.out.println("datos a insertar: " + jugador);
      PreparedStatement prepStatement=conexion.prepareStatement(sInsert);
      prepStatement.setString(1, jugador.getNombre());
      prepStatement.setString(2, jugador.getProcedencia());
      prepStatement.setInt(3, Integer.parseInt(jugador.getAltura ()));
      prepStatement.setString(4, jugador.getPeso ());
      prepStatement.setString(5, jugador.getPosicion ());
      prepStatement.setString(6, jugador.getNombre_equipo ());
      
      iRes=prepStatement.executeUpdate();
	}
		catch(SQLException sqlex) {
			System.out.println("ERROR********+ " + sqlex.getMessage());
sqlex.printStackTrace();
		}
	
	
return iRes;
	}
}
