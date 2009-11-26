package TP3;
public class Inky extends Fantasma {

	public Inky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) throws PacmanSinVidaException{
        Pacman unPacman = unNivel.obtenerPacman();
		Point distancia = this.distanciaPacman(unPacman.obtenerPosicion());
		int distanciaEnX = distancia.getX();
		int distanciaEnY = distancia.getY();
		double positivoEnX = Math.pow(distancia.getX(),2);
		double positivoEnY = Math.pow(distancia.getY(),2);
		positivoEnX = Math.sqrt(positivoEnX);
		positivoEnY = Math.sqrt(positivoEnY);

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
		        this.moverArriba(unNivel);
			}else{//sino se mueve y--
		        this.moverAbajo(unNivel);
			}
		}		
        if(unNivel.mismaPosicion(this, unPacman)){
        	unPacman.morir(); //Este metodo lanza excepcion de JuegoPerdido.
        	unNivel.renacerFantasmas();
        	unNivel.posicionInicialPacman();
        }
	}

	public void huirDePacman(Nivel unNivel) {
		Pacman unPacman = unNivel.obtenerPacman();
        this.moverAbajo(unNivel);
        if(unNivel.mismaPosicion(this, unPacman)){
        	this.fantasmaComido(unNivel);
        }
    }
	
	
	/*public static void main(String[] args) {
		Point Inicial = new Point(3,3);
		Laberinto miLaberinto = new Laberinto(1); //TODO: VERIFICAR ESTO CON EL LABERINTO.
		miLaberinto.cargarLaberintoSegunNivel(); //TODO: CORREGIR PARA CAPTURAR LA EXCEPCION.
		Inky miInky = new Inky(Inicial,5);
		
		//HUIR
		
		miInky.hacerseComestible();
		System.out.println(miInky.obtenerPosicion().getX());
		System.out.println(miInky.obtenerPosicion().getY());
		miInky.huirDePacman(miLaberinto);
		System.out.println(miInky.obtenerPosicion().getX());
		System.out.println(miInky.obtenerPosicion().getY());
		miInky.huirDePacman(miLaberinto);
		System.out.println(miInky.obtenerPosicion().getX());
		System.out.println(miInky.obtenerPosicion().getY());
		miInky.huirDePacman(miLaberinto);
		System.out.println(miInky.obtenerPosicion().getX());
		System.out.println(miInky.obtenerPosicion().getY());
		miInky.huirDePacman(miLaberinto);
		System.out.println(miInky.obtenerPosicion().getX());
		System.out.println(miInky.obtenerPosicion().getY());
		miInky.huirDePacman(miLaberinto);
		System.out.println(miInky.obtenerPosicion().getX());
		System.out.println(miInky.obtenerPosicion().getY());
		miInky.huirDePacman(miLaberinto);
		System.out.println(miInky.obtenerPosicion().getX());
		System.out.println(miInky.obtenerPosicion().getY());
		
	}*/
	
}