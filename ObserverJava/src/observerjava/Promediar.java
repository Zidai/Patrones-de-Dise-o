package observerjava;
/*
 * @author Zidai
 */
import java.util.Observer;
import java.util.Observable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Observable;
public class Promediar implements Observer {
  private Sujeto suj;

  public Promediar(Sujeto s){
    suj = s;
  }

  @Override
  public void update(Observable o, Object obj){
    suj = (Sujeto)o;
    promediar();
  }

  public void promediar(){
    int acumulador = 0;
    ArrayList datos = suj.getDatos();
    Iterator it = datos.iterator();
    int cantidad_datos = datos.size();
    while(it.hasNext()){
      acumulador += (Integer)it.next();
    }
    System.out.println("Promedio: " + (float)(acumulador / cantidad_datos));
    System.out.println("-------------------------");
  }
}