/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datomatcom;

/**
 *BALDERAS TALARICO MAURO CESAR
 * @author zidai
 */
public class Test{
    
    
    public static void main(String[] args) {
        //Notacion de Punto
        DatoMatCom xP = new DatoPunto(3, 2);
        DatoMatCom yP = new DatoPunto(1, 5);
        xP.mostrar();
        yP.mostrar();
        xP.ejesuma(yP).mostrar();
        xP.ejeMult(yP).mostrar();
        //Notacion de Fraccion
        DatoMatCom xF = new DatoFraccion(3, 2);
        DatoMatCom yF = new DatoFraccion(1, 5);
        xF.mostrar();
        yF.mostrar();
        xF.ejesuma(yF).mostrar();
        xF.ejeMult(yF).mostrar();
        //Notacion de Polar
        DatoMatCom xPol = new DatoComplejo(3.3, 22);
        DatoMatCom yPol = new DatoComplejo(13, -8.13);
        xPol.mostrar();
        yPol.mostrar();
        xPol.ejesuma(yPol).mostrar();
        xPol.ejeMult(yPol).mostrar();
        //Notacion de Exponente
        DatoMatCom xExp =new DatoExponente(2,2);
        DatoMatCom yExp =new DatoExponente(2,2);
        xExp.mostrar();
        yExp.mostrar();
        xExp.ejesuma(yExp);
        xExp.ejeMult(yExp);
        //Notacion de Vector
        DatoMatCom xVec = new DatoVector(2, 25.5);
        DatoMatCom yVec = new DatoVector(3, 4.6);
        xVec.mostrar();
        yVec.mostrar();
        xVec.ejesuma(yVec).mostrar();
        xVec.ejeMult(yVec);
        //EXAMEN
        DatoMatCom xDL = new DatoDimencionLineal(2, 97);
        DatoMatCom yDL = new DatoDimencionLineal(3, 67);
        xDL.mostrar();
        yDL.mostrar();
        xDL.ejesuma(yDL).mostrar();
        xDL.ejeMult(yDL);
        
        DatoMatCom xDA = new DatoDimencionArea(2, 97);
        DatoMatCom yDA = new DatoDimencionArea(3, 67);
        xDA.mostrar();
        yDA.mostrar();
        xDA.ejesuma(yDA).mostrar();
        xDA.ejeMult(yDA);
        
        DatoMatCom xDT = new DatoDeTiempo(2, 97);
        DatoMatCom yDT = new DatoDeTiempo(3, 67);
        xDT.mostrar();
        yDT.mostrar();
        xDT.ejesuma(yDT).mostrar();
        xDT.ejeMult(yDT);
        
    }
}
