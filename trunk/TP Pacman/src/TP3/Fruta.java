package TP3;

import Vista.VistaContenido;
import interfasesYControladores.SuperficieDeDibujo;

public class Fruta extends Comestible {

	private VistaContenido vistaFruta;
	public Fruta (){
		this.puntaje = 100;
		vistaFruta=new VistaContenido(this,"fruta.jpg");	
	}
	
	public void hayPacman(Nivel unNivel,int x,int y) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
		unNivel.obtenerMiLaberinto().agregarVacio(x,y);
	}
	
	public void serTransitado(Nivel unNivel){
		
	}	
	public void dibujar(SuperficieDeDibujo superficie, int x, int y) {
		vistaFruta.dibujar(superficie,x,y);
	}
}