package modelo;


public class Pinky extends Fantasma  {

	public Pinky(int velocidadInicial,int tiempoEnJaula) {
		super(velocidadInicial, tiempoEnJaula);
	}
	
	//Contiene la estrategia que usar� Pinky para atrapar al pacman.
	public void atraparPacman(Nivel unNivel){
		int numeroAleatorio = (int) (Math.random()*3);
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
	}

	//Contiene la estrategia que usar� Pinky para huir al pacman.
	public void huirDePacman(Nivel unNivel) {
        this.moverIzquierda(unNivel);
    }
	
	//Tiene una posici�n predeterminada para estar en la jaula
	public void irAJaula() {
		Point posicion = new Point (13,14);
		this.posicion = posicion;
		this.encerrado = true;
		this.hacerseNoComestible();

	}
	
	//Tiene una posici�n predeterminada para salir de la jaula
	public void salirDeJaula (){
		Point posicion = new Point (13,11);
		this.posicion = posicion;
		this.encerrado = false;
	}

}