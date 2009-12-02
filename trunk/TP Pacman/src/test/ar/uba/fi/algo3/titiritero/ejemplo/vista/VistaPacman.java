package test.ar.uba.fi.algo3.titiritero.ejemplo.vista;

import graphicCollection.Imagen;
import graphicCollection.Ventana;

import interfasesYControladores.Movible;
import interfasesYControladores.SuperficieDeDibujo;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;


public class VistaPacman extends Imagen {
	 
	private int contador=1;
	private Image imagen1;
	private Image imagen2;
	private Image imagen3;
	private Image imagen4;
	private Image imagen5;
	private String nombreArchivoImagen1;
	private String nombreArchivoImagen2;
	private String nombreArchivoImagen3;
	private String nombreArchivoImagen4;
	private String nombreArchivoImagen5;
	
	public VistaPacman() {
		super();
		setNombreArchivoImagen("pacmanU.jpg","pacmanD.jpg","pacmanL.jpg","pacmanR.jpg","pacmanCerrado.jpg");
		
	}
	//redefino dibujar de la clase Imagen.
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		int x=this.movible.getX();
		int y=this.movible.getY();
		if(contador<10){
			if (this.movible.getSentidoY() == -1){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagen1,x,y, null);
			}
			if (this.movible.getSentidoY() == 1){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagen2,x,y, null);
			}
			if (this.movible.getSentidoX() == -1){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagen3,x,y, null);
			}
			if (this.movible.getSentidoX() == 1){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagen4,x,y, null);
			}
			
		}
		if(contador>=10){
			Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
			grafico.drawImage(imagen5,x,y, null);
		}
		if(contador==15) contador=1;
		else contador++;
	}

	public void setNombreArchivoImagen(String nombreArchivoImagen1,String nombreArchivoImagen2,String nombreArchivoImagen3,
										String nombreArchivoImagen4,String nombreArchivoImagen5) {
		this.nombreArchivoImagen1 = nombreArchivoImagen1;
		this.nombreArchivoImagen2 = nombreArchivoImagen2;
		this.nombreArchivoImagen3 = nombreArchivoImagen3;
		this.nombreArchivoImagen4 = nombreArchivoImagen4;
		this.nombreArchivoImagen5 = nombreArchivoImagen5;
		InputStream in = getClass().getResourceAsStream(this.nombreArchivoImagen1);
		JPEGImageDecoder decoder1 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoImagen2);
		JPEGImageDecoder decoder2 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoImagen3);
		JPEGImageDecoder decoder3 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoImagen4);
		JPEGImageDecoder decoder4 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoImagen5);
		JPEGImageDecoder decoder5 = JPEGCodec.createJPEGDecoder(in);
		try{
			this.imagen1 = decoder1.decodeAsBufferedImage();
			this.imagen2 = decoder2.decodeAsBufferedImage();
			this.imagen3 = decoder3.decodeAsBufferedImage();
			this.imagen4 = decoder4.decodeAsBufferedImage();
			this.imagen5 = decoder5.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){
			
			
		}			
	}
}
