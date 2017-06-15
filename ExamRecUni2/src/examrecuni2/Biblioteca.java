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
public abstract class Biblioteca {
    int numElementos;
    Mostrar indice;
    Mostrar alfabeto;
    public int getNumElementos(){
    return numElementos;}
    
    public void add(Biblioteca BibliotecaComponent) {
        if(BibliotecaComponent instanceof Libro){
            this.numElementos+=BibliotecaComponent.numElementos;
        }
    }

    public void remove(Biblioteca BibliotecaComponent) {
        throw new UnsupportedOperationException();
    }

    public Biblioteca getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getTitulo() {
        throw new UnsupportedOperationException();
    }

    public String getAnioEdicion() {
        throw new UnsupportedOperationException();
    }
    
    public int getNumPag() {
        throw new UnsupportedOperationException();
    }
    public void print() {
        throw new UnsupportedOperationException();
    }
}
