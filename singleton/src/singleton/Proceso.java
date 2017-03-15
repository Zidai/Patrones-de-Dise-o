package singleton;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Zidai
 */
public class Proceso implements Runnable{
    //Ejemplo de un proceso donde se trata de crear tres  instancias
    private SingletonParaHilos osc; 
    @Override
    public void run() {
        osc =  SingletonParaHilos.getInstance();
        System.out.println("Se creo una nueva instancia "+osc.nins());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
         Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        osc =  SingletonParaHilos.getInstance();
        System.out.println("Se creo una nueva instancia  "+ osc.nins());
        try {Thread.sleep((int)(Math.random()*1000)) ;} catch (InterruptedException ex){}
        osc =  SingletonParaHilos.getInstance();
        System.out.println("Se creo una nueva instancia   "+osc.nins());
    }
}

