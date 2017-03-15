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
public class DatoDimencionLineal extends DatoMatCom{
    public DatoDimencionLineal(double x, double y){
        super(x, y);
        opSum= new SumaDimLin();
        opMul= new MultiNO();
    }
    @Override
    public void mostrar(){
        System.out.println("Dimencion Lineal: " + (int)valor1 +"m "+ (int)valor2 + "cm");
    }
}
