package datomatcom;
/**
 *
 * @author diana
 */
public class MultiExpo implements Multiplicar{    
    @Override
    public DatoMatCom Multi(DatoMatCom x, DatoMatCom y){
        if(x.valor1==y.valor1){
            System.out.println("Resultado: "+(int)x.valor1+"^"+(int)(x.valor2+y.valor2));
        }
        else{System.out.println((int)x.valor1+"^"+(int)x.valor2+"+"+(int)y.valor1+"^"+(int)y.valor2);}
        return x;
    }
}