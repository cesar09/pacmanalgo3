package ar.uba.fi.algo3.titiritero.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import test.ar.uba.fi.algo3.titiritero.ejemplo.modelo.Pacman;



public class KeyboardController extends KeyAdapter{
	
	private ControladorJuego controlador;

	public KeyboardController(ControladorJuego unControlador) {
		this.controlador=unControlador;
	}
	public void keyPressed(KeyEvent e){ 
		Pacman unPacman;
		int aux=e.getKeyCode();
		switch(aux){
		case 38: //TODO esto debe ir dentro del Pacman o ligado al pacman pero no de esta forma
			unPacman = (Pacman) controlador.getObjetoVivo();
			unPacman.nuevoSentido(0,-1);	
			break;
		case 40: 
			unPacman = (Pacman) controlador.getObjetoVivo();
			unPacman.nuevoSentido(0,1);
			break;
		case 37: 
			unPacman = (Pacman) controlador.getObjetoVivo();
			unPacman.nuevoSentido(-1,0);
			break;
		case 39: 
			unPacman = (Pacman) controlador.getObjetoVivo();
			unPacman.nuevoSentido(1,0);
			break;
		}
	}
}
