package PruebasUnitarias;

import modelo.ArchivoFueraDeFormatoException;
import modelo.Juego;
import modelo.Nivel;

import junit.framework.TestCase;


public class TestNivel extends TestCase{
	
	public void setUp(Juego miJuego, Nivel miNivel) throws ArchivoFueraDeFormatoException{
		miNivel = new Nivel(miJuego, 1);		
	}
	
	public void testLlevarFantasmasAJaula(){
		
	}
	
	public void testLlevarPacmanAPosicionInicial(){
		
	}

	public void testMoverFantasmas(){
		
	}
	
	public void testMueveFantasmas(){
		
	}
	
	public void testMoverSegunSentido(){
		
	}

	public void testHacerFantasmasComestibles(){
		
	}
	
	public void testHacerFantasmasNoComestibles(){
		
	}
	
	public void testMismaPosicion(){
		
	}
}
