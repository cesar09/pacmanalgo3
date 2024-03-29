package controlador;

import Vista.Ventana;
import Vista.VentanaPrincipal;
import modelo.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		Juego unJuego = null;
		Ventana ventanaPrincipal = new VentanaPrincipal();
		int valor=ventanaPrincipal.continuarPartida();
		if (valor==0) unJuego=Juego.recuperarJuego("TP Pacman/Archivos/partida.dat");
		else if(valor==1) unJuego=new Juego();
		
		ControladorJuego cont = new ControladorJuego(unJuego);
	
		cont.setSuperficieDeDibujo(ventanaPrincipal);		
		cont.setIntervaloSimulacion(100);
		
		cont.comenzar();
	} 
}