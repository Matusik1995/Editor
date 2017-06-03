import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by java on 11.04.17.
 */
public class Saving implements ActionListener {

    private JTextPane Editor;
    private RTFEditorKit rtf;

     Saving (JTextPane editor, RTFEditorKit RTF)

    {

        Editor = editor;
        rtf = RTF;
    }

    public void actionPerformed(ActionEvent actionEvent) {

        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter ("RTF Files (*.rtf)", "rtf");
        fc.setFileFilter(filter);
        fc.setAcceptAllFileFilterUsed(false);

            int returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
               StyledDocument doc = (StyledDocument)Editor.getDocument();

                try {
                    FileOutputStream fos = new FileOutputStream(file+".rtf");

                    rtf.write(fos,doc,doc.getStartPosition().getOffset(),doc.getLength());
                    fos.flush();
                    fos.close();


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
