package TP3;
public class Inky extends Fantasma {

	public Inky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Laberinto unLaberinto,Pacman unPacman) {
		// TODO: Pensar como implementar la estrategia
		/*
		 * 
		 * 
		 */
		int x = 2;
		int y = 2;
		this.mover(x, y);
		
	}

	public void huirDePacman(Laberinto unLaberinto) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Transitable transitable;
        try {
            	transitable = (Transitable)unLaberinto.devolverPosicion(x, y-1).getContenido();
                this.mover(x, y-1);
                y--;
        } catch (ClassCastException e) {
            	try {
            		transitable = (Transitable)unLaberinto.devolverPosicion(x-1,y).getContenido();
            		this.mover(x-1, y);
            		x--;
            	} catch (ClassCastException e2) {}
            }
    }
	
	
	public static void main(String[] args) {
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
		
	}
	
}