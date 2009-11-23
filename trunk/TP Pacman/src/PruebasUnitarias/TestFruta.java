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
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
		Vacio unBloqueVacio= new Vacio();		
		unBloqueVacio.hayPacman(unNivel);
		assertEquals(this.unJuego.getPuntajeDelJugador(),100);
	}
	public void testGetTransitable() {
		Vacio unBloqueVacio= new Vacio();		
		Transitable auxiliar= unBloqueVacio.getTransitable();
		assertSame(unBloqueVacio,auxiliar);
	}
}
