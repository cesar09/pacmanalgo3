package modelo;

public class Bloque implements Contenido {

	public Bloque(){	
	}

	public void hayPacman(Nivel unNivel,int x,int y) throws NoTransitableException{
		throw new NoTransitableException();
	}

	public void serTransitado(Nivel unNivel, Fantasma unFantasma, int x, int y) throws NoTransitableException {
		throw new NoTransitableException();		
	}

}
