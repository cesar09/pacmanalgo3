package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestFruta extends TestCase {

	private Nivel unNivel;
	private Juego unJuego;

	public void setUp(){
		unJuego= new Juego();
		this.unNivel= new Nivel(unJuego);	
	}
	
	public void testHayPacman() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Fruta unaFruta= new Fruta();		
		unaFruta.hayPacman(unNivel);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),100);
	}
	
	public void testSerTransitado() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Fruta unaFruta= new Fruta();		
		unaFruta.serTransitado(unNivel);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
	}
}
