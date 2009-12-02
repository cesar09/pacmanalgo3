package TP3;

import Vista.VistaContenido;
import interfasesYControladores.*;

public class Bloque implements Contenido {

	private VistaContenido vistaBloque; 
	public Bloque(){	
		vistaBloque=new VistaContenido(this,"bloque.jpg");
	}

	public void hayPacman(Nivel unNivel,int x,int y) throws NoTransitableException{
		throw new NoTransitableException();
	}

	public void serTransitado(Nivel unNivel) throws NoTransitableException {
		throw new NoTransitableException();		
	}

	public void dibujar(SuperficieDeDibujo superficie, int x, int y) {
		vistaBloque.dibujar(superficie,x,y);
	}

}
