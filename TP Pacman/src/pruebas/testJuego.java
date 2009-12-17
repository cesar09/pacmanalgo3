package pruebas;


import modelo.Juego;

import junit.framework.TestCase;

public class testJuego extends TestCase{

	private Juego unJuego;
	
	public void setUp() {
		this.unJuego= new Juego();
	}
	
	public void testSeGanoNivel(){
		int i=0;
		while (i<274){
			this.unJuego.obtenerNivel().obtenerMiLaberinto().restarCantidadPastillas();
			i++;
		}
		assertTrue(this.unJuego.seGanoNivel());
	}
	
}
