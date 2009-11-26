package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class testPacman extends TestCase{

	private Pacman unPacman;
	
	public void setUp(){
		unPacman=new Pacman();
		Point unPoint;
		unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),23);
		assertEquals(unPoint.getY(),13);
	}
	public void testMorir(){
		try{
			unPacman.morir();
			unPacman.morir();
		}catch(PacmanSinVidaException e){
			fail("Lanz� excepcion estando a�n vivo.");
		}
		try{
			unPacman.morir();
			fail("No lanz� excepcion de pacman sin vida est�ndo con 0 vidas.");
		}catch(PacmanSinVidaException e){
			assertTrue(true);
		}
	}
	public void testAgregarVida(){
		unPacman.agregarVida();
		
		try{
			unPacman.morir();
			unPacman.morir();
			unPacman.morir();
			unPacman.morir();
			fail("No lanz� excepcion de pacman sin vida est�ndo con 0 vidas.");
		}catch(PacmanSinVidaException e){
			assertTrue(true);
		}
	}
	
	public void testNuevaPosicion(){
		unPacman.renacer();
		Point unPoint;
		unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),23);
		assertEquals(unPoint.getY(),13);
		assertSame(unPacman.obtenerPosicion(),unPoint);
	}
	public void testIrIzquierda(){
		unPacman.irIzquierda();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),22);
		assertEquals(unPoint.getY(),13);
	}
	public void testIrDerecha(){
		unPacman.irDerecha();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),24);
		assertEquals(unPoint.getY(),13);
	}
	public void testIrArriba(){
		unPacman.irArriba();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),23);
		assertEquals(unPoint.getY(),14);
	}
	public void testIrAbajo(){
		unPacman.irAbajo();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),23);
		assertEquals(unPoint.getY(),12);
	}
	public void testMatarOMorir1(){
		Juego unJuego= new Juego();
		Nivel unNivel= new Nivel(unJuego);	
		Fantasma unFantasma= new Clyde(10);
		unFantasma.hacerseComestible();
		try {
			unPacman.comerOMorir(unFantasma,unNivel);			
		} catch (PacmanSinVidaException e) {
			fail("El pacman se qued� sin vidas cuando ten�a 3 y perdi� solo 1.");
		}
		assertEquals(unJuego.obtenerPuntajeDelJugador(),200);
	}
	public void testMatarOMorir2(){
		Juego unJuego= new Juego();
		Nivel unNivel= new Nivel(unJuego);	
		Fantasma unFantasma= new Clyde(10);
		try {
			unPacman.comerOMorir(unFantasma,unNivel);	
			unPacman.comerOMorir(unFantasma,unNivel);
			unPacman.comerOMorir(unFantasma,unNivel);
			fail("El pacman debi� morir luego de haber sido comido 3 veces.");
		} catch (PacmanSinVidaException e) {
			assertTrue(true);
		}
		assertEquals(unJuego.obtenerPuntajeDelJugador(),0);
	}
	
	
	public void testObtenerVidas(){
		assertEquals(unPacman.obtenerVidasDisponibles(),3);
	}
}
