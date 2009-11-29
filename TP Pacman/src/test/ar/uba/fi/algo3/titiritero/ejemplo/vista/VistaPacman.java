package test.ar.uba.fi.algo3.titiritero.ejemplo.vista;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VistaPacman extends Imagen {
	 
	private int contador=1;
	private Image imagen1;
	private Image imagen2;
	private String nombreArchivoImagen1;
	private String nombreArchivoImagen2;
	public VistaPacman() {
		super();
		setNombreArchivoImagen("pacman.jpg","pacmanCerrado.jpg");
		
	}
	//redefino dibujar de la clase Imagen.
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		int x=this.posicionable.getX();
		int y=this.posicionable.getY();
		if(contador<10){
			Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
			grafico.drawImage(imagen1,x,y, null);
		}
		if(contador>=10){
			Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
			grafico.drawImage(imagen2,x,y, null);
		}
		if(contador==15) contador=1;
		else contador++;
	}

	public void setNombreArchivoImagen(String nombreArchivoImagen1,String nombreArchivoImagen2) {
		this.nombreArchivoImagen1 = nombreArchivoImagen1;
		this.nombreArchivoImagen2 = nombreArchivoImagen2;
		InputStream in = getClass().getResourceAsStream(this.nombreArchivoImagen1);
		JPEGImageDecoder decoder1 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoImagen2);
		JPEGImageDecoder decoder2 = JPEGCodec.createJPEGDecoder(in);
		try{
			this.imagen1 = decoder1.decodeAsBufferedImage();
			this.imagen2 = decoder2.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){
			
			
		}			
	}
}
