package observerDis;
/*
 * @author Zidai
 */
public class Pronostico implements Observador,MostrarElemento{
    private float actualtemperatura;
    private float actualpresion;
    private float anttemperatura;
    private float antpresion;
    private Sujeto datos;
    private int[]valores={1,0,1};
    
    Pronostico(Sujeto datos){
        this.datos=datos;
        this.datos.registrarObservador(this, valores);
    }

    @Override
    public void actualizart(float temperatura,float humedad,float presion) {
        this.anttemperatura=this.actualtemperatura;
        this.actualtemperatura=temperatura;
        this.antpresion=this.actualpresion;
        this.actualpresion=presion;
        mostrar();
    }
/*
    @Override
    public void actualizarh(float humedad) {

    }

    @Override
    public void actualizarp(float presion) {
        
    }*/

    @Override
    public void mostrar() {
        System.out.println(pronosticar());
        System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
    }
    public String pronosticar(){
        String cadena;
        if(this.anttemperatura<this.actualtemperatura && this.antpresion>this.actualpresion){
           return cadena="Probabilidad de calor";
        }
        if(this.antpresion<this.actualpresion && this.anttemperatura>this.actualtemperatura){
         return cadena="Probabilidad de lluvias";
        }
        if(this.antpresion==this.actualpresion && this.anttemperatura==this.actualtemperatura){
            return cadena="Las condiciones son iguales";
        }
        
        return cadena="No es posible determinar el clima";
    }

    @Override
    public void actualizart(float temperatura) {
        this.anttemperatura=this.actualtemperatura;
        this.actualtemperatura=temperatura;
    }

    @Override
    public void actualizarh(float humedad) {

    }

    @Override
    public void actualizarp(float presion) {
        this.antpresion=this.actualpresion;
        this.actualpresion=presion;
        mostrar();
    }
    
}
