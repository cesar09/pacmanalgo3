package modelo;


public class Punto extends Comestible {

	public Punto (){
		this.puntaje = 10;
	}
	
	public void hayPacman(Nivel unNivel,int x,int y) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
		unNivel.obtenerMiLaberinto().restarCantidadPastillas();
		unNivel.obtenerMiLaberinto().agregarVacio(x,y);
	}
	
	public void serTransitado(Nivel unNivel, Fantasma unFantasma, int x, int y){
		
	}

}
