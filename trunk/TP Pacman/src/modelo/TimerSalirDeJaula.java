package modelo;
import java.util.Timer;
import java.util.TimerTask;

	public class TimerSalirDeJaula {
		
		Timer timer;
		Fantasma fantasma;
		
		public TimerSalirDeJaula ( int segundos, Fantasma unFantasma ) {
		timer = new Timer ( ) ;
		this.fantasma = unFantasma;
		timer.schedule ( new RemindTask ( ) , segundos*1000 ) ;
		}

		private void liberarFantasma() {
			this.fantasma.salirDeJaula();
			
		}
		
		class RemindTask extends TimerTask {
			public void run ( ) {
				liberarFantasma();
				timer.cancel ( ) ; //Cancela el hilo del timer
			}
			
		}
}