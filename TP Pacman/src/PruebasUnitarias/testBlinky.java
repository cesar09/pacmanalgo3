package PruebasUnitarias;

import graphicCollection.Ventana;
import junit.framework.TestCase;
import TP3.*;
public class testBlinky extends TestCase{

	private Blinky blinky;
	private Nivel unNivel;
	private Ventana unaVentana;
	
	public void setUp(){
		this.blinky=new Blinky(1);	
		Juego unJuego=new Juego();
		try{
			this.unNivel =new Nivel(unJuego,unJuego.obtenerNivelActual(),unaVentana);
		} catch (ArchivoFueraDeFormatoException e) {
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel");
		}
	}
	
	public void testMoverIzquierda(){
		Point unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),13);
		try{
			this.blinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),13);
		try{
			this.blinky.elegirMovimiento(unNivel);
			this.blinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),11);
		assertEquals(unPoint.getY(),14);
		try{
			this.blinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),11);
		assertEquals(unPoint.getY(),13);
	}
	
	public void testComestible(){
		assertFalse(this.blinky.esComestible());
		this.blinky.hacerseComestible();
		assertTrue(this.blinky.esComestible());
		try{
			this.blinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		Point unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),13);
		try{
			this.blinky.elegirMovimiento(unNivel);
			this.blinky.elegirMovimiento(unNivel);
			this.blinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),14);
		try{
			this.blinky.elegirMovimiento(unNivel);
			this.blinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),14);
	}
	
	public void testIrAJaula(){
		try{
			this.blinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		this.blinky.irAJaula();
		Point unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),13);
	}
	
	public void testSalirDeJaula(){
		assertTrue(this.blinky.estaEncerrado());
		this.blinky.salirDeJaula();
		assertFalse(this.blinky.estaEncerrado());
		Point unPoint=this.blinky.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),11);		
	}
}
