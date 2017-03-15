package datomatcom;
/**
 *
 * @author zidai
 */
public class SumaExpo  implements Sumar{   
    @Override
    public DatoMatCom suma(DatoMatCom x, DatoMatCom y){
        if(x.valor1==y.valor1){
            if(x.valor2==y.valor2){
                System.out.println("Resultado: 2*"+(int)x.valor1+"^"+(int)x.valor2);
            }
            else{System.out.println((int)x.valor1+"^"+(int)x.valor2+"+"+(int)y.valor1+"^"+(int)y.valor2);}
        }
        else{System.out.println((int)x.valor1+"^"+(int)x.valor2+"+"+(int)y.valor1+"^"+(int)y.valor2);}
        return x;
    }
}
