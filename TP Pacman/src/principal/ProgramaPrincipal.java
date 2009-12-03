package principal;

import TP3.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		Juego unJuego=new Juego();
		unJuego.setIntervaloSimulacion(100);
		unJuego.comenzar();
	} 
}