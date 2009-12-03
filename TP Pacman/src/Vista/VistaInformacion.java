package Vista;

import graphicCollection.*;
import interfasesYControladores.*;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFormattedTextField;

import com.sun.image.codec.jpeg.*;
import TP3.*;

public class VistaInformacion implements Dibujable, Posicionable{

	private Nivel miNivel;
	

	public VistaInformacion(Nivel unNivel){
		this.miNivel = unNivel;
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
			Graphics grafico = ((Ventana)superfice).getGrafico();
			Color miColor = new Color(500);
			grafico.setColor(miColor);
			grafico.drawString("VIDAS: "+ this.miNivel.obtenerMiJuego().obtenerVidasDisponibles(), 580, 200);
			grafico.drawString("PUNTAJE: "+ this.miNivel.obtenerMiJuego().obtenerPuntajeDelJugador(), 580, 220);
	}
		


	public Posicionable getPosicionable() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setPosicionable(Posicionable posicionable) {
		// TODO Auto-generated method stub
		
	}


	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
