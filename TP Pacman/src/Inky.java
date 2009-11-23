
public class Inky extends Fantasma {

	public Inky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman() {
		// TODO: Pensar como implementar la estrategia
		/*
		 * Se mueve aleatoriamente
		 * Tiene una esquina "favorita" 
		 * Diferencia con Clyde: q si tiene a pacman cerca, lo sigue
		 */
		int x = 2;
		int y = 2;
		this.mover(x, y);
	}

	public void huirDePacman() {
		// TODO: Pensar como implementar la estrategia
		int x = 2;
		int y = 2;
		this.mover(x, y);
	}

}