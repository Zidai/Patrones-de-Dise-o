package iteratorpatternsalto;
public interface Iterator {
  public boolean hasNext();
  public Object next();
  public void rango(int vi, int vf);
  public void rangoEn(int vi, int vf, int step);
  public int getStep();
}