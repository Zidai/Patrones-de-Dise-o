package componentecampotexto;
/*
 * @author Zidai
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class CampoTextoNumerico extends JTextField implements KeyListener {
    private int limMax;
    private int limMin;
    private int decimales;

    public CampoTextoNumerico(){
        super();
        limMax = 10;
        limMin = 1;
        setColumns(limMax);
        addKeyListener(this);

        //esto se ve tremendamente feo
        setInputVerifier(new InputVerifier() {
            public boolean verify(JComponent input) {
                JTextField tf = (JTextField) input;
                String cadena = tf.getText();
                if(!Pattern.matches("\\d*\\.?\\d+", cadena)){
                    System.out.println("ingrese un solo punto decimal");
                    return false;
                }
                if(cadena.length() == 0){
                    System.out.println("ingrese un número entre: " + getLimMin() + " y " + getLimMax());
                    return false;
                }
                try{
                    if(Double.parseDouble(cadena) < (double)getLimMin()){
                    System.out.println("debe ingresar un número mayor a: " + getLimMin());
                    return false;
                }
                if(Double.parseDouble(cadena) > (double)getLimMax()){
                    System.out.println("debe ingresar un número menor a: " + getLimMax());
                    return false;
                }
                if(Integer.parseInt(cadena) < getLimMin()){
                    System.out.println("debe ingresar un número mayor a: " + getLimMin());
                    return false;
                }
                if(Integer.parseInt(cadena) > getLimMax()){
                    System.out.println("debe ingresar un número menor a: " + getLimMax());
                    return false;
                }
            } catch(Exception e){}
            return true;
            }
        });
    }

    public void setLimMax(int v){
        if(v >= limMin){
        limMax = v;
        }else{
        limMax = limMin;
        }
    }

    public int getLimMax(){
        return limMax;
    }

    public int getLimMin(){
        return limMin;
    }

    public void setLimMin(int v){
        if(v < 0){
            limMin = limMax;
        }
        if(v > limMax){
            limMin = limMax - 1;
        }else{
            limMin = v;
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();
        if((caracter < '0' || caracter > '9') && caracter != '.'){
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}