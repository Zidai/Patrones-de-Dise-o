package iteratorpattern;
public class DinerMenuIterator implements Iterator {
  private MenuItem[] items;
  private int position;
  private int pi = 0;
  private int pf;

  public DinerMenuIterator(MenuItem[] items){
    this.items = items;
    pi = 0;
    pf = items.length;
    position = pi;
  }
  public Object next(){
    MenuItem menuItem = items[position];
    position = position + 1;
    return menuItem;
  }
  public boolean hasNext(){
    if(position >= items.length || items[position] == null){
      return false;
    }else{
      return true;
    }
  }
  public void rango(int vi, int vf){
    pi = vi < 0 || vi > items.length? 0 : vi;
    pf = vf >= vi && vf <= items.length? vf : items.length;
    position = pi;
  }
}