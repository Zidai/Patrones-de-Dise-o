package factorymethod;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
/**
 * @author Zidai
 */
public class Texto extends Figura{
    
    public Texto(Object d, Integer t, String n){
        valor=d;
        tamaño=t;
        nombre=n;
        posx=50;
        posy=50;
    }
    public Texto(Object d, Integer t, String n, int x, int y){
        valor=d;
        tamaño=t;
        nombre=n;
        posx=x;
        posy=y;
    }
    
    @Override
    public void paint(Graphics g){
        Font f=g.getFont();
        FontMetrics fm=g.getFontMetrics();
        g.setFont(new Font(f.getName(), f.getStyle(), (int)tamaño));
        g.drawString((String)valor, posx, posy);
    }
    
  
}
