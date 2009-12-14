package controlador;

import controlador.*;
import modelo.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		Juego unJuego=new Juego();
		
		ControladorJuego cont = new ControladorJuego(unJuego);
		
		cont.setIntervaloSimulacion(100);
		
		cont.comenzar();
	} 
}