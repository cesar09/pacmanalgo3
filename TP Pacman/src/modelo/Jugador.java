package modelo;
public class Jugador {
	
	private int puntaje;
	private int vidas;
	
	public Jugador(){
		this.puntaje = 0;
		this.vidas = 3;
	}
	
	public void sumarPuntaje(int puntajeASumar){
		if(puntajeASumar<0) throw new IllegalArgumentException();
		this.puntaje+=puntajeASumar;
	}
	
	public int obtenerPuntaje(){
		return this.puntaje;
	}
	
	public void perderVida(){
		this.vidas--;
	}
	
	public int obtenerVidasDisponibles(){
		return (this.vidas);
	}
	
	public void agregarVida(){
		this.vidas++;
	}
	
}
