package TP3;
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
	
	public void perderVida() throws JugadorSinVidasException{
		this.vidas--;
		if (this.vidas == 0){
			throw new JugadorSinVidasException();			
		}
	}
	
	public int obtenerVidasDisponibles(){
		return (this.vidas);
	}
	
	public void agregarVida(){
		this.vidas++;
	}
	
}
