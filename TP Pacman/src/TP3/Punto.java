package TP3;
public class Punto extends Comestible {

	public Punto (){
		this.puntaje = 10;
	}
	
	public void hayPacman(Nivel unNivel) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
	}

	public void serTransitado(Nivel unNivel){
		
	}	

}
