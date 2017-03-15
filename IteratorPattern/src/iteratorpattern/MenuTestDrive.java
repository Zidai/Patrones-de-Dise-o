package iteratorpattern;
/**
 * @author Zidai
 */
public class MenuTestDrive {
    public static void main(String[] args){
        /*PancakeHouseMenu p=new PancakeHouseMenu();
        DinerMenu d=new DinerMenu();
        Waitress w=new Waitress(p, d);
        w.printMenu();*/
        PancakeHouseMenu phm = new PancakeHouseMenu();
        DinerMenu dm = new DinerMenu();
  
        Waitress w = new Waitress(phm, dm);
        // w.printMenu();
        // w.printRango(3, 5);
        w.printRango(1, 9);
        // w.printRange(3, 5);
        // w.printRange(1, 9);
        w.printNames();
    }
}
