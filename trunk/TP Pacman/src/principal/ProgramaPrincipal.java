package principal;

import modelo.*;
import interfasesYControladores.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		Juego unJuego=new Juego();
		
		ControladorJuego cont = new ControladorJuego(unJuego);
		
		cont.setIntervaloSimulacion(100);
		
		cont.comenzar();
	} 
}