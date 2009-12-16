package pruebas;

import modelo.ArchivoFueraDeFormatoException;
import modelo.Juego;
import modelo.Nivel;
import modelo.PuntoPoder;
import junit.framework.TestCase;


public class TestPuntoPoder extends TestCase {

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
	
	public void testHayPacman1() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		PuntoPoder unBloqueVacio= new PuntoPoder();		
		unBloqueVacio.hayPacman(unNivel,1,1);//Doy valores a x e y aleatorios, ya que no son necesarios.
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),50);
	}

//	public void testSerTransitado() {
//		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
//		PuntoPoder unBloqueVacio= new PuntoPoder();		
//		unBloqueVacio.serTransitado(unNivel, null, null, null);
//		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
//	}
}
