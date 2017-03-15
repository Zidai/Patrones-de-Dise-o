package factorymethod;
/**
 *
 * @author Zidai
 */
public class ManipuladorPoligono extends Manipulador{
    public Figura crearFigura(Object d, Integer t){
        return figura=new Poligono(d,t, "Polígono");
    }
    
}
