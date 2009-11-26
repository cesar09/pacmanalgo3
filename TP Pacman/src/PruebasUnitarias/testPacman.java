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
			fail("Lanz+o excepcion estando a�n vivo.");
		}
		try{
			unPacman.morir();
			fail("Lanz+o excepcion estando a�n vivo.");
		}catch(PacmanSinVidaException e){
			assertTrue(true);
		}
	}
	
	
}
