package TP3;
public class Nivel {
	
	private Juego juego;
	private Laberinto miLaberinto;
	private Pacman pacman;
	

	private Blinky blinky;
	private Pinky pinky;
	private Inky inky;
	private Clyde clyde;
	private int ultimoSentidoPacman;
	

	public Nivel(Juego unJuego){
		this.juego = unJuego;
		this.miLaberinto = new Laberinto (this.juego.obtenerNivelActual());
		this.crearPersonajes();
		this.ultimoSentidoPacman=1; //inicializo para q vaya a la izquierda como ultimo movim.
	}
	//TODO: debería ser este metodo protected
	public void crearPersonajes(){
		int vel = 1;//habria q setear la velocidad dentro de cada contructor
		Point pos = new Point (1,1);//TODO: inicializar las posiciones correctamente
		this.blinky = new Blinky (pos,vel);
		this.pinky = new Pinky (pos,vel);
		this.inky = new Inky (pos,vel);
		this.clyde = new Clyde (pos,vel); 	
		this.pacman = new Pacman (pos);
	}
	
	public void renacerPersonajes() {
		Point posicion= new Point (1,1);//TODO: inicializar las posiciones correctamente
		this.pacman.renacer(posicion);
		this.blinky.volverAJaula(posicion);
		this.pinky.volverAJaula(posicion);
		this.inky.volverAJaula(posicion);
		this.clyde.volverAJaula(posicion); 	
		this.pacman.renacer(posicion);
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
	
	public void muevePacman(){// throws JuegoPerdido{	
		int sentido=0;
		//TODO: FALTARÍA IMPLEMENTAR EL DETECTOR DE INTERRUPCIONES 
	    //SI SENTIDO ES 0, EGECUTA EL ULTIMO MOVIMIENTO
		//SI EL MOVIMIENTO INDICADO NO ES TRANSITABLE
		if(!(this.moverSegunSentido(sentido))) this.moverSegunSentido(ultimoSentidoPacman);
/*		if(this.mismaPosicion(blinky, pacman)) this.comerOMorir(blinky,pacman);
		else if(this.mismaPosicion(inky, pacman)) this.comerOMorir(inky,pacman);
		else if(this.mismaPosicion(pinky, pacman)) this.comerOMorir(pinky,pacman);
		else if(this.mismaPosicion(clyde, pacman)) this.comerOMorir(clyde,pacman);
	}
	
	private void comerOMorir(Fantasma unFantasma, Pacman pacman) throws JuegoPerdido {
		// TODO Auto-generated method stub
		if(!unFantasma.esComestible()) pacman.morir();
		else unFantasma.fantasmaComido(this);*/
	}
	protected boolean moverSegunSentido(int sentido){
		int x;
		int y;
		switch (sentido){
		
		case 1:
			//Este es un ejemplo de si quiere ir para la izquierda.
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
			//Este es un ejemplo de si quiere ir para la derecha.
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
			//Este es un ejemplo de si quiere ir para abajo.
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
	
	public Juego getJuego(){
		return this.juego;
	}
	
	public boolean mismaPosicion(Fantasma unFantasma,Pacman unPacman){
		if(unFantasma.obtenerPosicion().equals(unPacman.obtenerPosicion())){
			return true;
		} else {
			return false;
			}
	}
	/*public void nuevoNivel(int nivelActual) throws ArchivoFueraDeFormatoException {
		// TODO Auto-generated method stub
		this.miLaberinto = new Laberinto (nivelActual);
		this.renacerPersonajes();
		this.ultimoSentidoPacman=1; //inicializo para q vaya a la izquierda como ultimo movim.
	}*/
    

	public void pacmanAtrapado() {
         if(this.obtenerPacman().obtenerVidasDisponibles()==0){
        	 this.juego.juegoPerdido();
         } else {
        	 this.renacerPersonajes();
        	 this.mueveFantasma();
         }
		
	}
	
}
