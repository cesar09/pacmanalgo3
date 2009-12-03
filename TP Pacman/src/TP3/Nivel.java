package TP3;

import interfasesYControladores.*;
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
	private int ultimoSentidoPacmanX;
	private int ultimoSentidoPacmanY;
	

	public Nivel(Juego unJuego, int nivel, Ventana ventana) throws ArchivoFueraDeFormatoException{
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
		int velocidad = 8 - this.nivel;
		if (velocidad >2){
			this.crearPersonajes(velocidad);
		}else{
			this.crearPersonajes(2);
		}
		configurarInterfazGrafica(ventana);
		this.ultimoSentidoPacman=1;//TODO esto es necesario??? inicializo para q pacman vaya a la izquierda como ultimo movim.
		new TimerFruta(15,this); 
		new TimerVacio(22,this);
	}

	protected void configurarInterfazGrafica(Ventana ventana) {
		fondo=new Mesa(740,625);
		VistaFondo vistaFondo=new VistaFondo(fondo);
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
		ventana.addKeyboard(teclado);
		
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
		this.blinky = new Blinky (velocidad-2);
		this.pinky = new Pinky (velocidad);
		this.inky = new Inky (velocidad-2);
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
	
	public void moverFantasma (Fantasma unFantasma, int tiempo) throws PacmanAtrapadoException{
		if (unFantasma.estaEncerrado()){
			new TimerSalirDeJaula (tiempo, unFantasma);
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
			this.moverFantasma(this.blinky,2);
			this.moverFantasma(this.pinky,10);
			this.moverFantasma(this.clyde,18);
			this.moverFantasma(this.inky,26);
		}catch(PacmanAtrapadoException e){
			this.llevarFantasmasAJaula();
			this.llevarPacmanAPosicionInicial();
			throw new PacmanAtrapadoException ();
		}
	}
		
	
	public void muevePacman() throws PacmanAtrapadoException{
		//SI EL MOVIMIENTO INDICADO NO ES TRANSITABLE lanza excepcion
			if(!this.moverSegunSentido(false)) this.moverSegunSentido(true);
		}	
	
	protected boolean moverSegunSentido(boolean moverSegunUltimoSentido) throws PacmanAtrapadoException{
		int x;
		int y;
		int sentidoEnX=this.pacman.getSentidoX();
		int sentidoEnY=this.pacman.getSentidoY();
		if(moverSegunUltimoSentido){	
			sentidoEnX=ultimoSentidoPacmanX;
			sentidoEnY=ultimoSentidoPacmanY;
		}
		x = this.pacman.getX();
		y = this.pacman.getY();
		
		switch (sentidoEnX){		
		case -1:
			//Si se desea ir para la izquierda.
			x = x-1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irIzquierda();
				 ultimoSentidoPacmanX=-1;
				 ultimoSentidoPacmanY=0;
				 if (!this.juego.seGanoJuego()){
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
				 ultimoSentidoPacmanX=1;
				 ultimoSentidoPacmanY=0;
				 if (!this.juego.seGanoJuego()){
					 this.comeOMuere(this.blinky);
					 this.comeOMuere(this.pinky);
					 this.comeOMuere(this.clyde);
					 this.comeOMuere(this.inky);
					 return true;
				 }
			} catch (NoTransitableException e) {}
			 break;
		}
		switch (sentidoEnY){
		case 1:
			//Si se desea ir para abajo.
			y = y+1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irAbajo();
				 ultimoSentidoPacmanY=1;
				 ultimoSentidoPacmanX=0;
				 if (!this.juego.seGanoJuego()){
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
				 ultimoSentidoPacmanY=-1;
				 ultimoSentidoPacmanX=0;
				 if (!this.juego.seGanoJuego()){
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
		int fantasmaX = unFantasma.obtenerPosicion().getX();
		int fantasmaY = unFantasma.obtenerPosicion().getY();
		int pacmanX = unPacman.obtenerPosicion().getX();
		int pacmanY = unPacman.obtenerPosicion().getY();
		if(fantasmaX == pacmanX){
			if (fantasmaY == pacmanY){
				return true;
			}
		}
		return false;
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
