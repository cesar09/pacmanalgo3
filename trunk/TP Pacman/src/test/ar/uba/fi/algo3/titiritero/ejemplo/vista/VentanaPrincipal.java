package test.ar.uba.fi.algo3.titiritero.ejemplo.vista;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana {

	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		super(500,500, unControladorJuego);
		this.setTitle("Ejemplo");
	}

	private static final long serialVersionUID = 1L;

}
