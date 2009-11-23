
public class Blinky extends Fantasma {

	public Blinky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman() {
		// TODO: Pensar como implementar la estrategia
		
		/* LO SIGUE
		 * si el pacman esta abajo mover hacia abajo
		 * si el pacman esta arriba mover hacia arriba
		 * si el pacman esta derecha mover hacia derecha
		 * si el pacman esta izquierda mover hacia izquierda
		*/
		int x = 2;
		int y = 2;
		this.mover(x, y);
	}

	public void huirDePacman() {
		// TODO: Pensar como implementar la estrategia
		// Que cada uno escape a una esquina distinta quizás
		int x = 2;
		int y = 2;
		this.mover(x, y);
	}

}
