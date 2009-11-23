package TP3;
public class Blinky extends Fantasma {

	public Blinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Laberinto unLaberinto) {
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();
		
		try {
            unLaberinto.devolverPosicion(x-1, y).getContenido().getTransitable();
            this.mover(x+1, y);
        } catch (NoTransitableException e) {}
	
		
	
	/*	unLaberinto.devolverPosicion(x, y+1).getContenido().getTransitable();
			this.mover(x,y+1);

	    unLaberinto.devolverPosicion(x-1, y).getContenido().getTransitable();
			this.mover(x-1,y);

	    unLaberinto.devolverPosicion(x, y-1).getContenido().getTransitable();
			this.mover(x,y-1);*/

	}


	public void huirDePacman(Laberinto unLaberinto) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Transitable transitable;
		Transitable transitable2;
        while (this.esComestible()){
            try {
            	transitable = (Transitable)unLaberinto.devolverPosicion(x, y+1).getContenido();
                this.mover(x, y+1);
            } catch (ClassCastException e) {
            	try {
            		transitable2 = (Transitable)unLaberinto.devolverPosicion(x+1,y).getContenido();
            		this.mover(x+1, y);
            	} catch (ClassCastException e2) {}
            }
        }
    }
		
	public static void main(String[] args) {
		Point Inicial = new Point(3,3);
		Laberinto miLaberinto = new Laberinto();
		miLaberinto.cargarLaberintoSegunNivel();
		Blinky miBlinky = new Blinky(Inicial,5);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.atraparPacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.atraparPacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.atraparPacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
	}
}
