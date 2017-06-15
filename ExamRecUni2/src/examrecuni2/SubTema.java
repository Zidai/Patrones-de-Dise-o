/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examrecuni2;

/**
 *
 * @author Zidai
 */
public class SubTema extends Biblioteca {
    String name;
    int numPag;
    
    public SubTema(String name,int numPag){
        this.name=name;
        this.numPag=numPag;
    }
    
     public String getTitulo() {
        return name;
    }

    public int getNumPag() {
        return numPag;
    }
    
    @Override
    public void print() {
        System.out.print("  ..." + getTitulo());
        System.out.println("............. " + getNumPag());
    }
}
