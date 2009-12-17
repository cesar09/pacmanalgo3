package pruebas;

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
		unNivel.obtenerPacman().nuevoSentido(-1,0);
		unNivel.comenzarMoverPacman();
		Point unPoint=unNivel.obtenerPacman().obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),23);
	}
	public void testIrDerecha(){
		unNivel.obtenerPacman().nuevoSentido(1,0);
		unNivel.comenzarMoverPacman();
		Point unPoint=unNivel.obtenerPacman().obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),23);
	}
	public void testIrArriba(){
		unNivel.obtenerPacman().nuevoSentido(0,-1);
		unNivel.comenzarMoverPacman();
		Point unPoint=unNivel.obtenerPacman().obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),23);
	}
	public void testIrAbajo(){
		unNivel.obtenerPacman().nuevoSentido(0,1);
		unNivel.comenzarMoverPacman();
		Point unPoint=unNivel.obtenerPacman().obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),23);
	}

}
