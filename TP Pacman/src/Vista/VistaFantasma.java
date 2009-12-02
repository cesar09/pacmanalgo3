package Vista;

import graphicCollection.*;
import java.awt.*;
import java.io.InputStream;
import com.sun.image.codec.jpeg.*;
import TP3.*;
import ar.uba.fi.algo3.titiritero.*;

public class VistaFantasma implements Dibujable{
	 
	private int contador=1;
	private Image imagenFantasma;
	private Image imagenComible;
	private String nombreArchivoComible="comible.jpg";
	private Posicionable posicionable;
	private Fantasma unFantasma;
	
	public VistaFantasma(Fantasma unFantasma, String nombreArchivoImagen) {
		this.unFantasma=unFantasma;
		setNombreArchivoImagen(nombreArchivoImagen);
	}
	
	//redefino dibujar de la clase Imagen.
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		int x=this.posicionable.getX();
		int y=this.posicionable.getY();
		if(contador<10){
			if (!unFantasma.esComestible()){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagenFantasma,x*20,y*20, null);
			}
			else{
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagenComible,x*20,y*20, null);
			}			
		}
		if(contador==15) contador=1;
		else contador++;
	}

	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		InputStream in = getClass().getResourceAsStream(nombreArchivoImagen);
		JPEGImageDecoder decoder1 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoComible);
		JPEGImageDecoder decoder2 = JPEGCodec.createJPEGDecoder(in);
		try{
			this.imagenFantasma = decoder1.decodeAsBufferedImage();
			this.imagenComible = decoder2.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){				
		}			
	}

	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;		
	}
}