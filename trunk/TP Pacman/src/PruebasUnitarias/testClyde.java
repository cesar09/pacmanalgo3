package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;
public class testClyde extends TestCase{

	private Clyde unFantasma;
	private Nivel unNivel;
	
	public void setUp(){
		this.unFantasma=new Clyde(1);	
		Juego unJuego=new Juego();
		this.unNivel =new Nivel(unJuego);
	}
	public void testMoverDerecha(){
		Point unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),13);
		try {
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),15);
		assertEquals(unPoint.getY(),13);
		try {
			this.unFantasma.elegirMovimiento(unNivel);
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),14);
		try {
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),15);
		try {
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),14);
	}
	public void testComestible(){
		assertFalse(this.unFantasma.esComestible());
		this.unFantasma.hacerseComestible();
		assertTrue(this.unFantasma.esComestible());
		try {
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		Point unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),13);
		try {
			this.unFantasma.elegirMovimiento(unNivel);
			this.unFantasma.elegirMovimiento(unNivel);
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),13);
	}
		
	public void testIrAJaula(){
		try {
			this.unFantasma.elegirMovimiento(unNivel);
		} catch (PacmanSinVidaException e) {
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");
		}
		this.unFantasma.irAJaula();
		Point unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),13);
	}
	public void testSalirDeJaula(){
		assertTrue(this.unFantasma.estaEncerrado());
		this.unFantasma.salirDeJaula();
		assertFalse(this.unFantasma.estaEncerrado());
		Point unPoint=this.unFantasma.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),11);		
	}
}