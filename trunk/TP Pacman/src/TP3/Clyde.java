package TP3;
public class Clyde extends Fantasma {

	public Clyde(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) throws PacmanSinVidaException{
        Pacman unPacman = unNivel.obtenerPacman();
        this.moverDerecha(unNivel);
        if(unNivel.mismaPosicion(this, unPacman)){
        	unNivel.renacerFantasmas();
        	unNivel.posicionInicialPacman();
        }
	}

	public void huirDePacman(Nivel unNivel) {
		Pacman unPacman = unNivel.obtenerPacman();
        this.moverArriba(unNivel);
        if(unNivel.mismaPosicion(this, unPacman)){
        	this.fantasmaComido(unNivel);
        }
    }
	
}