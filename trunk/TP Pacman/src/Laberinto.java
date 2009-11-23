
public class Laberinto {

private Posicion[][] matrizPosicion;
private int fila;
private int columna;

 public Laberinto(){
	 this.fila= 7; // las y maximas
	 this.columna=7; //las x maximas
	 matrizPosicion = new Posicion[7][7];
	 for(int i = 0;i<7;i++){
		 for(int j = 0; j<7;j++){
			 matrizPosicion[i][j]=null;
		 }
	 }
 }

 //nose me ocurria un nombre mas elegante desp lo cambiamos
 //este lo tendria que usar el pacman 
 public Posicion devolverPosicion(int x,int y){
	 if ((x<=0)|(x>columna)|(y<=0)|(y>fila)) throw new IllegalArgumentException();
	 Posicion PosicionPedida;
	 PosicionPedida = matrizPosicion[y][x];
	 return PosicionPedida;
 }

//harcodie mientras no tengamos xml
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
	  matrizPosicion[6][6]= new Posicion(new Bloque());	  

 }


}
