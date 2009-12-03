package PruebasUnitarias;

import TP3.*;
import junit.framework.TestCase;

public class testBloque extends TestCase{
	
	
	private Nivel unNivel;
	private Juego unJuego;

	public void setUp(){
		unJuego= new Juego();
		try{
			this.unNivel =new Nivel(unJuego,unJuego.obtenerNivelActual());
		} catch (ArchivoFueraDeFormatoException e) {
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel");
		}
	}
	
	public void testHayPacman(){
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Bloque unBloque= new Bloque();		
		try {
			unBloque.hayPacman(unNivel,1,1);//Doy valores a x e y aleatorios, ya que no son necesarios.
			fail("Debi� lanzar excepci�n por ser los Bloques no transitables.");
		} catch (NoTransitableException e) {
			assertTrue(true);
		}
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);		
	}
	
	public void testSerTransitado(){
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Bloque unBloque= new Bloque();		
		try {
			unBloque.serTransitado(unNivel);
			fail("Debi� lanzar excepci�n por ser los Bloques no transitables.");
		} catch (NoTransitableException e) {
			assertTrue(true);
		}
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);		
	}

}