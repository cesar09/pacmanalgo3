package modelo;

public class Juego {

	private Nivel unNivel; 
	private Jugador jugador;
	private int nivelActual;
	private static int cantidadDeNiveles=6;
	private boolean archivoErroneo=false;
	
	
	public Juego(){
		this.nivelActual = 1; //nivel inicial 1.
		this.jugador = new Jugador();
		try{
			this.unNivel = new Nivel(this, this.nivelActual);
		} catch (ArchivoFueraDeFormatoException e) {
			archivoErroneo=true;
		}
	}

	
	public void pasarDeNivel() throws JuegoGanadoException{
		this.nivelActual++;
		if(seGanoJuego()){
			throw new JuegoGanadoException();
		}
		else try {
				this.unNivel = new Nivel(this, this.nivelActual);
			} catch (ArchivoFueraDeFormatoException e) {
				archivoErroneo=true;
			}
	}
	

	//Comprobación de si ya se ha ganado el Juego.
	public boolean seGanoJuego() {
		if(cantidadDeNiveles<nivelActual) return true;
		else return false;
	}
	
	//Va sumando el puntaje al jugador, cada 10000 puntos agrega una vida.
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
	
	//Comienza los movimientos del juego.
	public void mover() throws NivelGanadoException, ArchivoFueraDeFormatoException{
		if(archivoErroneo) throw new ArchivoFueraDeFormatoException();
		this.unNivel.comenzarMoverFantasmas();
		this.unNivel.comenzarMoverPacman();
		if (this.seGanoNivel()){
			throw new NivelGanadoException();
		}
	}
	
	//Comprobación de si ya se ha ganado el nivel.
	public boolean seGanoNivel(){
		if (this.unNivel.obtenerMiLaberinto().obtenerCantidadPastillas() == 0){
			return true;
		}
		return false;
	}


	public void pacmanFueAtrapado() {
		this.jugador.perderVida();	
	}	
	
	
	public Nivel obtenerNivel(){
		return (this.unNivel);
	}


	public boolean archivoErroneo() {
		return this.archivoErroneo;
	}
	
}
