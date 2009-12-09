package interfasesYControladores;

import java.util.*;

import graphicCollection.*;
import Vista.*;
import modelo.*;

public class ControladorJuego {
	
	private List dibujables;
	private Juego miJuego;
	private boolean estaEnEjecucion;
	private long intervaloSimulacion;
	private SuperficieDeDibujo superficieDeDibujo;
	
	
	public ControladorJuego(Juego unJuego){
		this.dibujables = new ArrayList();
		this.miJuego = unJuego;
	}
	
	
	public void comenzar(){
		estaEnEjecucion = true;
		try{
			try{			
				while(estaEnEjecucion){
					miJuego.mover();
					this.dibujar();
					Thread.sleep(intervaloSimulacion);
				}
			}
			catch (NivelGanado e) {
				this.dibujar();
				miJuego.pasarDeNivel();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}catch(JuegoGanado e){ return;
		}
	}

	
	public void agregarDibujable(Dibujable unDibujable){
		dibujables.add(unDibujable);
	}
	
	public void removerDibujable(Dibujable unDibujable){
		dibujables.remove(unDibujable);
	}
	
	public long getIntervaloSimulacion() {
		return intervaloSimulacion;
	}

	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
	}


	private void dibujar() {
		this.superficieDeDibujo.limpiar();
		Iterator iterador = dibujables.iterator();
		while(iterador.hasNext()){
			Dibujable dibujable = (Dibujable)iterador.next();
			dibujable.dibujar(this.superficieDeDibujo);
		}		
		this.superficieDeDibujo.actualizar();
	}
	

	public SuperficieDeDibujo obtenerSuperficieDeDibujo() {
		return superficieDeDibujo;
	}

	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		this.superficieDeDibujo = superficieDeDibujo;
	}
	
}
