/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiempo;

/**
 *
 * @author Zidai
 */
import javax.swing.JOptionPane;
public class Aplica {
	public static void main( String args[] ){
		Fecha y=new Fecha();
		Tiempo x = new Tiempo();
		y.introduceFecha();
		x.introduceHora();
		int segu=x.segundosTrans();
		int fech=y.diasTrans();
		Fecha z=new Fecha();
                
		z.estableceFecha(2017,12,21);
		int udm=z.diasTrans();
		int ragnarok=udm-fech;
		ragnarok--;
		int segt=(86400-x.segundosTrans());
		if (udm>fech){
			JOptionPane.showMessageDialog(null,"La fecha es: "+y+"\nLa hora es: "+x+"\n\nLos dias transcurridos desde año nuevo son: "+fech+"\nLos segundos trascurridos desde media noche son: "+segu+"\n\nY faltan "+ragnarok+" dias con "+segt+" segundos para el fin del mundo","HORA y FECHA",JOptionPane.PLAIN_MESSAGE);
		}
		else {
				JOptionPane.showMessageDialog(null,"FELICIDADES ERES UNO DE LOS ELEJIDOS \n\nLa fecha es: "+y+"\nLa hora es: "+x+"\n\nLos dias transcurridos desde año nuevo son: "+fech+"\nLos segundos trascurridos desde media noche son: "+segu+"\n\nY en este momento estamos en el paraiso","HORA y FECHA",JOptionPane.PLAIN_MESSAGE);
		}
	}	
}

