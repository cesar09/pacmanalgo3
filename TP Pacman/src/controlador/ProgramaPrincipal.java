package controlador;

import Vista.Ventana;
import Vista.VentanaPrincipal;
import modelo.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		Juego unJuego=new Juego();
		
		ControladorJuego cont = new ControladorJuego(unJuego);
		Ventana ventanaPrincipal = new VentanaPrincipal();
		cont.setSuperficieDeDibujo(ventanaPrincipal);		
		cont.setIntervaloSimulacion(100);
		
		cont.comenzar();
	} 
}