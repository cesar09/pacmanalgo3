package TP3;
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

		public void hacerFantasmasNoComestibles(){
			this.miNivel.hacerFantasmasNoComestibles();
		}

		class RemindTask extends TimerTask {
			public void run ( ) {
				hacerFantasmasNoComestibles();
				timer.cancel ( ) ; //Cancela el hilo del timer
			}
		}
		
		/*
		public static void main ( String args [ ] ) {
			System.out.println ( "Empezará." ) ;
			new TimerComestible ( 10 ) ;
				System.out.println ( "Empezó." ) ;
		}
		*/
}
	
