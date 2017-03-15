package datomatcom;
/**
 * @author zidai
 */
public class DatoExponente extends DatoMatCom{
    public DatoExponente(double x, double y){
        super(x, y);
        opSum= new SumaExpo();
        opMul= new MultiExpo();
    }
    @Override
    public void mostrar(){
        System.out.println("Exponente:" + (int)valor1 +"^"+ (int)valor2);
    }
    
}
