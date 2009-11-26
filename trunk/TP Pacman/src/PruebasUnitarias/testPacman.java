package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class testPacman extends TestCase{

	private Pacman unPacman;
	
	public void setUp(){
		Point unPoint=new Point(4,4);
		unPacman=new Pacman();
		assertSame(unPacman.obtenerPosicion(),unPoint);
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
		Point unPoint=new Point(2,2);
		unPacman.renacer();
		assertSame(unPacman.obtenerPosicion(),unPoint);
	}
	public void testIrIzquierda(){
		unPacman.irIzquierda();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),3);
		assertEquals(unPoint.getY(),4);
	}
	public void testIrDerecha(){
		unPacman.irDerecha();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),5);
		assertEquals(unPoint.getY(),4);
	}
	public void testIrArriba(){
		unPacman.irArriba();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),4);
		assertEquals(unPoint.getY(),5);
	}
	public void testIrAbajo(){
		unPacman.irAbajo();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),4);
		assertEquals(unPoint.getY(),3);
	}
}
