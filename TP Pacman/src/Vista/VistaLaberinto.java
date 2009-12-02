package Vista;

import graphicCollection.*;
import interfasesYControladores.*;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import com.sun.image.codec.jpeg.*;
import TP3.*;

public class VistaLaberinto implements Dibujable{

	private Posicionable laberinto;
	private Laberinto unLaberinto;
	
	public VistaLaberinto(Laberinto unLaberinto){
		this.unLaberinto=unLaberinto;
		this.setPosicionable(unLaberinto);
	}
	
	public void dibujar(SuperficieDeDibujo superficie) {
		int cantidadFilas=31;
		int cantidadColumnas=28;
		Contenido unContenido;
		for (int y = 0; y < cantidadFilas; y++) {
			for (int x = 0; x < cantidadColumnas ; x++) {				
				unContenido=unLaberinto.devolverContenido(x,y);
				unContenido.dibujar(superficie,x,y); 
				}
		}
	}

	public Posicionable getPosicionable() {
		return this.laberinto;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.laberinto=posicionable;
	}

}