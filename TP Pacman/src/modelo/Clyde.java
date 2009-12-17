package modelo;
public class Clyde extends Fantasma {

	public Clyde(int velocidadInicial,int tiempoEnJaula) {
		super(velocidadInicial, tiempoEnJaula);
		this.nuevaDireccion(2);
	}

	//Contiene la estrategia que usará Clyde para atrapar al pacman.
	public void atraparPacman(Nivel unNivel) {
		 switch(this.ultimaDireccion()) {
		 case 0:
			 this.moverDerechaDos(unNivel);
		     break;
		 case 1:
			 this.moverAbajoDos(unNivel);
			 break;
		 case 2:
			 this.moverIzquierdaDos(unNivel);
			 break;
		 case 3:
			 this.moverArribaDos(unNivel);
			 break;
		 }
	}
	
	//Contiene la estrategia que usará Clyde para huir al pacman.
	public void huirDePacman(Nivel unNivel) {
        this.moverDerecha(unNivel);
    }
	
	//Tiene una posición predeterminada para estar en la jaula
	public void irAJaula() {
		Point posicion = new Point (14,13);
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