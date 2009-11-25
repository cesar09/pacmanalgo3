package TP3;
public class Blinky extends Fantasma {

	public Blinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) throws JuegoPerdido {
        Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        Pacman unPacman = unNivel.obtenerPacman();
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        try {
           unLaberinto.devolverContenido(x-1,y).serTransitado(unNivel);
           this.mover(x-1, y);
           x--;
        }catch (NoTransitableException e) {
            try {
              unLaberinto.devolverContenido(x,y+1).serTransitado(unNivel);
              this.mover(x,y+1);
              y++;
            }catch (NoTransitableException e2) {}
            }
        if(unNivel.mismaPosicion(this, unPacman)){
        	unPacman.morir(); //Este metodo lanza excepcion de JuegoPerdido.
        	unNivel.setearFantasmas();
        	unNivel.posicionInicialPacman();
        }
	}
	
	public void huirDePacman(Nivel unNivel) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        try {
        		unLaberinto.devolverContenido(x,y+1).serTransitado(unNivel);
                this.mover(x, y+1);
                y++;
        }catch (NoTransitableException e) {
            	try {
            		unLaberinto.devolverContenido(x+1,y).serTransitado(unNivel);
            		this.mover(x+1, y);
            		x++;
            	}catch (NoTransitableException e2) {}
            }
        Pacman unPacman = unNivel.obtenerPacman();
        if(unNivel.mismaPosicion(this, unPacman)){
        	this.fantasmaComido(unNivel);
        }
    }
/*		
	public static void main(String[] args) {
		Point Inicial = new Point(3,3);
		Laberinto miLaberinto = new Laberinto(1);//TODO: VERIFICAR ESTO CON EL LABERINTO.
		miLaberinto.cargarLaberintoSegunNivel();//TODO: CORREGIR PARA CAPTURAR LA EXCDEPCION.
		Blinky miBlinky = new Blinky(Inicial,5);
		Pacman unPacman = new Pacman(new Point (1,1));
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.hacerseComestible();
		miBlinky.huirDePacman(miLaberinto);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());
		miBlinky.atraparPacman(miLaberinto,unPacman);
		System.out.println(miBlinky.obtenerPosicion().getX());
		System.out.println(miBlinky.obtenerPosicion().getY());

	}*/
}