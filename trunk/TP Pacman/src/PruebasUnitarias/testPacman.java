package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class testPacman extends TestCase{

	private Pacman unPacman;
	
	public void setUp(){
		unPacman=new Pacman();
		Point unPoint= new Point(0,0);
		unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),1);
		assertEquals(unPoint.getY(),1);
	}
	public void testMorir(){
		try{
			unPacman.morir();
			unPacman.morir();
		}catch(PacmanSinVidaException e){
			fail("Lanzó excepcion estando aún vivo.");
		}
		try{
			unPacman.morir();
			fail("No lanzó excepcion de pacman sin vida estándo con 0 vidas.");
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
			fail("No lanzó excepcion de pacman sin vida estándo con 0 vidas.");
		}catch(PacmanSinVidaException e){
			assertTrue(true);
		}
	}
	
	public void testNuevaPosicion(){
		unPacman.renacer();
		Point unPoint= new Point(0,0);
		unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),1);
		assertEquals(unPoint.getY(),1);
		assertSame(unPacman.obtenerPosicion(),unPoint);
	}
	public void testIrIzquierda(){
		unPacman.irIzquierda();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),0);
		assertEquals(unPoint.getY(),1);
	}
	public void testIrDerecha(){
		unPacman.irDerecha();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),2);
		assertEquals(unPoint.getY(),1);
	}
	public void testIrArriba(){
		unPacman.irArriba();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),1);
		assertEquals(unPoint.getY(),2);
	}
	public void testIrAbajo(){
		unPacman.irAbajo();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),1);
		assertEquals(unPoint.getY(),0);
	}
	public void testMatarOMorir1(){
		Juego unJuego= new Juego();
		Nivel unNivel= new Nivel(unJuego);	
		Fantasma unFantasma= new Clyde(10);
		unFantasma.hacerseComestible();
		try {
			unPacman.comerOMorir(unFantasma,unNivel);			
		} catch (PacmanSinVidaException e) {
			fail("El pacman se quedó sin vidas cuando tenía 3 y perdió solo 1.");
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
			fail("El pacman debió morir luego de haber sido comido 3 veces.");
		} catch (PacmanSinVidaException e) {
			assertTrue(true);
		}
		assertEquals(unJuego.obtenerPuntajeDelJugador(),0);
	}
	
	
	public void testObtenerVidas(){
		assertEquals(unPacman.obtenerVidasDisponibles(),3);
	}
}
