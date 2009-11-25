package PruebasUnitarias;

import junit.framework.TestCase;
import TP3.*;

public class testPoint extends TestCase{

	private Point punto1;
	private Point punto2;
	
	public void setUp(){
		this.punto1= new Point();
		this.punto2=new Point(1,1);		
	}
	
	public void testPointUno(){
		assertEquals(punto1.getX(),0);
		assertEquals(punto1.getY(),0);
	}
	public void testPointDos(){
		assertEquals(punto2.getX(),1);
		assertEquals(punto2.getY(),1);
	}
	public void testPointSetXY(){
		punto1.setXY(3,4);
		assertEquals(punto2.getX(),3);
		assertEquals(punto2.getY(),4);
	}
}
