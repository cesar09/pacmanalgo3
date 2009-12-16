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
	
	public void setUp() {
		this.unJuego= new Juego();
	}
	
	public void testHacerFantasmasComestibles(){
		this.unJuego.obtenerNivel().hacerFantasmasComestibles();
		assertTrue(this.unJuego.obtenerNivel().obtenerBlinky().esComestible());
		assertTrue(this.unJuego.obtenerNivel().obtenerClyde().esComestible());
		assertTrue(this.unJuego.obtenerNivel().obtenerInky().esComestible());
		assertTrue(this.unJuego.obtenerNivel().obtenerPinky().esComestible());
	}
	
	public void testHacerFantasmasNoComestibles(){
		this.unJuego.obtenerNivel().hacerFantasmasComestibles();
		this.unJuego.obtenerNivel().hacerFantasmasNoComestibles();
		assertFalse(this.unJuego.obtenerNivel().obtenerBlinky().esComestible());
		assertFalse(this.unJuego.obtenerNivel().obtenerClyde().esComestible());
		assertFalse(this.unJuego.obtenerNivel().obtenerInky().esComestible());
		assertFalse(this.unJuego.obtenerNivel().obtenerPinky().esComestible());
	}
	
	public void testMismaPosicion(){
		Pacman pacman = this.unJuego.obtenerNivel().obtenerPacman();
		Blinky blinky = this.unJuego.obtenerNivel().obtenerBlinky();
		blinky.mover(13, 23);
		assertTrue(this.unJuego.obtenerNivel().mismaPosicion(blinky, pacman));
	}
	
	public void testComerFantasma(){
		Blinky blinky = this.unJuego.obtenerNivel().obtenerBlinky();
		this.unJuego.obtenerNivel().hacerFantasmasComestibles();
		blinky.mover(13, 23);
		this.unJuego.obtenerNivel().comerFantasmaOMorirPacman(blinky);
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),200);
	}

	public void testMatarPacman2(){
		Blinky blinky = this.unJuego.obtenerNivel().obtenerBlinky();
		blinky.mover(13, 23);
		this.unJuego.obtenerNivel().comerFantasmaOMorirPacman(blinky);
		assertEquals(this.unJuego.obtenerVidasDisponibles(),2);
	}
	
}
