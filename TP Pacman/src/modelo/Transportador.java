package modelo;

public class Transportador implements Contenido {


	public void hayPacman(Nivel unNivel, int x, int y){
		unNivel.transportarPacman(x,y);
	}

	
	public void serTransitado(Nivel unNivel, Fantasma unFantasma, int x, int y) throws NoTransitableException {
		unNivel.transportarFantasma(unFantasma,x,y);
	}

}
