package TP3;

import java.util.Timer;
import java.util.TimerTask;

public class TimerVelocidadAtrapar {
	
	Timer timer;
	Fantasma unFantasma;
	Nivel unNivel;
	
	public TimerVelocidadAtrapar ( int segundos, Fantasma unFantasma, Nivel unNivel ) {
		timer = new Timer ( ) ;
		this.unFantasma = unFantasma;
		this.unNivel = unNivel; 
		timer.schedule ( new RemindTask ( ) , segundos*1000 ) ;
	}

	
	private void fantasmaAtrapaPacman() {
		try{
			this.unFantasma.atraparPacman(unNivel);
		}catch(PacmanSinVidaException e){}
	}
	

	class RemindTask extends TimerTask {
		public void run ( ) {
				fantasmaAtrapaPacman();
				timer.cancel ( ) ; //Cancela el hilo del timer
		}

	}
	
}
