
public class Nivel {
	
	private Juego juego;
	private Laberinto miLaberinto;
	private Pacman pacman;
	
	// TODO Hay q usarlo como vector quizás: private Vector<Fantasma> fantasmas; 
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
		this.miLaberinto = new Laberinto ();//cuando se tenga xml se pasa el nivel
		//TODO falta inicializar la parte del laberinto(pensar si está bien el tipo array)
	}
		
	public boolean esTransitable(int x, int y){
		/*if ((laberinto[x][y])instanceof Contenido){
				//Transitable auxiliar = (Transitable)laberinto[x][y].getContenido();
				//auxiliar.serComido(this);
				laberinto[x][y].getContenido().getTransitable().hayPacman(this);
				return true;	
		}*/
		 try {//falta validar devolver posicion en la clase laberinto
			 this.getMiLaberinto().devolverPosicion(y, x).getContenido().getTransitable().hayPacman(this);
			 return true;
		 } catch (NoTransitableException e) {
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
		//Hace que los fantasmas ahora puedan ser comidos por pacman
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
