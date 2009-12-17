package modelo;
public class Clyde extends Fantasma {

	public Clyde(int velocidadInicial,int tiempoEnJaula) {
		super(velocidadInicial, tiempoEnJaula);
		this.nuevaUltimaPosicion(2);
	}

	public void atraparPacman(Nivel unNivel) {
		 switch(this.UltimaPosicion()) {
		 case 0:
			 this.moverDerecha(unNivel);
		     break;
		 case 1:
			 this.moverAbajo(unNivel);
			 break;
		 case 2:
			 this.moverIzquierda(unNivel);
			 break;
		 case 3:
			 this.moverArriba(unNivel);
			 break;
		 }
	}
	
	public void huirDePacman(Nivel unNivel) {
        this.moverDerecha(unNivel);
    }
	
	public void irAJaula() {
		Point posicion = new Point (14,13);
		this.posicion = posicion;
		this.encerrado = true;
		this.hacerseNoComestible();
	}
	
	public void salirDeJaula (){
		Point posicion = new Point (13,11);
		this.posicion = posicion;
		this.encerrado = false;
	}
	
	public void moverAbajo(Nivel unNivel){
		Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();
        try {
        	y++;
        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
        		this.mover(x,y);
        	}
            this.nuevaUltimaPosicion(1);
            }catch (NoTransitableException e1) {
            	this.moverIzquierda(unNivel);
            }
    }
	
	public void moverArriba(Nivel unNivel){
		Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();
        try {
        	y--;
        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
        		this.mover(x,y);
        	}
            this.nuevaUltimaPosicion(3);
            }catch (NoTransitableException e1) {
            	this.moverDerecha(unNivel);
        		    }
		
	}
	
	public void moverDerecha(Nivel unNivel){
		Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();
        try {
        	x++;
        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
        		this.mover(x,y);
        	}
            this.nuevaUltimaPosicion(0);
            }catch (NoTransitableException e1) {
            	this.moverAbajo(unNivel);
        		    }
	}
	
	public void moverIzquierda(Nivel unNivel){
		Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();
        try {
        	x--;
        	unLaberinto.devolverContenido(x,y).serTransitado(unNivel,this,x, y);
        	if (!(unLaberinto.devolverContenido(x,y) instanceof Transportador)){
        		this.mover(x,y);
        	}
            this.nuevaUltimaPosicion(2);
            }catch (NoTransitableException e1) {
            	this.moverArriba(unNivel);
        	 }
	}

	
}