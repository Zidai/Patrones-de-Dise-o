package examen2auto;
/*
 * @author Zidai
 */
public interface Sujeto {
    public void registrarObservador(Observador O,int[] servicios);
    public void removerObservador(Observador O);
    public void notificarObservadores();
}
