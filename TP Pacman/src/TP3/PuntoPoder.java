package TP3;
public class PuntoPoder extends Comestible {

	public PuntoPoder (){
		this.puntaje = 50;
	}
	
	public void hayPacman(Nivel unNivel) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
		unNivel.hacerFantasmasComestibles();
	}

	public void serTransitado(Nivel unNivel){
		
	}	
}