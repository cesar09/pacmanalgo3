package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestPuntoPoder extends TestCase {

	private Nivel unNivel;
	private Juego unJuego;

	public void setUp(){
		unJuego= new Juego();
		this.unNivel= new Nivel(unJuego);	
	}
	
	public void testHayPacman1() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		PuntoPoder unBloqueVacio= new PuntoPoder();		
		unBloqueVacio.hayPacman(unNivel);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),50);
	}
	public void testHayPacman2() {
		Laberinto unLaberinto=unNivel.obtenerMiLaberinto();
		for(int x=0;x<243;x++) unLaberinto.restarCantidadPastillas();
		PuntoPoder unPuntoPoder= new PuntoPoder();	
		unPuntoPoder.hayPacman(unNivel);
		assertEquals(unJuego.obtenerNivelActual(),2);
	}
	public void testSerTransitado() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		PuntoPoder unBloqueVacio= new PuntoPoder();		
		unBloqueVacio.serTransitado(unNivel);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
	}
}
