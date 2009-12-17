package modelo;
public class Inky extends Fantasma {

	public Inky(int velocidadInicial,int tiempoEnJaula) {
		super(velocidadInicial, tiempoEnJaula);
	}

	//Contiene la estrategia que usará Inky para atrapar al pacman.
	public void atraparPacman(Nivel unNivel){
	    Point distancia = this.distanciaPacman(unNivel.obtenerPacman().obtenerPosicion());
	    int distanciaEnX = distancia.getX();
		int distanciaEnY = distancia.getY();
		int positivoEnX = (int)Math.sqrt(Math.pow(distancia.getX(),2));
		int positivoEnY = (int)Math.sqrt(Math.pow(distancia.getY(),2));

		//comprueba si en x o y estan a menor casilleros
		if(positivoEnX>=positivoEnY){
            //si x esta a menor distancia y la diferencia es negativa entonces se mueve x++
			if(distanciaEnX<=0){
				this.moverDerecha(unNivel);
			}else{//si x esta a menor distancia y la diferencia es positivo entonces se mueve x--
			    this.moverIzquierda(unNivel);
		      }
			}else{//si estaba a menor distancia en y lo anterior no corre y entra en este else
			//si la distancia es negativa se mueve y++
			if(distanciaEnY<=0){
		        this.moverAbajo(unNivel);
			}else{//sino se mueve y--
		        this.moverArriba(unNivel);
		        }
			}
		}	

	//Contiene la estrategia que usará Inky para huir al pacman.
	public void huirDePacman(Nivel unNivel) {
        this.moverAbajo(unNivel);
    }
	
	//Tiene una posición predeterminada para estar en la jaula
	public void irAJaula() {
		Point posicion = new Point (14,14);
		this.posicion = posicion;
		this.encerrado = true;
		this.hacerseNoComestible();
	}
	
	//Tiene una posición predeterminada para salir de la jaula
	public void salirDeJaula (){
		Point posicion = new Point (14,11);
		this.posicion = posicion;
		this.encerrado = false;
	}
	
}