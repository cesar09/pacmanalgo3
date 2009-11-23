
import java.util.Vector;

public class Juego {

	private Vector<Nivel> niveles; 
	private Jugador jugador;
	private int nivelActual;
	
	public Juego(){
		this.niveles = new Vector<Nivel> (4);
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
