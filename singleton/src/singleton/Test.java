/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author Zidai
 */
public class Test {
    public static void main(String arg[]){
        //SingletonClasico oS= new SingletonClasico();
        //SingletonClasico oS1= new SingletonClasico();
        //SingletonClasico oS2 = null;
        //oS=oS2;
        //System.out.println(oS==oS1);
        //System.out.println(oS==oS2);
        
        SingletonClasico singleton0= SingletonClasico.getInstancia();
        System.out.println(singleton0.numIns());
        SingletonClasico singleton1= SingletonClasico.getInstancia();
        System.out.println(singleton1.numIns());
        System.out.println(singleton0==singleton0);
    }
}
