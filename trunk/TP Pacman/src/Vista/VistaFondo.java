package Vista;

import graphicCollection.Cuadrado;

import java.awt.Color;

import TP3.Mesa;


public class VistaFondo extends Cuadrado {

	public VistaFondo(Mesa fondo) {
		super(fondo.getAncho(),fondo.getAlto());
		setColor(Color.BLACK);
	}

}