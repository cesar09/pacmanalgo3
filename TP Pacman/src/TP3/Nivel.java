package TP3;

import interfasesYControladores.*;
import test.ar.uba.fi.algo3.titiritero.ejemplo.modelo.Mesa;
import graphicCollection.*;
import Vista.*;

public class Nivel {
	
	private Juego juego;
	private Laberinto miLaberinto;
	private Pacman pacman;
	private int nivel;

	private Blinky blinky;
	private Pinky pinky;
	private Inky inky;
	private Clyde clyde;
	private int ultimoSentidoPacman;
	private Mesa fondo;
	

	public Nivel(Juego unJuego, int nivel) throws ArchivoFueraDeFormatoException{
		//La idea es q reciba el numero de nivel por parametro y en base al
		//nivel se crea el laberinto. Tmb pense en darle a velocidad el mismo
		//valor q nivel, entonces a medida q avanza niveles, la velocidad de
		//los fantasmas es mayor. Lo mismo con la duracion de puntoPoder.
		this.juego = unJuego;
		this.nivel=nivel;
		try{
			this.miLaberinto = new Laberinto (this.nivel);
		}catch(ArchivoFueraDeFormatoException e){
			throw new ArchivoFueraDeFormatoException();
		}
		int velocidad = 10 - this.nivel;
		if (velocidad >2){
			this.crearPersonajes(velocidad);
		}else{
			this.crearPersonajes(2);
		}
		configurarInterfazGrafica();
		this.ultimoSentidoPacman=1;//inicializo para q vaya a la izquierda como ultimo movim.
		new TimerFruta(15,this); 
		new TimerVacio(22,this);
	}

	protected void configurarInterfazGrafica() {
		fondo=new Mesa(600,600);
		VistaFondo vistaFondo=new VistaFondo();
		vistaFondo.setPosicionable(fondo);
		
		VistaLaberinto vistaLaberinto=new VistaLaberinto(miLaberinto);
		VistaFantasma vistaPinky=new VistaFantasma(pinky,"pinky.jpg");
		vistaPinky.setPosicionable(pinky);

		VistaFantasma vistaBlinky=new VistaFantasma(blinky,"blinky.jpg");
		vistaBlinky.setPosicionable(blinky);
		
		VistaFantasma vistaClyde=new VistaFantasma(clyde,"clyde.jpg");
		vistaClyde.setPosicionable(clyde);
		
		VistaFantasma vistaInky=new VistaFantasma(inky,"inky.jpg");
		vistaInky.setPosicionable(inky);
		
		VistaPacman vistaPacman=new VistaPacman(this.pacman);		
		vistaPacman.setPosicionable(pacman);
		vistaPacman.setMovible(pacman);
		KeyboardController teclado=new KeyboardController(this.pacman);
		MouseClickController mouse=new MouseClickController();
		Ventana ventana=new VentanaPrincipal(mouse,teclado);
		this.juego.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		this.juego.agregarDibujable(vistaFondo);
		this.juego.agregarDibujable(vistaLaberinto);
		this.juego.agregarDibujable(vistaPacman);
		this.juego.agregarDibujable(vistaPinky);
		this.juego.agregarDibujable(vistaClyde);
		this.juego.agregarDibujable(vistaBlinky);
		this.juego.agregarDibujable(vistaInky);
	}

	private void crearPersonajes(int velocidad){
		this.blinky = new Blinky (velocidad-1);
		this.pinky = new Pinky (velocidad);
		this.inky = new Inky (velocidad-1);
		this.clyde = new Clyde (velocidad); 	
		this.pacman = new Pacman ();
	}
	
	public void llevarFantasmasAJaula() {
		this.blinky.irAJaula();
		this.pinky.irAJaula();
		this.inky.irAJaula();
		this.clyde.irAJaula(); 	
	}
	
	public void llevarPacmanAPosicionInicial() {
		this.pacman.renacer();
	}
	
	public Juego obtenerMiJuego(){
		return (this.juego);
	}
	
	public void moverFantasma (Fantasma unFantasma) throws PacmanAtrapadoException{
		if (unFantasma.estaEncerrado()){
			new TimerSalirDeJaula (2, unFantasma);
		}else{
			try{
				unFantasma.elegirMovimiento(this);
			}catch(PacmanAtrapadoException e){
				throw new PacmanAtrapadoException ();
			}catch(FantasmaAtrapadoException e2){
				unFantasma.fantasmaComido(this);
			}
		}
	}
	
