package pruebas;

import modelo.*;
import junit.framework.TestCase;

public class testFantasma extends TestCase {
	

	private Fantasma miFantasma;
	private Nivel unNivel;
	private Juego unJuego;

	public void setUp(){
		miFantasma = new Clyde(1,1);
		try {
			unNivel = new Nivel(unJuego,1);
		} catch (ArchivoFueraDeFormatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testElegirMovimiento(){
		
		miFantasma.hacerseComestible();
		miFantasma.elegirMovimiento(unNivel);	
		assertFalse(miFantasma.yaMovio());
		
		
		
		
		
	}

}
