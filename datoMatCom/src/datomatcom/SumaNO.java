package datomatcom;
/**
 *
 * @author zidai
 */
public class SumaNO implements Sumar{
    @Override
    public DatoMatCom suma(DatoMatCom x, DatoMatCom y){
        System.out.println("No se puede Sumar");
        return x;
    }
}