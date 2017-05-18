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
public class Fecha {
	int anio,mes,dia;
	int totaldias,dias;
	Fecha(){
		estableceFecha(0,0,0);
	}
	public void estableceFecha(int a,int m,int d){
		anio=a;mes=m;dia=d;
	}
	public void introduceFecha(){
		anio =Integer.parseInt(JOptionPane.showInputDialog("introduce el año en 4 cifras"));
		mes = Integer.parseInt(JOptionPane.showInputDialog("introduce el mes (1-12)"));
		dia = Integer.parseInt(JOptionPane.showInputDialog("introduce el dia (1-31)"));
	
		}

	
	
	public int diasTrans(){
		int n=27;
		for (int i=1904; i<=anio; i=i+4){
			if (i==anio){
				n=28;
			}
		}
		int diasmes[]={0,0,31,n,31,30,31,30,31,31,30,31,30,31};
		for (int j=1;j<=mes;j++){
			totaldias+=diasmes[j];
		}	
		dias = (totaldias+dia);
		return dias;
	}
	public String toString(){
		String s = anio+"."+mes+"."+dia;
		return s;  
	}
}


