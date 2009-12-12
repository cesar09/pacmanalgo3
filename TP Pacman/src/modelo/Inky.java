package modelo;
public class Inky extends Fantasma {

	public Inky(int velocidadInicial,int tiempoEnJaula) {
		super(velocidadInicial, tiempoEnJaula);
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
		
		/*Point PosicionPacman = unNivel.obtenerPacman().obtenerPosicion();
		int pacmanX = PosicionPacman.getX();
		int pacmanY = PosicionPacman.getY();
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();
		Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
		if ((pacmanX < this.obtenerPosicion().getX()) && (!this.yaMovio())){
			try {
	        	x--;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        		this.setYaMovido(true);
	        	}
                }catch (NoTransitableException e1) {}
		}
		
		if ((pacmanX > this.obtenerPosicion().getX()) && (!this.yaMovio())){
			try {
	        	x++;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        		this.setYaMovido(true);
	        	}
                }catch (NoTransitableException e1) {}
		}
		
		if ((pacmanY < this.obtenerPosicion().getY()) && (!this.yaMovio())){
			try {
	        	y++;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        		this.setYaMovido(true);
	        	}
                }catch (NoTransitableException e1) {}
		}
		
		if ((pacmanY > this.obtenerPosicion().getY()) && (!this.yaMovio())){
			try {
	        	y--;
	        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
	        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
	        		this.mover(x,y);
	        		this.setYaMovido(true);
	        	}
                }catch (NoTransitableException e1) {}
		}*/
	}

	public void huirDePacman(Nivel unNivel) {
        this.moverAbajo(unNivel);
    }
	
	public void irAJaula() {
		Point posicion = new Point (14,14);
		this.posicion = posicion;
		this.encerrado = true;
		this.hacerseNoComestible();
	}
	
	public void salirDeJaula (){
		Point posicion = new Point (14,11);
		this.posicion = posicion;
		this.encerrado = false;
	}
	
}