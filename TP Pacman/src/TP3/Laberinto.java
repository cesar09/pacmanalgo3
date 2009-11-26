package TP3;

import java.io.*; //lo utiliza el cargarLaberintoSegunNivel que lee de archivo

public class Laberinto {

private Contenido[][] contenidos;
private int fila;
private int columna;
private int cantidadPastillas;
private int cantFilas = 31;
private int cantColumnas = 28;
private int posicionFilaFruta = 17;
private int posicionColumnaFruta = 14;

public Laberinto(int nivel){
	 this.fila = cantFilas;
	 this.columna = cantColumnas;
	 cantidadPastillas = 0;
	 contenidos = new Contenido[columna][fila];
	 try{
		 this.cargarLaberintoSegunNivel(nivel);
	 }catch (ArchivoFueraDeFormatoException e){
		 
	 }
}

//public static void main(String[] args){
//	Laberinto unLab=new Laberinto(1);
//}

public Contenido devolverContenido(int x,int y){
	 if ((x<0)|(x>=columna)|(y<0)|(y>=fila)) throw new IllegalArgumentException();
	 Contenido contenidoPedido;
	 contenidoPedido = contenidos[x][y];
	 return contenidoPedido;
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
		for (y = 0; y < fila; y++) {
			for (x = 0; x < columna +2; x++) {				
				try {
					caracter = input.read();					
				} catch (IOException e) {
					e.printStackTrace();
				}
				if((x>columna-1)&(!((caracter==13)|(caracter==10)))) throw new ArchivoFueraDeFormatoException(); 
				else if (x<=columna-1){
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
	contenidos[posicionFilaFruta][posicionColumnaFruta] = new Fruta();
	}

public void agregarVacio() {
	contenidos[posicionFilaFruta][posicionColumnaFruta] = new Vacio();
}
}