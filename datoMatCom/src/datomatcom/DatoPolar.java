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
public class DatoPolar extends DatoMatCom{
    
    public DatoPolar(double x, double y){
        super(x, y);
        opSum= new SumaDirecta();
        opMul= new MultiDirecto();
        
    }
    
    @Override
    public void mostrar(){
        System.out.println("Polar: (" + valor1 +","+ valor2 + "i)");
    }
    
}
