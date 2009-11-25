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
		
		public void elegirMovimiento(Nivel unNivel){	
			if (comestible){//aca es un while 
				this.huirDePacman(unNivel);
			}else{
				this.atraparPacman(unNivel);
			}
		}
		
		public Point obtenerPosicion() {
			return (this.posicion);
		}
		
		public boolean esComestible(){
			return this.comestible;
		}
		
		abstract public void atraparPacman(Nivel unNivel);
		
		abstract public void huirDePacman(Nivel unNivel);
		
		public void fantasmaComido(Nivel unNivel) {
			this.hacerseNoComestible();
			this.mover(1,1);//TODO:poner los valores de posicion inicial
			Juego unJuego=unNivel.obtenerMiJuego();
			unJuego.sumarPuntajeAlJugador(200);
		}

}
