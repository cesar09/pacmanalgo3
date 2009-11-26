package TP3;

import java.util.Timer;
import java.util.TimerTask;

public class TimerVacio {
	
	private Timer timer;
	private Nivel miNivel;
	private long periodo = 5000;

	public TimerVacio ( int segundos, Nivel miNivel ){
		this.timer = new Timer ( ) ;
		this.miNivel = miNivel;
		this.timer.schedule( new RemindTask ( ) , segundos*1000, periodo);
	}

	private void aparecerVacio(){
			this.miNivel.obtenerMiLaberinto().agregarVacio();
	}

	class RemindTask extends TimerTask {
		public void run ( ) {
			aparecerVacio();
//			timer.cancel ( ) ; //Cancela el hilo del timer
								
		}
	}
}