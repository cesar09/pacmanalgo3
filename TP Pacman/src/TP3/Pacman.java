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
	
	public void morir() throws PacmanSinVidaException {
		this.vidas -= 1;
		if (this.vidas==0) throw new PacmanSinVidaException();
	}
	
	public void comerOMorir(Fantasma unFantasma, Nivel unNivel) throws PacmanSinVidaException {
		if(!unFantasma.esComestible()) this.morir();
		else unFantasma.fantasmaComido(unNivel);
	}
/*//Esto tmb se puede volar al re carajo.
	public int obtenerVidasDisponibles(){
		return this.vidas;		
	}*/

	public void agregarVida(){
		this.vidas += 1;
	}
//La vi como renacer pero queda mejor nuevaPosicion para mi, lo hablamos sino.
	public void nuevaPosicion(Point posicion) {
		this.posicion=posicion;
		
	}

}
