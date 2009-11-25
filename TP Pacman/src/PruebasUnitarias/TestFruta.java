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
			e.printStackTrace();
		}		
	}
	
	public void testHayPacman() {
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
		Fruta unBloqueVacio= new Fruta();		
		unBloqueVacio.hayPacman(unNivel);
		assertEquals(this.unJuego.getPuntajeDelJugador(),100);
	}
	
	public void testSerTransitado() {
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
		Fruta unBloqueVacio= new Fruta();		
		unBloqueVacio.serTransitado(unNivel);
		assertEquals(this.unJuego.getPuntajeDelJugador(),0);
	}
}
