package iteratorpattern;

import java.util.ArrayList;
public class PancakeHouseMenu {
  ArrayList menuItems;
  
  public PancakeHouseMenu(){
    menuItems = new ArrayList();
    addItem("1.-K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
    addItem("2.-Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
    addItem("3.-Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
    addItem("4.-Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
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