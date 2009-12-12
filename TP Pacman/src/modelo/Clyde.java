package modelo;
public class Clyde extends Fantasma {

	public Clyde(int velocidadInicial,int tiempoEnJaula) {
		super(velocidadInicial, tiempoEnJaula);
		this.nuevaUltimaPosicion(3);
	}

	public void atraparPacman(Nivel unNivel) {
		 switch(this.UltimaPosicion()) {
		 case 0:
			 this.moverDerecha(unNivel);
		     break;
		 case 1:
			 this.moverAbajo(unNivel);
			 break;
		 case 2:
			 this.moverIzquierda(unNivel);
		 case 3:
			 this.moverArriba(unNivel);
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
		this.hacerseNoComestible();
	}
	
	public void salirDeJaula (){
		Point posicion = new Point (13,11);
		this.posicion = posicion;
		this.encerrado = false;
	}

	
}