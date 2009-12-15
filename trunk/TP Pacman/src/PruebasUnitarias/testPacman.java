package PruebasUnitarias;

import modelo.ArchivoFueraDeFormatoException;
import modelo.Juego;
import modelo.Nivel;
import modelo.Pacman;
import modelo.Point;
import junit.framework.TestCase;

public class testPacman extends TestCase{

	private Pacman unPacman;
	private Nivel unNivel;
	
	public void setUp(){
		try {
			this.unNivel=new Nivel(new Juego(),1);
			assertTrue(true);
		} catch (ArchivoFueraDeFormatoException e) {
			fail("No devió devolver error.");
		}
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
		unPacman.nuevoSentido(-1,0);
		unPacman.moverSegunSentido(false,unNivel);
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),23);
	}
	public void testIrDerecha(){
		unPacman.nuevoSentido(1,0);
		unPacman.moverSegunSentido(false,unNivel);
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),23);
	}
	public void testIrArriba(){
		unPacman.nuevoSentido(0,-1);
		unPacman.moverSegunSentido(false,unNivel);
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),22);
	}
	public void testIrAbajo(){
		unPacman.nuevoSentido(0,1);
		unPacman.moverSegunSentido(false,unNivel);
		Point unPoint=unPacman.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),24);
	}

}
