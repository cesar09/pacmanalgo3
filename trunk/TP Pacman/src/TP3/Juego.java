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
		try {
			this.unNivel.nuevoNivel(nivelActual);
		} catch (ArchivoFueraDeFormatoException e) {
			// Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel "+nivelActual+".");
		}
	}

	public void sumarPuntajeAlJugador(int puntaje){
		if(puntaje<0) throw new IllegalArgumentException();
		this.jugador.sumarPuntaje(puntaje);
		if (this.jugador.obtenerPuntaje()%10000.0 == 0) // Obtiene el resto de la division
			this.unNivel.obtenerPacman().agregarVida();
	}
	
	public int obtenerPuntajeDelJugador(){
		return this.jugador.obtenerPuntaje();
	}
	
	public int obtenerNivelActual(){
		return this.nivelActual;
	}
	
	public int obtenerVidasDisponibles(){
		return (this.unNivel.obtenerPacman().obtenerVidasDisponibles());
	}
	
	public void mover(){
		try {
			this.unNivel.mueveFantasma();
			this.unNivel.muevePacman();
		} catch (PacmanSinVidaException e) {
			this.juegoPerdido();
		}
	}

	public void juegoPerdido(){
		System.out.println("Has perdido el juego.");
		//Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
	}
	
}
