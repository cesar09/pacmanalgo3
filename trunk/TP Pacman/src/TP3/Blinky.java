package TP3;
public class Blinky extends Fantasma {

	public Blinky(int velocidadInicial) {
		super(velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) {
        this.moverIzquierda(unNivel);
	}
	
	public void huirDePacman(Nivel unNivel) {
        this.moverDerecha(unNivel);
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
	}

}