package iteratorpatternsalto;

import java.util.ArrayList;
@SuppressWarnings("unchecked")
public class PancakeHouseMenu {
  ArrayList menuItems;
  
  public PancakeHouseMenu(){
    menuItems = new ArrayList();
    addItem("1.- K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
    addItem("2.- Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
    addItem("3.- Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
    addItem("4.- Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
    addItem("5.- Licuados", "de fresa, frambuesa, moras", true, 3.59);
    addItem("6.- Jugo", "de naranja, de manzana", true, 3.59);
    addItem("7.- La especialidad", "de la casa", true, 3.59);
    addItem("8.- Pastel", "de chocolate", true,  3.05);
    addItem("9.- Tortas", "de lo que quiera", true,  3.05);
    addItem("10.- Omelets", "yummy n_n", true,  3.05);
    addItem("11.- Enfrijoladas", "de frijol con queso", true,  3.05);
    addItem("12.- Enchiladas", "verdes y rojas", true,  3.05);
  }
  public void addItem(String name, String description, boolean vegetarian, double price){
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    menuItems.add(menuItem);
  }
  public ArrayList getMenuItems(){
    return menuItems;
  }
  public Iterator createIterator(){
    return new PancakeHouseMenuIterator(menuItems);
  }
}