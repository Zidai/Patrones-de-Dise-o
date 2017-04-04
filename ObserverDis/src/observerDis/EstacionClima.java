package observerDis;
/*
 * @author Zidai
 */
public class EstacionClima {
    public static void main(String [] p){
        DatosClima datos=new DatosClima();
        MostrarCondicionesActuales condicionesActuales=new MostrarCondicionesActuales(datos);
        MuestraEstadisticas std=new MuestraEstadisticas(datos);
        Pronostico pro=new Pronostico(datos);
        datos.modificarMedidas(12.5f, 45,65.4f);
        datos.modificarMedidas(20.3f,67,23);
        datos.modificarMedidas(15.5f, 45,34.4f);
        datos.modificarMedidas(15.5f, 32,60.4f);
        datos.modificarMedidas(15.5f, 32,60.4f);
    }
}
