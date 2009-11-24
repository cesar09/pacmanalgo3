package TP3;
public class Fruta extends Comestible {

	public Fruta (){
		this.puntaje = 100;
	}
	
	public void hayPacman(Nivel unNivel) {
		unNivel.obtenerMiJuego().sumarPuntajeAlJugador(this.puntaje);
	}

}