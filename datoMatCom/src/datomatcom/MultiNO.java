package datomatcom;
/**
 *
 * @author diana
 */
public class MultiNO implements Multiplicar{    
    @Override
    public DatoMatCom Multi(DatoMatCom x, DatoMatCom y){
        System.out.println("No se puede Multiplicar");
        return x;
    }
}