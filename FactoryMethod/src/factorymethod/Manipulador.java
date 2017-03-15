package factorymethod;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Zidai
 */
public abstract class Manipulador extends JPanel{
     Figura figura;
    
    public abstract Figura crearFigura(Object d, Integer t);
    
    public void dibujarFigura(Graphics g){
    figura.dibujar(g);
    }
    
    public void trasladarFigura(int x, int y){
    figura.trasladar(x, y);
    }
    
    public void escalarFigura(int factor){
    figura.escalar(factor);
    }
}

