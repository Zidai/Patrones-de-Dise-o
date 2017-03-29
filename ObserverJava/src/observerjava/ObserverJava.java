package observerjava;
import java.util.Observer;
public class ObserverJava {
  public static void main(String args []){
    //crear observable
    ConjuntoDatos s1 = new ConjuntoDatos();
    //crear observador
    Observer o1 = new Imprimir(s1);
    Observer o2 = new Promediar(s1);
    Observer o3 = new Graficar(s1);
    //es como si los fuera apilando
    s1.addObserver(o3);
    s1.addObserver(o2);
    s1.addObserver(o1);


    s1.agregar(1);
    s1.agregar(2);
    s1.agregar(5);
    s1.agregar(10);
  }
}