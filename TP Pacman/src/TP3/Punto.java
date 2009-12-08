package TP3;

import interfasesYControladores.SuperficieDeDibujo;
import Vista.VistaContenido;

public class Punto extends Comestible {

	private VistaContenido vistaPunto;

	public Punto (){
		this.puntaje = 10;
	}
	
	public void hayPacman(Nivel unNivel,int x,int y) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
		unNivel.obtenerMiLaberinto().restarCantidadPastillas();
		unNivel.obtenerMiLaberinto().agregarVacio(x,y);
	}
	
	public void serTransitado(Nivel unNivel){
		
	}

}
