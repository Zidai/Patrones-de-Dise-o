package adapter;
/**
 *
 * @author Zidai
 */
import java.awt.*;
import javax.swing.*;

public class BookEntry
{
    private final String title;
    private final String imagePath;
    private ImageIcon image;
    
    public BookEntry(String title, String imagePath)
    {
        this.title=title;
        this.imagePath=imagePath;
    }

    public String getTitle(){return title;}
    
    public ImageIcon getImage(){
        if(image==null){
            image=new ImageIcon(imagePath);
        }
        return image;
    }
    
    //Override standard toString method to give a useful result.
    public String toString(){return title;}
}

