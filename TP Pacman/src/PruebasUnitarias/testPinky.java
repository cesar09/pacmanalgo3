package PruebasUnitarias;

import graphicCollection.Ventana;
import junit.framework.TestCase;
import TP3.*;
public class testPinky extends TestCase{

	private Pinky pinky;
	private Nivel unNivel;
	private Ventana unaVentana;
	
	public void setUp(){
		this.pinky=new Pinky(1);	
		Juego unJuego=new Juego();
		try{
			this.unNivel =new Nivel(unJuego,unJuego.obtenerNivelActual(),unaVentana);
		} catch (ArchivoFueraDeFormatoException e) {
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel");
		}
	}
	
	public void testMoverPorRandom(){
		Point unPoint=this.pinky.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),14);
		try{
			this.pinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.pinky.obtenerPosicion();
		assertTrue((unPoint.getX()==13)|(unPoint.getY()==14));
	}
	public void testComestible(){
		assertFalse(this.pinky.esComestible());
		this.pinky.hacerseComestible();
		assertTrue(this.pinky.esComestible());
		try{
			this.pinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		Point unPoint=this.pinky.obtenerPosicion();
		assertEquals(unPoint.getX(),12);
		assertEquals(unPoint.getY(),14);
		try{
			this.pinky.elegirMovimiento(unNivel);
			this.pinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		unPoint=this.pinky.obtenerPosicion();
		assertEquals(unPoint.getX(),11);
		assertEquals(unPoint.getY(),13);
	}
		
	public void testIrAJaula(){
		try{
			this.pinky.elegirMovimiento(unNivel);
		}catch(PacmanAtrapadoException e){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}catch(FantasmaAtrapadoException e2){
			fail("No debió lanzar excepción aquí, ya que a esta altura los fantasmas no han salido de la jaula.");;
		}
		this.pinky.irAJaula();
		Point unPoint=this.pinky.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),14);
	}
	public void testSalirDeJaula(){
		assertTrue(this.pinky.estaEncerrado());
		this.pinky.salirDeJaula();
		assertFalse(this.pinky.estaEncerrado());
		Point unPoint=this.pinky.obtenerPosicion();
		assertEquals(unPoint.getX(),13);
		assertEquals(unPoint.getY(),11);		
	}
}