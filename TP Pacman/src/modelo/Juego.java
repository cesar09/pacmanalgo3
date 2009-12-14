package modelo;

public class Juego {

	private Nivel unNivel; 
	private Jugador jugador;
	private int nivelActual;
	private static int cantidadDeNiveles=3;
	
	
	public Juego(){
		this.nivelActual = 1; //nivel inicial 1.
		this.jugador = new Jugador();
		try{
			this.unNivel = new Nivel(this, this.nivelActual);
		} catch (ArchivoFueraDeFormatoException e) {
			// TODO Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel "+nivelActual+".");
		}
	}

	
	public void pasarDeNivel() throws JuegoGanado{
		this.nivelActual++;
		if(seGanoJuego()){
			throw new JuegoGanado();
		}
		else try {
				this.unNivel = new Nivel(this, this.nivelActual);
			} catch (ArchivoFueraDeFormatoException e) {
			// TODO Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
				System.out.println("Formato incorrecto en laberinto correspondiente al nivel "+nivelActual+".");
			}
	}
	

	public boolean seGanoJuego() {
		if(cantidadDeNiveles<nivelActual) return true;
		else return false;
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
	
	
	public void mover() throws NivelGanado{
		this.unNivel.comenzarMoverFantasmas();
		this.unNivel.muevePacman();
		if (this.seGanoNivel()){
			throw new NivelGanado();
		}
	}
	
	
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
	
}
