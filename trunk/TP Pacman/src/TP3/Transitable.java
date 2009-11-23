package TP3;
abstract public class Transitable implements Contenido {
	
	public Transitable getTransitable(){
		return (this);
	}
	
	abstract public void hayPacman(Nivel unNivel);
	
}
