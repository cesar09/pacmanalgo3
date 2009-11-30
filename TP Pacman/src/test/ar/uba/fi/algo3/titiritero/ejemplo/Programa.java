package test.ar.uba.fi.algo3.titiritero.ejemplo;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import test.ar.uba.fi.algo3.titiritero.ejemplo.modelo.Mesa;
import test.ar.uba.fi.algo3.titiritero.ejemplo.modelo.Pacman;
import test.ar.uba.fi.algo3.titiritero.ejemplo.modelo.Pelota;
import test.ar.uba.fi.algo3.titiritero.ejemplo.vista.VentanaPrincipal;
import test.ar.uba.fi.algo3.titiritero.ejemplo.vista.VistaMesa;
import test.ar.uba.fi.algo3.titiritero.ejemplo.vista.VistaPacman;
import test.ar.uba.fi.algo3.titiritero.ejemplo.vista.VistaPelota;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Programa {

	public static void main(String[] args) {

		/*
		 * Primero instancio mi modelo: una pelota que se mueve por una mesa
		 */
		Pacman unPacman = new Pacman();
		Mesa unaMesa = new Mesa(500, 500);
		unPacman.setMesa(unaMesa);
		/*
		 * Luego instancio los objetos del framework: una ventana y el controlador
		 */		
		
		ControladorJuego controlador = new ControladorJuego();
		Ventana ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		/*
		 * Instancio un cuadrado para que actue como vista de la mesa
		 */
		VistaMesa vistaMesa = new VistaMesa();
		vistaMesa.setPosicionable(unaMesa);
		
		/*
		 * Instancio una imagen para que actue como vista de la pelota
		 */
		
		/*
		 * agrego la pelota a la lista de objetos vivios del controlador
		 * para que este le de vida dentro del gameloop
		 */
		
		
		//TODO agreggado mío para mostrar una imagen del pacman.
		/*
		 * Instancio una imagen para que actue como vista de la pelota
		 */
		VistaPacman vistaPacman = new VistaPacman();
		vistaPacman.setMovible(unPacman);
		
		/*
		 * agrego la pelota a la lista de objetos vivios del controlador
		 * para que este le de vida dentro del gameloop
		 */
		
		//TODO agreggado mio.
		controlador.agregarObjetoVivo(unPacman);
		
		
		/*
		 * Agrego los objetos que actuan como vista a la lista de dibujables del controlador
		 * para que sean repintados al final de cada gameloop
		 */
		
		controlador.agregarDibujable(vistaMesa);

		//TODO agregado mio.
		controlador.agregarDibujable(vistaPacman);
		
		controlador.agregarMouseClickObservador(vistaMesa);
		
		/*
		 * finalmente establezco el intervalo de sleep dentro del gameloop
		 * y comienzo a ejecutar
		 */
		controlador.setIntervaloSimulacion(10);
		controlador.comenzar();

	}

}
