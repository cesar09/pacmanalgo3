package TP3;
public interface Contenido {
		
	abstract public void hayPacman(Nivel unNivel) throws NoTransitableException;
	
	abstract public void serTransitado(Nivel unNivel) throws NoTransitableException;
	
	
}
