package principal;

import graphicCollection.KeyboardController;
import modelo.*;
import Vista.VistaFantasma;
import Vista.VistaFondo;
import Vista.VistaInformacion;
import Vista.VistaLaberinto;
import Vista.VistaPacman;
import Vista.VentanaPrincipal;
import graphicCollection.*;
import interfasesYControladores.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		Juego unJuego=new Juego();
		
		ControladorJuego cont = new ControladorJuego(unJuego);
		
		Nivel unNivel = unJuego.obtenerNivel();
		
		Mesa fondo=new Mesa(565,650);
		VistaFondo vistaFondo=new VistaFondo(fondo);
		vistaFondo.setPosicionable(fondo);
		
		
		
		VistaLaberinto vistaLaberinto=new VistaLaberinto(unNivel.obtenerMiLaberinto());
		VistaFantasma vistaPinky=new VistaFantasma(unNivel.obtenerPinky(),"pinky.jpg");
		vistaPinky.setPosicionable(unNivel.obtenerPinky());

		VistaFantasma vistaBlinky=new VistaFantasma(unNivel.obtenerBlinky(),"blinky.jpg");
		vistaBlinky.setPosicionable(unNivel.obtenerBlinky());
		
		VistaFantasma vistaClyde=new VistaFantasma(unNivel.obtenerClyde(),"clyde.jpg");
		vistaClyde.setPosicionable(unNivel.obtenerClyde());
		
		VistaFantasma vistaInky=new VistaFantasma(unNivel.obtenerInky(),"inky.jpg");
		vistaInky.setPosicionable(unNivel.obtenerInky());
		
		VistaPacman vistaPacman=new VistaPacman(unNivel.obtenerPacman());		
		vistaPacman.setPosicionable(unNivel.obtenerPacman());
		vistaPacman.setMovible(unNivel.obtenerPacman());
		KeyboardController teclado=new KeyboardController(unNivel.obtenerPacman());
		Ventana ven = new VentanaPrincipal();
		cont.setSuperficieDeDibujo(ven);
		ven.addKeyboard(teclado);
		VistaInformacion informacion = new VistaInformacion(unNivel);
		
		ven.setVisible(true);
		cont.agregarDibujable(vistaFondo);
		cont.agregarDibujable(vistaLaberinto);
		cont.agregarDibujable(vistaPacman);
		cont.agregarDibujable(vistaPinky);
		cont.agregarDibujable(vistaClyde);
		cont.agregarDibujable(vistaBlinky);
		cont.agregarDibujable(vistaInky);
		cont.agregarDibujable(informacion);
		
		
		cont.setIntervaloSimulacion(100);
		cont.comenzar();
	} 
}