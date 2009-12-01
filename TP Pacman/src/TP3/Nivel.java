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
		this.ultimoSentidoPacman=1;//inicializo para q vaya a la izquierda como ultimo movim.
		new TimerFruta(15,this); 
		new TimerVacio(22,this);
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
		int sentido=0;
		//FALTARÍA IMPLEMENTAR EL DETECTOR DE INTERRUPCIONES 
	    //SI SENTIDO ES 0, EJECUTA EL ULTIMO MOVIMIENTO
		//SI EL MOVIMIENTO INDICADO NO ES TRANSITABLE
		try{
			if(!(this.moverSegunSentido(sentido))) this.moverSegunSentido(ultimoSentidoPacman);
		}catch(PacmanAtrapadoException e){
			throw new PacmanAtrapadoException();
		}
	}
	
	
	public boolean moverSegunSentido(int sentido) throws PacmanAtrapadoException{
		int x;
		int y;
		switch (sentido){
		
		case 1:
			//Si se desea ir para la izquierda.
			x = this.pacman.obtenerPosicion().getX()-1;
			y = this.pacman.obtenerPosicion().getY();
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irIzquierda();
				 if (!this.juego.seGanoJuego()){
					 ultimoSentidoPacman=1;
					 try{
						 this.comeOMuere(this.blinky);
						 this.comeOMuere(this.pinky);
						 this.comeOMuere(this.clyde);
						 this.comeOMuere(this.inky);
					 }catch (PacmanAtrapadoException e2){
						 throw new PacmanAtrapadoException();
					 }
				 return true;
				 }
			} catch (NoTransitableException e) {}
			 break;
		case 2:
			//Si se desea ir para la derecha.
			x = this.pacman.obtenerPosicion().getX()+1;
			y = this.pacman.obtenerPosicion().getY();
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irDerecha();
				 if (!this.juego.seGanoJuego()){
					 ultimoSentidoPacman=1;
					 try{
						 this.comeOMuere(this.blinky);
						 this.comeOMuere(this.pinky);
						 this.comeOMuere(this.clyde);
						 this.comeOMuere(this.inky);
					 }catch (PacmanAtrapadoException e2){
						 throw new PacmanAtrapadoException();
					 }
				 return true;
				 }
			} catch (NoTransitableException e) {}
			 break;
		
		case 3:
			//Si se desea ir para abajo.
			x = this.pacman.obtenerPosicion().getX();
			y = this.pacman.obtenerPosicion().getY()+1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irAbajo();
				 if (!this.juego.seGanoJuego()){
					 ultimoSentidoPacman=1;
					 try{
						 this.comeOMuere(this.blinky);
						 this.comeOMuere(this.pinky);
						 this.comeOMuere(this.clyde);
						 this.comeOMuere(this.inky);
					 }catch (PacmanAtrapadoException e2){
						 throw new PacmanAtrapadoException();
					 }
				 return true;
				 }
			} catch (NoTransitableException e) {}
			 break;
		
		case 4:
			x = this.pacman.obtenerPosicion().getX();
			y = this.pacman.obtenerPosicion().getY()-1;
			try {
				 this.obtenerMiLaberinto().devolverContenido(x,y).hayPacman(this,x,y);
				 this.pacman.irArriba();
				 if (!this.juego.seGanoJuego()){
					 ultimoSentidoPacman=1;
					 try{
						 this.comeOMuere(this.blinky);
						 this.comeOMuere(this.pinky);
						 this.comeOMuere(this.clyde);
						 this.comeOMuere(this.inky);
					 }catch (PacmanAtrapadoException e2){
						 throw new PacmanAtrapadoException();
					 }
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
