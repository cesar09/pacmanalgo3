package TP3;
public class Clyde extends Fantasma {

	public Clyde(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel){
        Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        Pacman unPacman = unNivel.obtenerPacman();
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        try {
           unLaberinto.devolverContenido(x+1,y).serTransitado(unNivel);
           this.mover(x+1, y);
           x++;
		}catch (NoTransitableException e) {
            try {
              unLaberinto.devolverContenido(x,y-1).serTransitado(unNivel);
              this.mover(x,y-1);
              y--;
            }catch (NoTransitableException e2) {}
        }
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
        	    unLaberinto.devolverContenido(x,y+1).serTransitado(unNivel);
                this.mover(x, y+1);
                y++;
        }catch (NoTransitableException e) {
            	try {
            		unLaberinto.devolverContenido(x-1,y).serTransitado(unNivel);
            		this.mover(x-1, y);
            		x--;
            	}catch (NoTransitableException e2) {}
            }
        Pacman unPacman = unNivel.obtenerPacman();
        if(unNivel.mismaPosicion(this, unPacman)){
        	this.fantasmaComido(unNivel);
        }
    }

	

	
	
	
}