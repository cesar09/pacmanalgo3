package modelo;

import interfasesYControladores.Posicionable;

public abstract class Fantasma extends Personaje implements Posicionable{

		private boolean comestible;
		protected int velocidad;
		private int contador;
		protected boolean encerrado;
		private int ultimaPosicion;

		
		
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
		
		public void mover(int x, int y) {
			this.posicion.setXY(x, y); 
		}
		
		public void elegirMovimiento (Nivel unNivel){
			if(this.contador==velocidad){
				if (this.esComestible()){ 
					this.huirDePacman(unNivel);
					if (unNivel.mismaPosicion(this, unNivel.obtenerPacman())){
						this.fantasmaComido(unNivel);
					}
				}else{
					if (!this.esComestible()){
						this.atraparPacman(unNivel);	
						if (unNivel.mismaPosicion(this, unNivel.obtenerPacman())){
							unNivel.setPacmanAtrapado(true);
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

		
		public void moverFantasma (Nivel unNivel) {
			if (this.estaEncerrado()){
				this.salirDeJaula();//TODO ACA VA LA PARTE DEL CONTADOR TIMER.
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
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel);
                this.mover(x,y);
                this.nuevaUltimaPosicion(1);
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
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel);
                this.mover(x,y);
                this.nuevaUltimaPosicion(0);
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
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel);
                this.mover(x,y);
                this.nuevaUltimaPosicion(3);
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
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel);
                this.mover(x,y);
                this.nuevaUltimaPosicion(2);
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

		public void nuevaUltimaPosicion(int ultimaPosicion) {
			this.ultimaPosicion = ultimaPosicion;
		}

		public int UltimaPosicion() {
			return ultimaPosicion;
		}
	
}