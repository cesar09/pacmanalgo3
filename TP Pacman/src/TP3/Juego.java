package TP3;

public class Juego {

	private Nivel unNivel; 
	private Jugador jugador;
	private int nivelActual;
	
	public Juego(){
		this.unNivel = new Nivel(this);
		this.nivelActual = 1;
		this.jugador = new Jugador();
		//TODO: Nose q cantidad de niveles, VER de modificar
	}
	
	public void pasarDeNivel(){
		this.nivelActual += 1;
	}

	public void sumarPuntajeAlJugador(int puntaje){
		this.jugador.sumarPuntaje(puntaje);
	}
	
	public void mover(){
		//TODO: Debe llamar al mover correspondiente a la direccion en q se moverá
	}
	
}
