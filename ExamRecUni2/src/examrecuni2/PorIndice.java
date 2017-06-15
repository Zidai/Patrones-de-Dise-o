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
public class PorIndice implements Mostrar{

    @Override
    public void listar(Biblioteca a) {
        
        System.out.println(a.getChild(0).getTitulo());
        System.out.println(" "+a.getChild(0).getChild(0).getTitulo()+"......"+a.getChild(0).getChild(0).getNumPag());
        System.out.println("  "+a.getChild(0).getChild(0).getChild(0).getTitulo()+"......"+a.getChild(0).getChild(0).getChild(0).getNumPag());
        System.out.println("  "+a.getChild(0).getChild(0).getChild(1).getTitulo()+"......"+a.getChild(0).getChild(0).getChild(1).getNumPag());
        System.out.println(" "+a.getChild(0).getChild(1).getTitulo()+"......"+a.getChild(0).getChild(1).getNumPag());
        System.out.println("  "+a.getChild(0).getChild(1).getChild(1).getTitulo()+"......"+a.getChild(0).getChild(0).getChild(1).getNumPag());
        System.out.println("  "+a.getChild(0).getChild(1).getChild(1).getTitulo()+"......"+a.getChild(0).getChild(0).getChild(1).getNumPag());
        
        
       
    }
    
}
