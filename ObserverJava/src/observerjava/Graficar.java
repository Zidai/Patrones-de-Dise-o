package observerjava;
/*
 * @author Zidai
 */
import java.util.Observer;
import java.util.Observable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Observable;
public class Graficar implements Observer {
  private Sujeto suj;

  public Graficar(Sujeto s){
    suj = s;
  }

  @Override
  public void update(Observable o, Object obj){
    suj = (Sujeto)o;
    graficar();
  }

  public void graficar(){
    ArrayList datos = suj.getDatos();
    Iterator it = datos.iterator();
    System.out.println("Gráfica sencilla: ");
    while(it.hasNext()){
      int dato = (Integer)it.next();
      System.out.print(" " + dato + " : ");
      for(int i = 0; i < dato; i++){
        System.out.print("*");
      }
      System.out.println();
    }
    System.out.println("-------------------------");
  }
}