package TP3;

import interfasesYControladores.Posicionable;

public abstract class Fantasma extends Personaje implements Posicionable{

		private boolean comestible;
		protected int velocidad;
		private int contador;
		protected boolean encerrado;
		
		
		public Fantasma(int velocidadInicial) {
			this.irAJaula();
			this.comestible = false;
			this.velocidad = velocidadInicial;
			this.contador=1;
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
		
		protected void mover(int x, int y) {
			this.posicion.setXY(x, y); 
		}
		
		public void elegirMovimiento (Nivel unNivel)throws PacmanAtrapadoException,FantasmaAtrapadoException{
			if(this.contador==velocidad){
				if (this.esComestible()){ 
					this.huirDePacman(unNivel);
					if (unNivel.mismaPosicion(this, unNivel.obtenerPacman())){
						throw new FantasmaAtrapadoException();
					}
				}else{
					if (!this.esComestible()){
						this.atraparPacman(unNivel);
						if (unNivel.mismaPosicion(this, unNivel.obtenerPacman())){
							throw new PacmanAtrapadoException();
						}
					}
				}
				this.contador=1;
			}
			else this.contador++;
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
		}


		protected Point distanciaPacman(Point posicionPacman) {
			Point auxiliar = new Point(0,0);
			int distanciaEnX = this.obtenerPosicion().getX() - posicionPacman.getX();
			int distanciaEnY = this.obtenerPosicion().getY() - posicionPacman.getY();
			auxiliar.setXY(distanciaEnX,distanciaEnY);
			return auxiliar;
		}
		
		protected void moverAbajo(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	unLaberinto.devolverContenido(x,y+1).serTransitado(unNivel);
                this.mover(x,y+1);
                y++;
                }catch (NoTransitableException e1) {
                	try {
                		unLaberinto.devolverContenido(x+1,y).serTransitado(unNivel);
            		    this.mover(x+1, y);
            		    x++;
            		    }catch (NoTransitableException e2) {
                        	try {
                        		unLaberinto.devolverContenido(x-1,y).serTransitado(unNivel);
                    		    this.mover(x-1,y);
                    		    x--;
                    		    }catch (NoTransitableException e3) {
                                	try {
                                		unLaberinto.devolverContenido(x,y-1).serTransitado(unNivel);
                            		    this.mover(x, y-1);
                            		    y--;
                            		    }catch (NoTransitableException e4) {}
                            		    }
                    		    }
            		    }
                }
		
		protected void moverArriba(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	unLaberinto.devolverContenido(x,y-1).serTransitado(unNivel);
                this.mover(x,y-1);
                y--;
                }catch (NoTransitableException e1) {
                	try {
                		unLaberinto.devolverContenido(x-1,y).serTransitado(unNivel);
            		    this.mover(x-1, y);
            		    x--;
            		    }catch (NoTransitableException e2) {
                        	try {
                        		unLaberinto.devolverContenido(x+1,y).serTransitado(unNivel);
                    		    this.mover(x+1,y);
                    		    x++;
                    		    }catch (NoTransitableException e3) {
                                	try {
                                		unLaberinto.devolverContenido(x,y+1).serTransitado(unNivel);
                            		    this.mover(x, y+1);
                            		    y++;
                            		    }catch (NoTransitableException e4) {}
                            		    }
                    		    }
            		    }
			
		}
		
		protected void moverDerecha(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	unLaberinto.devolverContenido(x+1,y).serTransitado(unNivel);
                this.mover(x+1,y);
                y++;
                }catch (NoTransitableException e1) {
                	try {
                		unLaberinto.devolverContenido(x,y+1).serTransitado(unNivel);
            		    this.mover(x,y+1);
            		    y++;
            		    }catch (NoTransitableException e2) {
                        	try {
                        		unLaberinto.devolverContenido(x,y-1).serTransitado(unNivel);
                    		    this.mover(x,y-1);
                    		    y--;
                    		    }catch (NoTransitableException e3) {
                                	try {
                                		unLaberinto.devolverContenido(x-1,y).serTransitado(unNivel);
                            		    this.mover(x-1,y);
                            		    x--;
                            		    }catch (NoTransitableException e4) {}
                            		    }
                    		    }
            		    }
			
		}
		
		protected void moverIzquierda(Nivel unNivel){
			Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
			int x = this.obtenerPosicion().getX();
			int y = this.obtenerPosicion().getY();
	        try {
	        	unLaberinto.devolverContenido(x-1,y).serTransitado(unNivel);
                this.mover(x-1,y);
                x--;
                }catch (NoTransitableException e1) {
                	try {
                		unLaberinto.devolverContenido(x,y-1).serTransitado(unNivel);
            		    this.mover(x,y-1);
            		    y--;
            		    }catch (NoTransitableException e2) {
                        	try {
                        		unLaberinto.devolverContenido(x,y+1).serTransitado(unNivel);
                    		    this.mover(x,y+1);
                    		    y++;
                    		    }catch (NoTransitableException e3) {
                                	try {
                                		unLaberinto.devolverContenido(x+1,y).serTransitado(unNivel);
                            		    this.mover(x+1,y);
                            		    x++;
                            		    }catch (NoTransitableException e4) {}
                            		    }
                    		    }
            		    }
			
		}
		public int getX() {
			return this.obtenerPosicion().getX();
		}
		public int getY() {
			return this.obtenerPosicion().getY();
		}
	
}
