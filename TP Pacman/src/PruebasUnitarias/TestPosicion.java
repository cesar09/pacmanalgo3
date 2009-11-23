package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestPosicion extends TestCase {
				
	public void TestGetContenido(){
		Contenido unContenido = new Bloque();
		Posicion unaPosicion= new Posicion(unContenido);
		assertSame(unaPosicion.getContenido(),unContenido);
	}	
}
