package modelo;

public class PuntoPoder extends Comestible {

	public PuntoPoder (){
		this.puntaje = 50;
	}
	
	public void hayPacman(Nivel unNivel,int x,int y) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
		this.hacerFantasmasComestibles(unNivel);
		unNivel.obtenerMiLaberinto().restarCantidadPastillas();
		unNivel.obtenerMiLaberinto().agregarVacio(x,y);
	}

	public void serTransitado(Nivel unNivel, Fantasma unFantasma, int x, int y){		
	}	

	public void hacerFantasmasComestibles(Nivel unNivel){
		unNivel.obtenerBlinky().hacerseComestible();
		unNivel.obtenerPinky().hacerseComestible();
		unNivel.obtenerInky().hacerseComestible();
		unNivel.obtenerClyde().hacerseComestible();
		int segundos = (7 - unNivel.obtenerNumeroNivel());
		if (segundos > 1){
			new TimerComestible (segundos, unNivel);
		}else{
			new TimerComestible (2, unNivel);
		}
	}
	
}