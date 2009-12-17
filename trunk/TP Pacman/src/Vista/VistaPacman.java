package Vista;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import modelo.Pacman;
import com.sun.image.codec.jpeg.*;
import controlador.*;

public class VistaPacman extends KeyboardController implements Dibujable{
	 
	private int contador=1;
	private Image imagenPacmanU;
	private Image imagenPacmanD;
	private Image imagenPacmanL;
	private Image imagenPacmanR;
	private Image imagenPacmanCerrado;
	private String nombreArchivoPacmanU="pacmanU.jpg";
	private String nombreArchivoPacmanD="pacmanD.jpg";
	private String nombreArchivoPacmanL="pacmanL.jpg";
	private String nombreArchivoPacmanR="pacmanR.jpg";
	private String nombreArchivoPacmanCerrado="pacmanCerrado.jpg";
	private Movible movible;
	private Posicionable posicionable;
	private KeyboardDireccion keyboardDireccion;
	
	public VistaPacman(Pacman unPacman) {
		this.setMovible(unPacman);
		this.setKeyboardDireccion(unPacman);
		setNombreArchivoImagen();
	}
	
	//redefino dibujar de la clase Imagen.
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		int x=this.posicionable.getX();
		int y=this.posicionable.getY();
		if(contador<2){
			if (this.movible.getSentidoGraficoY() == -1){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagenPacmanU,x*20,y*20, null);
			}
			if (this.movible.getSentidoGraficoY() == 1){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagenPacmanD,x*20,y*20, null);
			}
			if (this.movible.getSentidoGraficoX() == -1){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagenPacmanL,x*20,y*20, null);
			}
			if (this.movible.getSentidoGraficoX() == 1){
				Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
				grafico.drawImage(imagenPacmanR,x*20,y*20, null);
			}
			
		}
		if(contador>=2){
			Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
			grafico.drawImage(imagenPacmanCerrado,x*20,y*20, null);
		}
		if(contador==2) contador=1;
		else contador++;
	}

	public void setNombreArchivoImagen() {
		InputStream in = getClass().getResourceAsStream(this.nombreArchivoPacmanU);
		JPEGImageDecoder decoder1 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoPacmanD);
		JPEGImageDecoder decoder2 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoPacmanL);
		JPEGImageDecoder decoder3 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoPacmanR);
		JPEGImageDecoder decoder4 = JPEGCodec.createJPEGDecoder(in);
		in = getClass().getResourceAsStream(this.nombreArchivoPacmanCerrado);
		JPEGImageDecoder decoder5 = JPEGCodec.createJPEGDecoder(in);
		try{
			this.imagenPacmanU = decoder1.decodeAsBufferedImage();
			this.imagenPacmanD = decoder2.decodeAsBufferedImage();
			this.imagenPacmanL = decoder3.decodeAsBufferedImage();
			this.imagenPacmanR = decoder4.decodeAsBufferedImage();
			this.imagenPacmanCerrado = decoder5.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){			
		}			
	}
	
	public Movible getMovible() {
		return this.movible;
	}	
	//Se ejecuta desde el constructor
	public void setMovible(Movible movible) {
		this.movible = movible;
	}

	private void setKeyboardDireccion(Pacman unPacman) {
		this.keyboardDireccion=unPacman;
	}
	
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;		
	}
	
	public void keyPressed(KeyEvent e){ 
		int aux=e.getKeyCode();
		switch(aux){
		case 38: //TODO esto debe ir dentro del Pacman o ligado al pacman pero no de esta forma
			this.keyboardDireccion.nuevoSentido(0,-1);	
			break;
		case 40: 
			this.keyboardDireccion.nuevoSentido(0,1);
			break;
		case 37: 
			this.keyboardDireccion.nuevoSentido(-1,0);
			break;
		case 39: 
			this.keyboardDireccion.nuevoSentido(1,0);
			break;
		}
	}
}