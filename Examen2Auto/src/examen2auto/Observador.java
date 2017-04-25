package examen2auto;
/*
 * @author Zidai
 */
public interface Observador {
    public void actualizarA(float Rendimiento,float limKM,float presion);
    public void actualizart(float temperatura);
    public void actualizarh(float humedad);
    public void actualizarp(float presion);
    
}
