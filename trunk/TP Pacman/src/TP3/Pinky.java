package TP3;
public class Pinky extends Fantasma {

	public Pinky(int velocidadInicial) {
		super(velocidadInicial);
	}
	
	//metodo implicitamente apodado fantasmaDrogado()
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
		Point posicion = new Point (3,4);
		this.posicion = posicion;
	}
	
	
	/*public static void main(String[] args) {
		Point Inicial = new Point(3,3);
		Laberinto miLaberinto = new Laberinto(1);//TODO: VERIFICAR ESTO CON EL LABERINTO.
		miLaberinto.cargarLaberintoSegunNivel();
		Pinky miPinky = new Pinky(Inicial,5);
		
		//HUIR
		
		miPinky.hacerseComestible();
		System.out.println(miPinky.obtenerPosicion().getX());
		System.out.println(miPinky.obtenerPosicion().getY());
		miPinky.huirDePacman(miLaberinto);
		System.out.println(miPinky.obtenerPosicion().getX());
		System.out.println(miPinky.obtenerPosicion().getY());
		miPinky.huirDePacman(miLaberinto);
		System.out.println(miPinky.obtenerPosicion().getX());
		System.out.println(miPinky.obtenerPosicion().getY());
		miPinky.huirDePacman(miLaberinto);
		System.out.println(miPinky.obtenerPosicion().getX());
		System.out.println(miPinky.obtenerPosicion().getY());
		miPinky.huirDePacman(miLaberinto);
		System.out.println(miPinky.obtenerPosicion().getX());
		System.out.println(miPinky.obtenerPosicion().getY());
		miPinky.huirDePacman(miLaberinto);
		System.out.println(miPinky.obtenerPosicion().getX());
		System.out.println(miPinky.obtenerPosicion().getY());
		miPinky.huirDePacman(miLaberinto);
		System.out.println(miPinky.obtenerPosicion().getX());
		System.out.println(miPinky.obtenerPosicion().getY());
		
	}*/
	

}