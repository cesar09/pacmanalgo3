package TP3;
import java.util.Timer;
import java.util.TimerTask;

import TP3.Nivel;

	public class TimerSalirDeJaula {
		
		Timer timer;
		Nivel miNivel;
		
		public TimerSalirDeJaula ( int segundos, Nivel unNivel ) {
		timer = new Timer ( ) ;
		this.miNivel = unNivel;
		timer.schedule ( new RemindTask ( ) , segundos*1000 ) ;
		}

		/*public void salirDeJaula(){
			
		}*/

		class RemindTask extends TimerTask {
			public void run ( ) {
			//	salirDeJaula();
				timer.cancel ( ) ; //Cancela el hilo del timer
			}
		}
}