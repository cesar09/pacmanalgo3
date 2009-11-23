
public class Inky extends Fantasma {

	public Inky(Point posicionInicial, int velocidadInicial) {
		super(posicionInicial, velocidadInicial);
	}

	public void atraparPacman(Laberinto unLaberinto) {
		// TODO: Pensar como implementar la estrategia
		/*
		 * 
		 * 
		 */
		int x = 2;
		int y = 2;
		this.mover(x, y);
		
	}

	@Override
	public void huirDePacman(Laberinto unLaberinto) {
		// TODO: Pensar como implementar la estrategia
		int x = 2;
		int y = 2;
		this.mover(x, y);
	}
}