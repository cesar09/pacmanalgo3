package TP3;
public class Inky extends Fantasma {

	public Inky(int velocidadInicial) {
		super(velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel){
		Point distancia = this.distanciaPacman(unNivel.obtenerPacman().obtenerPosicion());
		int distanciaEnX = distancia.getX();
		int distanciaEnY = distancia.getY();
		double positivoEnX = Math.sqrt(Math.pow(distancia.getX(),2));
		double positivoEnY = Math.sqrt(Math.pow(distancia.getY(),2));

		//comprueba si en x o y estan a menor casilleros
		if(positivoEnX<=positivoEnY){
            //si x esta a menor distancia y la diferencia es positiva entonces se mueve x++
			if(distanciaEnX>=0){
				this.moverDerecha(unNivel);
			}else{//si x esta a menor distancia y la diferencia es negativo entonces se mueve x--
		      this.moverIzquierda(unNivel);
		      }
			}else{//si estaba a menor distancia en y lo anterior no corre y entra en este else
			//si la distancia es positivia se mueve y++
			if(distanciaEnY>=0){
		        this.moverAbajo(unNivel);
			}else{//sino se mueve y--
		        this.moverArriba(unNivel);
			}
		}		
	}

	public void huirDePacman(Nivel unNivel) {
        this.moverAbajo(unNivel);
    }
	
	public void irAJaula() {
		Point posicion = new Point (14,14);
		this.posicion = posicion;
		this.encerrado = true;
	}
	
	public void salirDeJaula (){
		Point posicion = new Point (14,11);
		this.posicion = posicion;
		this.encerrado = false;
	}
	
}