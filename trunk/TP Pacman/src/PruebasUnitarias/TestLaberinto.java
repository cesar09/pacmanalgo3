package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestLaberinto extends TestCase {
	
	private Laberinto unLaberinto;

	public void setUp(){
		try{
			this.unLaberinto = new Laberinto(1);
			assertTrue(true);
		}catch (ArchivoFueraDeFormatoException e){
			fail("No se pudo cargar el laberinto.");
		}
	}
	
	public void testDevolverContenido(){
		assertTrue (unLaberinto.devolverContenido(1, 2) instanceof Punto);
		assertTrue (unLaberinto.devolverContenido(1, 3)instanceof PuntoPoder);
		assertTrue (unLaberinto.devolverContenido(0, 0)instanceof Bloque);
		assertTrue (unLaberinto.devolverContenido(13, 23)instanceof Vacio);
	}
	
}
