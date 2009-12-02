package TP3;

import interfasesYControladores.SuperficieDeDibujo;
import Vista.VistaContenido;

public class PuntoPoder extends Comestible {

	private VistaContenido vistaPuntoPoder;

	public PuntoPoder (){
		this.puntaje = 50;
		vistaPuntoPoder=new VistaContenido(this,"puntopoder.jpg");	
	}
	
	public void hayPacman(Nivel unNivel,int x,int y) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
		unNivel.hacerFantasmasComestibles();
		unNivel.obtenerMiLaberinto().restarCantidadPastillas();
		unNivel.obtenerMiLaberinto().agregarVacio(x,y);
	}

	public void serTransitado(Nivel unNivel){		
	}	
	public void dibujar(SuperficieDeDibujo superficie,int x,int y) {
		vistaPuntoPoder.dibujar(superficie,x,y);
	}
}