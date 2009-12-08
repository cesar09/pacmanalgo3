package modelo;

import Vista.VistaContenido;
import interfasesYControladores.SuperficieDeDibujo;

public class Fruta extends Comestible {

	private VistaContenido vistaFruta;
	public Fruta (){
		this.puntaje = 100;
	}
	
	public void hayPacman(Nivel unNivel,int x,int y) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
		unNivel.obtenerMiLaberinto().agregarVacio(x,y);
	}
	
	public void serTransitado(Nivel unNivel){
		
	}	

}