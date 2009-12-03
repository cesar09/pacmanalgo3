package TP3;

import interfasesYControladores.Dibujable;
import interfasesYControladores.SuperficieDeDibujo;

import java.util.*;


public class Juego {

	private Nivel unNivel; 
	private Jugador jugador;
	private int nivelActual;
	private List dibujables;
	private SuperficieDeDibujo superficieDeDibujo;
	private boolean estaEnEjecucion;
	private long intervaloSimulacion;
	private static int cantidadDeNiveles=2;
	
	public Juego(){
		this.dibujables = new ArrayList();
		this.nivelActual = 1; //nivel inicial 1.
		this.jugador = new Jugador();
		try{
			this.unNivel = new Nivel(this, this.nivelActual);
		} catch (ArchivoFueraDeFormatoException e) {
			// Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
			System.out.println("Formato incorrecto en laberinto correspondiente al nivel "+nivelActual+".");
		}
	}
	public void comenzar(){
		estaEnEjecucion = true;
		try{			
			while(estaEnEjecucion){
				this.mover();
				this.dibujar();
				Thread.sleep(intervaloSimulacion);
			}
		}
		catch (NivelGanado e) {
			this.dibujar();
			this.pasarDeNivel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void pasarDeNivel(){
		this.nivelActual++;
		if(cantidadDeNiveles<nivelActual) this.JuegoGanado(); 
		else try {
				this.dibujables = new ArrayList();
				this.unNivel = new Nivel(this, this.nivelActual);
			} catch (ArchivoFueraDeFormatoException e) {
			// Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
				System.out.println("Formato incorrecto en laberinto correspondiente al nivel "+nivelActual+".");
			}
		this.comenzar();
	}

	public void sumarPuntajeAlJugador(int puntaje){
		if(puntaje<0) throw new IllegalArgumentException();
		this.jugador.sumarPuntaje(puntaje);
		if (this.jugador.obtenerPuntaje()%10000.0 == 0) // Obtiene el resto de la division
			this.jugador.agregarVida();
	}
	
	public int obtenerPuntajeDelJugador(){
		return this.jugador.obtenerPuntaje();
	}
	
	public int obtenerNivelActual(){
		return this.nivelActual;
	}
	
	public int obtenerVidasDisponibles(){
		return (this.jugador.obtenerVidasDisponibles());
	}
	
	public void mover() throws NivelGanado{
		try {
			this.superficieDeDibujo.limpiar();
			this.unNivel.mueveFantasmas();
			this.unNivel.muevePacman();
		} catch (PacmanAtrapadoException e) {
			try{
				this.jugador.perderVida();
			}catch (JugadorSinVidasException e2){
				this.juegoPerdido();
			}
		}
		if (this.seGanoJuego()){
			throw new NivelGanado();
		}
	}

	public void juegoPerdido(){
		System.out.println("Has perdido el juego.");
		//Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
	}
	private void JuegoGanado() {
		System.out.println("Has ganado el juego.");
		//Acá debe ser enviado un mensaje grafico cuando implementemos la sección visual del tp.
	}
	
	public boolean seGanoJuego(){
		if (this.unNivel.obtenerMiLaberinto().obtenerCantidadPastillas() == 0){
			return true;
		}
		return false;
	}
	
	private void dibujar() {
		Iterator iterador = dibujables.iterator();
		while(iterador.hasNext()){
			Dibujable dibujable = (Dibujable)iterador.next();
			dibujable.dibujar(this.superficieDeDibujo);
		}		
		this.superficieDeDibujo.actualizar();
	}
	public void agregarDibujable(Dibujable unDibujable){
		dibujables.add(unDibujable);
	}
	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return superficieDeDibujo;
	}
	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		this.superficieDeDibujo = superficieDeDibujo;
	}
	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
	}	
}
