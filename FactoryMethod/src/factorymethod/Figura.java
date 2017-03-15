package factorymethod;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Zidai
 */
public abstract class Figura extends JComponent{
    
     Object valor;
     Integer tamaño;
     String nombre;
     int posx;
     int posy;
    
    
    public void dibujar(Graphics g){
        this.paint(g);
    }
    
    public void setx(int x){
    posx=x;
    }
    
    public void sety(int y){
    posy=y;
    }
    
    public String getValor(){
    return (String )valor;
    }
  
    public void trasladar(int x, int y){
        posx=x;
        posy=y;
    }
    
    public void escalar(int factor){
        tamaño=factor;    
    }
    
}
