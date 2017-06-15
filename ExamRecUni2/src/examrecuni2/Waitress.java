package examrecuni2;
/**
 * @author Zidai
 */
public class Waitress {
    private Biblioteca allMenus;

    public Waitress(Biblioteca allMenus) {
        this.allMenus = allMenus;
    }

    public void printBiblioteca() {
        allMenus.print();
    }
}