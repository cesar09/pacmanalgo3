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
			//TODO: Hay que poner un tiempo para q se vuelva a poner false
		}
		
		protected void mover(int x, int y) {
			this.posicion.setXY(x, y); 
		}
		
		public void elegirMovimiento(Laberinto unLaberinto){	
			if (comestible){//aca es un while 
				this.huirDePacman(unLaberinto);
			}else{
				this.atraparPacman(unLaberinto);
			}
		}
		
		public Point obtenerPosicion() {
			return (this.posicion);
		}
		
		public boolean esComestible(){
			return this.comestible;
		}
		
		abstract public void atraparPacman(Laberinto unLaberinto);
		
		abstract public void huirDePacman(Laberinto unLaberinto);

}
