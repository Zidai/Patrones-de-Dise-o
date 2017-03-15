package iteratorpattern;

public class Waitress {
  PancakeHouseMenu pancakeHouseMenu; //contienen la lista de items
  DinerMenu dinerMenu;

  public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu){
    this.pancakeHouseMenu = pancakeHouseMenu;
    this.dinerMenu = dinerMenu;
  }
  public void printNames(){
    Iterator dinerIterator = dinerMenu.createIterator(); 
    while(dinerIterator.hasNext()){
      MenuItem menuItem = (MenuItem)dinerIterator.next(); //casting por si viene de ArrayList
      System.out.println(menuItem.getName());
    }
  }

  public void printRango(int vi, int vf){
    Iterator dinerIterator = dinerMenu.createIterator();
    dinerIterator.rango(vi - 1, vf);
    vi = vi - 1; //we're working with arrays, (starting with index 0)
    while(dinerIterator.hasNext()){
      MenuItem menuItem = (MenuItem)dinerIterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.println(menuItem.getPrice());
      System.out.println(menuItem.getDescription());
    }
  }
  public void printMenu(){
    Iterator pancakeIterator = pancakeHouseMenu.createIterator(); //llama al que recorre los items
    Iterator dinerIterator = dinerMenu.createIterator(); 
    System.out.println("Menu\n---\nBREAKFAST");
    printMenu(pancakeIterator); //llama al método privado
    System.out.println("\nLUNCH");
    printMenu(dinerIterator); //llama al método privado
  }
  //por qué hacer dos métodos??? (privado, público)
  private void printMenu(Iterator iterator){
    while(iterator.hasNext()){
      MenuItem menuItem = (MenuItem)iterator.next();
      System.out.println(menuItem.getName() + ", ");
      System.out.println(menuItem.getPrice() + " -- ");
      System.out.println(menuItem.getDescription());
    }
  }
}