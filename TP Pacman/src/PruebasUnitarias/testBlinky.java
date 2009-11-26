package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;
public class testBlinky extends TestCase{

	private Blinky unFantasma;
	private Nivel unNivel;
	
	public void setUp(){
		this.unFantasma=new Blinky(10);	
		Juego unJuego=new Juego();
		this.unNivel =new Nivel(unJuego);
	}
	public void testMoverIzquierda(){
		Point unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),13);
		try {
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),13);
		try {
			this.unFantasma.elegirMovimiento(unNivel);
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),11);
		assertEquals(unPoint.getY(),14);
		try {
			this.unFantasma.elegirMovimiento(unNivel);
			this.unFantasma.elegirMovimiento(unNivel);
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
	}
}
