package modelo;

public class Nivel {
	
	private Juego juego;
	private Laberinto miLaberinto;
	private Pacman pacman;
	private int nivel;

	private Blinky blinky;
	private Pinky pinky;
	private Inky inky;
	private Clyde clyde;
	
	private int ultimoSentidoPacmanX;
	private int ultimoSentidoPacmanY;
	private TimerComestible timerComestible;
	private boolean timerActivado=false;
	private boolean timerComestibleActivado;
	//private TimerSalirDeJaula timerSalirDeJaula;
	//private boolean timerSalirActivado=false;
	

	public Nivel(Juego unJuego, int nivel) throws ArchivoFueraDeFormatoException{
		//La idea es q reciba el numero de nivel por parametro y en base al
		//nivel se crea el laberinto. Tmb pense en darle a velocidad el mismo
		//valor q nivel, entonces a medida q avanza niveles, la velocidad de
		//los fantasmas es mayor. Lo mismo con la duracion de puntoPoder.
		this.juego = unJuego;
		this.nivel=nivel;
		this.miLaberinto = new Laberinto (this.nivel);
		
		int velocidad = 8 - this.nivel;
		if (velocidad >3)
			this.crearPersonajes(velocidad);
		else
			this.crearPersonajes(3);
		new TimerFruta(15,this); 
		new TimerVacio(22,this);
	}


	private void crearPersonajes(int velocidad){
		this.blinky = new Blinky (velocidad-2,10);
		this.pinky = new Pinky (velocidad,20);
		this.inky = new Inky (velocidad-2,30);
		this.clyde = new Clyde (velocidad,40); 	
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
	
	
	public void comenzarMoverFantasmas(){
			this.blinky.moverFantasma(this);
			this.pinky.moverFantasma(this);
			this.clyde.moverFantasma(this);
			this.inky.moverFantasma(this);
	}		
	
	public void muevePacman(){
			if(!pacman.moverSegunSentido(false,this)) pacman.moverSegunSentido(true,this);
		}	
	
	public void compararPosicionesConFantasmas() {
		this.comerFantasmaOMorirPacman(this.blinky);
		this.comerFantasmaOMorirPacman(this.pinky);
		this.comerFantasmaOMorirPacman(this.clyde);
		this.comerFantasmaOMorirPacman(this.inky);		
	}

	public void hacerFantasmasComestibles(){
		this.blinky.hacerseComestible();
		this.pinky.hacerseComestible();
		this.inky.hacerseComestible();
		this.clyde.hacerseComestible();
		int segundos = (12 - this.nivel);
		if (segundos > 1){
			if(timerComestibleActivado) timerComestible.cancelarTimer();
			timerComestible= new TimerComestible (segundos, this);
		}else{
			if(timerComestibleActivado) timerComestible.cancelarTimer();
			timerComestible= new TimerComestible (segundos, this);
		}
		timerComestibleActivado=true;
	}
	
	public void hacerFantasmasNoComestibles(){
		timerActivado=false;
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
	
	//compara las posiciones de unFantasma y unPacman, devuelve true si son igual, o false en caso contrario
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

	//según el estado del Fantasma muere el pacman o el fantasma y se reinicializan las posiciones.
	public void comerFantasmaOMorirPacman(Fantasma unFantasma){
		if (mismaPosicion(unFantasma,this.obtenerPacman())){
			if(unFantasma.esComestible()){
				unFantasma.fantasmaComido(this);
			}else{
				this.llevarFantasmasAJaula();
				this.llevarPacmanAPosicionInicial();
				this.juego.pacmanFueAtrapado();
			}				
		}
	}
	
	public Pinky obtenerPinky(){
		return (this.pinky);
	}
	
	
	public Blinky obtenerBlinky(){
		return (this.blinky);
	}
	
	
	public Clyde obtenerClyde(){
		return (this.clyde);
	}
	
	
	public Inky obtenerInky(){
		return (this.inky);
	}


	public void transportarPacman(int x) {
		if(x==0){
			this.pacman.serTransportadoADerecha();
			try{	
				int posicionPacmanX = this.pacman.obtenerPosicion().getX()-1;
				int posicionPacmanY = this.pacman.obtenerPosicion().getY();
				this.obtenerMiLaberinto().devolverContenido(posicionPacmanX,posicionPacmanY).hayPacman(this,posicionPacmanX,posicionPacmanY);
			   } catch (NoTransitableException e) {}
			}
		
		if(x==27){
			this.pacman.serTransportadoAIzquierda();
		    try{	
			   int posicionPacmanX = this.pacman.obtenerPosicion().getX()+1;
			   int posicionPacmanY = this.pacman.obtenerPosicion().getY();
			   this.obtenerMiLaberinto().devolverContenido(posicionPacmanX,posicionPacmanY).hayPacman(this,posicionPacmanX,posicionPacmanY);
		    } catch (NoTransitableException e) {}
		}
	}


	public void transportarFantasma(Fantasma unFantasma, int x) {
		if(x==0){
			unFantasma.serTransportadoADerecha();
			}
		if(x==27){
			unFantasma.serTransportadoAIzquierda();
		}	
	}
	
}
