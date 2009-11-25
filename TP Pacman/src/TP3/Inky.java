package TP3;
public class Inky extends Fantasma {

	public Inky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) throws JuegoPerdido {
        //falta poner la condicion q sea transitable
		Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        Pacman unPacman = unNivel.obtenerPacman();
		Point distancia = this.distanciaPacman(unPacman.obtenerPosicion());

		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();

		int distanciaEnX = distancia.getX();
		int distanciaEnY = distancia.getY();

		double positivoEnX = Math.pow(distancia.getX(),2);
		double positivoEnY = Math.pow(distancia.getY(),2);

		positivoEnX = Math.sqrt(positivoEnX);
		positivoEnY = Math.sqrt(positivoEnY);
		
		if(positivoEnX<=positivoEnY){
			if(distanciaEnX>=0){
				
				this.mover(x+1,y);
			}else{
				this.mover(x-1,y);
			}
		}else{
			if(distanciaEnY>=0){
				this.mover(x,y+1);
			}else{
				this.mover(x,y-1);
			}
		}		
		if(unNivel.mismaPosicion(this,unPacman)){
			unPacman.morir();//este metodo lanza excepcion.
			unNivel.setearFantasmas();
        	unNivel.posicionInicialPacman();
		}
	}

	public Point distanciaPacman(Point posicionPacman) {
		Point auxiliar = new Point();
		int distanciaEnX = this.obtenerPosicion().getX() - posicionPacman.getX();
		int distanciaEnY = this.obtenerPosicion().getY() - posicionPacman.getY();
		auxiliar.setXY(distanciaEnX,distanciaEnY);
		return auxiliar;
	}

	public void huirDePacman(Nivel unNivel) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        try {
        	unLaberinto.devolverContenido(x,y-1).serTransitado(unNivel);
                this.mover(x, y-1);
                y--;
        }catch (NoTransitableException e) {
            	try {
            		unLaberinto.devolverContenido(x-1,y).serTransitado(unNivel);
            		this.mover(x-1, y);
            		x--;
            	}catch (NoTransitableException e2) {}
            }
        Pacman unPacman = unNivel.obtenerPacman();
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