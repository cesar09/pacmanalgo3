package TP3;
public class Pinky extends Fantasma {

	public Pinky(int velocidadInicial) {
		super(velocidadInicial);
	}
	
	public void atraparPacman(Nivel unNivel)throws PacmanSinVidaException{
		Pacman unPacman = unNivel.obtenerPacman();
		int numeroAleatorio = (int) (Math.random()*1+4);
		 switch(numeroAleatorio) {
		 case 0:
			 this.moverDerecha(unNivel);
			 break;
		 case 1: 
			 this.moverArriba(unNivel);
			 break;
		 case 2: 
			 this.moverIzquierda(unNivel);
			 break;
		 case 3: 
			 this.moverAbajo(unNivel);
			 break;
		 }
		 if(unNivel.mismaPosicion(this, unPacman)){
	        	unPacman.morir();
	        	unNivel.llevarFantasmasAJaula();
	        	unNivel.posicionInicialPacman();
	        }
	}

	public void huirDePacman(Nivel unNivel) {
		Pacman unPacman = unNivel.obtenerPacman();
        this.moverIzquierda(unNivel);
        if(unNivel.mismaPosicion(this, unPacman)){
        	this.fantasmaComido(unNivel);
        }
    }
	
	public void irAJaula() {
		Point posicion = new Point (13,14);
		this.posicion = posicion;
	}
	

}