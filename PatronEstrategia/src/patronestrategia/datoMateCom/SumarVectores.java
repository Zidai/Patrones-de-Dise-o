package patronestrategia.datoMateCom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import patronestrategia.datoMateCom.Sumar;
import patronestrategia.datoMateCom.DatoMateComp;

/**
 *
 * @author Zidai
 */
public class SumarVectores implements Sumar {
    
  @Override
  public void suma (DatoMateComp dmc){
    System.out.println("Suma de dos vectores");
  }
}