package modelo;

public class Transportador implements Contenido {


	public void hayPacman(Nivel unNivel, int x, int y){
		unNivel.transportarPacman(x);
	}

	
	public void serTransitado(Nivel unNivel) throws NoTransitableException {
		
	}

}
