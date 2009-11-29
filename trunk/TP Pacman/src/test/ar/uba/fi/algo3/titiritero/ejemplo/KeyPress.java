package test.ar.uba.fi.algo3.titiritero.ejemplo;
import java.awt.*;
import java.awt.event.*;

public class KeyPress extends Frame{
  Label label;
  TextField txtField;
  public static void main(String[] args) {
    KeyPress k = new KeyPress();
  }

  public KeyPress(){
	 super("De prueba");
    this.addKeyListener(new MyKeyListener());
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent we){
        System.exit(0);
      }
    });
   setSize(400,400);
    setVisible(true);
  }

  public class MyKeyListener extends KeyAdapter{
    public void keyPressed(KeyEvent ke){
      System.out.println(ke.getKeyCode());
    }
  }  
}