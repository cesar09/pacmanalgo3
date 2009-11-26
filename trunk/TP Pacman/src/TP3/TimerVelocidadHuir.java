package TP3;
import java.util.Timer;
import java.util.TimerTask;

public class TimerVelocidadHuir {
			
	Timer timer;
	Fantasma unFantasma;
	Nivel unNivel;
	
	public TimerVelocidadHuir ( int segundos, Fantasma unFantasma, Nivel unNivel ) {
		timer = new Timer ( ) ;
		this.unFantasma = unFantasma;
		this.unNivel = unNivel; 
		timer.schedule ( new RemindTask ( ) , segundos*1000 ) ;
	}

	
	private void fantasmaHuiDePacman() {
		try{
			this.unFantasma.atraparPacman(unNivel);
		}catch(PacmanSinVidaException e){}
	}
	

	class RemindTask extends TimerTask {
		public void run ( ) {
				fantasmaHuiDePacman();
				timer.cancel ( ) ; //Cancela el hilo del timer
		}
	}
}

	