package modelo;

import java.io.*; 

import Vista.Posicionable;


public class Laberinto implements Posicionable{

private Contenido[][] contenidos;
private int cantidadPastillas;
private int cantidadFilas = 31;
private int cantidadColumnas = 28;

public Laberinto(int nivel) throws ArchivoFueraDeFormatoException{
	 cantidadPastillas = 0;
	 contenidos = new Contenido[cantidadColumnas][cantidadFilas];
	 this.cargarLaberintoSegunNivel(nivel);
	
}

public Contenido devolverContenido(int x,int y){
	 if ((x<0)|(x>=cantidadColumnas)|(y<0)|(y>=cantidadFilas)) throw new IllegalArgumentException();
	 	return (contenidos[x][y]);
 }
 
private void cargarLaberintoSegunNivel(int nivel) throws ArchivoFueraDeFormatoException{
	  	
		int x; 
		int y;
		int caracter = 0;
				
		BufferedReader input = null;
		File laberintoFile = new File("nivel"+nivel+".xml");
		try {
			input = new BufferedReader(new FileReader(laberintoFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (y = 0; y < cantidadFilas; y++) {
			for (x = 0; x < cantidadColumnas +2; x++) {				
				try {
					caracter = input.read();					
				} catch (IOException e) {
					e.printStackTrace();
				}
				if((x>cantidadColumnas-1)&(!((caracter==13)|(caracter==10)))) throw new ArchivoFueraDeFormatoException(); 
				else if (x<=cantidadColumnas-1){
					agregarObjeto(caracter, x, y);
				
				}
			}
		}

	}
	

private void agregarObjeto(int caracter, int x, int y) throws ArchivoFueraDeFormatoException {
		switch (caracter) {
			case 35:
				contenidos[x][y]= new Bloque();
				break;
			case 111:
				contenidos[x][y]= new Punto();
				cantidadPastillas++;
				break;
			case 79:
				contenidos[x][y]= new PuntoPoder();
				cantidadPastillas++;
				break;
			case 32:
				contenidos[x][y]= new Vacio();
				break;
			case 61:
				contenidos[x][y]= new Transportador();
				break;
			default: throw new ArchivoFueraDeFormatoException();
		}	
	} 

	public int obtenerCantidadPastillas(){
		return cantidadPastillas;
	}

	public int restarCantidadPastillas(){
		return cantidadPastillas--;
	}
	public void agregarFruta(){
		contenidos[14][17] = new Fruta();
	}

	public void agregarVacio(int columna,int fila) {
		contenidos[columna][fila] = new Vacio();
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}
}