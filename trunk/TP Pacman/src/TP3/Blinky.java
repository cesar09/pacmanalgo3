package TP3;
public class Blinky extends Fantasma {

	public Blinky(int velocidadInicial) {
		super(velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) throws PacmanSinVidaException{
        Pacman unPacman = unNivel.obtenerPacman();
        this.moverIzquierda(unNivel);
        if(unNivel.mismaPosicion(this, unPacman)){
        	unPacman.morir();
        	unNivel.llevarFantasmasAJaula();
        	this.encerrado = true;
        	unNivel.llevarPacmanAPosicionInicial();
        }
	}
	
	public void huirDePacman(Nivel unNivel) {
		Pacman unPacman = unNivel.obtenerPacman();
        this.moverDerecha(unNivel);
        if(unNivel.mismaPosicion(this,unPacman)){
        	this.fantasmaComido(unNivel);
        }
    }
	
	public void irAJaula() {
		Point posicion = new Point (13,13);
		this.posicion = posicion;
		this.encerrado = true;
	}
	
	public void salirDeJaula (){
		this.encerrado = false;
		Point posicion = new Point (13,11);
		this.posicion = posicion;
		this.encerrado = false;
	}

}