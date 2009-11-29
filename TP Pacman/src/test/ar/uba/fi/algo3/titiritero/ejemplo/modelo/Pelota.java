package test.ar.uba.fi.algo3.titiritero.ejemplo.modelo;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Pelota implements Posicionable, ObjetoVivo {

	public Pelota(){
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
		x += this.sentidoX;
		x += this.sentidoX;
		y +=this.sentidoY;
		if(x >= this.mesa.getAncho() || x < 0){
			this.sentidoX = -1 * this.sentidoX;
		}
		if(y >= this.mesa.getAlto() || y < 0){
			this.sentidoY = -1 * this.sentidoY;
		}
	}
	
	private int x;
	private int y;
	private Mesa mesa;
	private int sentidoX;
	private int sentidoY;
	
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	

}
