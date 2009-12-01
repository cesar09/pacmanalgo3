package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;
public class testInky extends TestCase{

	private Inky inky;
	private Nivel unNivel;
	
	public void setUp(){
		this.inky=new Inky(1);	
		Juego unJuego=new Juego();
		try{
			this.unNivel =new Nivel(unJuego,unJuego.obtenerNivelActual());
		} catch (ArchivoFueraDeFormatoException e) {
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel");
		}
	}
	
	public void testMoverFantasma(){
		Point unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),14);
		try{
			this.inky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),15);
		assertEquals(unPoint.getY(),14);
		try{
			this.inky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),14);
		try{
			this.inky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),15);
		try{
			this.inky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),14);
	}
	public void testComestible(){
		assertFalse(this.inky.esComestible());
		this.inky.hacerseComestible();
		assertTrue(this.inky.esComestible());
		try{
			this.inky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		Point unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),15);
		try{
			this.inky.elegirMovimiento(unNivel);
			this.inky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),16);
		assertEquals(unPoint.getY(),15);
		try{
			this.inky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),15);
		assertEquals(unPoint.getY(),15);
	}
	public void testMoverDerecha(){
		try{
			this.inky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		this.inky.irAJaula();
		Point unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),14);
	}
	public void testSalirDeJaula(){
		assertTrue(this.inky.estaEncerrado());
		this.inky.salirDeJaula();
		assertFalse(this.inky.estaEncerrado());
		Point unPoint=this.inky.obtenerPosicion();
		assertEquals(unPoint.getX(),14);
		assertEquals(unPoint.getY(),11);		
	}
	
}