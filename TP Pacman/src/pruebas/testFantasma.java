package pruebas;

import modelo.*;
import junit.framework.TestCase;

public class testFantasma extends TestCase {
	

	private Fantasma miFantasma;
	private Nivel unNivel;
	private Juego unJuego;
	private int posicionInicialX;
	private int posicionInicialY;

	public void setUp(){
		miFantasma = new Blinky(1,1);
		try {
			unNivel = new Nivel(unJuego,1);
		} catch (ArchivoFueraDeFormatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testElegirMovimientoSiEsComestible(){
		posicionInicialX = miFantasma.getX();
		posicionInicialY = miFantasma.getY();
		miFantasma.hacerseComestible();
		miFantasma.elegirMovimiento(unNivel);	
		assertFalse(miFantasma.yaMovio());
		assertEquals(++posicionInicialX, miFantasma.getX());
		assertEquals(posicionInicialY, miFantasma.getY());
	}
	
	public void testElegirMovimientoSiNoEsComestible(){
		posicionInicialX = miFantasma.getX();
		posicionInicialY = miFantasma.getY();
		miFantasma.hacerseNoComestible();
		miFantasma.elegirMovimiento(unNivel);	
		assertFalse(miFantasma.yaMovio());
		assertEquals(--posicionInicialX, miFantasma.getX());
		assertEquals(posicionInicialY, miFantasma.getY());
	}
	
	public void testFantasmaComido(){
		
	}

	public void testMoverFantasma(){
		
	}

	public void testDistanciaPacman(){
		
	}
	
	public void testMoverAbajo(){
		
	}
	
	public void testMoverArriba(){
		
	}

	public void testMoverDerecha(){
	
	}

	public void testMoverIzquierda(){
	
	}
	
	
}
