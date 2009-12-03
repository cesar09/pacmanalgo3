package PruebasUnitarias;

import graphicCollection.Ventana;
import junit.framework.TestCase;
import TP3.*;

public class TestNivel extends TestCase{
	
	public void setUp(Juego miJuego, Nivel miNivel, Ventana miVentana) throws ArchivoFueraDeFormatoException{
		miNivel = new Nivel(miJuego, 1, miVentana);		
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
