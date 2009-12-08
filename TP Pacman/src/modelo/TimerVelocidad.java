package modelo;
	import java.util.Timer;
	import java.util.TimerTask;

	public class TimerVelocidad {
		
		Timer timer;
		Nivel miNivel;
		Fantasma unFantasma;

		public TimerVelocidad ( int segundos, Nivel miNivel, Fantasma unFantasma ) {
		this.timer = new Timer ( ) ;
		this.miNivel = miNivel;
		this.unFantasma = unFantasma;
		this.timer.schedule ( new RemindTask ( ) , segundos*1000 ) ;
		}

		private void moverFantasma(){
			
		}

		class RemindTask extends TimerTask {
			public void run ( ) {
				moverFantasma();
				timer.cancel ( ) ; //Cancela el hilo del timer
			}
		}
		
}
	
