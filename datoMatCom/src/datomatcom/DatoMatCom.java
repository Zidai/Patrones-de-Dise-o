package datomatcom;
/*@author zidai*/
public abstract class DatoMatCom {    
    protected Sumar opSum;
    protected Multiplicar opMul;
    protected double valor1;
    protected double valor2;
    public DatoMatCom(double x, double y){
        valor1 = x;
        valor2 = y;
    }
    public void mostrar(){    }
    public void comparar(){    }
    public DatoMatCom ejesuma (DatoMatCom punto2){
        return opSum.suma(this, punto2);
    }
    public DatoMatCom ejeMult (DatoMatCom punto2){
        return opMul.Multi(this, punto2);
    }
}
