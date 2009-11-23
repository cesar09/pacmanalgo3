package TP3;
public class Jugador {
	
	private int puntaje;
	
	public Jugador(){
		this.puntaje = 0;
	}
	
	public void sumarPuntaje(int puntajeASumar){
		if(puntajeASumar<0) throw new IllegalArgumentException();
		this.puntaje+=puntajeASumar;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
}
