
public abstract class Fantasma implements Personaje {

		private Point posicion;
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
		
		public void mover(int x, int y) {
			this.posicion.setXY(x, y); 
		}
		
		public void elegirMovimiento(){	
			if (comestible){
				this.huirDePacman();
			}else{
				this.atraparPacman();
			}
		}
		
		public Point obtenerPosicion() {
			return (this.posicion);
		}
		
		abstract public void atraparPacman();
		
		abstract public void huirDePacman();

}
