package TP3;
public class Pinky extends Fantasma {

	public Pinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}
	
	public void atraparPacman(Nivel unNivel){
		// TODO: Pensar como implementar la estrategia
		/*
		 * 
		 * 
		 */
		int x = 2;
		int y = 2;
		Pacman unPacman = unNivel.obtenerPacman();
		this.mover(x, y);
	
        if(unNivel.mismaPosicion(this, unPacman)){
        	unPacman.morir();
        	unNivel.pacmanAtrapado();
        }
	}
	

	public void huirDePacman(Nivel unNivel) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        try {
        	unLaberinto.devolverContenido(x,y-1).serTransitado(unNivel);
                this.mover(x, y-1);
                y--;
        }catch (NoTransitableException e) {
            	try {
            		unLaberinto.devolverContenido(x+1,y).serTransitado(unNivel);
            		this.mover(x+1, y);
            		x++;
            	}catch (NoTransitableException e2) {}
         }
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