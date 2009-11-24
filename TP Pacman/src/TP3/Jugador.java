package TP3;
public class Jugador {
	
	private int puntaje;
	
	public Jugador(){
		this.puntaje = 0;
	}
	public static void main(String[] argv){
		Jugador unJugador=new Jugador();
		unJugador.sumarPuntaje(10);
		
	}
	
	
	public void sumarPuntaje(int puntajeASumar){
		if(puntajeASumar<0) throw new IllegalArgumentException();
		this.puntaje+=puntajeASumar;
	}
	
	public int obtenerPuntaje(){
		return this.puntaje;
	}
	
}
