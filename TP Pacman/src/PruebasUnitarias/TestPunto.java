package PruebasUnitarias;

import modelo.ArchivoFueraDeFormatoException;
import modelo.Juego;
import modelo.Nivel;
import modelo.Punto;
import graphicCollection.Ventana;
import junit.framework.TestCase;
import TP3.*;

public class TestPunto extends TestCase {

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
	
	public void testHayPacman1() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Punto unPunto= new Punto();		
		unPunto.hayPacman(unNivel,1,1);//Doy valores a x e y aleatorios, ya que no son necesarios.
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),10);
	}
	
	public void testSerTransitado() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Punto unPunto= new Punto();		
		unPunto.serTransitado(unNivel, null, null, null);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
	}
	
}

