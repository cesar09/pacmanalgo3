package test.ar.uba.fi.algo3.titiritero.ejemplo.vista;

import interfasesYControladores.ControladorJuego;
import graphicCollection.Ventana;

public class VentanaPrincipal extends Ventana {

	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		super(500,500, null,null);
		this.setTitle("Ejemplo");
	}

	private static final long serialVersionUID = 1L;

}
