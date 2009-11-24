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
		
		protected void mover(int x, int y) {
			this.posicion.setXY(x, y); 
		}
		
		public void elegirMovimiento(Laberinto unLaberinto, Pacman unPacman){	
			if (comestible){//aca es un while 
				this.huirDePacman(unLaberinto);
			}else{
				this.atraparPacman(unLaberinto,unPacman);
			}
		}
		
		public Point obtenerPosicion() {
			return (this.posicion);
		}
		
		public boolean esComestible(){
			return this.comestible;
		}
		
		public boolean mismaPosicion(Fantasma unFantasma,Pacman unPacman){
			if(unFantasma.obtenerPosicion().equals(unPacman.obtenerPosicion())){
				return true;
			} else {
				return false;
				}
		}
		
		abstract public void atraparPacman(Laberinto unLaberinto, Pacman unPacman);
		
		abstract public void huirDePacman(Laberinto unLaberinto);

}
