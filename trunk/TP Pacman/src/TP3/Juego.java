package TP3;

public class Juego {

	private Nivel unNivel; 
	private Jugador jugador;
	private int nivelActual;
	private static int cantidadDeNiveles=2;
	
	public Juego(){
		this.nivelActual = 1; //nivel inicial 1.
		this.jugador = new Jugador();
		try{
			this.unNivel = new Nivel(this, this.nivelActual);
		} catch (ArchivoFueraDeFormatoException e) {
			// Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel "+nivelActual+".");
		}
	}
	
	public void pasarDeNivel(){
		this.nivelActual++;
		if(cantidadDeNiveles==nivelActual) this.JuegoGanado(); 
		else try {
				this.unNivel = new Nivel(this, this.nivelActual);
			} catch (ArchivoFueraDeFormatoException e) {
			// Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
				System.out.println("Formato incorrecto en laberinto correspondiente al nivel "+nivelActual+".");
			}
	}

	public void sumarPuntajeAlJugador(int puntaje){
		if(puntaje<0) throw new IllegalArgumentException();
		this.jugador.sumarPuntaje(puntaje);
		if (this.jugador.obtenerPuntaje()%10000.0 == 0) // Obtiene el resto de la division
			this.jugador.agregarVida();
	}
	
	public int obtenerPuntajeDelJugador(){
		return this.jugador.obtenerPuntaje();
	}
	
	public int obtenerNivelActual(){
		return this.nivelActual;
	}
	
	public int obtenerVidasDisponibles(){
		return (this.jugador.obtenerVidasDisponibles());
	}
	
	public void mover(){
		try {
			this.unNivel.mueveFantasmas();
			this.unNivel.muevePacman();
		} catch (PacmanAtrapadoException e) {
			try{
				this.jugador.perderVida();
			}catch (JugadorSinVidasException e2){
				this.juegoPerdido();
			}
		}
		if (this.seGanoJuego()){
			this.pasarDeNivel();
		}
	}

	public void juegoPerdido(){
		System.out.println("Has perdido el juego.");
		//Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
	}
	private void JuegoGanado() {
		System.out.println("Has ganado el juego.");
		//Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
	}
	
	public boolean seGanoJuego(){
		if (this.unNivel.obtenerMiLaberinto().obtenerCantidadPastillas() == 0){
			return true;
		}
		return false;
	}
	
}
