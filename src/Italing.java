import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Paweł on 15.04.2017.
 */


public class Italing implements ActionListener
{
   private JTextPane textPane;
    private SimpleAttributeSet sas;

    Italing (JTextPane TextPane)

    {
        textPane = TextPane;
        sas= new SimpleAttributeSet();
    }



    public void actionPerformed(ActionEvent actionEvent) {


        if(textPane.getSelectedText()!=null) {


            StyleConstants.setItalic(sas, true);
            textPane.getStyledDocument().setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectedText().length(),sas, false);

        }
    }







}


