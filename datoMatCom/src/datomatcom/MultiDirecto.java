package datomatcom;
/**
 *
 * @author diana
 */
public class MultiDirecto implements Multiplicar{    
    @Override
    public DatoMatCom Multi(DatoMatCom x, DatoMatCom y){
        x.valor1=x.valor1*y.valor1;
        x.valor2=x.valor2*y.valor2;
        return x;
    }
}