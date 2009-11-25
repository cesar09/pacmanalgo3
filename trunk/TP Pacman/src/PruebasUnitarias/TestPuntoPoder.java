package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestPuntoPoder extends TestCase {

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
		PuntoPoder unBloqueVacio= new PuntoPoder();		
		unBloqueVacio.hayPacman(unNivel);
		assertEquals(this.unJuego.getPuntajeDelJugador(),50);
	}
	public void testSerTransitado() {
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
		PuntoPoder unBloqueVacio= new PuntoPoder();		
		unBloqueVacio.serTransitado(unNivel);
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
	}
}
