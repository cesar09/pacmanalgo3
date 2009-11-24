package TP3;
public class Nivel {
	
	private Juego juego;
	private Laberinto miLaberinto;
	private Pacman pacman;
	
	// TODO Podria usarse como array: private Fantasma[] fantasmas; 
	private Blinky blinky;
	private Pinky pinky;
	private Inky inky;
	private Clyde clyde;

	public Nivel(Juego unJuego){
		this.juego = unJuego;
		int vel = 1;
		Point pos = new Point (1,1);
		this.blinky = new Blinky (pos,vel);
		this.pinky = new Pinky (pos,vel);
		this.inky = new Inky (pos,vel);
		this.clyde = new Clyde (pos,vel); 
		this.pacman = new Pacman (pos);
		this.miLaberinto = new Laberinto ();//TODO: cuando se tenga xml se pasa el nivel
	}
		
	public boolean esTransitable(int x, int y){
		try {
			 Transitable transitable = (Transitable)this.getMiLaberinto().devolverPosicion(y, x).getContenido();
			 transitable.hayPacman(this);
			 return true;
		 } catch (ClassCastException e) {
				 return false;
			 }
	}
	
	public Juego getMiJuego(){
		return (this.juego);
	}
	
	public void mueveFantasma(){
		this.blinky.elegirMovimiento(this.getMiLaberinto());
		this.pinky.elegirMovimiento(this.getMiLaberinto());
		this.inky.elegirMovimiento(this.getMiLaberinto());
		this.clyde.elegirMovimiento(this.getMiLaberinto());
	}
	
	public void muevePacman(){
			//TODO: Llama al "mover" de esta misma clase q corresponda a 
		    //la direccion deseada.
		
		//Este es un ejemplo de si quiere ir para arriba.
		int x = this.pacman.obtenerPosicion().getX();
		int y = this.pacman.obtenerPosicion().getY()+1;
		if (esTransitable(x,y)){
			this.pacman.irArriba();
		}
	}
	
	public void hacerFantasmasComestibles(){
		this.blinky.hacerseComestible();
		this.pinky.hacerseComestible();
		this.inky.hacerseComestible();
		this.clyde.hacerseComestible();
	}

	public void setMiLaberinto(Laberinto miLaberinto) {
		this.miLaberinto = miLaberinto;
	}

	public Laberinto getMiLaberinto() {
		return miLaberinto;
	}
	
}
