package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class testPacman extends TestCase{

	private Pacman unPacman;
	
	public void setUp(){
		unPacman=new Pacman();
		Point unPoint;
		unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),23);
	}

	public void testNuevaPosicion(){
		unPacman.renacer();
		Point unPoint;
		unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),23);
		assertSame(unPacman.obtenerPosicion(),unPoint);
	}
	public void testIrIzquierda(){
		unPacman.irIzquierda();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),23);
	}
	public void testIrDerecha(){
		unPacman.irDerecha();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),23);
	}
	public void testIrArriba(){
		unPacman.irArriba();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),22);
	}
	public void testIrAbajo(){
		unPacman.irAbajo();
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),24);
	}

}
