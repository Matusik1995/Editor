import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Paweł on 15.04.2017.
 */
public class Fonts implements ActionListener {

    private JSpinner fontsizeSpinner;
    private JComboBox FontBox;
    private JTextPane textPane;


        Fonts (JSpinner FontsizeSpinner, JComboBox fontBox, JTextPane TextPane)
            {
                fontsizeSpinner = FontsizeSpinner;
                FontBox = fontBox;
                textPane = TextPane;

            }



    public void actionPerformed(ActionEvent e) {
        String Ssize= fontsizeSpinner.getValue().toString();
        Integer Isize = Integer.valueOf(Ssize);


        switch (FontBox.getSelectedIndex()) {

            case 0:
                try {
                    Font f = new Font("Standard", Font.PLAIN,12);
                    textPane.setFont(f.deriveFont((float) Isize));
                } catch (Exception ex)

                {
                    System.out.print("Error font creating");
                }
                break;

            case 1:
                try {
                    Font f = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Paweł\\IdeaProjects\\Editor\\src\\Fonts\\AlexBrush-Regular.ttf"));
                    textPane.setFont(f.deriveFont((float)Isize));


                } catch (Exception ex) {
                    System.out.print("Error font creating");
                }

                break;

            case 2:
                try {

                    Font f = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Paweł\\IdeaProjects\\Editor\\src\\Fonts\\CaviarDreams.ttf"));

                } catch (Exception ex) {

                    System.out.print("Error font creating");

                }


                break;

            case 3:
                try {

                    Font f = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Paweł\\IdeaProjects\\Editor\\src\\Fonts\\OpenSans-Regular.ttf"));
                    textPane.setFont(f.deriveFont((float)Isize));

                } catch (Exception ex) {
                    System.out.print("Error font creating");

                }

                break;

            case 4:
                try {

                    Font f = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Paweł\\IdeaProjects\\Editor\\src\\Fonts\\Pacifico.ttf"));
                    textPane.setFont(f.deriveFont((float)Isize));

                } catch (Exception ex) {

                    System.out.print("Error font creating");

                }

                break;

            case 5:
                try {

                    Font f = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Paweł\\IdeaProjects\\Editor\\src\\Fonts\\SEASRN__.ttf"));
                    textPane.setFont(f.deriveFont((float)Isize));

                } catch (Exception ex) {

                    System.out.print("Error font creating");

                }

                break;
        }
    }
}
