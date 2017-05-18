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
public class Tiempo {	
	private int hora,min,seg,st;	
	Tiempo(){
		estableceHora(0,0,0);
	}	
	public void estableceHora(int h,int m,int s){		
		hora=h;min=m;seg=s;		
	}	
	public void introduceHora(){
		hora =Integer.parseInt(JOptionPane.showInputDialog("introduce la hora (0-23)"));
		min = Integer.parseInt(JOptionPane.showInputDialog("introduce los minutos (0-59)"));
		seg = Integer.parseInt(JOptionPane.showInputDialog("introduce los segundos (0-59)"));
	}	
	public int segundosTrans(){    
		st=((hora*3600)+(min*60)+seg);		
		return st;
	}	
	public String toString()
	{		
		String s = hora+":"+min+":"+seg;
		return s;  
	}			
}