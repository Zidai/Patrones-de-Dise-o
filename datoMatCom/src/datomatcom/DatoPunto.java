package datomatcom;
/**
 *
 * @author Zidai
 */
public class DatoPunto extends DatoMatCom{
    public DatoPunto(double x, double y){
        super(x, y);
        opSum= new SumaDirecta();
        opMul= new MultiNO();
    }
    @Override
    public void mostrar(){
        System.out.println("Punto: (" + valor1 +","+ valor2 + ")");
    }
}
