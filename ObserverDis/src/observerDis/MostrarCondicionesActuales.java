package observerDis;
/*
 * @author Zidai
 */
public class MostrarCondicionesActuales implements Observador,MostrarElemento{
    private float temperatura;
    private float humedad;
    private Sujeto datos;
    private int[]valores={1,1,0};
    MostrarCondicionesActuales(Sujeto datos){
        this.datos=datos;
        this.datos.registrarObservador(this,valores);
    }
    @Override
    public void mostrar() {
        System.out.println("Condiciones Actuales: "+temperatura+" °C y "+humedad+"% de humedad");
        System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
    }
    /*
    @Override
    public void actualizart(float temperatura) {
         if(Math.abs(this.temperatura-temperatura)>2){
             this.temperatura=temperatura;
         }
         mostrar();
    }

    @Override
    public void actualizarh(float humedad) {
        if(Math.abs(this.humedad-humedad)>2){
            this.humedad=humedad;
        }
        mostrar();
    }

    @Override
    public void actualizarp(float presion) {
        
    }*/

    @Override
    public void actualizart(float temperatura, float humedad, float presion) {
         if(Math.abs(this.humedad-humedad)>2){
            this.humedad=humedad;
        }
       if(Math.abs(this.temperatura-temperatura)>2){
             this.temperatura=temperatura;
         }
       mostrar();
    }

    @Override
    public void actualizart(float temperatura) {
         if(Math.abs(this.temperatura-temperatura)>2){
             this.temperatura=temperatura;
         }
    }

    @Override
    public void actualizarh(float humedad) {
        if(Math.abs(this.humedad-humedad)>2){
            this.humedad=humedad;
        }
        mostrar();
    }

    @Override
    public void actualizarp(float presion) {
       
    }

 
  
}
