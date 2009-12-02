package TP3;

import ar.uba.fi.algo3.titiritero.*;

public class Pacman extends Personaje implements Posicionable,Movible {

	
	private int sentidoY=0;
	private int sentidoX=-1;

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
	
	public void nuevoSentido(int i, int j) {
		if((((i==1)|(i==-1))&(j==0))|(((j==1)|(j==-1))&(i==0))) {
			this.sentidoX=i;
			this.sentidoY=j;
		}
		else throw new IllegalArgumentException();
	}

	public int getX() {
		Point unPoint=obtenerPosicion();
		return unPoint.getX();
	}

	public int getY() {
		Point unPoint=obtenerPosicion();
		return unPoint.getY();
	}

	public int getSentidoX() {
		return sentidoX;
	}

	public int getSentidoY() {
		// TODO Auto-generated method stub
		return sentidoY;
	}

}
