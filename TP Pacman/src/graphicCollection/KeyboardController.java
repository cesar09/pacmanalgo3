package graphicCollection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import TP3.*;
	

public class KeyboardController extends KeyAdapter{
	
	private Pacman unPacman;
	
	public KeyboardController(Pacman pacman) {
		this.unPacman=pacman;
	}
	public void keyPressed(KeyEvent e){ 
		int aux=e.getKeyCode();
		switch(aux){
		case 38: //TODO esto debe ir dentro del Pacman o ligado al pacman pero no de esta forma
			this.unPacman.nuevoSentido(0,-1);	
			break;
		case 40: 
			this.unPacman.nuevoSentido(0,1);
			break;
		case 37: 
			this.unPacman.nuevoSentido(-1,0);
			break;
		case 39: 
			this.unPacman.nuevoSentido(1,0);
			break;
		}
	}
}
