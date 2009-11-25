package TP3;

public class Juego {

	private Nivel unNivel; 
	private Jugador jugador;
	private int nivelActual;
	
	public Juego(){
		this.nivelActual = 1; //nivel inicial 1.
		this.jugador = new Jugador();
		this.unNivel = new Nivel(this);
	}
	
	public void pasarDeNivel(){
		this.nivelActual++;
        this.unNivel = new Nivel(this);
	}

	public void sumarPuntajeAlJugador(int puntaje){
		if(puntaje<0) throw new IllegalArgumentException();
		this.jugador.sumarPuntaje(puntaje);
	}
	
	public int obtenerPuntajeDelJugador(){
		return this.jugador.obtenerPuntaje();
	}
	
	public int obtenerNivelActual(){
		return this.nivelActual;
	}
	
	public void mover(){
	/*	try {
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
		}*/
		//TODO: Debe llamar al mover correspondiente a la direccion en q se moverá
	}

	public void juegoPerdido(){
		System.out.println("lo siente gil perdiste");
		System.out.println("alegrate llegaste al nivel:"+ this.nivelActual);
		//TODO estos mensaje son muy buenos!!! pero habría q cambiarlos jeje.
	}
	
}
