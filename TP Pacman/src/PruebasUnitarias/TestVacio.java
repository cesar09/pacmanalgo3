package PruebasUnitarias;
import junit.framework.TestCase;
import TP3.*;
public class TestVacio extends TestCase {
	
	private Nivel unNivel;

	public void setUp(){
		this.unNivel= new Nivel(null);		
	}
	
	public void testHayPacman(Nivel unNivel) {
		Laberinto unLaberinto= unNivel.getMiLaberinto();
		Posicion unaPosicion= unLaberinto.devolverPosicion(1,1);
		Transitable unContenido= (Vacio)unaPosicion.getContenido();
		unContenido.hayPacman(unNivel);
		
		//TODO: TERMINAR ESTA GAROMPA.
	}

}
