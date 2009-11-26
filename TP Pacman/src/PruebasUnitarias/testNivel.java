package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class testNivel {
	
	public void testFantasmaComestible(){
		Fantasma unFantasma = new Blinky(10);
		Fantasma otroFantasma = new Clyde(10);
		assertFalse(unFantasma.hacerseComestible());
		
	}

}
