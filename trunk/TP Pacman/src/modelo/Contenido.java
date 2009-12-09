package modelo;


public interface Contenido {
		
	abstract public void hayPacman(Nivel unNivel,int x,int y) throws NoTransitableException;
	
	abstract public void serTransitado(Nivel unNivel, Fantasma unFantasma, int x, int y) throws NoTransitableException;

}
