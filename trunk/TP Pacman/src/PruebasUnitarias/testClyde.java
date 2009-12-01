package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;
public class testClyde extends TestCase{

	private Clyde clyde;
	private Nivel unNivel;
	
	public void setUp(){
		this.clyde=new Clyde(1);	
		Juego unJuego=new Juego();
		try{
			this.unNivel =new Nivel(unJuego,unJuego.obtenerNivelActual());
		} catch (ArchivoFueraDeFormatoException e) {
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel");
		}
	}
	
	public void testMoverDerecha(){
		Point unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),13);
		try{
			this.clyde.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),15);
		assertEquals(unPoint.getY(),13);
		try{
			this.clyde.elegirMovimiento(unNivel);
			this.clyde.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),14);
		try{
			this.clyde.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),15);
		try{
			this.clyde.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),14);
	}
	public void testComestible(){
		assertFalse(this.clyde.esComestible());
		this.clyde.hacerseComestible();
		assertTrue(this.clyde.esComestible());
		try{
			this.clyde.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		Point unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),13);
		try{
			this.clyde.elegirMovimiento(unNivel);
			this.clyde.elegirMovimiento(unNivel);
			this.clyde.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),13);
	}
		
	public void testIrAJaula(){
		try{
			this.clyde.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		this.clyde.irAJaula();
		Point unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),13);
	}
	public void testSalirDeJaula(){
		assertTrue(this.clyde.estaEncerrado());
		this.clyde.salirDeJaula();
		assertFalse(this.clyde.estaEncerrado());
		Point unPoint=this.clyde.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),11);		
	}
}