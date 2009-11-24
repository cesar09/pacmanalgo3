package TP3;

import java.io.*; //lo utiliza el cargarLaberintoSegunNivel que lee de archivo

public class Laberinto {

private Contenido[][] contenidos;
private int fila;
private int columna;
private int nivel;


public Laberinto(int nivel){
	 this.nivel = nivel;
	 this.fila= 30; // las y maximas
	 this.columna=27; //las x maximas
	 contenidos = new Contenido[fila][columna];
	 for(int i = 0;i<fila;i++){ //TODO: me parece que esto de los null es al pedo
		 for(int j = 0; j<columna;j++){
			 contenidos[i][j]=null;
		 }
	 }
 }

 public Contenido devolverContenido(int x,int y){
	 if ((x<0)|(x>=columna)|(y<0)|(y>=fila)) throw new IllegalArgumentException();
	 Contenido contenidoPedido;
	 contenidoPedido = contenidos[y][x];
	 return contenidoPedido;
 }

//harcodie mientras no tengamos xml
/*	
public void cargarLaberintoSegunNivel(){

	  matrizPosicion[0][0]= new Posicion(new Bloque());
	  matrizPosicion[0][1]= new Posicion(new Bloque());
	  matrizPosicion[0][2]= new Posicion(new Bloque());
	  matrizPosicion[0][3]= new Posicion(new Bloque());
	  matrizPosicion[0][4]= new Posicion(new Bloque());
	  matrizPosicion[0][5]= new Posicion(new Bloque());
	  matrizPosicion[0][6]= new Posicion(new Bloque());
	  matrizPosicion[1][0]= new Posicion(new Bloque());
	  matrizPosicion[1][1]= new Posicion(new PuntoPoder());
	  matrizPosicion[1][2]= new Posicion(new Punto());
	  matrizPosicion[1][3]= new Posicion(new Punto());
	  matrizPosicion[1][4]= new Posicion(new Punto());
	  matrizPosicion[1][5]= new Posicion(new PuntoPoder());
	  matrizPosicion[1][6]= new Posicion(new Bloque());
	  matrizPosicion[2][0]= new Posicion(new Bloque());
	  matrizPosicion[2][1]= new Posicion(new Punto());
	  matrizPosicion[2][2]= new Posicion(new Bloque());
	  matrizPosicion[2][3]= new Posicion(new Punto());
	  matrizPosicion[2][4]= new Posicion(new Bloque());
	  matrizPosicion[2][5]= new Posicion(new Punto());
	  matrizPosicion[2][6]= new Posicion(new Bloque());
	  matrizPosicion[3][0]= new Posicion(new Bloque());
	  matrizPosicion[3][1]= new Posicion(new Punto());
	  matrizPosicion[3][2]= new Posicion(new Punto());
	  matrizPosicion[3][3]= new Posicion(new Punto());
	  matrizPosicion[3][4]= new Posicion(new Punto());
	  matrizPosicion[3][5]= new Posicion(new Punto());
	  matrizPosicion[3][6]= new Posicion(new Bloque());
	  matrizPosicion[4][0]= new Posicion(new Bloque());
	  matrizPosicion[4][1]= new Posicion(new Punto());
	  matrizPosicion[4][2]= new Posicion(new Bloque());
	  matrizPosicion[4][3]= new Posicion(new Punto());
	  matrizPosicion[4][4]= new Posicion(new Bloque());
	  matrizPosicion[4][5]= new Posicion(new Punto());
	  matrizPosicion[4][6]= new Posicion(new Bloque());
	  matrizPosicion[5][0]= new Posicion(new Bloque());
	  matrizPosicion[5][1]= new Posicion(new PuntoPoder());
	  matrizPosicion[5][2]= new Posicion(new Punto());
	  matrizPosicion[5][3]= new Posicion(new Punto());
	  matrizPosicion[5][4]= new Posicion(new Punto());
	  matrizPosicion[5][5]= new Posicion(new PuntoPoder());
	  matrizPosicion[5][6]= new Posicion(new Bloque());
	  matrizPosicion[6][0]= new Posicion(new Bloque());
	  matrizPosicion[6][1]= new Posicion(new Bloque());
	  matrizPosicion[6][2]= new Posicion(new Bloque());
	  matrizPosicion[6][3]= new Posicion(new Bloque());
	  matrizPosicion[6][4]= new Posicion(new Bloque());
	  matrizPosicion[6][5]= new Posicion(new Bloque());
	  matrizPosicion[0][0]= new Posicion(new Bloque());
	}
*/

//Este es el metodo que carga desde archivo el laberinto. Falta comprobar que ande.

public void cargarLaberintoSegunNivel() throws ArchivoFueraDeFormatoException{
	  	
		int x; 
		int y;
		int caracter = 0;
				
		BufferedReader input = null;
		File laberintoFile = new File("nivel1.xml");
		try {
			input = new BufferedReader(new FileReader(laberintoFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (y = 0; y <= fila; y++) {
			for (x = 0; x <= columna +2; x++) {				
				try {
					caracter = input.read();					
				} catch (IOException e) {
					e.printStackTrace();
				}
				if((x>columna)&(!((caracter==13)|(caracter==10)))) throw new ArchivoFueraDeFormatoException(); 
				else if (x<=columna){
					try {
					agregarObjeto(caracter, x, y);
					} catch (ArchivoFueraDeFormatoException e) {
						e.printStackTrace();
					}
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

//Constructor para la carga desde archivo

public static void main(String[] args) throws ArchivoFueraDeFormatoException {
	Laberinto unLaberinto= new Laberinto(1);
	unLaberinto.cargarLaberintoSegunNivel();
}


} 

