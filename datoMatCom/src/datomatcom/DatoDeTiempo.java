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
public class DatoDeTiempo extends DatoMatCom{
    public DatoDeTiempo(double x, double y){
        super(x, y);
        opSum= new SumaTiempo();
        opMul= new MultiNO();
    }
    @Override
    public void mostrar(){
        System.out.println("Tiempo: " + (int)valor1 +":"+ (int)valor2 );
    }
}
