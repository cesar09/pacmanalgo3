package TP3;
public class Clyde extends Fantasma {

	public Clyde(int velocidadInicial) {
		super(velocidadInicial);
		this.nuevaUltimaPosicion(3);
	}

	public void atraparPacman(Nivel unNivel) {
		 switch(UltimaPosicion()) {
		 case 0:
			 this.moverArriba(unNivel);
		     break;
		 case 1:
			 this.moverAbajo(unNivel);
			 break;
		 case 2:
			 this.moverIzquierda(unNivel);
		 case 3:
			 this.moverDerecha(unNivel);
			 break;
		 }
	}
	
	public void huirDePacman(Nivel unNivel) {
        this.moverDerecha(unNivel);
    }
	
	public void irAJaula() {
		Point posicion = new Point (14,13);
		this.posicion = posicion;
		this.encerrado = true;
	}
	
	public void salirDeJaula (){
		Point posicion = new Point (13,11);
		this.posicion = posicion;
		this.encerrado = false;
	}

	
}