/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datomatcom;

/**
 *
 * @author Zidai
 */
public class SumaTiempo implements Sumar{
    @Override
    public DatoMatCom suma(DatoMatCom x, DatoMatCom y){
        double horasE=0;
        x.valor2 = (int)x.valor2 + (int)y.valor2;
        if(x.valor2>=60){
            horasE= (int)x.valor2/60;
            double minsE= x.valor2;
            minsE=minsE - (horasE*60);
            x.valor2= minsE;
        }
        x.valor1 = x.valor1 + y.valor1 + horasE;
        return x;
    }
}
