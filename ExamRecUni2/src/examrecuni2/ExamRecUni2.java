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
public class ExamRecUni2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Biblioteca biblioteca = new Libro("Todos los Libros", "Todos los libros de la biblioteca");
        Biblioteca libroA=new Libro("Libro X", "2010");
        Biblioteca libroB=new Libro("Libro Y", "2015");
        Biblioteca libroC=new Libro("Libro Z", "2010");
        
        biblioteca.add(libroA);
        biblioteca.add(libroB);
        biblioteca.add(libroC);
        Biblioteca libAtema1=new Tema("Tema a", 1);
        Biblioteca libAtema2=new Tema("Tema b", 20);
        libroA.add(libAtema1);
        libroA.add(libAtema2);
        
        libAtema1.add(new SubTema("N-Subtema", 1));
        libAtema1.add(new SubTema("I-Subtema", 4));
        libAtema2.add(new SubTema("B-Subtema", 21));
        libAtema2.add(new SubTema("X-Subtema", 30));
        
        Waitress waitress = new Waitress(biblioteca);
        waitress.printBiblioteca();
        
        
        
        
        
        
    }
    
}
