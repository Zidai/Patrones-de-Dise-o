package adapter;
/**
 * @author Zidai
 */
//import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ListExample extends JPanel{
    private BookEntry books[]={
        new BookEntry("Espada de Combate","01.jpg"),
        new BookEntry("Rifle de asalto","02.jpg"),
        new BookEntry("Rifle Sniper .22","03.jpg"),
        new BookEntry("Ballesta de cazador","04.jpg"),
        new BookEntry("Wakisashi","05.jpg"),
        new BookEntry("Katana","06.jpg"),
        new BookEntry("Hacha de leñador","07.jpg"),
        new BookEntry("Squall Weapon","08.jpg"),
        new BookEntry("Espada de Alucard","09.jpg"),
        new BookEntry("Hacha de Alucard","10.jpg"),
        new BookEntry("Cuchillo de Orco","11.jpg"),
        new BookEntry("Escudo Wargo","12.jpg"),
        new BookEntry("Cañon Gatling 1912","13.jpg"),
        new BookEntry("Florete Español","14.jpg"),
        new BookEntry("Pistola de Corven","15.jpg"),
        new BookEntry("Laser de MarsMervin","16.jpg"),
        new BookEntry("Lancer","17.jpg"),
        new BookEntry("RPG Rocket Luncher","18.jpg"),
        new BookEntry("Espada Carfico Nudillo","19.jpg"),
        new BookEntry("Navaja de Cazador","20.jpg"),
        new BookEntry("Espada de Cloud","21.jpg"),
        new BookEntry("Espada China","22.jpg"),
        new BookEntry("Mandoble Ingles","23.jpg"),
        new BookEntry("Espada del Caos","24.jpg"),
        new BookEntry("Espada de William Wallas","25.jpg"),
    };
    private JList booklist= new JList(books);
    
    public ListExample(){
        setLayout(new BorderLayout());
        JButton button=new JButton("Print");
        button.addActionListener(new PrintListener());
        booklist=new JList(books);
        booklist.setCellRenderer(new BookCellRenderer());
        booklist.setVisibleRowCount(4);
        JScrollPane pane =new JScrollPane(booklist);
        add(pane,BorderLayout.EAST);
        add(button,BorderLayout.SOUTH);
    }
    
    public static void main(String s[]){
        JFrame frame=new JFrame("List Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ListExample());
        frame.pack();
        frame.setVisible(true);
    }
    //An inner class to respond to click of the Print button 
    class PrintListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int selected[]=booklist.getSelectedIndices();
            System.out.println("selected Elements: ");
            for(int i= 0;i<selected.length;i++){
                BookEntry element=(BookEntry)booklist.getModel().getElementAt(selected[i]);
                System.out.println(" "+ element.getTitle());
            }
            
        }
    }

}
