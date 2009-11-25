package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestFruta extends TestCase {

	private Nivel unNivel;
	private Juego unJuego;

	public void setUp(){
		unJuego= new Juego();
		try {
			this.unNivel= new Nivel(unJuego);
		} catch (ArchivoFueraDeFormatoException e) {
			// TODO Auto-generated catch block
			fail("Fallo la carga del archivo para crear el laberinto.");
		}		
	}
	
	public void testHayPacman() {
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
		Fruta unaFruta= new Fruta();		
		unaFruta.hayPacman(unNivel);
		assertEquals(this.unJuego.getPuntajeDelJugador(),100);
	}
	
	public void testSerTransitado() {
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
		Fruta unaFruta= new Fruta();		
		unaFruta.serTransitado(unNivel);
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
	}
}