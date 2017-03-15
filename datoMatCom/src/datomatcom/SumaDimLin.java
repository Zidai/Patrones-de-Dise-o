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
public class SumaDimLin implements Sumar{
    @Override
    public DatoMatCom suma(DatoMatCom x, DatoMatCom y){
        double metrosE=0;
        x.valor2 = (int)x.valor2 + (int)y.valor2;
        if(x.valor2>=100){
            metrosE= x.valor2/100;
            double cenE= x.valor2;
            cenE=cenE - ((int)metrosE*100);
            x.valor2= cenE;
        }
        x.valor1 = x.valor1 + y.valor1 + metrosE;
        return x;
    }
}
