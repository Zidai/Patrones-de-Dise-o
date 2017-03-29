package compositemenunumele;
/**
 * @author Zidai
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;
    
    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
        if(menuComponent instanceof MenuItem){
            this.numElementos+=menuComponent.numElementos;
        }
        
    }

    public void remove(MenuComponent menuComponent) {
        if (menuComponent instanceof MenuItem){
            
            menuComponents.remove(menuComponent);
        }
    }

    public int getNumElementos(){
        return numElementos;
    }
    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("Numero de elementos: "+numElementos);
        System.out.println("----------------");
        Iterator it = menuComponents.iterator();
        while(it.hasNext()) {
            MenuComponent menuComponent = (MenuComponent)it.next();
            menuComponent.print();      // will be called recursively!
        }
    }
    //tarea imprimir el costo total de los items y usar el remove
}
