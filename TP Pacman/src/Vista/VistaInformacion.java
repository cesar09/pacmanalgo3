package Vista;

import graphicCollection.*;
import java.awt.Font;
import interfasesYControladores.*;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFormattedTextField;

import com.sun.image.codec.jpeg.*;
import TP3.*;

public class VistaInformacion implements Dibujable{

	private Nivel miNivel;
	

	public VistaInformacion(Nivel unNivel){
		this.miNivel = unNivel;
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
			Graphics grafico = ((Ventana)superfice).getGrafico();
			Color miColor = new Color(500);
			grafico.setColor(miColor);
			grafico.setFont(new Font("fuente",  Font.BOLD, 20));
			grafico.drawString("VIDAS: "+ this.miNivel.obtenerMiJuego().obtenerVidasDisponibles(), 100, 640);
			grafico.drawString("PUNTAJE: "+ this.miNivel.obtenerMiJuego().obtenerPuntajeDelJugador(), 340, 640);
	}

	public Posicionable getPosicionable() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPosicionable(Posicionable posicionable) {
		// TODO Auto-generated method stub
		
	}		
}
