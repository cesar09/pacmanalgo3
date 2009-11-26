package TP3;
public class Punto extends Comestible {

	public Punto (){
		this.puntaje = 10;
	}
	
	public void hayPacman(Nivel unNivel) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
		unNivel.obtenerMiLaberinto().restarCantidadPastillas();
		if (unNivel.obtenerMiLaberinto().obtenerCantidadPastillas() == 0)
			unNivel.finDeNivel();
	}
	
	public void serTransitado(Nivel unNivel){
		
	}	

}
