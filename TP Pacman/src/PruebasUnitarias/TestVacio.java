package PruebasUnitarias;
import graphicCollection.Ventana;
import junit.framework.TestCase;
import TP3.*;
public class TestVacio extends TestCase {
	
	private Nivel unNivel;
	private Juego unJuego;
	private Ventana unaVentana;

	public void setUp(){
		unJuego= new Juego();
		try{
			this.unNivel =new Nivel(unJuego,unJuego.obtenerNivelActual(),unaVentana);
		} catch (ArchivoFueraDeFormatoException e) {
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel");
		}
	}
	
	public void testHayPacman() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Vacio unBloqueVacio= new Vacio();		
		unBloqueVacio.hayPacman(unNivel,1,1);//Doy valores a x e y aleatorios, ya que no son necesarios.
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
	}
	
	public void testSerTransitado() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Vacio unBloqueVacio= new Vacio();		
		unBloqueVacio.serTransitado(unNivel);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		
	}
}
