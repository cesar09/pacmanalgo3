package TP3;
	import java.util.Timer;
	import java.util.TimerTask;

	public class TimerComestible {
		
		Timer timer;
		Nivel miNivel;
		private boolean contadorActivado=false;
		public TimerComestible ( int segundos, Nivel miNivel ) {			
			if(contadorActivado)timer.cancel () ;
			this.timer = new Timer ( ) ;
			this.miNivel = miNivel;
			contadorActivado=true;
			this.timer.schedule ( new RemindTask ( ) , segundos*1000 ) ;
		}

		private void hacerFantasmasNoComestibles(){
			this.miNivel.hacerFantasmasNoComestibles();
		}

		class RemindTask extends TimerTask {
			public void run ( ) {
				hacerFantasmasNoComestibles();
				timer.cancel () ; //Cancela el hilo del timer
				contadorActivado=false;
			}
		}
		
}
	
