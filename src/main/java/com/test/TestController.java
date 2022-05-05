package com.test;
import java.util.LinkedList;

import com.ies.baroja.Controller;
import com.model.Jugadores;
public class TestController {
	public static void main(String[]args) {
		System.out.println("inicio **************");
		
		LinkedList<Jugadores> lista=Controller.getjugadores();
		System.out.println("jugadores = "+lista);

	}

}
