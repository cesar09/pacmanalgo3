package modelo;

import interfasesYControladores.*;

public class Pacman extends Personaje implements Posicionable,Movible {

	
	private int sentidoY=0;
	private int sentidoX=-1;
	private int sentidoGraficoY=0;
	private int sentidoGraficoX=-1;

	public Pacman() {
		this.renacer();
	}
	
	protected void mover(int x, int y) {
		this.posicion.setXY(x, y);
	}
	
	public void irIzquierda() {
		this.mover((this.posicion.getX()-1),this.posicion.getY());
		this.nuevoSentidoGrafico(-1,0);
	}
	
	public void irDerecha() {
		this.mover((this.posicion.getX()+1),this.posicion.getY());
		this.nuevoSentidoGrafico(1,0);
	}
	
	public void irArriba() {
		this.mover(this.posicion.getX(),(this.posicion.getY()-1));
		this.nuevoSentidoGrafico(0,-1);
	}
	
	public void irAbajo() {
		this.mover(this.posicion.getX(),(this.posicion.getY()+1));
		this.nuevoSentidoGrafico(0,1);
	}
	
	public Point obtenerPosicion() {
		return (this.posicion);
	}
	
	public void renacer() {
		Point posicion = new Point(13,23);
		this.posicion=posicion;
		sentidoY=0;
		sentidoX=-1;
		sentidoGraficoY=0;
		sentidoGraficoX=-1;
	}
	
	public void nuevoSentido(int i, int j) {
		if((((i==1)|(i==-1))&(j==0))|(((j==1)|(j==-1))&(i==0))) {
			this.sentidoX=i;
			this.sentidoY=j;
		}
		else throw new IllegalArgumentException();
	}

	public void nuevoSentidoGrafico(int i, int j) {
		if((((i==1)|(i==-1))&(j==0))|(((j==1)|(j==-1))&(i==0))) {
			this.sentidoGraficoX=i;
			this.sentidoGraficoY=j;
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
		return sentidoY;
	}

	public int getSentidoGraficoX() {
		return sentidoGraficoX;
	}

	public int getSentidoGraficoY() {
		return sentidoGraficoY;
	}

	public void serTransportadoADerecha() {
			this.mover(28,8);
	}
	
	public void serTransportadoAIzquierda() {
		this.mover(-1,8);
	}
	
}
