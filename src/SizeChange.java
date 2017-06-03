
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


/**
 * Created by Paweł on 15.04.2017.
 */
public class SizeChange implements ChangeListener {

    private JSpinner fontsizeSpinner;
    private JTextPane textPane;

    SizeChange (JSpinner FontsizeSpinner, JTextPane TextPane)
    {
        fontsizeSpinner = FontsizeSpinner;
        textPane = TextPane;

    }

    public void stateChanged(ChangeEvent e) {


        String Ssize= fontsizeSpinner.getValue().toString();
        Integer Isize = Integer.valueOf(Ssize);
       SimpleAttributeSet sas = new SimpleAttributeSet();
        if(textPane.getSelectedText()!=null) {

            StyleConstants.setFontSize(sas, Isize);
            textPane.getStyledDocument().setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectedText().length(), sas, false);
        }
    }

}
