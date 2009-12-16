package pruebas;

import modelo.ArchivoFueraDeFormatoException;
import modelo.NoTransitableException;
import modelo.Juego;
import modelo.Nivel;
import junit.framework.TestCase;
import modelo.Blinky;
import modelo.Pacman;


public class testTransportador extends TestCase{
	
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
	
	public void testHayPacman(){
		Pacman pacman = this.unNivel.obtenerPacman();
		assertEquals(pacman.obtenerPosicion().getX(),13);
		assertEquals(pacman.obtenerPosicion().getY(),23);
		try{
			this.unNivel.obtenerMiLaberinto().devolverContenido(0,8).hayPacman(unNivel,0,8);
			//Se debería teletransportar de izquierda a derecha.
		}catch (NoTransitableException e) {
			fail("No debería lanzar excepción ya que el transportador es transitable.");
		}
		assertEquals(pacman.obtenerPosicion().getX(),27);
		assertEquals(pacman.obtenerPosicion().getY(),8);
	}
	
	public void testSerTransitado(){
		Blinky blinky = this.unNivel.obtenerBlinky();
		assertEquals(blinky.obtenerPosicion().getX(),13);
		assertEquals(blinky.obtenerPosicion().getY(),13);
		try{
			this.unNivel.obtenerMiLaberinto().devolverContenido(0,8).serTransitado(unNivel,blinky,0,8);
			//Se debería teletransportar de izquierda a derecha.
		}catch (NoTransitableException e) {
			fail("No debería lanzar excepción ya que el transportador es transitable.");
		}
		assertEquals(blinky.obtenerPosicion().getX(),26);
		assertEquals(blinky.obtenerPosicion().getY(),8);
	}
}
