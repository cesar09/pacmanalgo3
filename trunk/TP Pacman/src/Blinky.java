
public class Blinky extends Fantasma {

	public Blinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Laberinto unLaberinto) {
		int x = this.obtenerPosicion().getX();
		int y = this.obtenerPosicion().getY();
//la idea es q le vaya pidiendo en las 4 direcciones al laberinto si es transitable para moverse
//falta checkear que pasa si el pacman esta en la misma posicion		
		if(unLaberinto.posicionValidad(x+1, y))
			this.mover(x+1,y);
		else
		if(unLaberinto.posicionValidad(x, y+1))
			this.mover(x,y+1);
		else
		if(unLaberinto.posicionValidad(x-1, y))
			this.mover(x-1,y);
		else
		if(unLaberinto.posicionValidad(x, y-1))
			this.mover(x,y-1);
		
	}

	@Override
	public void huirDePacman(Laberinto unLaberinto) {
		// TODO: Pensar como implementar la estrategia
		int x = 2;
		int y = 2;
		this.mover(x, y);
	}
}
