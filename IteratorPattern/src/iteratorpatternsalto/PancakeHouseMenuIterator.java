package iteratorpatternsalto;

import java.util.ArrayList;
public class PancakeHouseMenuIterator implements Iterator {
  private ArrayList items;
  private int pi = 0;
  private int pf;
  private int position;
  private int salto;

  public PancakeHouseMenuIterator(ArrayList items){
    this.items = items;
    pf = items.size();
    pi = 0;
    position = pi;
  }
  public Object next(){
    MenuItem menuItem = (MenuItem)items.get(position);
    position = position + 1;
    return menuItem;
  }
  public boolean hasNext(){
    // return position < items.size() && list[position] != null;
    return !items.isEmpty() && position < pf; //pf = items.size()
  }
  public void rango(int vi, int vf){
    pi = vi < 0 || vi > items.size()? 0 : vi;
    pf = vf >= vi && vf <= items.size()? vf : items.size();
    position = pi;
  }
  public void rangoEn(int vi, int vf, int step){
    pi = vi < 0 || vi > items.size() ? 0 : vi;
    pf = vf >= vi && vf <= items.size() ? vf : items.size();
    position = pi;
    if(step > items.size()){
      salto = items.size();
    }else{
      if(step < 0){
        salto = 1;
      }else{
        salto = step;
      }
    }
  }
  public int getStep(){
    return salto;
  }
}