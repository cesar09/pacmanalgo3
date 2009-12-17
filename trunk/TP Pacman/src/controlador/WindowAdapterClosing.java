package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Vista.Ventana;
import Vista.VentanaPrincipal;

public class WindowAdapterClosing extends WindowAdapter{
	
	protected Ventana ventanaPrincipal;
	public WindowAdapterClosing(Ventana ventanaPrincipal){
		super();
		this.ventanaPrincipal=ventanaPrincipal;		
	}
}
