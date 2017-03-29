package observerjava;
/*
 * @author Zidai
 */
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.util.Iterator;
public class ConjuntoDatos extends Observable implements Sujeto {
  private ArrayList<Integer> datos;

  public ConjuntoDatos(){
    datos = new ArrayList<Integer>();
  }

  public void agregar(int d){
    datos.add(d);
    setChanged();
    notifyObservers();
  }

  public ArrayList getDatos(){
    return datos;
  }
}