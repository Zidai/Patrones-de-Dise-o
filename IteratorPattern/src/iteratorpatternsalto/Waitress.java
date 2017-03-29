package iteratorpatternsalto;

public class Waitress {
  PancakeHouseMenu pancakeHouseMenu; //contienen la lista de items
  DinerMenu dinerMenu;
  Iterator pancakeIterator;
  Iterator dinerIterator;

  public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu){
    this.pancakeHouseMenu = pancakeHouseMenu;
    this.dinerMenu = dinerMenu;
    pancakeIterator = pancakeHouseMenu.createIterator();
    dinerIterator = dinerMenu.createIterator();
  }
  public void printNames(){
    System.out.println("Breakfast");
    printNames(pancakeIterator);
    System.out.println("Lunch");
    printNames(dinerIterator);
  }
  private void printNames(Iterator iterator){
    while(iterator.hasNext()){
      MenuItem menuItem = (MenuItem)iterator.next(); //casting por si viene de ArrayList
      System.out.println(menuItem.getName());
    }
  }
  public void printRangeIn(int vi, int vf, int step){
    vi = vi - 1;
    dinerIterator.rangoEn(vi, vf, step); //una vez que modifique los apuntadores...
    pancakeIterator.rangoEn(vi, vf, step);
    // System.out.println(step);
    // System.out.println(dinerIterator.getStep());
    // System.out.println(step);
    // System.out.println(pancakeIterator.getStep());

    // dinerIterator.rangoEn(vi, vf);
    System.out.println("\nLUNCH");
    printRangeIn(dinerIterator, vf, dinerIterator.getStep());
    System.out.println("Menu\n---\nBREAKFAST");
    printRangeIn(pancakeIterator, vf, pancakeIterator.getStep());
  }
  private void printRangeIn(Iterator iterator, int vf, int step){ 
    for(int i = 0; i < vf; i++){
        if(iterator.hasNext()){
          MenuItem menuItem = (MenuItem)iterator.next();
          for(int j = 1; j < step; j++){
            try{
              menuItem = (MenuItem)iterator.next();
            }catch(Exception e){
              return;
            }
          }
          System.out.print(menuItem.getName() + ", ");
          System.out.println(menuItem.getPrice());
          System.out.println(menuItem.getDescription());
        }
    }
  }
  public void printRange(int vi, int vf){
    vi = vi - 1; //we're working with arrays, (starting with index 0)
    pancakeIterator.rango(vi, vf);
    System.out.println("Menu\n---\nBREAKFAST");
    printRange(pancakeIterator, vf);

    dinerIterator.rango(vi, vf);
    System.out.println("\nLUNCH");
    printRange(dinerIterator, vf);
  }
  private void printRange(Iterator iterator, int vf){
    for(int i = 0; i < vf; i ++){
      if(iterator.hasNext()){
        MenuItem menuItem = (MenuItem)iterator.next();
        System.out.print(menuItem.getName() + ", ");
        System.out.println(menuItem.getPrice());
        System.out.println(menuItem.getDescription());
      }
    }
  }
  public void printMenu(){
    // pancakeHouseMenu.createIterator(); //llama al que recorre los items
    // dinerMenu.createIterator(); 
    System.out.println("Menu\n---\nBREAKFAST");
    printMenu(pancakeIterator); //llama al método privado
    System.out.println("\nLUNCH");
    printMenu(dinerIterator); //llama al método privado
  }
  //por qué hacer dos métodos??? (privado, público)
  //ah pues porque el privado, recibe el iterador, como se recorren de igual manera,
  //no se tiene que implementar un recorrido para imprimir cada menú
  private void printMenu(Iterator iterator){
    while(iterator.hasNext()){
      MenuItem menuItem = (MenuItem)iterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.println(menuItem.getPrice());
      System.out.println(menuItem.getDescription());
    }
  }
}