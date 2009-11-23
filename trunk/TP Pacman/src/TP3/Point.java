package TP3;
public class Point {
	// Creamos esta clase Point para poder usarla en el laberinto
  int x,y;
  
  public Point(int x, int y) {
    this.x= x; this.y= y;
  }
 
  public void setXY (int x, int y){
	  this.x = x;
	  this.y = y;
  }
  
  public Point getPoint(){
	  return(this);
  }
  
  public int getX(){
	  return(this.x);
  }
  
  public int getY(){
	  return(this.y);
  }
  
}
