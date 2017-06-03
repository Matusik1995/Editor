import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by java on 11.04.17.
 */
public class Opening implements ActionListener {

   private JTextPane Editor;
    private RTFEditorKit rtf;



    Opening(JTextPane editor, RTFEditorKit RTF)

    {
        Editor = editor;
        rtf=RTF;

    }

    public void actionPerformed(ActionEvent actionEvent) {

        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter ("RTF Files (*.rtf)", "rtf");
        fc.setFileFilter(filter);
        fc.setAcceptAllFileFilterUsed(false);


        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();


            try {
                rtf.read(new FileInputStream(file),Editor.getDocument(), 0);


            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("I/O error");
            } catch (BadLocationException e) {
                System.out.println("Wrong location");
            }



            }


        }




    }



