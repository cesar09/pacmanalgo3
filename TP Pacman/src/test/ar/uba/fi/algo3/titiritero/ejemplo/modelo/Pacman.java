package test.ar.uba.fi.algo3.titiritero.ejemplo.modelo;

import interfasesYControladores.Movible;
import interfasesYControladores.ObjetoVivo;

public class Pacman implements Movible, ObjetoVivo {

	private int nuevoSentidoX;
	private int nuevoSentidoY;
	private int x;
	private int y;
	private Mesa mesa;
	private int sentidoX;
	private int sentidoY;


	public Pacman(){
		this.sentidoX = 1;
		this.sentidoY = 1;
		this.x = 20;
		this.y = 20;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void vivir() {
		switch (nuevoSentidoX){
		case -1:
			if(x>0)
				x += this.nuevoSentidoX;
			break;
		case 1:
			if(x <= (this.mesa.getAncho()-85))
				x += this.nuevoSentidoX;
			break;
		}
		switch (nuevoSentidoY){
		case -1:
			if(y>0)
				y += this.nuevoSentidoY;
			break;
		case 1:
			if(y <= (this.mesa.getAncho()-105))
				y += this.nuevoSentidoY;
			break;
		}
	}
	
	public void nuevoSentido(int nuevoSentidoX, int nuevoSentidoY){
		this.nuevoSentidoX=nuevoSentidoX;
		this.nuevoSentidoY=nuevoSentidoY;
	}
	
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getSentidoX() {
		return this.nuevoSentidoX;
	}

	public int getSentidoY() {
		return this.nuevoSentidoY;
	}
}
	
