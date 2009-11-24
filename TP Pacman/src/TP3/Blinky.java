package TP3;
public class Blinky extends Fantasma {

	public Blinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Nivel unNivel) {
        Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        Pacman unPacman = unNivel.getPacman();
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Transitable transitable;
        try {
           transitable = (Transitable)unLaberinto.devolverContenido(x-1,y);
           this.mover(x-1, y);
           x--;}
    
        catch (ClassCastException e) {
            try {
              transitable = (Transitable)unLaberinto.devolverContenido(x,y+1);
              this.mover(x,y+1);
              y++;
            	} catch (ClassCastException e2) {}
            }
        if(this.mismaPosicion(this, unPacman)){
        	unPacman.morir();
        }
	}
	
	public void huirDePacman(Nivel unNivel) {
        int x = this.obtenerPosicion().getX();
        int y = this.obtenerPosicion().getY();
        Laberinto unLaberinto = unNivel.obtenerMiLaberinto();
        Transitable transitable;
        try {
            	transitable = (Transitable)unLaberinto.devolverContenido(x, y+1);
                this.mover(x, y+1);
                y++;
        } catch (ClassCastException e) {
            	try {
            		transitable = (Transitable)unLaberinto.devolverContenido(x+1,y);
            		this.mover(x+1, y);
            		x++;
            	} catch (ClassCastException e2) {}
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