package test.ar.uba.fi.algo3.titiritero.ejemplo;

import graphicCollection.Ventana;
import test.ar.uba.fi.algo3.titiritero.ejemplo.vista.VentanaPrincipal;
import TP3.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		Juego unJuego=new Juego();
		unJuego.setIntervaloSimulacion(60);
		unJuego.comenzar();
	}
}