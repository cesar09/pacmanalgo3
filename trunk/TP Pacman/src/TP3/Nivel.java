package TP3;
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
	

	public Nivel(Juego unJuego){
		this.juego = unJuego;
		this.nivel=1;
		this.miLaberinto = new Laberinto (this.nivel);
		this.crearPersonajes();
		this.ultimoSentidoPacman=1; //inicializo para q vaya a la izquierda como ultimo movim.
		new TimerFruta(5,this); 
		new TimerVacio(15,this);
	}

	private void crearPersonajes(){
		this.blinky = new Blinky (1);
		this.pinky = new Pinky (2);
		this.inky = new Inky (1);
		this.clyde = new Clyde (2); 	
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
	
	public void mueveFantasma() throws PacmanSinVidaException{
		if (this.blinky.estaEncerrado()){
			new TimerSalirDeJaula (2, this.blinky);
		}else
			this.blinky.elegirMovimiento(this);
		if (this.pinky.estaEncerrado()){
			new TimerSalirDeJaula (3, this.blinky);
		}else
			this.pinky.elegirMovimiento(this);
		if (this.clyde.estaEncerrado()){
			new TimerSalirDeJaula (4, this.blinky);
		}else
			this.clyde.elegirMovimiento(this);	
		if (this.inky.estaEncerrado()){
			new TimerSalirDeJaula (5, this.blinky);
		}else
			this.inky.elegirMovimiento(this);
	}
	
	public void muevePacman() throws PacmanSinVidaException{
		int sentido=0;
		//FALTARÍA IMPLEMENTAR EL DETECTOR DE INTERRUPCIONES 
	    //SI SENTIDO ES 0, EJECUTA EL ULTIMO MOVIMIENTO
		//SI EL MOVIMIENTO INDICADO NO ES TRANSITABLE
		if(!(this.moverSegunSentido(sentido))) this.moverSegunSentido(ultimoSentidoPacman);
		if(this.mismaPosicion(blinky, pacman)) pacman.comerOMorir(blinky,this);
		else if(this.mismaPosicion(inky, pacman)) pacman.comerOMorir(inky,this);
		else if(this.mismaPosicion(pinky, pacman)) pacman.comerOMorir(pinky,this);
		else if(this.mismaPosicion(clyde, pacman)) pacman.comerOMorir(clyde,this);
	}
	
	
	public boolean moverSegunSentido(int sentido){
		int x;
		int y;
		switch (sentido){
		
		case 1:
			//Si se desea ir para la izquierda.
			x = this.pacman.obtenerPosicion().getX()-1;
			y = this.pacman.obtenerPosicion().getY();
			try {
				 this.obtenerMiLaberinto().devolverContenido(y, x).hayPacman(this);
				 this.pacman.irIzquierda();
				 ultimoSentidoPacman=1;
				 return true;
			 } catch (NoTransitableException e) {}
			 break;
		case 2:
			//Si se desea ir para la derecha.
			x = this.pacman.obtenerPosicion().getX()+1;
			y = this.pacman.obtenerPosicion().getY();
			try {
				 this.obtenerMiLaberinto().devolverContenido(y, x).hayPacman(this);
				 this.pacman.irDerecha();
				 ultimoSentidoPacman=2;
				 return true;
			 } catch (NoTransitableException e) {}
		break;
		
		case 3:
			//Si se desea ir para abajo.
			x = this.pacman.obtenerPosicion().getX();
			y = this.pacman.obtenerPosicion().getY()-1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(y, x).hayPacman(this);
				 this.pacman.irAbajo();
				 ultimoSentidoPacman=3;
				 return true;
			 } catch (NoTransitableException e) {}
		break;
		
		case 4:
			x = this.pacman.obtenerPosicion().getX();
			y = this.pacman.obtenerPosicion().getY()+1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(y, x).hayPacman(this);
				 this.pacman.irArriba();
				 ultimoSentidoPacman=4;
				 return true;
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
		new TimerComestible (7, this);
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
	
	public void nuevoNivel(int nivelActual) throws ArchivoFueraDeFormatoException {
		this.nivel=nivelActual;
		this.miLaberinto = new Laberinto (nivelActual);
		this.llevarFantasmasAJaula();
		this.ultimoSentidoPacman=1; //inicializo para q vaya a la izquierda como ultimo movim.
	}
    
	public void finDeNivel(){
		this.juego.pasarDeNivel();	
	}
	
}
