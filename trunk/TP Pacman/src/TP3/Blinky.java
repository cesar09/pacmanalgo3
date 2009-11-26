package TP3;
public class Blinky extends Fantasma {

	public Blinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) throws PacmanSinVidaException{
        Pacman unPacman = unNivel.obtenerPacman();
        this.moverIzquierda(unNivel);
        if(unNivel.mismaPosicion(this, unPacman)){
        	unPacman.morir();
        	unNivel.renacerFantasmas();
        	unNivel.posicionInicialPacman();
        }
	}
	
	public void huirDePacman(Nivel unNivel) {
		Pacman unPacman = unNivel.obtenerPacman();
        this.moverDerecha(unNivel);
        if(unNivel.mismaPosicion(this,unPacman)){
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