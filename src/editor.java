import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.rtf.RTFEditorKit;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by java on 04.04.17.
 */
public class editor {


    private JPanel MainPanel;
    private JButton Open;
    private JButton B;
    private JButton Save;
    private JButton U;
    private JPanel ButtonsPanel;
    private JToolBar.Separator DownSeparator;
    private JTextPane textPane;
    private JButton uB;
    private JButton I;
    private JButton uI;
    private JButton uU;
    private JComboBox FontBox;
    private JSpinner FontSizeSpinner;
    private JButton UndoButton;
    private JButton RedoButton;
    private JComboBox ColorBox;
    private RTFEditorKit rtf;
    private UndoManager manager = new UndoManager();

   private String[] Fonts = { "Standard", "AlexBrush", "CDreams", "OpenSans", "Pacifico","SeaResort" };
    private String[] Colors = { "Black", "Blue", "Red", "Green", "Yellow","Cyan" };





    private  void setActions (){

        Open.addActionListener(new Opening(textPane,rtf));
        Save.addActionListener(new Saving(textPane,rtf));
        B.addActionListener(new Bolding(textPane));
        uB.addActionListener(new unBolding(textPane));
        U.addActionListener(new Underlining(textPane));
        uU.addActionListener(new unUnderlining(textPane));
        I.addActionListener(new Italing(textPane));
        uI.addActionListener(new unItaling(textPane));
        FontSizeSpinner.addChangeListener(new SizeChange(FontSizeSpinner,textPane));
        FontBox.addActionListener(new Fonts(FontSizeSpinner,FontBox,textPane));
        ColorBox.addActionListener(new Colors(ColorBox,textPane));


        textPane.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });

        UndoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               if (manager.canUndo())
                        manager.undo();

            }
        });

        RedoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (manager.canRedo())
                    manager.redo();

            }
        });



    }



    private void createAndShowGUI() {

        JFrame f = new JFrame();

        try {
            Image img = ImageIO.read(getClass().getResource("resources/undo-5.png"));
            Image resizedImage = img.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH ) ;
            UndoButton.setIcon(new ImageIcon(resizedImage));
        } catch (Exception ex) {
            System.out.print("Error loading image");
        }

        try {
            Image img = ImageIO.read(getClass().getResource("resources/redo-5.png"));
            Image resizedImage = img.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH ) ;
            RedoButton.setIcon(new ImageIcon(resizedImage));
        } catch (Exception ex) {

            System.out.print("Error loading image");

        }


        JScrollPane scroll = new JScrollPane(textPane);
        rtf = new RTFEditorKit();
        textPane.setEditorKit(rtf);
        textPane.setBackground(Color.white);
        SpinnerNumberModel model = new SpinnerNumberModel (12,1,40,1);
         FontSizeSpinner.setModel(model);

         for (int i=0;i<Fonts.length;i++) {
             FontBox.addItem(Fonts[i]);

         }

        for (int i=0;i<Colors.length;i++) {
            ColorBox.addItem(Colors[i]);

        }





        f.setSize(800,600);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.add(MainPanel, BorderLayout.CENTER);
        f.add(ButtonsPanel, BorderLayout.PAGE_START);
        f.add(DownSeparator, BorderLayout.PAGE_END);
        f.add(scroll);
        f.setVisible(true);


    }




    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                editor app = new editor();
                app.createAndShowGUI();
                app.setActions();
            }
        });
    }
}
