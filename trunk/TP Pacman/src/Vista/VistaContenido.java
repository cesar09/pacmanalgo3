package Vista;

import graphicCollection.*;
import interfasesYControladores.*;

import java.awt.*;
import java.io.InputStream;

import modelo.Contenido;

import com.sun.image.codec.jpeg.*;
import TP3.*;

public class VistaContenido{
	 
	private Image imagenContenido;
	private Posicionable posicionable;
	private Contenido unContenido;
	
	public VistaContenido(String nombreArchivoImagen) {
		setNombreArchivoImagen(nombreArchivoImagen);
	}	
	
	//redefino dibujar de la clase Imagen.
	public void dibujar(SuperficieDeDibujo superficeDeDibujo, int x, int y) {
			Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
			grafico.drawImage(imagenContenido,x*20,y*20, null);
	}

	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		InputStream in = getClass().getResourceAsStream(nombreArchivoImagen);
		JPEGImageDecoder decoder1 = JPEGCodec.createJPEGDecoder(in);
		try{
			this.imagenContenido= decoder1.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){
		}			
	}
}