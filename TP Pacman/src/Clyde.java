
public class Clyde extends Fantasma {

	public Clyde(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman() {
		// TODO: Pensar como implementar la estrategia
		/*
		 * Se mueve aleatoriamente siempre
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