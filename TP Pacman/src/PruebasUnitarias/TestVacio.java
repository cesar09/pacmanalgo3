package PruebasUnitarias;
import junit.framework.TestCase;
import TP3.*;
public class TestVacio extends TestCase {
	
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
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Vacio unBloqueVacio= new Vacio();		
		unBloqueVacio.hayPacman(unNivel);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
	}
	
	public void testSerTransitado() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Vacio unBloqueVacio= new Vacio();		
		unBloqueVacio.serTransitado(unNivel);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		
	}
}
