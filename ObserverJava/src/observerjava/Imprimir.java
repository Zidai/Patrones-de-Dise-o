package observerjava;
/*
 * @author Zidai
 */
import java.util.Observer;
import java.util.Observable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Observable;
public class Imprimir implements Observer {
  private Sujeto suj;

  public Imprimir(Sujeto s){
    suj = s;
  }

  @Override
  public void update(Observable o, Object obj){
    suj = (Sujeto)o;
    imprimir();
  }

  public void imprimir(){
    ArrayList datos = suj.getDatos();
    Iterator it = datos.iterator();
    while(it.hasNext()){
      System.out.println(" " + (Integer)it.next());
    }
    System.out.println("-------------------------");
  }
}
