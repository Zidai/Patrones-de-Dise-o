/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examrecuni4;

/*
Prueba el codigo dado en la parte inferior, lo que tienes que hacer es crear un componente como el mostrado en el archivo adjunto el cual debe tener las siguientes funcionalidades
1. Asignarle los datos a la lista izquierda
2. Poder elegir la funcionalidad de los botones,
3 mover hace lo que ya se muestra en el codigo 
4 Copiar pasa los elementos de la lista izquierda a la derecha sin quitarlos de la original
5 Poder recuperar los elementos que se encuentren en la lista 
Crea una aplicación para probar las funcionalidades de tu componente, para probar la ultima tiene que usar un boton en la aplicacion para recuperar los datos de la lista derecha y mostrarlos en la aplicacion
**************************
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ComListaNum11 extends JPanel implements Serializable {

    private JList listaNumeros; // lista para guardar numeros enteros
    private JList copiaLista;
    private JButton botonJButtonCopiar;
    private JButton botonJButtonMover;
    private JButton botonJButtonMoverIzq;
    private List<Integer> valores;
    private DefaultListModel modelo;
    private DefaultListModel modelo1;
    private int NV = 10;

    public ComListaNum11() {
        JPanel panel1 = new JPanel();
        listaNumeros = new JList();
        copiaLista = new JList();
        listaNumeros.setFixedCellWidth(30);
        copiaLista.setFixedCellWidth(30);
        listaNumeros.setFixedCellHeight(20);
        copiaLista.setFixedCellHeight(20);
        listaNumeros.setLocation(0, 0);
        listaNumeros.setBounds(0, 0, 40, 300);
        listaNumeros.setSize(20, 100);
        copiaLista.setSize(20, 100);
        modelo = new DefaultListModel();
        modelo1 = new DefaultListModel();
        agregar(modelo);
        listaNumeros.setModel(modelo);
        listaNumeros.setVisibleRowCount(5); // muestra cinco filas
        listaNumeros.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // agrega lista con panel de desplazamiento
        botonJButtonMover = new JButton("Mover >>>"); // crea botón para mover
        botonJButtonMover.addActionListener(new ActionListener() {
            // maneja evento de botón
            public void actionPerformed(ActionEvent evento) {      // coloca los valores seleccionados en copiaLista
                //copiaLista.setListData(listaNumeros.getSelectedValues());
                int ind[] = listaNumeros.getSelectedIndices();
                for (int i = ind.length - 1; i >= 0; i--) {
                    modelo1.addElement(modelo.get(ind[i]));
                    modelo.removeElementAt(ind[i]);
                }
                listaNumeros.clearSelection();
                copiaLista.setModel(modelo1);
                // quita las marcas de seleccion 
            }
            // fin del método actionPerformed
        }); // fin de la llamada a addActionListener
        panel1.add(botonJButtonMover);
        botonJButtonMoverIzq = new JButton("<<< Mover");
        botonJButtonMoverIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ind[] = copiaLista.getSelectedIndices();
                for(int i = 0; i < ind.length; i++){
                    System.out.println("IN: " + ind[i]);
                    modelo.addElement(modelo1.get(ind[i]));
                    modelo1.removeElementAt(ind[i]);
                }
                copiaLista.clearSelection();
                listaNumeros.setModel(modelo);
            }
        });
        panel1.add(botonJButtonMoverIzq);
        botonJButtonCopiar = new JButton("Copiar");
        botonJButtonCopiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ind[] = listaNumeros.getSelectedIndices();
                for (int i = ind.length - 1; i >= 0; i--) {
                    modelo1.addElement(modelo.get(ind[i]));
                    //modelo.removeElementAt(ind[i]);
                }
                listaNumeros.clearSelection();
                copiaLista.setModel(modelo1);
            }
        });
        panel1.add(botonJButtonCopiar);
        add(panel1, BorderLayout.CENTER);
        copiaLista = new JList();
        copiaLista.setVisibleRowCount(5); // muestra 5 filas
        copiaLista.setFixedCellWidth(30); // establece la anchura
        copiaLista.setFixedCellHeight(15); // establece la altura
        copiaLista.setSelectionMode(
                ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaNumeros), BorderLayout.WEST);
        add(new JScrollPane(copiaLista), BorderLayout.EAST); // agrega lista con panel de desplazamiento

    } // fin del constructor de MarcoListaNum

    public void agregar(DefaultListModel m) {
        for (int e = 0; e < NV; e++) {
            m.addElement(e+1);
        }
    }

    public int getNV() {
        return NV;
    }

    public void setNV(int NV) {
        this.NV = NV;
        modelo.removeAllElements();
        agregar(modelo);
        listaNumeros.setModel(modelo);
    }

    
    
    /*public static void main(String s[]) {
        ComListaNum11 listanum = new ComListaNum11();
        JFrame frame = new JFrame("Listas");
        frame.add(listanum);
        listanum.setNV(20);
        frame.setSize(400, 400);
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }*/

}
