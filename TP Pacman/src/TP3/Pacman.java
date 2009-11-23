package TP3;
public class Pacman extends Personaje {

	private int vidas;
	
	public Pacman(Point posicionInicial) {
		this.vidas = 3;
		this.posicion = posicionInicial;
	}
	
	protected void mover(int x, int y) {
		this.posicion.setXY(x, y); 
	}
	
	public void irIzquierda() {
		//Mueve al pacman un casillero a la izquierda
		this.mover((this.posicion.getX()-1),this.posicion.getY());
	}
	
	public void irDerecha() {
		//Mueve al pacman un casillero a la derecha
			this.mover((this.posicion.getX()+1),this.posicion.getY());
	}
	
	public void irArriba() {
		//Mueve al pacman un casillero arriba
		this.mover(this.posicion.getX(),(this.posicion.getY()+1));
	}
	
	public void irAbajo() {
		//Mueve al pacman un casillero abajo
		this.mover(this.posicion.getX(),(this.posicion.getY()-1));
	}
	
	public Point obtenerPosicion() {
		return (this.posicion);
	}
	
	public void morir() {
		this.vidas -= 1;
	}

}
