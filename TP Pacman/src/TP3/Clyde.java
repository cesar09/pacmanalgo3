package TP3;
public class Clyde extends Fantasma {

	public Clyde(int velocidadInicial) {
		super(velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel){
        this.moverDerecha(unNivel);
    }

	public void huirDePacman(Nivel unNivel) {
        this.moverArriba(unNivel);
    }
	
	public void irAJaula() {
		Point posicion = new Point (14,13);
		this.posicion = posicion;
		this.encerrado = true;
	}
	
	public void salirDeJaula (){
		Point posicion = new Point (14,11);
		this.posicion = posicion;
		this.encerrado = false;
	}
	
}