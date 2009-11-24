package TP3;
public class Point {

  int x,y;
  
  public Point(int x, int y) {
    this.x= x; this.y= y;
  }
  
  public Point(){
	  x=0;
	  y=0;
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
