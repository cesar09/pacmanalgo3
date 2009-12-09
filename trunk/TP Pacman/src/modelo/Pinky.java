package modelo;


public class Pinky extends Fantasma  {

	public Pinky(int velocidadInicial) {
		super(velocidadInicial);
	}
	
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

	public void huirDePacman(Nivel unNivel) {
        this.moverIzquierda(unNivel);
    }
	
	public void irAJaula() {
		Point posicion = new Point (13,14);
		this.posicion = posicion;
		this.encerrado = true;
	}
	
	
	public void salirDeJaula (){
		Point posicion = new Point (13,11);
		this.posicion = posicion;
		this.encerrado = false;
	}

}