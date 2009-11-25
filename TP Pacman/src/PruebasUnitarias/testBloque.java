package PruebasUnitarias;

import TP3.*;
import junit.framework.TestCase;

public class testBloque extends TestCase{
	
	
	private Nivel unNivel;
	private Juego unJuego;

	public void setUp(){
		unJuego= new Juego();
		this.unNivel= new Nivel(unJuego);
			
	}
	
	public void testHayPacman(){
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Bloque unBloque= new Bloque();		
		try {
			unBloque.hayPacman(unNivel);
			fail("Debió lanzar excepción por ser los Bloques no transitables.");
		} catch (NoTransitableException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);		
	}
	
	public void testSerTransitado(){
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Bloque unBloque= new Bloque();		
		try {
			unBloque.serTransitado(unNivel);
			fail("Debió lanzar excepción por ser los Bloques no transitables.");
		} catch (NoTransitableException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);		
	}

}
