package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestLaberinto extends TestCase {
		
	private Laberinto miLaberinto;

	public void setUp(){
		try {
			miLaberinto = new Laberinto(1);
		} catch (ArchivoFueraDeFormatoException e) {
			e.printStackTrace();
		}
	}
		
		
/*		  miLaberinto.agregarObjeto(35,0,0);
		  miLaberinto.agregarObjeto(35,0,1);
          miLaberinto.agregarObjeto(35,0,2);
          miLaberinto.agregarObjeto(35,0,3);
          miLaberinto.agregarObjeto(35,0,4);
          miLaberinto.agregarObjeto(35,0,5);
          miLaberinto.agregarObjeto(35,0,6);
          miLaberinto.agregarObjeto(35,1,0);
          miLaberinto.agregarObjeto(79,1,1);
          miLaberinto.agregarObjeto(111,1,2);
          miLaberinto.agregarObjeto(111,1,3);
          miLaberinto.agregarObjeto(111,1,4);
          miLaberinto.agregarObjeto(79,1,5);
          miLaberinto.agregarObjeto(35,1,6);
          miLaberinto.agregarObjeto(35,2,0);
          miLaberinto.agregarObjeto(111,2,1);
          miLaberinto.agregarObjeto(35,2,2);
          miLaberinto.agregarObjeto(111,2,3);
          miLaberinto.agregarObjeto(35,2,4);
          miLaberinto.agregarObjeto(111,2,5);
          miLaberinto.agregarObjeto(35,2,6);
          miLaberinto.agregarObjeto(35,3,0);
          miLaberinto.agregarObjeto(111,3,1);
          miLaberinto.agregarObjeto(111,3,2);
          miLaberinto.agregarObjeto(111,3,3);
          miLaberinto.agregarObjeto(111,3,4);
          miLaberinto.agregarObjeto(111,3,5);
          miLaberinto.agregarObjeto(35,3,6);
          miLaberinto.agregarObjeto(35,4,0);
          miLaberinto.agregarObjeto(111,4,1);
          miLaberinto.agregarObjeto(35,4,2);
          miLaberinto.agregarObjeto(111,4,3);
          miLaberinto.agregarObjeto(35,4,4);
          miLaberinto.agregarObjeto(111,4,5);
          miLaberinto.agregarObjeto(35,4,6);
          miLaberinto.agregarObjeto(35,5,0);
          miLaberinto.agregarObjeto(79,5,1);
          miLaberinto.agregarObjeto(111,5,2);
          miLaberinto.agregarObjeto(111,5,3);
          miLaberinto.agregarObjeto(111,5,4);
          miLaberinto.agregarObjeto(79,5,5);
          miLaberinto.agregarObjeto(35,5,6);
          miLaberinto.agregarObjeto(35,6,0);
          miLaberinto.agregarObjeto(35,6,1);
          miLaberinto.agregarObjeto(35,6,2);
          miLaberinto.agregarObjeto(35,6,3);
          miLaberinto.agregarObjeto(35,6,4);
          miLaberinto.agregarObjeto(35,6,5);
          miLaberinto.agregarObjeto(35,6,6);       
*/


	/*
	 * Testea que devuelva el contenido correcto segun la posicion de los
	 * elementos en la carga del Laberinto mediante el archivo nivel1.xml 
	 */
	public void testDevolverContenido(){
		assertTrue (miLaberinto.devolverContenido(1, 2) instanceof Punto);
		assertTrue (miLaberinto.devolverContenido(1, 3)instanceof PuntoPoder);
		assertTrue (miLaberinto.devolverContenido(0, 0)instanceof Bloque);
		assertTrue (miLaberinto.devolverContenido(13, 23)instanceof Vacio);
	}
	
	/*
	 * Testea que devuelva la cantidad de pastillas (punto y puntoPoder)
	 * correcta. Hay 244 pastillas en el archivo nivel1.xml
	 */
	public void testObtenerCantPastillas(){
		assertEquals (miLaberinto.obtenerCantidadPastillas(),244);
	}
	
	/*
	 * Testea que agregue la fruta correctamente
	 */
	public void testAgregarFruta(){
		miLaberinto.agregarFruta();
		assertTrue (miLaberinto.devolverContenido(14, 17) instanceof Fruta);
	}	
	
}
