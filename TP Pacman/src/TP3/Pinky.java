package TP3;
public class Pinky extends Fantasma {

	public Pinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}
	@Override
	public void atraparPacman(Laberinto unLaberinto,Pacman unPacman) {
		// TODO: Pensar como implementar la estrategia
		/*
		 * 
		 * 
		 */
		int x = 2;
		int y = 2;
		this.mover(x, y);
		
	}

	public void huirDePacman(Laberinto unLaberinto) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Transitable transitable;
        try {
            	transitable = (Transitable)unLaberinto.devolverPosicion(x, y-1).getContenido();
                this.mover(x, y-1);
                y--;
        } catch (ClassCastException e) {
            	try {
            		transitable = (Transitable)unLaberinto.devolverPosicion(x+1,y).getContenido();
            		this.mover(x+1, y);
            		x++;
            	} catch (ClassCastException e2) {}
         }
    }
	
	
	public static void main(String[] args) {
		Point Inicial = new Point(3,3);
		Laberinto miLaberinto = new Laberinto();
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
		
	}
	

}