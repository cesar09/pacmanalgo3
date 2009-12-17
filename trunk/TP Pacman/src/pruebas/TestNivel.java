package pruebas;


import modelo.*;




import junit.framework.TestCase;


public class TestNivel extends TestCase{
	
	private Juego unJuego;
	
	public void setUp() {
		this.unJuego= new Juego();
	}
	
		public void testMismaPosicion(){
		Pacman pacman = this.unJuego.obtenerNivel().obtenerPacman();
		Blinky blinky = this.unJuego.obtenerNivel().obtenerBlinky();
		blinky.mover(13, 23);
		assertTrue(this.unJuego.obtenerNivel().mismaPosicion(blinky, pacman));
	}
	
	public void testComerFantasma(){
		Blinky blinky = this.unJuego.obtenerNivel().obtenerBlinky();
		try{
			this.unJuego.obtenerNivel().obtenerMiLaberinto().devolverContenido(1, 3).hayPacman(this.unJuego.obtenerNivel(), 1, 3);
		}catch (NoTransitableException e){}
		blinky.mover(13, 23);
		this.unJuego.obtenerNivel().comerFantasmaOMorirPacman(blinky);
		assertEquals(blinky.obtenerPosicion().getX(),13);
		assertEquals(blinky.obtenerPosicion().getY(),13);
		//assertEquals(this.unJuego.obtenerPuntajeDelJugador(),200);
	}

	public void testMatarPacman2(){
		Blinky blinky = this.unJuego.obtenerNivel().obtenerBlinky();
		blinky.mover(13, 23);
		this.unJuego.obtenerNivel().comerFantasmaOMorirPacman(blinky);
		assertEquals(this.unJuego.obtenerVidasDisponibles(),2);
	}
	
}
