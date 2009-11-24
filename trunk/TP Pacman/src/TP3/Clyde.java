package TP3;
public class Clyde extends Fantasma {

	public Clyde(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) {
		// TODO: Pensar como implementar la estrategia
		/*
		 * 
		 * 
		 */
		int x = 2;
		int y = 2;
		this.mover(x, y);
		
	}

	public void huirDePacman(Nivel unNivel) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        Transitable transitable;
        try {
            	transitable = (Transitable)unLaberinto.devolverPosicion(x, y+1).getContenido();
                this.mover(x, y+1);
                y++;
        } catch (ClassCastException e) {
            	try {
            		transitable = (Transitable)unLaberinto.devolverPosicion(x-1,y).getContenido();
            		this.mover(x-1, y);
            		x--;
            	} catch (ClassCastException e2) {}
            }
    }

	

	
	
	
}