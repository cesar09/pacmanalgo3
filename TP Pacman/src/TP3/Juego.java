package TP3;

public class Juego {

	private Nivel unNivel; 
	private Jugador jugador;
	private int nivelActual;
	
	public Juego(){
		this.unNivel = new Nivel(this); //le pasa el Juego por argumento.
		this.nivelActual = 1; //nivel inicial 1.
		this.jugador = new Jugador();
		//TODO: Nose q cantidad de niveles, VER de modificar
	}
	
	public void pasarDeNivel(){
		this.nivelActual += 1;
		//TODO: acá falta cambiar el laberinto, quizas halla que agregar metodos en laberinto para descartar el viejo y poner el nuevo.
	}

	public void sumarPuntajeAlJugador(int puntaje){
		if(puntaje<0) throw new IllegalArgumentException();
		this.jugador.sumarPuntaje(puntaje);
	}
	
	public int getPuntajeDelJugador(){
		return this.jugador.obtenerPuntaje();
	}
	
	public void mover(){
		try {
			this.unNivel.mueveFantasma();
		} catch (JuegoPerdido e) {
			// Si un fantasma morfa al pacman y se quedó sin vidas se lanza JuegoPerido, esto lo atrapa
			this.juegoPerdido();
		}
		
		try {
			this.unNivel.muevePacman();
		} catch (JuegoPerdido e) {
			// Si un fantasma morfa al pacman y se quedó sin vidas se lanza JuegoPerido, esto lo atrapa
			this.juegoPerdido();
		}
		//TODO: Debe llamar al mover correspondiente a la direccion en q se moverá
	}

	public void juegoPerdido() {
		System.out.println("lo siente gil perdiste");
		System.out.println("alegrate llegaste al nivel:"+ this.nivelActual);
		//TODO estos mensaje son muy buenos!!! pero habría q cambiarlos jeje.
	}
	
}
