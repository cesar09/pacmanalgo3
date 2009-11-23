public class PuntoPoder extends Comestible {

	public PuntoPoder (){
		this.puntaje = 50;
	}
	
	public void hayPacman(Nivel unNivel) {
		unNivel.getMiJuego().sumarPuntajeAlJugador(this.puntaje);
		unNivel.hacerFantasmasComestibles();
	}

}