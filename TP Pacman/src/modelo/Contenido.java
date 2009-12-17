package modelo;


public interface Contenido {
		
	//Este m�todo se usa cuando el pacman est� parado en el casillero del bloque
	abstract public void hayPacman(Nivel unNivel,int x,int y) throws NoTransitableException;
	
	//Este m�todo se usa cuando un fantasma est� parado en el casillero del bloque
	abstract public void serTransitado(Nivel unNivel, Fantasma unFantasma, int x, int y) throws NoTransitableException;

}
