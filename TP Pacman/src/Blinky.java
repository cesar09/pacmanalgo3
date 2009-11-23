
public class Blinky extends Fantasma {

	public Blinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Laberinto unLaberinto) {
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();
		try {
		unLaberinto.devolverPosicion(x+1, y).getContenido().getTransitable();
			this.mover(x+1,y);
		} catch (NoTransitableException e) {}
		try {
		unLaberinto.devolverPosicion(x, y+1).getContenido().getTransitable();
			this.mover(x,y+1);
		} catch (NoTransitableException e) {}
		try {	
	    unLaberinto.devolverPosicion(x-1, y).getContenido().getTransitable();
			this.mover(x-1,y);
		} catch (NoTransitableException e) {}
		try {
	    unLaberinto.devolverPosicion(x, y-1).getContenido().getTransitable();
			this.mover(x,y-1);
		} catch (NoTransitableException e) {}
	}


	public void huirDePacman(Laberinto unLaberinto) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        while (this.esComestible()){
            try {
                unLaberinto.devolverPosicion(x, y+1).getContenido().getTransitable();
                this.mover(x, y+1);
            } catch (NoTransitableException e) {}
            try {
            	unLaberinto.devolverPosicion(x+1,y).getContenido().getTransitable();
                this.mover(x+1, y);
            } catch (NoTransitableException e) {}
            }
    }
	
	public static void main(String[] args) {
		Point Inicial = new Point(3,3);
		Laberinto miLaberinto = new Laberinto();
		miLaberinto.cargarLaberintoSegunNivel();
		Blinky miBlinky = new Blinky(Inicial,5);
		
	}
}
