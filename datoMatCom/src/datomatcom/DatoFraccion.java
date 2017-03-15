package datomatcom;
/**
 *
 * @author zidai
 */
public class DatoFraccion extends DatoMatCom{
    public DatoFraccion(double x, double y){
        super(x, y);
        opSum= new SumaFracc();
        opMul= new MultiDirecto();
    }
    @Override
    public void mostrar(){
        System.out.println("Fraccion:" + (int)valor1 +"/"+ (int)valor2);
    }
    
}
