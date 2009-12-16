package pruebas;

import modelo.ArchivoFueraDeFormatoException;
import modelo.Juego;
import modelo.Nivel;
import modelo.Blinky;
import modelo.Pacman;
import modelo.NivelGanado;
import modelo.NoTransitableException;

import junit.framework.TestCase;


public class TestNivel extends TestCase{
	
	private Juego unJuego;
	private Nivel unNivel;
	
	public void setUp() {
		this.unJuego= new Juego();
		try{
			this.unNivel =new Nivel(unJuego,unJuego.obtenerNivelActual());
		} catch (ArchivoFueraDeFormatoException e) {
			fail("Formato incorrecto en laberinto correspondiente al nivel");
		}
	}
	
	public void testHacerFantasmasComestibles(){
		this.unNivel.hacerFantasmasComestibles();
		assertTrue(this.unNivel.obtenerBlinky().esComestible());
		assertTrue(this.unNivel.obtenerClyde().esComestible());
		assertTrue(this.unNivel.obtenerInky().esComestible());
		assertTrue(this.unNivel.obtenerPinky().esComestible());
	}
	
	public void testHacerFantasmasNoComestibles(){
		this.unNivel.hacerFantasmasComestibles();
		this.unNivel.hacerFantasmasNoComestibles();
		assertFalse(this.unNivel.obtenerBlinky().esComestible());
		assertFalse(this.unNivel.obtenerClyde().esComestible());
		assertFalse(this.unNivel.obtenerInky().esComestible());
		assertFalse(this.unNivel.obtenerPinky().esComestible());
	}
	
	public void testMismaPosicion(){
		Pacman pacman = this.unNivel.obtenerPacman();
		Blinky blinky = this.unNivel.obtenerBlinky();
		blinky.mover(13, 23);
		assertTrue(this.unNivel.mismaPosicion(blinky, pacman));
	}
	
	public void testComerFantasma(){
		Blinky blinky = this.unNivel.obtenerBlinky();
		this.unNivel.hacerFantasmasComestibles();
		blinky.mover(13, 23);
		this.unNivel.comerFantasmaOMorirPacman(blinky);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),200);
	}

	public void testMatarPacman2(){
		Blinky blinky = this.unNivel.obtenerBlinky();
		blinky.mover(13, 23);
		this.unNivel.comerFantasmaOMorirPacman(blinky);
		assertEquals(this.unJuego.obtenerVidasDisponibles(),2);
	}
	
}
