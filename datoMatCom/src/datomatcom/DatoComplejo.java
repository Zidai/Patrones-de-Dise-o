package datomatcom;
/**
 *
 * @author Zidai
 */
public class DatoComplejo extends DatoMatCom{
    public DatoComplejo(double x, double y){
        super(x, y);
        opSum= new SumaDirecta();
        opMul= new MultiNO();
    }
    @Override
    public void mostrar(){
        System.out.println("Complejo: (" + valor1 +","+ valor2 + "i)");
    }
}
