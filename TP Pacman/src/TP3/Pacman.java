package TP3;
public class Pacman extends Personaje {

	private int vidas;
	
	public Pacman() {
		this.vidas = 3;
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
		this.mover(this.posicion.getX(),(this.posicion.getY()+1));
	}
	
	public void irAbajo() {
		this.mover(this.posicion.getX(),(this.posicion.getY()-1));
	}
	
	public Point obtenerPosicion() {
		return (this.posicion);
	}
	
	public void morir() throws PacmanSinVidaException {
		this.vidas -= 1;
		if (this.vidas==0) throw new PacmanSinVidaException();
	}
	
	public void comerOMorir(Fantasma unFantasma, Nivel unNivel) throws PacmanSinVidaException {
		if(!unFantasma.esComestible()) this.morir();
		else unFantasma.fantasmaComido(unNivel);
	}

	public int obtenerVidasDisponibles(){
		return this.vidas;		
	}

	public void agregarVida(){
		this.vidas += 1;
	}

	public void renacer() {
		Point posicion = new Point(13,23); //TODO: VERIFICAR Q ESTE BIEN LA POSICION
		this.posicion=posicion;		
	}

}
