package PruebasUnitarias;

import modelo.ArchivoFueraDeFormatoException;
import modelo.Fruta;
import modelo.Juego;
import modelo.Nivel;
import graphicCollection.Ventana;
import junit.framework.TestCase;
import TP3.*;

public class TestFruta extends TestCase {

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
		Fruta unaFruta= new Fruta();		
		unaFruta.hayPacman(unNivel,1,1);//Doy valores a x e y aleatorios, ya que no son necesarios.
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),100);
	}
	
	public void testSerTransitado() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Fruta unaFruta= new Fruta();		
		unaFruta.serTransitado(unNivel, null, null, null);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
	}
}
