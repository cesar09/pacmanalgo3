package TP3;
public class Pacman extends Personaje {

	
	public Pacman() {
		this.renacer();
	}
	
	protected void mover(int x, int y) {
		this.posicion.setXY(x, y); 
	}
	
	public void irIzquierda() {
		this.mover((this.posicion.getX()-1),this.posicion.getY());
	}
	
	public void irDerecha() {
		this.mover((this.posicion.getX()+1),this.posicion.getY());
	}
	
	public void irArriba() {
		this.mover(this.posicion.getX(),(this.posicion.getY()-1));
	}
	
	public void irAbajo() {
		this.mover(this.posicion.getX(),(this.posicion.getY()+1));
	}
	
	public Point obtenerPosicion() {
		return (this.posicion);
	}
	
	public void renacer() {
		Point posicion = new Point(13,23);
		this.posicion=posicion;		
	}

}
