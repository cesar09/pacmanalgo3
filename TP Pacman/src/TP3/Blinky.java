package TP3;
public class Blinky extends Fantasma {

	public Blinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Laberinto unLaberinto) {
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();

		
		
		/*try {
			transitable= (Transitable)unLaberinto.devolverPosicion(x-1, y).getContenido();
            this.mover(x+1, y);
        } catch (ClassCastException e) {}*/
	
		
	
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
        try {
            	transitable = (Transitable)unLaberinto.devolverPosicion(x, y+1).getContenido();
                this.mover(x, y+1);
                y++;
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
		Blinky miBlinky = new Blinky(Inicial,5);
		
		
		//HUIR
		
		miBlinky.hacerseComestible();
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.huirDePacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.huirDePacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.huirDePacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.huirDePacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.huirDePacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.huirDePacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		
	}
}
