package observerDis;
/*
 * @author Zidai
 */
public class MuestraEstadisticas implements Observador,MostrarElemento{
    private float mtemperatura,mhumedad,mpresion;
    private float xtemperatura,xhumedad,xpresion;
    private float ptemperatura,phumedad,ppresion;
    private Sujeto datos;
    private  int valores[]={1,1,1};
    
    MuestraEstadisticas(Sujeto datos){
        this.datos=datos;
        this.datos.registrarObservador(this,valores);
        mtemperatura=1000;mhumedad=1000;mpresion=1000;
        xtemperatura=0;xhumedad=0;xpresion=0;
    }
    
 /*   
    @Override
    public void actualizart(float temperatura) {
        if(temperatura<this.mtemperatura){
            this.mtemperatura=temperatura;
        }
        if(temperatura>this.xtemperatura){
            this.xtemperatura=temperatura;
        }
        this.ptemperatura=(this.mtemperatura+this.xtemperatura)/2;
        mostrar();
    }*/

    @Override
    public void mostrar() {
        System.out.println("Max Temp: "+xtemperatura+"\tMin Temp: "+mtemperatura+"\tAVG: "+ptemperatura);
        System.out.println("Max Presion: "+xpresion+"\tMin Presion: "+mpresion+"\tAVG: "+ppresion);
        System.out.println("Max Humedad: "+xhumedad+"\tMin Humedad: "+mhumedad+"\tAVG: "+phumedad);
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
    }

    
/*
    @Override
    public void actualizarh(float humedad) {
        if(humedad<this.mhumedad){
            this.mhumedad=humedad;
        }
        if(humedad>this.xhumedad){
            this.xhumedad=humedad;
        }
        this.phumedad=(this.mhumedad+this.xhumedad)/2;
          mostrar();
    }

    @Override
    public void actualizarp(float presion) {
        if(presion<this.mpresion){
            this.mpresion=presion;
        }
        if(presion>this.xpresion){
            this.xpresion=presion;
        }
        this.ppresion=(this.mpresion+this.xpresion)/2;
          mostrar();
    }
*/

    @Override
    public void actualizart(float temperatura, float humedad, float presion) {
         if(temperatura<this.mtemperatura){
            this.mtemperatura=temperatura;
        }
        if(temperatura>this.xtemperatura){
            this.xtemperatura=temperatura;
        }
        this.ptemperatura=(this.mtemperatura+this.xtemperatura)/2;
         if(humedad<this.mhumedad){
            this.mhumedad=humedad;
        }
        if(humedad>this.xhumedad){
            this.xhumedad=humedad;
        }
        this.phumedad=(this.mhumedad+this.xhumedad)/2;
           if(presion<this.mpresion){
            this.mpresion=presion;
        }
        if(presion>this.xpresion){
            this.xpresion=presion;
        }
        this.ppresion=(this.mpresion+this.xpresion)/2;
        mostrar();
    }

    @Override
    public void actualizart(float temperatura) {
        if(temperatura<this.mtemperatura){
            this.mtemperatura=temperatura;
        }
        if(temperatura>this.xtemperatura){
            this.xtemperatura=temperatura;
        }
        this.ptemperatura=(this.mtemperatura+this.xtemperatura)/2;
    }

    @Override
    public void actualizarh(float humedad) {
        if(humedad<this.mhumedad){
            this.mhumedad=humedad;
        }
        if(humedad>this.xhumedad){
            this.xhumedad=humedad;
        }
        this.phumedad=(this.mhumedad+this.xhumedad)/2;
    }

    @Override
    public void actualizarp(float presion) {
        if(presion<this.mpresion){
            this.mpresion=presion;
        }
        if(presion>this.xpresion){
            this.xpresion=presion;
        }
        this.ppresion=(this.mpresion+this.xpresion)/2;
        mostrar();
    }
    
  
    
}
