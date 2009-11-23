package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestBloque extends TestCase {

			
	public void TestGetTransitable(){
		Bloque unBloque = new Bloque();
		assertEquals(unBloque.getTransitable(),null);			
	}
		
}
