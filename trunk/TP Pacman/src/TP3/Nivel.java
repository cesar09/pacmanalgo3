package TP3;
public class Nivel {
	
	private Juego juego;
	private Laberinto miLaberinto;
	private Pacman pacman;
	

	private Blinky blinky;
	private Pinky pinky;
	private Inky inky;
	private Clyde clyde;
	private int ultimoSentido;
	

	public Nivel(Juego unJuego){
		this.juego = unJuego;
		this.miLaberinto = new Laberinto (1);
		this.setearPacmanFantasmas();
		this.ultimoSentido=1; //inicializo para q valla a la izquierda como ultimo movim.
	}
	//TODO: debería ser este metodo protected
	public void setearPacmanFantasmas(){
		int vel = 1;//habria q setear la velocidad dentro de cada contructor
		Point pos = new Point (1,1);
		this.blinky = new Blinky (pos,vel);
		this.pinky = new Pinky (pos,vel);
		this.inky = new Inky (pos,vel);
		this.clyde = new Clyde (pos,vel); 
		this.pacman = new Pacman (pos);
	}
		
	public boolean esTransitable(int x, int y){
		try {
			 Transitable transitable = (Transitable)this.obtenerMiLaberinto().devolverContenido(y, x);
			 transitable.hayPacman(this);
			 return true;
		 } catch (ClassCastException e) {
				 return false;
			 }
	}
	
	public Juego obtenerMiJuego(){
		return (this.juego);
	}
	
	public void mueveFantasma(){
		this.blinky.elegirMovimiento(this);
		this.pinky.elegirMovimiento(this);
		this.inky.elegirMovimiento(this);
		this.clyde.elegirMovimiento(this);
	}
	
	public void muevePacman(){	
		int sentido=0;
		//TODO: FALTARÍA IMPLEMENTAR EL DETECTOR DE INTERRUPCIONES 
	    //SI SENTIDO ES 0, EGECUTA EL ULTIMO MOVIMIENTO
		//SI EL MOVIMIENTO INDICADO NO ES TRANSITABLE
		if(!(this.moverSegunSentido(sentido))) this.moverSegunSentido(ultimoSentido);
	}
	
	protected boolean moverSegunSentido(int sentido){
		int x;
		int y;
		switch (sentido){
		
		case 1:
			//Este es un ejemplo de si quiere ir para la izquierda.
			x = this.pacman.obtenerPosicion().getX()-1;
			y = this.pacman.obtenerPosicion().getY();
			if (esTransitable(x,y)){
				this.pacman.irIzquierda();
				ultimoSentido=1;
				return true;
			}
		break;
		case 2:
			//Este es un ejemplo de si quiere ir para la derecha.
			x = this.pacman.obtenerPosicion().getX()+1;
			y = this.pacman.obtenerPosicion().getY();
			if (esTransitable(x,y)){
				this.pacman.irDerecha();
				ultimoSentido=2;
				return true;
			}
		break;
		
		case 3:
			//Este es un ejemplo de si quiere ir para abajo.
			x = this.pacman.obtenerPosicion().getX();
			y = this.pacman.obtenerPosicion().getY()-1;
			if (esTransitable(x,y)){
				this.pacman.irAbajo();
				ultimoSentido=3;
				return true;
			}
		break;
		
		case 4:
			x = this.pacman.obtenerPosicion().getX();
			y = this.pacman.obtenerPosicion().getY()+1;
			if (esTransitable(x,y)){
				this.pacman.irArriba();
				ultimoSentido=4;
				return true;
			}
		break;
		}
		return false;
	}
	
	public void hacerFantasmasComestibles(){
		this.blinky.hacerseComestible();
		this.pinky.hacerseComestible();
		this.inky.hacerseComestible();
		this.clyde.hacerseComestible();
	}

	public Laberinto obtenerMiLaberinto() {
		return miLaberinto;
	}
	
	public Pacman getPacman(){
		return this.pacman;
	}
	
	public Juego getJuego(){
		return this.juego;
	}
    
	//esto qdo rustico, alguien que lo mejore en lo posible 
	public void pacmanAtrapado() {
         if(this.getPacman().getVida()==0){
        	 this.getJuego().juegoPerdido();
         } else {
        	 this.setearPacmanFantasmas();
        	 this.mueveFantasma();
         }
		
	}
	
}
