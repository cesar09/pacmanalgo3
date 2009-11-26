package TP3;
import java.util.Timer;
import java.util.TimerTask;

import TP3.Nivel;

	public class TimerSalirDeJaula {
		
		Timer timer;
		
		public TimerSalirDeJaula ( int segundos ) {
		timer = new Timer ( ) ;
		timer.schedule ( new RemindTask ( ) , segundos*1000 ) ;
		}

		class RemindTask extends TimerTask {
			public void run ( ) {
				timer.cancel ( ) ; //Cancela el hilo del timer
			}
		}
}