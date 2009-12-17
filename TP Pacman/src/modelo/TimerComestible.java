package modelo;
	import java.util.Timer;
	import java.util.TimerTask;

	public class TimerComestible {
		
		Timer timer;
		Nivel miNivel;
		public TimerComestible ( int segundos, Nivel miNivel ) {			
			this.timer = new Timer ( ) ;
			this.miNivel = miNivel;
			this.timer.schedule ( new RemindTask ( ) , segundos*1000 ) ;
		}

		private void hacerFantasmasNoComestibles(){
			this.miNivel.obtenerBlinky().hacerseNoComestible();
			this.miNivel.obtenerInky().hacerseNoComestible();
			this.miNivel.obtenerPinky().hacerseNoComestible();
			this.miNivel.obtenerClyde().hacerseNoComestible();
		}

		public void cancelarTimer(){
			timer.cancel ();
		}
		class RemindTask extends TimerTask {
			public void run ( ) {
				hacerFantasmasNoComestibles();
				timer.cancel () ; //Cancela el hilo del timer
			}
		}
		
}
	
