package TP3;
public class Jugador {
	
	private int puntaje;
	
	public Jugador(){
		this.puntaje = 0;
	}
	
	public void sumarPuntaje(int puntajeASumar){
		this.puntaje+=puntajeASumar;
	}
}
