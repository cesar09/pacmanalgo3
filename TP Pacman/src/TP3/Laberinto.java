package TP3;

import java.io.*; //lo utiliza el cargarLaberintoSegunNivel que lee de archivo

public class Laberinto {

private Contenido[][] contenidos;
private int fila;
private int columna;

public Laberinto(int nivel){
	 this.fila= 31; // las y maximas
	 this.columna=28; //las x maximas
	 contenidos = new Contenido[columna][fila];
	 try{
		 this.cargarLaberintoSegunNivel(1);
	 }catch (ArchivoFueraDeFormatoException e){
		 
	 }
}

 public Contenido devolverContenido(int x,int y){
	 if ((x<0)|(x>=columna)|(y<0)|(y>=fila)) throw new IllegalArgumentException();
	 Contenido contenidoPedido;
	 contenidoPedido = contenidos[x][y];
	 return contenidoPedido;
 }
 
public void cargarLaberintoSegunNivel(int nivel) throws ArchivoFueraDeFormatoException{
	  	
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
				break;
			case 79:
				contenidos[x][y]= new PuntoPoder();
				break;
			case 32:
				contenidos[x][y]= new Vacio();
				break;
			default: throw new ArchivoFueraDeFormatoException();
		}
	
	}
} 
