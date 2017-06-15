/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examrecuni2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Zidai
 */
public class Libro extends Biblioteca{
    String titulo;
    String anioEdicion;
    ArrayList temas = new ArrayList();
    
    public Libro(String titulo,String anioEdicion){
        indice=new PorIndice();
        alfabeto=new PorAlfabeto();
        this.titulo=titulo;
        this.anioEdicion=anioEdicion;
    }
    
    @Override
    public void add(Biblioteca biblioteca) {
        temas.add(biblioteca);
        if(biblioteca instanceof Tema){
            this.numElementos+=biblioteca.numElementos;
        }
        
    }

    @Override
    public void remove(Biblioteca biblioteca) {
        if (biblioteca instanceof Tema){
            
            temas.remove(biblioteca);
        }
    }

    @Override
    public int getNumElementos(){
        return numElementos;
    }
    @Override
    public Biblioteca getChild(int i) {
        return (Biblioteca)temas.get(i);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getAnioEdicion() {
        return anioEdicion;
    }

    @Override
    public void print() {
        System.out.print("\n" + getTitulo());
        System.out.println(", " + getAnioEdicion());
        System.out.println("----------------");
        Iterator it = temas.iterator();
        while(it.hasNext()) {
            Biblioteca biblioteca = (Biblioteca)it.next();
            biblioteca.print();      // will be called recursively!
        }
    }
}
