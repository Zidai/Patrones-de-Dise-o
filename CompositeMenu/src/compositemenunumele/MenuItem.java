package compositemenunumele;
/**
 * @author Zidai
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;
    int numeroItems;

    public MenuItem(String name,String description,boolean vegetarian,double price,int numeroItems){
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
        this.numeroItems=numeroItems;
        this.numElementos=1;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }
    
    public int getNumeroItems() {
        return numeroItems;
    }

    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
        System.out.println("A pagar -- " + getPrice()*getNumeroItems());
    }
}
