package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class TestJugador extends TestCase {

	private Jugador unJugador;
	
	public void SetUp(){
		unJugador= new Jugador();		
	}
	public void TestObtenerPuntaje(){
		assertEquals(unJugador.obtenerPuntaje(),0);		
	}
	public void TestSumarPuntajeUno(){
		try{
			unJugador.sumarPuntaje(10);
		}
		catch(IllegalArgumentException e){
			fail("Lanzó excepcion al intentar sumar puntaje con valor válido.");
		}
		assertEquals(unJugador.obtenerPuntaje(),10);
	}
	public void TestSumarPuntajeDos(){
		try{
			unJugador.sumarPuntaje(-1);
			fail("Permitió sumar puntaje con un valor inválido.");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
}
