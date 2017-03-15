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
public class DatoDimencionArea extends DatoMatCom{
    public DatoDimencionArea(double x, double y){
        super(x, y);
        opSum= new SumaNO();
        opMul= new MultiNO();
    }
    @Override
    public void mostrar(){
        System.out.println("Dimencion Area: " + valor1 +"x"+ valor2);
    }
}
