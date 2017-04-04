package observerDis;
/*
 * @author Zidai
 */
public interface Observador {
    public void actualizart(float temperatura,float humedad,float presion);
    public void actualizart(float temperatura);
    public void actualizarh(float humedad);
    public void actualizarp(float presion);
    
}
