/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examrecuni2;
import java.util.ArrayList;

/**
 *
 * @author Zidai
 */
public class Tema extends Biblioteca{
    String name;
    int numPag;
    ArrayList subTemas = new ArrayList();

    public Tema(String name, int numPag){
        this.name = name;
        this.numPag = numPag;
    }

    @Override
    public String getTitulo() {
        return name;
    }

    public int getNumPag() {
        return numPag;
    }
    
    @Override
    public void add(Biblioteca biblioteca) {
        subTemas.add(biblioteca);
        if(biblioteca instanceof SubTema){
            this.numElementos+=biblioteca.numElementos;
        }
        
    }

    @Override
    public void remove(Biblioteca biblioteca) {
        if (biblioteca instanceof SubTema){
            
            subTemas.remove(biblioteca);
        }
    }

    @Override
    public int getNumElementos(){
        return numElementos;
    }
    @Override
    public Biblioteca getChild(int i) {
        return (Biblioteca)subTemas.get(i);
    }
    
    @Override
    public void print() {
        System.out.print("  " + getTitulo());
        System.out.println(".......... " + getNumPag());
    }
}
