package modelo;

import Vista.Posicionable;

public abstract class Fantasma extends Personaje implements Posicionable{

		private boolean comestible;
		protected int velocidad;
		private int contadorVelocidad;
		private int contadorJaula;
		private int tiempoEnJaula;
		protected boolean encerrado;
		private int ultimaDireccion;
		private boolean yaMovido;

		
		
		public Fantasma(int velocidadInicial, int tiempoEnJaula) {
			this.irAJaula();
			this.comestible = false;
			this.velocidad = velocidadInicial;
			this.contadorVelocidad=1;
			this.yaMovido = false;
			this.tiempoEnJaula = tiempoEnJaula;
		}

		
		public boolean estaEncerrado(){
			return (this.encerrado);
		}
		
		public void hacerseComestible(){
			this.comestible = true;
		}
		
		public void hacerseNoComestible(){
			this.comestible = false;
		}
		
		public void mover(int x, int y) {
			this.posicion.setXY(x, y); 
		}
		
		public void elegirMovimiento (Nivel unNivel){
			this.yaMovido = false;
			if(this.contadorVelocidad==velocidad){
				if (this.esComestible())
					this.huirDePacman(unNivel);
				else this.atraparPacman(unNivel);			
				unNivel.comerFantasmaOMorirPacman(this);
				this.contadorVelocidad=1;
			}
			else this.contadorVelocidad++;
		}
		
		public Point obtenerPosicion() {
			return (this.posicion);
		}
		
		public boolean esComestible(){
			return this.comestible;
		}
		
		abstract public void salirDeJaula();
		
		abstract public void irAJaula ();
		
		abstract public void atraparPacman(Nivel unNivel);
		
		abstract public void huirDePacman(Nivel unNivel);
		
		public void fantasmaComido(Nivel unNivel) {
			this.hacerseNoComestible();
			unNivel.obtenerMiJuego().sumarPuntajeAlJugador(200);
			this.irAJaula();
			this.contadorJaula = 0;
		}

		
		public void moverFantasma (Nivel unNivel) {
			if (this.estaEncerrado()){
				if (this.contadorJaula == this.tiempoEnJaula){
					this.salirDeJaula();
				}else{
					this.contadorJaula++;
				}
			}else{
					this.elegirMovimiento(unNivel);
				}
		}
		

		public Point distanciaPacman(Point posicionPacman) {
			Point auxiliar = new Point(0,0);
			int distanciaEnX = this.obtenerPosicion().getX() - posicionPacman.getX();
			int distanciaEnY = this.obtenerPosicion().getY() - posicionPacman.getY();
			auxiliar.setXY(distanciaEnX,distanciaEnY);
			return auxiliar;
		}
		
		public void moverAbajo(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	y++;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        	}
                this.nuevaDireccion(1);
                }catch (NoTransitableException e1) {
                	this.moverDerecha(unNivel);
                }
        }
		
		public void moverArriba(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	y--;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        	}
                this.nuevaDireccion(0);
                }catch (NoTransitableException e1) {
                	this.moverIzquierda(unNivel);
            		    }
			
		}
		
		public void moverDerecha(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	x++;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        	}
                this.nuevaDireccion(3);
                }catch (NoTransitableException e1) {
                	this.moverArriba(unNivel);
            		    }
		}
		
		public void moverIzquierda(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	x--;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        	}
                this.nuevaDireccion(2);
                }catch (NoTransitableException e1) {
                	this.moverAbajo(unNivel);
            	 }
		}
		
		public int getX() {
			return this.obtenerPosicion().getX();
		}
		public int getY() {
			return this.obtenerPosicion().getY();
		}

		public void nuevaDireccion(int nuevaDireccion){
			this.ultimaDireccion = nuevaDireccion;
		}

		public int ultimaDireccion() {
			return ultimaDireccion;
		}
		
		protected void serTransportadoADerecha(int y) {
			this.mover(26,y);
		}
		
		protected void serTransportadoAIzquierda(int y) {
			this.mover(1,y);
		}

		public void setYaMovido(boolean yaMovido) {
			this.yaMovido = yaMovido;
		}

		public boolean yaMovio() {
			return yaMovido;
		}
		
		
		public void moverAbajoDos(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	y++;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        	}
	            this.nuevaDireccion(1);
	            }catch (NoTransitableException e1) {
	            	this.moverIzquierdaDos(unNivel);
	            }
	    }
		
		public void moverArribaDos(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	y--;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        	}
	            this.nuevaDireccion(3);
	            }catch (NoTransitableException e1) {
	            	this.moverDerechaDos(unNivel);
	        		    }
			
		}
		
		public void moverDerechaDos(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	x++;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        	}
	            this.nuevaDireccion(0);
	            }catch (NoTransitableException e1) {
	            	this.moverAbajoDos(unNivel);
	        		    }
		}
		
		public void moverIzquierdaDos(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	x--;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        	}
	            this.nuevaDireccion(2);
	            }catch (NoTransitableException e1) {
	            	this.moverArribaDos(unNivel);
	        	 }
		}
	
}