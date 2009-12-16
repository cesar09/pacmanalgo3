package pruebas;
import modelo.ArchivoFueraDeFormatoException;
import modelo.Juego;
import modelo.Nivel;
import modelo.Vacio;
import junit.framework.TestCase;

public class TestVacio extends TestCase {
	
	private Nivel unNivel;
	private Juego unJuego;

	public void setUp(){
		unJuego= new Juego();
		try{
			this.unNivel =new Nivel(unJuego,unJuego.obtenerNivelActual());
		} catch (ArchivoFueraDeFormatoException e) {
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel");
		}
	}
	
	public void testHayPacman() {
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
		Vacio unBloqueVacio= new Vacio();		
		unBloqueVacio.hayPacman(unNivel,1,1);//Doy valores a x e y aleatorios, ya que no son necesarios.
		assertEquals(this.unJuego.obtenerPuntajeDelJugador(),0);
	}

}
