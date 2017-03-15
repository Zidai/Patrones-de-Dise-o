package datomatcom;
/**
 *
 * @author Zidai
 */
public class DatoVector extends DatoMatCom{
    public DatoVector(double x, double y){
        super(x, y);
        opSum= new SumaDirecta();
        opMul= new MultiNO();
    }
    @Override
    public void mostrar(){
        System.out.println("Vector: " + (int)valor1 +" a "+ valor2 + "°");
    }
}