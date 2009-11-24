package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestPosicion extends TestCase {
				
	public void testGetContenido(){
		Contenido unContenido = new Bloque();
		Posicion unaPosicion= new Posicion(unContenido);
		assertSame(unaPosicion.getContenido(),unContenido);
	}	
}
