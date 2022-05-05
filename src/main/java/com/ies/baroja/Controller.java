package com.ies.baroja;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.bbdd.ConexionBBDD;
import com.model.Jugadores;
/**get jugadores
 * @return linkedList<Jugadores>
 * @author agent
 **/

public class Controller {
private static String sConsulta = "select Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo from jugadores;";
public static LinkedList<Jugadores> getJugadores() {
	LinkedList<Jugadores> listaJugadores=new LinkedList<Jugadores>();
	ConexionBBDD miConn=new ConexionBBDD();
	try {
		miConn.conectar();
		//lanza,¡mos caonsulta
		ResultSet rsResultado=miConn.ejecutarConsulta(sConsulta);
		
		if(rsResultado!=null){
			
			while(rsResultado.next()) {
				Jugadores jugador = new Jugadores(rsResultado.getString("Nombre"),
				rsResultado.getString("Procedencia"),
				rsResultado.getString("Altura"),
				rsResultado.getString("Peso"),
				rsResultado.getString("Posicion"),
				rsResultado.getString("Nombre_equipo"));
				listaJugadores.add(jugador);
			}
		}
		else {
			System.out.println("error no hay datos");
		}
		
	}
	catch(SQLException sqlex){
		sqlex.printStackTrace();
	}
	finally {
		miConn.desconectar();
	}
	return listaJugadores;
}
public static boolean insertarJugador(Jugadores jugador) {
	boolean bRes=true;
	/**1 conectar a bbdd*/
	 ConexionBBDD miConn=new ConexionBBDD(); 
	 try {
		 /**2 obtener conexion */
		 miConn.conectar();
		 /**3 insertar jugador */
		 int iRes=miConn.insertarJugador(jugador);
		 System.out.println("Resultado de insergtar jugador "+iRes);
	 }
	 catch(SQLException sqlex)
	 { System.out.println("ERROR***** "+sqlex.getMessage());
		 sqlex.printStackTrace();
	 }finally {
		 //desconectar la BBDD
		 miConn.desconectar();
	 }
	 return bRes;
}
}
