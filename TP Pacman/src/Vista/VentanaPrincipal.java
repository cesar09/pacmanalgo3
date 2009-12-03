package Vista;

import graphicCollection.KeyboardController;
import graphicCollection.MouseClickController;
import graphicCollection.Ventana;
import TP3.*;

public class VentanaPrincipal extends Ventana {

	public VentanaPrincipal(MouseClickController unControladorMouse,KeyboardController unControladorTeclado) {
		super(725,650,unControladorMouse,unControladorTeclado);
		this.setTitle("Pacman Grupo 8");
	}

	private static final long serialVersionUID = 1L;

}