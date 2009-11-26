package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class testPacman extends TestCase{

	private Pacman unPacman;
	
	public void setUp(){
		Point unPoint=new Point(4,4);
		unPacman=new Pacman(unPoint);
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
		unPacman.nuevaPosicion(unPoint);
		assertSame(unPacman.obtenerPosicion(),unPoint);
	}
	
	
}
