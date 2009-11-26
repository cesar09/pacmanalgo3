package TP3;
public abstract class Fantasma extends Personaje {

		private boolean comestible;
		protected int velocidad;
		
		
		public Fantasma(Point posicionInicial, int velocidadInicial) {
			this.posicion = posicionInicial;
			this.comestible = false;
			this.velocidad = velocidadInicial;
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
		
		public void elegirMovimiento(Nivel unNivel) throws PacmanSinVidaException{	
				while (this.esComestible()){ 
					this.huirDePacman(unNivel);
					new TimerVelocidad (1/this.velocidad);
				}
				while(!this.esComestible()){
					this.atraparPacman(unNivel);
					new TimerVelocidad (1/this.velocidad);
				}
			}
		
		public Point obtenerPosicion() {
			return (this.posicion);
		}
		
		public boolean esComestible(){
			return this.comestible;
		}
		
		public void volverAJaula (Point posicion){
			this.posicion = posicion;
		}
		
		abstract public void atraparPacman(Nivel unNivel) throws PacmanSinVidaException;
		
		abstract public void huirDePacman(Nivel unNivel);
		
		public void fantasmaComido(Nivel unNivel) {
			this.hacerseNoComestible();
			this.mover(1,1);//TODO:poner los valores de posicion inicial
			unNivel.obtenerMiJuego().sumarPuntajeAlJugador(200);
		}


		public Point distanciaPacman(Point posicionPacman) {
			Point auxiliar = new Point();
			int distanciaEnX = this.obtenerPosicion().getX() - posicionPacman.getX();
			int distanciaEnY = this.obtenerPosicion().getY() - posicionPacman.getY();
			auxiliar.setXY(distanciaEnX,distanciaEnY);
			return auxiliar;
		}
}
