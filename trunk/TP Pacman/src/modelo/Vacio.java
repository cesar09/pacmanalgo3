package modelo;

import interfasesYControladores.SuperficieDeDibujo;
import Vista.VistaContenido;

public class Vacio implements Contenido {

	public Vacio(){
		
	}
	//Queda as� el m�todo para poder ser un Contenido sin ser una clase abstracta
	public void hayPacman(Nivel unNivel,int x,int y) {
				
	}

	public void serTransitado(Nivel unNivel) {
		
	}
	public void dibujar(SuperficieDeDibujo superficie,int x,int y) {
		// TODO Ac� no deber�a hacer nada.		
	}
	
}
