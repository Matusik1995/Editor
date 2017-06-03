import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Paweł on 15.04.2017.
 */
public class Colors implements ActionListener {

    private JComboBox ColorBox;
    private JTextPane textPane;


    Colors (JComboBox colorBox, JTextPane TextPane)
    {
        ColorBox = colorBox;
        textPane = TextPane;

    }



    public void actionPerformed(ActionEvent e) {

        SimpleAttributeSet sas = new SimpleAttributeSet();


        if (textPane.getSelectedText()!=null)

        {

            switch (ColorBox.getSelectedIndex()) {


                case 0:

                    StyleConstants.setForeground(sas, Color.BLACK);

                    break;

                case 1:

                    StyleConstants.setForeground(sas, Color.BLUE);

                    break;

                case 2:

                    StyleConstants.setForeground(sas, Color.RED);

                    break;

                case 3:

                    StyleConstants.setForeground(sas, Color.GREEN);

                    break;

                case 4:

                    StyleConstants.setForeground(sas, Color.YELLOW);

                    break;

                case 5:

                    StyleConstants.setForeground(sas, Color.CYAN);

                    break;
            }

            textPane.getStyledDocument().setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectedText().length(), sas, false);


        }
    }
}
