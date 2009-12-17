package modelo;


public interface Contenido {
		
	//Este método se usa cuando el pacman está parado en el casillero del bloque
	abstract public void hayPacman(Nivel unNivel,int x,int y) throws NoTransitableException;
	
	//Este método se usa cuando un fantasma está parado en el casillero del bloque
	abstract public void serTransitado(Nivel unNivel, Fantasma unFantasma, int x, int y) throws NoTransitableException;

}
