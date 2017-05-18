package componentecompuestopractica;

import javax.swing.JRadioButton;
/*
 * @author Zidai
 */
public class OpcionQuestionario extends JRadioButton{
    private boolean esCorrecta;
    
    public OpcionQuestionario(){
        super();
        esCorrecta = true;
    }

    public boolean getEsCorrecta(){
        return esCorrecta;
    }

    public void setEsCorrecta(boolean c){
        esCorrecta=c;
    }
    
}
