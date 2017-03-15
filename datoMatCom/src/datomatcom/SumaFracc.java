package datomatcom;
/**
 *
 * @author zidai
 */
public class SumaFracc implements Sumar{
    @Override
    public DatoMatCom suma(DatoMatCom x, DatoMatCom y){
        x.valor1 = (((x.valor2*y.valor2)/x.valor2)*x.valor1)+(((x.valor2*y.valor2)/y.valor2)*y.valor1);
        x.valor2 = x.valor2*y.valor2;
        return x;
    }
}