	public void mueveFantasmas() throws PacmanAtrapadoException{
		try{
			this.moverFantasma(this.blinky);
			this.moverFantasma(this.pinky);
			this.moverFantasma(this.clyde);
			this.moverFantasma(this.inky);
		}catch(PacmanAtrapadoException e){
			this.llevarFantasmasAJaula();
			this.llevarPacmanAPosicionInicial();
			throw new PacmanAtrapadoException ();
		}
	}
		
	
	public void muevePacman() throws PacmanAtrapadoException{
		//FALTARÍA IMPLEMENTAR EL DETECTOR DE INTERRUPCIONES 
		//SI EL MOVIMIENTO INDICADO NO ES TRANSITABLE lanza excepcion
			this.moverSegunSentido();
	}
	
	
	protected boolean moverSegunSentido() throws PacmanAtrapadoException{
		int x;
		int y;
		x = this.pacman.getX();
		y = this.pacman.getY();
		switch (this.pacman.getSentidoX()){		
		case -1:
			//Si se desea ir para la izquierda.
			x = x-1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irIzquierda();
				 if (!this.juego.seGanoJuego()){
					ultimoSentidoPacman=1;
					this.comeOMuere(this.blinky);
					this.comeOMuere(this.pinky);
					this.comeOMuere(this.clyde);
					this.comeOMuere(this.inky);
					return true;
				 }
			} catch (NoTransitableException e) {}
			 break;
		case 1:
			//Si se desea ir para la derecha.
			x = x+1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irDerecha();
				 if (!this.juego.seGanoJuego()){
					 ultimoSentidoPacman=1;
					 this.comeOMuere(this.blinky);
					 this.comeOMuere(this.pinky);
					 this.comeOMuere(this.clyde);
					 this.comeOMuere(this.inky);
					 return true;
				 }
			} catch (NoTransitableException e) {}
			 break;
		}
		switch (this.pacman.getSentidoY()){
		case 1:
			//Si se desea ir para abajo.
			y = y+1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irAbajo();
				 if (!this.juego.seGanoJuego()){
					 ultimoSentidoPacman=1;
					 this.comeOMuere(this.blinky);
					 this.comeOMuere(this.pinky);
					 this.comeOMuere(this.clyde);
					 this.comeOMuere(this.inky);
					 return true;
				 }
			} catch (NoTransitableException e) {}
			 break;
		
		case -1:
			y = y-1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irArriba();
				 if (!this.juego.seGanoJuego()){
					 ultimoSentidoPacman=1;
					 this.comeOMuere(this.blinky);
					 this.comeOMuere(this.pinky);
					 this.comeOMuere(this.clyde);
					 this.comeOMuere(this.inky);
					 return true;
				 }
			} catch (NoTransitableException e) {}
			 break;
		}
		return false;
	}
	
	public void hacerFantasmasComestibles(){
		this.blinky.hacerseComestible();
		this.pinky.hacerseComestible();
		this.inky.hacerseComestible();
		this.clyde.hacerseComestible();
		int segundos = (8 - this.nivel);
		if (segundos > 1){
			new TimerComestible (segundos, this);
		}else{
			new TimerComestible (2, this);
		}
	}
	
	public void hacerFantasmasNoComestibles(){
		this.blinky.hacerseNoComestible();
		this.pinky.hacerseNoComestible();
		this.inky.hacerseNoComestible();
		this.clyde.hacerseNoComestible();
	}

	public Laberinto obtenerMiLaberinto() {
		return miLaberinto;
	}
	
	public Pacman obtenerPacman(){
		return this.pacman;
	}
	
	public boolean mismaPosicion(Fantasma unFantasma,Pacman unPacman){
		if(unFantasma.obtenerPosicion().equals(unPacman.obtenerPosicion())){
			return true;
		} else {
			return false;
			}
	}
	
	public void comeOMuere(Fantasma unFantasma) throws PacmanAtrapadoException{
		if (mismaPosicion(unFantasma,this.obtenerPacman())){
			if(unFantasma.esComestible()){
				unFantasma.fantasmaComido(this);
			}else{
				throw new PacmanAtrapadoException();
			}
				
		}
	}
	
}
