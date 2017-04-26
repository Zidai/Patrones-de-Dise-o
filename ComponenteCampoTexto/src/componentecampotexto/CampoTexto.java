package componentecampotexto;
/*
 * @author Zidai
 */
import javax.swing.*;
import java.io.Serializable;
import java.awt.event.*;

public class CampoTexto extends JTextField implements Serializable, KeyListener, FocusListener {
  private int longMax;
  private int longMin;

  public CampoTexto(){
    super();
    longMax = 10;
    longMin = 3;
    setColumns(longMax);
    addKeyListener(this);

    //esto se ve tremendamente feo
    setInputVerifier(new InputVerifier() {
      public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String cadena = tf.getText();
        if(cadena.length() < getLongMin()){
          System.out.println("Ingrese minimo: " + getLongMin() + " caracteres");
          return false;
        }
        if(cadena.length() > getLongMax()){
           System.out.println("debe ingresar un máximo de: " + getLongMax() + " caracteres");
           return false;
        }
        return true;
      }
    });

  }

  public void setLongMax(int v){
    if(v >= longMin){
      longMax = v;
    }else{
      longMax = longMin;
    }
  }

  public int getLongMax(){
    return longMax;
  }
 
  public int getLongMin(){
    return longMin;
  }

  public void setLongMin(int v){
    if(v < 0){
      longMin = longMax;
    }
    if(v > longMax){
      longMin = longMax - 1;
    }else{
      longMin = v;
    }
  }

  @Override
  public void keyPressed(KeyEvent e){

  }

  @Override
  public void keyTyped(KeyEvent e) {
    char caracter = e.getKeyChar();
    if(caracter >= '0' && caracter <= '9'){
      e.consume();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void focusGained(FocusEvent e){

  }

  @Override
  public void focusLost(FocusEvent e){
    // String entrada = this.getText();
    // if(entrada.length() < getLongMin()){
    //   System.out.println("debe ingresar un minimo de: " + getLongMin() + " caracteres");
    // }
  }

}
