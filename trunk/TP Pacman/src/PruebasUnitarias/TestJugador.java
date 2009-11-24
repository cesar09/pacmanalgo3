package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestJugador extends TestCase {

	private Jugador unJugador;
	
	public void setUp(){
		this.unJugador= new Jugador();		
	}
	public void testObtenerPuntaje(){
		assertEquals(this.unJugador.obtenerPuntaje(),0);		
	}
	public void testSumarPuntajeUno(){
		try{
			unJugador.sumarPuntaje(10);
		}
		catch(IllegalArgumentException e){
			fail("Lanz� excepcion al intentar sumar puntaje con valor v�lido.");
		}
		assertEquals(unJugador.obtenerPuntaje(),10);
	}
	public void testSumarPuntajeDos(){
		try{
			unJugador.sumarPuntaje(-1);
			fail("Permiti� sumar puntaje con un valor inv�lido.");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
}
