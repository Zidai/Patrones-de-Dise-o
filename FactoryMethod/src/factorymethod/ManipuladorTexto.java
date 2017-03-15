package factorymethod;
/**
 * @author Zidai
 */
public class ManipuladorTexto extends Manipulador{
    
    
    public Figura crearFigura(Object d, Integer t){
     return figura= new Texto(d,t,"Texto");   
    }
    
    
}
