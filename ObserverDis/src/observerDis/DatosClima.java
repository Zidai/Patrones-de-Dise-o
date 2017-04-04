package observerDis;
/*
 * @author Zidai
 */
import java.util.ArrayList;
public class DatosClima implements Sujeto{
    private ArrayList observadores;
    private ArrayList<int[]> servicios;
    private float temperatura;
    private float humedad;
    private float presion;
    
    DatosClima(){
        observadores=new ArrayList();
        servicios=new ArrayList();
    }
    
    @Override
    public void registrarObservador(Observador O,int[] s) {
       observadores.add(O);
       servicios.add(s);
    }

    @Override
    public void removerObservador(Observador O) {
        int i=observadores.indexOf(O);
        if(i>0){
            observadores.remove(i);
            servicios.remove(i);
        }
    }

    @Override
    public void notificarObservadores(){
        for(int i=0;i<observadores.size();i++){
            Observador observador=(Observador)observadores.get(i);
            
            //observador.actualizart(temperatura, humedad, presion);
            
            
            int[] ser=servicios.get(i);
            
            for(int j=0;j<3;j++){
           
                if(ser[j]==1 && j==0){
                    observador.actualizart(temperatura);
                }
                if(ser[j]==1 && j==1){
                    observador.actualizarh(humedad);
                }
                if(ser[j]==1 && j==2){
                    observador.actualizarp(presion);
                }
            }
        }
    }
    
    public void cambioDeMedidas(){
        notificarObservadores();
    }
    
    public void modificarMedidas(float temperatura,float humedad,float presion){
            this.temperatura=temperatura;
            this.humedad=humedad;
            this.presion=presion;
            cambioDeMedidas();
    }
    
    
    
}
