package iteratorpatternsalto;
/*
 * @author Zidai
 */
public class IteratorPatternSalto {
  public static void main(String args []){
    PancakeHouseMenu phm = new PancakeHouseMenu();
    DinerMenu dm = new DinerMenu();

    Waitress w = new Waitress(phm, dm);
    // w.printMenu();
    // w.printRange(1, 5);
    // w.printRange(1, 3);
    // w.printNames();
    w.printRangeIn(8, 8, 7); //vi, vf, step
  }
}