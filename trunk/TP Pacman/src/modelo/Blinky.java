package modelo;
public class Blinky extends Fantasma {

	public Blinky(int velocidadInicial,int tiempoEnJaula) {
		super(velocidadInicial, tiempoEnJaula);
		this.nuevaDireccion(2);
	}

	//Contiene la estrategia que usará Blinky para atrapar al pacman.
	public void atraparPacman(Nivel unNivel) {
		 switch(this.ultimaDireccion()) {
		 case 0:
			 this.moverArriba(unNivel);
		     break;
		 case 1:
			 this.moverAbajo(unNivel);
			 break;
		 case 2:
			 this.moverIzquierda(unNivel);
			 break;
		 case 3:
			 this.moverDerecha(unNivel);
			 break;
		 }
	}
	
	//Contiene la estrategia que usará Blinky para huir al pacman.
	public void huirDePacman(Nivel unNivel) {
        this.moverDerecha(unNivel);
    }
	
	//Tiene una posición predeterminada para estar en la jaula
	public void irAJaula() {
		Point posicion = new Point (13,13);
		this.posicion = posicion;
		this.encerrado = true;
		this.hacerseNoComestible();
	}
	
	//Tiene una posición predeterminada para salir de la jaula
	public void salirDeJaula (){
		Point posicion = new Point (13,11);
		this.posicion = posicion;
		this.encerrado = false;
	}

}