package Vista;

import graphicCollection.*;
import java.awt.*;

import controlador.*;

import modelo.Nivel;
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
			int vidas=this.miNivel.obtenerMiJuego().obtenerVidasDisponibles();
			grafico.drawString("VIDAS: "+ vidas, 70, 640);
			grafico.drawString("NIVEL: "+ this.miNivel.obtenerMiJuego().obtenerNivelActual(), 220, 640);
			grafico.drawString("PUNTAJE: "+ this.miNivel.obtenerMiJuego().obtenerPuntajeDelJugador(), 370, 640);
			if(vidas==0) {
				grafico.setFont(new Font("fuente",  Font.BOLD, 30));
				grafico.drawString("JUEGO PERDIDO", 154, 360);
			}
			else if(this.miNivel.obtenerMiJuego().seGanoJuego()){
					grafico.setFont(new Font("fuente",  Font.BOLD, 30));
					grafico.drawString("JUEGO GANADO", 154, 360);
			}
	}

	public Posicionable getPosicionable() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPosicionable(Posicionable posicionable) {
		// TODO Auto-generated method stub
		
	}		
}
